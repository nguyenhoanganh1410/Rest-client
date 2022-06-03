<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

  <!-- reference our style sheet -->
  
              <link href="${pageContext.request.contextPath}/resources/css/style.css"
    rel="stylesheet">
    <style>
    	.formStyle{
    	width: 50%;}
    	.error{
    		color:red;
    	}
    </style>
</head>
<body>
	<div id="wrapper">
        <div id="header">
                <h2>CRM - Customer Relationship Manager</h2>
        </div>
        <div class="formStyle">
	       <form:form  action="update" modelAttribute="student">
		     <form:hidden path = "id" />
		     <div class="form-group">
			    <label for="name">Name:</label>
			    <form:input  path="name" class="form-control" placeholder="Enter name" />
			    <form:errors path="name" cssClass="error"/>
			  </div>
			  
			   <div class="form-group">
			    <label for="age">Age:</label>
			    <form:input   path="age" class="form-control" placeholder="Enter age"  />
			    <form:errors path="age" cssClass="error"/>
			  </div>
			  
			  	
		        Gender:   
		        Male <form:radiobutton path="sex" value="1"/>  
		        Female <form:radiobutton path="sex" value="0"/>  
		         <form:errors path="sex" cssClass="error"/>
		         <br>
		          <br>
			    <form:label path="favoriteSubject">Select favorite subject: </form:label>
                <form:checkbox path="favoriteSubject" value="Java" label="Java"/> 
                <form:checkbox path="favoriteSubject" value="PHP" label="PHP"/>
			  <br>
		          <br>
			   Favorite Language:   
		        Java <form:radiobutton path="favoriteLanguage" value="java"/>  
		        JavaScript <form:radiobutton path="favoriteLanguage" value="javascript"/>  
		         <form:errors path="favoriteLanguage" cssClass="error"/>
				
				<br>
				<input type="submit" value="Save" class="btn btn-primary"/>
			</form:form>
		</div>
	</div>
</body>
</html>