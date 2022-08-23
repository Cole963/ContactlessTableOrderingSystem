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
         else if(!(session.getAttribute("profile").equals("User Admin")))
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
               <c:if test="${userProfile != null}">
               <form id="userProfileForm" action="editUserProfile" method="post"  onsubmit="return userProfileFormValidation();">
               </c:if>
               <c:if test="${userProfile == null}">
               <form id="userProfileForm" action="addUserProfile" method="post" onsubmit="return userProfileFormValidation();">
               </c:if>
               <h2>
               <c:if test="${userProfile != null}">
               Edit User Profile
               </c:if>
               <c:if test="${userProfile == null}">
               Add New User Profile
               </c:if>
               </h2>
               <c:if test="${userProfile != null}">
               <input type="hidden" name="id" value="<c:out value='${userProfile.id}' />" />
               </c:if>
               <fieldset class="form-group">
               <label>Profile</label>
               <input type="text" value="<c:out value='${userProfile.profile}' />" class="form-control" name="profile" id="profile">
               <i class="fa-solid fa-circle-check symbol valid"></i>
               <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
               <small>Error</small>
               </fieldset>
               <fieldset class="form-group">
               <label>Description</label>
               <input type="text" value="<c:out value='${userProfile.description}' />" class="form-control" name="description" id="description">
               <i class="fa-solid fa-circle-check symbol valid"></i>
               <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
               <small>Error</small>
               </fieldset>
               <div class="btn-toolbar pull-right">
               <button type="reset" onclick="resetProfileFormDefault()" class="btn btn-outline-danger my-2 my-sm-0 mr-3">Reset</button>
               <c:if test="${userProfile != null}">
               <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Edit</button>
               </c:if>
               <c:if test="${userProfile == null}">
               <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Add</button>
               </c:if>
               </div>
               </form>
            </div>
         </div>
      </div>
   </body>
</html>