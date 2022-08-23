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
            <h3 class="text-center">Customer Frequency Weekly Report</h3>
            <hr>
            <div class = "col-md-6">
               <form action = "viewOwnerFrequencyWeeklyReport" method = "post">
                  Start Date: <input type="date" id="selectedDateVal1" class = "form-control" name="selectedDateVal1" onchange = "frequencyWeeklyCheck();" /> 		
               </form>
               <form action = "viewOwnerFrequencyWeeklyReport" method = "post">		
                  End Date: <input type="date" id="selectedDateVal2" class = "form-control" name="selectedDateVal2" onchange = "frequencyWeeklyCheck();" /> 
               </form>
            </div>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewMonthlyFrequencyReport" display="inline" style="float:right"> Monthly </a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewDailyFrequencyReport" display="inline" style="float:right"> Daily </a>
            <a class="btn btn-outline-success my-2 my-sm-0" href="<%=request.getContextPath()%>/viewOwnerFrequencyReport" display="inline" style="float:right"> General </a>
            <br></br>
            <table class="table table-bordered" id="tableReport">
               <thead>
                  <tr>
                     <th>Number of Customer</th>
                     <th>Start Date</th>
                     <th>End Date</th>
                  </tr>
               </thead>
               <tbody>
                  <c:forEach var="ownerReport" items="${ownerReportList}">
                     <tr id="ownerReport">
                        <td>
                           <c:out value="${ownerReport.noOfDistMobileNum}" />
                        </td>
                        <td>
                           <c:out value="${ownerReport.startDate}" />
                        </td>
                        <td>
                           <c:out value="${ownerReport.endDate}" />
                        </td>
                     </tr>
                  </c:forEach>
               </tbody>
            </table>
         </div>
      </div>
   </body>
</html>