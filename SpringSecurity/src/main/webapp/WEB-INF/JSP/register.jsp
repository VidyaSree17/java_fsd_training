<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
<h2>Register User</h2>

<form:form method="post" action="register" modelAttribute="user">
    <table>
        <tr>
            <td>Username:</td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><form:password path="password"/></td>
        </tr>
		<tr>
		     <td>Confirm Password:</td>
		            <td><form:password path="cpassword"/></td>
		        </tr>
        <tr>
            <td>Details:</td>
            <td><form:input path="details"/></td>
        </tr>
		<tr> 
			<td>Group Permission:</td> 
			<td><form:input path="groupPermission"/></td> 
		</tr>
        <tr>
            <td colspan="2"><input type="submit" value="Register"/></td>
        </tr>
    </table>
</form:form>

</body>
</html>
