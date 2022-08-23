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
            <h3 class="text-center">Customer Drinks and Dishes Weekly Report</h3>
            <hr>
            <div class = "col-md-6">
               <form action = "viewOwnerDrinksAndDishesWeeklyReport" method = "post">
                  Start Date: <input type="date" id="selectedDateVal1" class = "form-control" name="selectedDateVal1" onchange = "drinksAndDishesWeeklyCheck();" /> 		
               </form>
               <form action = "viewOwnerDrinksAndDishesWeeklyReport" method = "post">		
                  End Date: <input type="date" id="selectedDateVal2" class = "form-control" name="selectedDateVal2" onchange = "drinksAndDishesWeeklyCheck();" /> 
               </form>
            </div>
            
             <p>
            </p>
                  <c:if test="${startDate != null && endDate != null}">
                     <div class="col-md-6 text-success">
                        <p>
                           Start Date: 
                           <c:out value="${startDate}" />
                        </p>
                         <p>
                           End Date: 
                           <c:out value="${endDate}" />
                        </p>
                     </div>
                  </c:if>
                  
                  
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewOwnerDrinksAndDishesMonthlyReport" display="inline" style="float:right"> Monthly </a>
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