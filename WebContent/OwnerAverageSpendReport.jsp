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
            <h3 class="text-center">Customer Average Spending Full Report</h3>
            <hr>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewMonthlyAverageSpendReport" display="inline" style="float:right"> Monthly </a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewOwnerAverageSpendWeeklyReport" display="inline" style="float:right"> Weekly </a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewDailyAverageSpendReport" display="inline" style="float:right"> Daily </a>
            <br></br>
            <table class="table table-bordered">
               <thead>
                  <tr>
                     <th>Number of Visitors</th>
                     <th>Average Spending</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="ownerReport" items="${ownerReportList}">
                     <tr>
                        <td>
                           <c:out value="${ownerReport.noOfDistMobileNum}" />
                        </td>
                        <td>
                           $<fmt:formatNumber type="number"
                              minFractionDigits="2"
                              maxFractionDigits="2"
                              value="${ownerReport.avgSpend}"/>
                        </td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>