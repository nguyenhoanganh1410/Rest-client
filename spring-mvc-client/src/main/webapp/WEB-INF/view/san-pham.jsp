
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
                <h2>CRM - Product Relationship Manager</h2>
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
                              
                                <th>Tên sản phẩm</th>
                              	<th>Giá</th>
                                <th>Action</th>
                        </tr>
                        <!-- loop over and print our customers -->
                        <c:forEach var="tempCustomer" items="${dsSanPham}">
                        
                        
                                <!-- construct an "update" link with customer id -->
                                <c:url var="updateLink" value="/students/showFormForUpdate">
                                        <c:param name="ma-loai" value="${tempCustomer.id}" />
                                </c:url>		
                                			
                                <!-- construct an "delete" link with customer id -->
                                <c:url var="deleteLink" value="/students/delete">
                                        <c:param name="ma-loai" value="${tempCustomer.id}" />
                                </c:url>	
                                
                              
                                
                                			
                                <tr>
                                        <td> ${tempCustomer.tenSP} </td>
                                        <td> ${tempCustomer.gia} </td>
                                       
                                       
                                        <td>
                                                <!-- display the update link -->
                                                <a href="${updateLink}">Update</a>
                                             |
                                                <a href="${deleteLink}"
                                                   onclick="if (!(confirm('Are you sure you want to delete this student?'))) return false">Delete</a>
                                        	|
                                        	  <!-- display the update link -->
                                                <a href="${detailLink}">Products</a>
                                        </td>
                                </tr>
                        </c:forEach>

                </table>

        </div>

</div>


</body>

</html>









