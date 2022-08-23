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
            <h3 class="text-center">List of Menu Items</h3>
            <hr>
            <br>
            <div class="container">
               <div class="row">
                  <div class="col-md-6">
                     <form action="searchMenuItem" method="post" onsubmit="return trimSearchInput();">
                        <input id="searchInput" type="text" class="form-control" name="searchInput" placeholder="Search Menu Item by name..."/>
                     </form>
                  </div>
                  <div class="col-md-6">
                     <a href="<%=request.getContextPath()%>/newMenuItemForm" class="btn btn-outline-success my-2 my-sm-0" type="submit" style="float: right;"> + </a>
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
                     <th>Price</th>
                     <th>Picture</th>
                     <th>Action</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="item" items="${menuItemList}">
                     <tr>
                        <td>
                           <c:out value="${item.id}" />
                        </td>
                        <td>
                           <c:out value="${item.name}" />
                        </td>
                        <td>
                           $<fmt:formatNumber type="number"
                              minFractionDigits="2"
                              maxFractionDigits="2"
                              value="${item.price}"/>
                        </td>
                        <td>
                           <img height = "100px" width = "200px" src = "<c:out value = '${item.picture}'/>" alt = "no image"/>
                        </td>
                        <!-- -->
                        <td>
                           <a href="editMenuItemForm?id=<c:out value='${item.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
                           <a href="deleteMenuItem?id=<c:out value='${item.id}' />"
                              onclick="return confirmUserAction('Confirm delete of this Menu Item?');">Delete</a>
                        </td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>