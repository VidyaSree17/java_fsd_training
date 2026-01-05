

    <form action="login" method="POST">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        Username:<input type='text' name="username" /><br>
		Password:<input type='password' name="password" />
		<input type='submit' value='Login'/>
    </form>

