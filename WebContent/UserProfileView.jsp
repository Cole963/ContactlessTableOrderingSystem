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
      <div class="row">
         <div class="container">
            <h3 class="text-center">List of User Profiles</h3>
            <hr>
            <br>
            <div class="container">
               <div class="row">
                  <div class="col-md-6">
                     <form action="searchUserProfile" method="post" onsubmit="return trimSearchInput();">
                        <input id="searchInput" type="text" class="form-control" name="searchInput" placeholder="Search User Profile by profile name (case sensitive)"/>
                     </form>
                  </div>
                  <div class="col-md-6">
                     <a href="<%=request.getContextPath()%>/newUserProfileForm" class="btn btn-outline-success my-2 my-sm-0" type="submit" style="float: right;"> + </a>
                     <br></br>
                  </div>
               </div>
            </div>
            <br>
            <table class="table table-bordered table-hover">
               <thead>
                  <tr>
                     <th>ID</th>
                     <th>Profile</th>
                     <th>Description</th>
                     <th>Action</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="userProfile" items="${userProfileList}">
                     <tr>
                        <td>
                           <c:out value="${userProfile.id}" />
                        </td>
                        <td>
                           <c:out value="${userProfile.profile}" />
                        </td>
                        <td>
                           <c:out value="${userProfile.description}" />
                        </td>
                        <td><a href="editUserProfileForm?id=<c:out value='${userProfile.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                           <a href="deleteUserProfile?id=<c:out value='${userProfile.id}' /> "
                              onclick="return confirmUserAction('Confirm delete of this user profile?');">Delete</a>
                        </td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>