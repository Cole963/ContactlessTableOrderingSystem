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
               <c:if test="${userAccount != null}">
                  <form id="userAccountForm" action="editUserAccount" method="post" onsubmit="return userAccountFormValidation();">
               </c:if>
               <c:if test="${userAccount == null}">
               <form id="userAccountForm" action="addUserAccount" method="post" onsubmit="return userAccountFormValidation();">
               </c:if>
               <h2>
               <c:if test="${userAccount != null}">
               Edit User Account
               </c:if>
               <c:if test="${userAccount == null}">
               Add New User Account
               </c:if>
               </h2>
               <c:if test="${userAccount != null}">
               <input type="hidden" name="id" value="<c:out value='${userAccount.id}' />" />
               </c:if>
               <fieldset class="form-group">
               <label>Name</label>
               <input type="text" value="<c:out value='${userAccount.name}' />" class="form-control" name="fullname" id="fullname">
               <i class="fa-solid fa-circle-check symbol valid"></i>
               <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
               <small>Error</small>
               </fieldset>
               <fieldset class="form-group">
               <label>Username</label>
               <input type="text" value="<c:out value='${userAccount.username}' />" class="form-control" name="username" id="username">
               <i class="fa-solid fa-circle-check symbol valid"></i>
               <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
               <small>Error</small>
               </fieldset>
               <fieldset class="form-group">
               <label>Password</label>
               <input type="password" value="<c:out value='${userAccount.password}' />" class="form-control" name="password" id="password">
               <i class="fa-solid fa-circle-check symbol valid"></i>
               <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
               <small>Error</small>
               </fieldset>
               <fieldset class="form-group">
               <label>Email</label>
               <input type="text" value="<c:out value='${userAccount.email}' />" class="form-control" name="email" id="email">
               <i class="fa-solid fa-circle-check symbol valid"></i>
               <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
               <small>Error</small>
               </fieldset>
               <c:if test="${userAccount != null}">
               <fieldset class="form-group">
               <label>Status</label>
               <input type="text" value="<c:out value='${userAccount.status}' />" class="form-control" name="status" id="status" disabled>
               </fieldset>
               </c:if>
               <fieldset class="form-group">
               <label>User Profile</label>
               <select class="form-control" name="userProfile">
               <c:forEach var="userProfile" items="${userProfileList}">
               <option value="<c:out value='${userProfile.id}' />" <c:if test="${userAccount.userprofile.id == userProfile.id}">
               <c:out value="${'selected'}" />
               </c:if>>
               <c:out value="${userProfile.profile}" />
               </option>
               </c:forEach>
               </select>
               </fieldset>
               <div class="btn-toolbar pull-right">
               <button type="reset" onclick="resetAccountFormDefault()" class="btn btn-outline-danger my-2 my-sm-0 mr-3">Reset</button>
               <c:if test="${userAccount != null}">
               <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Edit</button>
               </c:if>
               <c:if test="${userAccount == null}">
               <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Add</button>
               </c:if>
               </div>
               </form>
            </div>
         </div>
      </div>
   </body>
</html>