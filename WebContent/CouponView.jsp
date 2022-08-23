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
         else if(!(session.getAttribute("profile").equals("Restaurant Manager")))
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
            <h3 class="text-center">List of Coupons</h3>
            <hr>
            <br>
            <div class="container">
               <div class="row">
                  <div class="col-md-6">
                     <form action="searchCoupon" method="post" onsubmit="return trimSearchInput();">
                        <input id="searchInput" type="text" class="form-control" name="searchInput" placeholder="Search Coupons by name ..."/>
                     </form>
                  </div>
               </div>
               <br>
               <div class="row">
                  <div class="col-md-6">
                     <select id="order-select" class="form-control">
                        <option class="item-1">-- Filter Coupons by status --</option>
                        <option value="all" class="item-2">Show all</option>
                        <option value="active" class="item-3">active</option>
                        <option value="expired" class="item-4">expired</option>
                     </select>
                  </div>
                  <div class="col-md-6">
                     <a href="<%=request.getContextPath()%>/newCouponForm" class="btn btn-outline-success my-2 my-sm-0" type="submit" style="float: right;"> + </a>
                     <br></br>
                  </div>
               </div>
            </div>
            <br>
            <table class="table table-bordered table-hover">
               <thead>
                  <tr>
                  	 <th>ID</th>
                     <th>Code</th>
                     <th>Status</th>
                     <th>Action</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="coupon" items="${coupons}">
                     <tr>
                     	<td>
                           <c:out value="${coupon.id}" />
                        </td>
                        <td>
                           <c:out value="${coupon.code}" />
                        </td>
                        <c:if test="${coupon.status == 'active'}">
                           <td class="text-success">
                           <c:out value="${coupon.status}" />
                           </td>
                        </c:if>
                        <c:if test="${coupon.status == 'expired'}">
                           <td class="text-danger">
                           <c:out value="${coupon.status}" />
                           </td>
                        </c:if>
                        <td>
                           <a href="editCouponForm?id=<c:out value='${coupon.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                           <a href="deleteCoupon?id=<c:out value='${coupon.id}' />"
                              onclick="return confirmUserAction('Confirm delete of this Coupon?');">Delete</a>
                        </td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>