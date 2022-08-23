<!DOCTYPE html>
<html>
   <head>
      <%@include file= "include/header.jsp" %>
      <c:if test="${sessionScope.error != null}">
         <script>
            alert("<c:out value='${error}' />");
         </script>
         <c:remove var="error" />
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
      <div class="container col-md-5">
         <div class="card">
            <div class="card-body">
               <c:if test="${coupon != null}">
                  <form action="editCoupon" method="post">
               </c:if>
               <c:if test="${coupon == null}">
                  <form action="addCoupon" method="post">
               </c:if>
               <h2>
                  <c:if test="${coupon != null}">
                     Edit Coupon
                  </c:if>
                  <c:if test="${coupon == null}">
                     Add New Coupon
                  </c:if>
               </h2>
               <c:if test="${coupon != null}">
                  <input type="hidden" name="id" value="<c:out value='${coupon.id}' />" />
                  <fieldset class="form-group">
                     <label>Coupon Code</label> <input type="text"
                        value= "<c:out value='${coupon.code}'/>" class="form-control" pattern = "code-([0-9]|[a-z]|[A-Z]){5,10}" title = "Coupon code needs to follow pattern of ''code-'' followed by 5-10 numbers or letters"
                        name="code" required="required" onsubmit="this.value = trimTemp(this.value);">
                  </fieldset>
                  <fieldset class="form-group">
                     <select name = "status" class="form-control">
                        <c:if test="${coupon.status == 'active' }">
                           <option value = "active" selected>active</option>
                           <option value = "expired">expired</option>
                        </c:if>
                        <c:if test="${coupon.status == 'expired' }">
                           <option value = "active">active</option>
                           <option value = "expired" selected>expired</option>
                        </c:if>
                     </select>
                  </fieldset>
               </c:if>
               <c:if test="${coupon == null }">
                  <fieldset class="form-group">
                     <label>Coupon Code</label> <input type="text"
                        placeholder = "code-" class="form-control" pattern = "code-([0-9]|[a-z]|[A-Z]){5,10}" title = "Coupon code needs to follow pattern of ''code-'' followed by 5-10 numbers or letters"
                        name="code" required="required" onsubmit="this.value = trimTemp(this.value);">
                  </fieldset>
               </c:if>
               <div class="btn-toolbar pull-right">
                  <c:if test="${coupon != null}">
                     <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Edit</button>
                  </c:if>
                  <c:if test="${coupon == null}">
                     <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Add</button>
                  </c:if>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>