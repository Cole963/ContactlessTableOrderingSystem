<!DOCTYPE html>
<html>
   <head>
      <%@include file= "include/header.jsp" %>
      <c:if test="${sessionScope.userActionMessage != null}">
         <script>
            alert("<c:out value='${userActionMessage}' />");
         </script>
         <c:remove var="userActionMessage" />
      </c:if>
      <%	
         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
         response.setHeader("Pragma", "no-cache");
         
         if(session.getAttribute("username")==null)
         {
         response.sendRedirect("LoginForm.jsp");
         }
         else if(!(session.getAttribute("profile").equals("Restaurant Staff")))
         {	
         response.sendRedirect("StaffHomePage.jsp");
         }
         %>
   </head>
   <body>
      <header>
         <%@include file = "include/navbar.jsp" %>
      </header>
      <br>
      <div class="row">
         <div class="container">
            <h3 class="text-center">List of Orders</h3>
            <hr>
            <br>
            <div class="container">
               <div class="row">
                  <div class="col-md-6">
                     <form action="searchOrder" method="post" onsubmit="return trimSearchInput();">
                        <input id="searchInput" type="text" class="form-control" name="searchInput" placeholder="Search Order by customer contact..."/>
                     </form>
                     <br/>
                  </div>
               </div>
            </div>
            <br>
            <table class="table table-bordered table-hover">
               <thead>
                  <tr>
                     <th>ID</th>
                     <th>Date Time</th>
                     <th>Customer Contact</th>
                     <th>Total Price</th>
                     <th>Status</th>
                     <th>Action</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="order" items="${orderList}" varStatus="loop">
                     <tr>
                        <td>
                           <c:out value="${order.id}" />
                        </td>
                        <td>
                           <c:out value="${order.timeStamp}" />
                        </td>
                        <td>
                           <c:if test="${order.status == 'completed'}">
                              <c:out value="${order.mobileNum}" />
                           </c:if>
                           <c:if test="${order.status == 'preparing'}">
                              <br>
                              <form action="editOrder" method ="post" class="form-inline formQuantity" id="formQuantity${loop.index}" onsubmit = "return validateMobileNum();">
                                 <input type="hidden" name= "id" value = "<c:out value='${order.id}' />" class = "form-input" form="formQuantity${loop.index}">
                                 <div class = "form-group d-flex justify-content-between">
                                    <input type ="text" id="mobileNum" name="mobile" class= "form-control toggleMobile" value="<c:out value="${order.mobileNum}"/>" readonly form="formQuantity${loop.index}"> 
                                    <button class="btn btn-sm btn-change toggleHide" type="submit" form="formQuantity${loop.index}" value="Submit"><i class="fa-solid fa-square-check" style="color:#5cb85c"></i></button>
                                 </div>
                              </form>
                           </c:if>
                        </td>
                        <td>
                           $
                           <fmt:formatNumber type="number"
                              minFractionDigits="2"
                              maxFractionDigits="2"
                              value="${order.totalPrice}"/>
                        </td>
                        <c:if test="${order.status == 'completed'}">
                           <td class="text-success">
                              <c:out value="${order.status}" />
                           </td>
                           <td>
                              <a href="viewOrderItem?orderId=<c:out value='${order.id}' />"><i class="fa-solid fa-eye"></i></a>
                           </td>
                        </c:if>
                        <c:if test="${order.status == 'preparing'}">
                           <td class="text-danger">
                              <c:out value="${order.status}" />
                           </td>
                           <td>
                              <button class="btn btn-sm toggleEditOrder"><i class="fa-solid fa-pen" style="color:#007BFF"></i></button>&nbsp;&nbsp;&nbsp;&nbsp;
                              <a href="deleteOrder?orderId=<c:out value='${order.id}' />"
                                 onclick="return confirmUserAction('Warning: All associated order items will also be deleted. Proceed?');"><i class="fa-solid fa-trash-can"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
                              <a href="completeOrder?orderId=<c:out value='${order.id}' />"
                                 onclick="return confirmUserAction('Confirm this order as completed?');"><i class="fa-solid fa-check"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;
                              <a href="viewOrderItem?orderId=<c:out value='${order.id}' />"><i class="fa-solid fa-eye"></i></a>
                           </td>
                        </c:if>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>