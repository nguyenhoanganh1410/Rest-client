
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List Customers</title>
    <!-- reference our style sheet -->
  
              <link href="${pageContext.request.contextPath}/resources/css/style.css"
    rel="stylesheet">
</head>
<body>
<div id="wrapper">
        <div id="header">
                <h2>CRM - Student Relationship Manager</h2>
        </div>
</div>
<div id="container">
        <div id="content">
                <!-- put new button: Add Customer -->
                <input type="button" value="Add Student"
                           onclick="window.location.href='showFormForAdd'; return false;" class="add-button"  />
                            <%--  window.location.href returns the href (URL) of the current page
                            Changing the value of the property will redirect the page.--%>
                <!--  add our html table here -->
                <table>
                        <tr>
                                <th>Name</th>
                                <th>Age</th>
                                <th>Sex</th>
                                <th>Favorite Language</th>
                                <th>Favorite Subject</th>
                                <th>Action</th>
                        </tr>
                        <!-- loop over and print our customers -->
                        <c:forEach var="tempCustomer" items="${students}">
                        
                        
                                <!-- construct an "update" link with customer id -->
                                <c:url var="updateLink" value="/students/showFormForUpdate">
                                        <c:param name="studentId" value="${tempCustomer.id}" />
                                </c:url>		
                                			
                                <!-- construct an "delete" link with customer id -->
                                <c:url var="deleteLink" value="/students/delete">
                                        <c:param name="studentId" value="${tempCustomer.id}" />
                                </c:url>		
                                
                                			
                                <tr>
                                        <td> ${tempCustomer.name} </td>
                                        <td> ${tempCustomer.age} </td>
                                       
                                        <c:choose>
										  <c:when test="${tempCustomer.sex == 1}">
										    <td>Male</td>
										  </c:when>
										  <c:otherwise>
										   <td>Female</td>
										  </c:otherwise>
										</c:choose>
                                        <td> ${tempCustomer.favoriteLanguage} </td>
                                        <td>
                                       
                                        	<c:forEach var="temp" items="${tempCustomer.favoriteSubject}">
                                        		<span>${temp}</span>
                                        	</c:forEach>
                                        </td>
                                        <td>
                                                <!-- display the update link -->
                                                <a href="${updateLink}">Update</a>
                                             |
                                                <a href="${deleteLink}"
                                                   onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
                                        </td>
                                </tr>
                        </c:forEach>

                </table>

        </div>

</div>


</body>

</html>









