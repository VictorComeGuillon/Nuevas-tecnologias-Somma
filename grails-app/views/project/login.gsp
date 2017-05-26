<%@page defaultCodec="HTML" %>
<html>
<head>
  <title>Application Login</title>
</head>
<body>
  <h1>Log in to the application</h1>
  <g:form controller="project" value="signIn">
    <div>Project Key: <input type="text" name="key_project" value="${params.key_project}"/></div>
  </g:form>
</body>
</html>