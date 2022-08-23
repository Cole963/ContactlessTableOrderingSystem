<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <%@include file= "include/header.jsp" %>
   </head>
   <body>
      <c:if test="${sessionScope.userActionMessage != null }">
         <script>
            alert("<c:out value = "${userActionMessage}" />");
         </script>
         <c:remove var="userActionMessage"/>
      </c:if>
      <%@include file = "include/navbar.jsp" %>
      <div class = "container" align = "center">
         <form action="searchMenuItemCustomer" method="post" onsubmit="return trimSearchInput();">
            <input id="searchInput" type="text" class="searchMenu" name="searchInput" placeholder="Which food do you want to eat?"/>
         </form>
      </div>
      <div class = "container">
         <div class = "row text-center py-5">
            <c:forEach var="item" items="${menuItemList}">
               <div class ="col-md-3 col-sm-6 my-3 my-md-3">
                  <form action = "homePage.jsp" method= "post">
                     <div class = "card shadow">
                        <div>
                           <img src= "
                           <c:out value = "${item.picture}"/>
                           " alt = "imghere" class="img-fluid card-img-top mainMenuImg">
                        </div>
                        <div class ="card-body">
                           <h5 class="card-title">
                              <c:out value="${item.name}" />
                           </h5>
                           <h5>
                              <span class="price">
                                 $
                                 <fmt:formatNumber type="number"
                                    minFractionDigits="2"
                                    maxFractionDigits="2"
                                    value="${item.price}"/>
                              </span>
                           </h5>
                           <a href="addToCart?id=<c:out value='${item.id}' />" class="btn btn-warning my-3">Add to Cart <i class="fas fa-shopping-cart"></i></a>
                        </div>
                     </div>
                  </form>
               </div>
            </c:forEach>
         </div>
      </div>
   </body>
</html>