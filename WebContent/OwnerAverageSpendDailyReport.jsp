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
            <h3 class="text-center">Customer Average Spend Daily Report</h3>
            <hr>
            <div class = "col-md-6">
               <form action = "viewDailyAverageSpendReport" method = "post">			
                  Date: <input type="date" id="selectedDateVal" class = "form-control" name="selectedDateVal" onchange = "averageSpendDailyCheck();" /> 
               </form>
            </div>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewMonthlyAverageSpendReport" display="inline" style="float:right"> Monthly </a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewOwnerAverageSpendWeeklyReport" display="inline" style="float:right"> Weekly </a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewOwnerAverageSpendReport" display="inline"  style="float:right"> General </a>
            <br></br>
            <table class="table table-bordered" id="tableReport">
               <thead>
                  <tr>
                     <th>Number of Customers</th>
                     <th>Average Spending</th>
                     <th>Date</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="ownerReport" items="${ownerReportList}">
                     <tr id="ownerReport">
                        <td>
                           <c:out value="${ownerReport.noOfDistMobileNum}" />
                        </td>
                        <td>
                           $<fmt:formatNumber type="number"
                              minFractionDigits="2"
                              maxFractionDigits="2"
                              value="${ownerReport.avgSpend}"/>
                        </td>
                        <td>
                           <c:out value="${ownerReport.date}" />
                        </td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>