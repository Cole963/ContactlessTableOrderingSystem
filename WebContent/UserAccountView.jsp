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
            <h3 class="text-center">List of User Accounts</h3>
            <hr>
            <br>
            <div class="container">
               <div class="row">
                  <div class="col-md-6">
                     <form action="searchUserAccount" method="post" onsubmit="return trimSearchInput();">
                        <input id="searchInput" type="text" class="form-control" name="searchInput" placeholder="Search User Account by full name..."/>
                     </form>
                  </div>
                  <div class="col-md-6">
                     <a href="<%=request.getContextPath()%>/newUserAccountForm" class="btn btn-outline-success my-2 my-sm-0" type="submit" style="float: right;"> + </a>
                     <br></br>
                  </div>
               </div>
            </div>
            <br>
            <table class="table table-bordered table-hover">
               <thead>
                  <tr>
                     <th>ID</th>
                     <th>Name</th>
                     <th>Username</th>
                     <th>Email</th>
                     <th>User Profile</th>
                     <th>Status</th>
                     <th>Action</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="user" items="${userAccountList}">
                     <tr>
                        <td>
                           <c:out value="${user.id}" />
                        </td>
                        <td>
                           <c:out value="${user.name}" />
                        </td>
                        <td>
                           <c:out value="${user.username}" />
                        </td>
                        <td>
                           <c:out value="${user.email}" />
                        </td>
                        <td>
                           <c:out value="${user.userprofile.profile}" />
                        </td>
                        <c:if test="${user.status == 'active'}">
                           <td class="text-success">
                              <c:out value="${user.status}" />
                           </td>
                           <td>
                              <a href="suspendUserAccount?id=<c:out value='${user.id}' />&status=suspended " 
                                 onclick="return confirmUserAction('Confirm suspension this user account?');">Suspend</a>&nbsp;&nbsp;&nbsp;&nbsp;
                              <a href="editUserAccountForm?id=<c:out value='${user.id}' />">Edit</a>
                           </td>
                        </c:if>
                        <c:if test="${user.status == 'suspended'}">
                           <td class="text-danger">
                              <c:out value="${user.status}" />
                           </td>
                           <td>
                              <a href="suspendUserAccount?id=<c:out value='${user.id}' />&status=active " 
                                 onclick="return confirmUserAction('Confirm activation of this user account?');">Unsuspend
                              </a>
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