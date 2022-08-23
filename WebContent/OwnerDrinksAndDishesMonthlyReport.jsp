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
         else if(!(session.getAttribute("profile").equals("Restaurant Owner")))
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
            <h3 class="text-center">Customer Drinks and Dishes Monthly Report</h3>
            <hr>
            <div class = "col-md-6">
               <form action = "viewOwnerDrinksAndDishesMonthlyReport" method = "post">			
                  Date: <input type="month" id="selectedMonthVal" class = "form-control" name="selectedMonthVal" onchange = "drinksAndDishesMonthlyCheck();" /> 
               </form>
            </div>
            
               <p>
            </p>
                  <c:if test="${date != null}">
                     <div class="col-md-6 text-success">
                        <p>
                           Year & Month: 
                           <c:out value="${date}" />
                        </p>
                     </div>
                  </c:if>
                  
                  
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewOwnerDrinksAndDishesWeeklyReport" display="inline" style="float:right"> Weekly </a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewOwnerDrinksAndDishesDailyReport" display="inline" style="float:right"> Daily </a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewOwnerDrinksAndDishesReport" display="inline" style="float:right"> General </a>
            <br></br>
            <table class="table table-bordered" id="tableReport">
               <thead>
                  <tr>
                     <th>Menu Item</th>
                     <th>Quantity</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="ownerReport" items="${ownerReportList}">
                     <tr id="ownerReport">
                        <td>
                           <c:out value="${ownerReport.name}" />
                        </td>
                        <td>
                           <c:out value="${ownerReport.quantity}" />
                        </td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>