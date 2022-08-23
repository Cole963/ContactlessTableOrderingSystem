<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <%@include file= "include/header.jsp" %>
   </head>
   <body>
      <%@include file = "include/navbar.jsp" %>
      <div class ="container">
         <div class = "d-flex py-3">
            <h3 class = "ml-auto">
               Total Price: $
               <fmt:formatNumber type="number"
                  minFractionDigits="2"
                  maxFractionDigits="2"
                  value="${total}"/>
            </h3>
            <form class="ml-auto" action = "cartCheckOut" method = "post" class ="form-inline">
               <input type="text" name="mobileNum" id="mobileNum" placeholder = "Input your mobile number" hidden = "hidden">
               <button type = "submit" class="btn btn-success" id = "checkoutButton" onclick = "return promptMobileNum()">Check out</button>
            </form>
         </div>
         <table class= "table table-loght">
            <thead>
               <tr>
                  <th scope="col">Name</th>
                  <th scope="col">Price</th>
                  <th scope="col">Quantity</th>
                  <th scope="col">Sub Total Price</th>
                  <th scope="col">Remove from cart</th>
               </tr>
            </thead>
            <tbody>
               <c:if test="${sessionCartList != null}">
                  <c:forEach var="cartItem" items="${sessionCartList}">
                     <tr>
                        <td>
                           <c:out value='${cartItem.name}' />
                        </td>
                        <td>
                           $
                           <fmt:formatNumber type="number"
                              minFractionDigits="2"
                              maxFractionDigits="2"
                              value="${cartItem.price}"/>
                        </td>
                        <td>
                           <form action="" method ="post" class="form-inline formQuantity" id="formQuantity">
                              <input type="hidden" name= "id" value = "<c:out value='${cartItem.id}' />" class = "form-input">
                              <div class = "form-group d-flex justify-content-between">
                                 <a class="btn btn-sm btn-change" href ="quantityChange?action=dec&id=<c:out value='${cartItem.id}' />"><i class="fa-solid fa-square-minus" style="color:#4ba2ff"></i></a>
                                 <input type ="text" name="quantity" class= "form-control" value= "<c:out value='${cartItem.quantity}' />" readonly> 
                                 <a class="btn btn-sm btn-change" href ="quantityChange?action=inc&id=<c:out value='${cartItem.id}' />"><i class="fa-solid fa-square-plus" style="color:#4ba2ff"></i></a>
                              </div>
                           </form>
                        </td>
                        <td>
                           $
                           <fmt:formatNumber type="number"
                              minFractionDigits="2"
                              maxFractionDigits="2"
                              value="${cartItem.subTotalPrice}"/>
                        </td>
                        <td>
                           <a class="btn btn-sm btn-danger" href="removeFromCart?id=<c:out value='${cartItem.id}' />">Remove</a>
                        </td>
                     </tr>
                  </c:forEach>
               </c:if>
            </tbody>
         </table>
      </div>
   </body>
</html>