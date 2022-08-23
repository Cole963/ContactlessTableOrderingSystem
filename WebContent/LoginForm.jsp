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
   </head>
   <body>
      <header>
        <%@include file = "include/navbar.jsp" %>
      </header>
      <br>
      <div class="container col-md-4">
         <div class="card">
            <div class="card-body">
               <form id="loginForm" action="login" method="post"  onsubmit="return loginValidation();">
                  <h2>Login</h2>
                  <fieldset class="form-group">
                     <label>Username</label>
                     <input type="text" class="form-control" name="username" id="username">
                     <i class="fa-solid fa-circle-check symbol valid"></i>
                     <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
                     <small>Error</small>
                  </fieldset>
                  <fieldset class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" name="password" id="password">
                     <i class="fa-solid fa-circle-check symbol valid"></i>
                     <i class="fa-solid fa-circle-exclamation symbol invalid"></i>
                     <small>Error</small>
                  </fieldset>
                  <div class="btn-toolbar pull-right">
                     <button type="submit" class="btn btn-outline-success my-2 my-sm-0 mr-3">Login</button>
                  </div>
               </form>
            </div>
         </div>
      </div>
   </body>
</html>