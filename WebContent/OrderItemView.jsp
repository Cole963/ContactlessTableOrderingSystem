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
            <h3 class="text-center">List of Order Items</h3>
            <hr>
            <br>
            <div class="container">
               <div class="row">
                  <div class="col-md-6">
                     <form action="searchOrderItem" method="post" onsubmit="return trimSearchInput();">
                    	<input type="hidden" name= "id" value = "<c:out value='${orderId}' />" class = "form-input"/>
                        <input id="searchInput" type="text" class="form-control" name="searchInput" placeholder="Search Order Item by name..."/>
                     </form>
                  </div>
                  <c:if test="${orderStatus == 'preparing'}">
                     <div class="col-md-6 text-danger">
                        <p style="padding-left: 60%;">
                           Order ID: 
                           <c:out value="${orderId}" />
                        </p>
                        <p style="padding-left: 60%;">
                           Order Status: 
                           <c:out value="${orderStatus}" />
                        </p>
                     </div>
                  </c:if>
                  <c:if test="${orderStatus == 'completed'}">
                     <div class="col-md-6 text-success">
                        <p style="padding-left: 60%;">
                           Order ID: 
                           <c:out value="${orderId}" />
                        </p>
                        <p style="padding-left: 60%;">
                           Order Status: 
                           <c:out value="${orderStatus}" />
                        </p>
                     </div>
                  </c:if>
               </div>
            </div>
            <br>
            <table class="table table-bordered table-hover">
               <thead>
                  <tr>
                     <th>ID</th>
                     <th>Name</th>
                     <th>Price</th>
                     <th>Quantity</th>
                     <th>Sub Total Price</th>
                     <c:if test="${orderStatus == 'preparing'}">
                        <th>Action</th>
                     </c:if>
                  </tr>
               </thead>
               <tbody>
                  <c:if test="${orderStatus == 'preparing'}">
                     <c:forEach var="orderItem" items="${orderItemList}" varStatus="loop">
                        <tr>
                           <td>
                              <c:out value="${orderItem.id}" />
                           </td>
                           <td>
                              <c:out value="${orderItem.name}" />
                           </td>
                           <td>
                              $
                              <fmt:formatNumber type="number"
                                 minFractionDigits="2"
                                 maxFractionDigits="2"
                                 value="${orderItem.unitPrice}"/>
                           </td>
                           <td>
                              <br>
                              <form action="editOrderItemQty" method ="post" class="form-inline formQuantity" id="formQuantity${loop.index}">
                                 <input type="hidden" name= "id" value = "<c:out value='${orderItem.id}' />" class = "form-input" form="formQuantity${loop.index}">
                                 <div class = "form-group d-flex justify-content-between">
                                    <button class="btn btn-sm btn-change toggleHide minus" type="button"><i class="fa-solid fa-square-minus" style="color:#007BFF"></i></button>
                                    <input type ="text" name="quantity" class= "form-control" value="<c:out value="${orderItem.quantity}" />" readonly form="formQuantity${loop.index}"> 
                                    <button class="btn btn-sm btn-change toggleHide plus" type="button"><i class="fa-solid fa-square-plus" style="color:#007BFF"></i></button>
                                    <button class="btn btn-sm btn-change toggleHide" type="submit" form="formQuantity${loop.index}" value="Submit"><i class="fa-solid fa-square-check" style="color:#5cb85c"></i></button>
                                 </div>
                              </form>
                           </td>
                           <td>
                              $
                              <fmt:formatNumber type="number"
                                 minFractionDigits="2"
                                 maxFractionDigits="2"
                                 value="${orderItem.subTotalPrice}"/>
                           </td>
                           <td>
                              <button class="btn btn-sm toggleEditOrderItem"><i class="fa-solid fa-pen" style="color:#007BFF"></i></button>&nbsp;&nbsp;&nbsp;&nbsp;
                              <a href="deleteOrderItem?id=<c:out value='${orderItem.id}' />"  onclick="return confirmUserAction('Confirm delete of this Order Item?');"><i class="fa-solid fa-trash-can"></i></a>
                           </td>
                        </tr>
                     </c:forEach>
                  </c:if>
                  <c:if test="${orderStatus == 'completed'}">
                     <c:forEach var="orderItem" items="${orderItemList}" varStatus="loop">
                        <tr>
                           <td>
                              <c:out value="${orderItem.id}" />
                           </td>
                           <td>
                              <c:out value="${orderItem.name}" />
                           </td>
                           <td>
                              $
                              <fmt:formatNumber type="number"
                                 minFractionDigits="2"
                                 maxFractionDigits="2"
                                 value="${orderItem.unitPrice}"/>
                           </td>
                           <td>
                              <c:out value="${orderItem.quantity}" />
                           </td>
                           <td>
                              $
                              <fmt:formatNumber type="number"
                                 minFractionDigits="2"
                                 maxFractionDigits="2"
                                 value="${orderItem.subTotalPrice}"/>
                           </td>
                        </tr>
                     </c:forEach>
                  </c:if>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>