<!DOCTYPE html>
<html>
   <head>
      <meta charset="ISO-8859-1">
      <title>Check out</title>
      <%@include file= "include/header.jsp" %>
   </head>
   <body>
      <%@include file = "include/navbar.jsp" %>
      <div class ="container">
         <h3 class = "centeredText">Thank you for ordering!</h3>
         <table class= "table table-loght">
            <thead>
               <tr>
                  <th scope="col">Name</th>
                  <th scope="col">Price</th>
                  <th scope="col">Quantity</th>
                  <th scope="col">Sub Total Price</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="cartItem" items="${cartList}">
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
                        <c:out value='${cartItem.quantity}' />
                     </td>
                     <td>
                        $
                        <fmt:formatNumber type="number"
                           minFractionDigits="2"
                           maxFractionDigits="2"
                           value="${cartItem.subTotalPrice}"/>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <table class= "table table-loght">
            <thead>
               <tr>
                  <th scope="col"></th>
                  <th scope="col" class = "centeredText">Total Price</th>
                  <th scope="col" class = "centeredText">
                     $
                     <fmt:formatNumber type="number"
                        minFractionDigits="2"
                        maxFractionDigits="2"
                        value="${total}"/>
                  </th>
               </tr>
            </thead>
         </table>
      </div>
   </body>
</html>