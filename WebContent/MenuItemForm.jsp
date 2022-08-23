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
               <c:if test="${menuItem != null}">
                  <form action="editMenuItem" method="post" enctype = "multipart/form-data" onsubmit="return menuItemFormValidation();">
               </c:if>
               <c:if test="${menuItem == null}">
               <form action="addMenuItem" method="post" enctype = "multipart/form-data" onsubmit="return menuItemFormValidation();">
               </c:if>
               <h2>
               <c:if test="${menuItem != null}">
               Edit Menu Item
               </c:if>
               <c:if test="${menuItem == null}">
               Add New Menu Item
               </c:if>
               </h2>
               <c:if test="${menuItem != null}">
               <input type="hidden" name="id" value="<c:out value='${menuItem.id}' />" />
               </c:if>
               <fieldset class="form-group">
               <label>Name</label> <input type="text" 
                  id="name"
                  name="name"
                  required="required"
                  maxlength="70"
                  value= "<c:out value='${menuItem.name}'/>"
                  title="This field is required"
                  pattern=".*\S+.*"
                  class="form-control">
               </fieldset>
               <fieldset class="form-group">
               <label>Price</label> <input type = "number" 
                  id="price"
                  name="price"
                  required="required"
                  min="0.01"
                  max="1000.00"
                  value=
                  "<fmt:formatNumber 
                  type="number"
                  minFractionDigits="2"
                  maxFractionDigits="2"
                  value='${menuItem.price}'/>"
               step="0.01"
               title = "Price format (up to 2 d.p.)"
               pattern=[0-9]+(\\.[0-9][0-9]?)?
               class="form-control">
               </fieldset>
               <fieldset class="form-group">
               <label>Current image</label> : <input type = "text"
                  value = "<c:out value = '${menuItem.picture}' />" 
                  class = "form-control" name = "CurrentImg" readonly>
               </fieldset>
               <fieldset class="form-group">
               <label>Select image :</label>
               <input type = "file" class = "form-control" name = "picture" style = "border:none; padding-left:0px;"/>	
               </fieldset>
               <div class="btn-toolbar pull-right">
               <c:if test="${menuItem != null}">
               <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Edit</button>
               </c:if>
               <c:if test="${menuItem == null}">
               <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Add</button>
               </c:if>
               </div>
               </form>
            </div>
         </div>
      </div>
   </body>
</html>