<!DOCTYPE html>
<html>
   <head>
      <%@include file= "include/header.jsp" %>
      <%	
         response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
         response.setHeader("Pragma", "no-cache");
         
         if(session.getAttribute("username")==null)
         {
         response.sendRedirect("LoginForm.jsp");
         }
         %>
   <style>
   body {background-image: linear-gradient(rgba(0,0,0,0.6),rgba(0,0,0,0.6)), url("img/background.jpg");
   		height: 100vh;
   		-webkit-background-size: cover;
   		background-size: cover;
   		background-position: center center;}
   </style>
   </head>
   <body>
      <header>
        <%@include file = "include/navbar.jsp" %>
      </header>
      <br>
	    <div class = "welcome-text">
	      <h1>Welcome</h1>
	      <h2>We are ScreamScrum</h2>
	   	</div>
   </body>
</html>