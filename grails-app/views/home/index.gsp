<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Home Page</title>
</head>
<body>

    <div id="content" role="main">
        <section class="row colset-2-its">   
        <g:link action="test">ENTER</g:link>         
        <h1>Welcome ${name}!</h1>
        <g:if test="${flash.message}"> 
            <div class="message" role="status">${flash.message}</div>
        </g:if>

            <p>There are ${documentTotal} documents in the database.</p> 

            <ul>
                <g:each in="${documentList}" var="document">
                <li><g:link controller="document" action="show" id="${document.id}">
                ${document.creation_date} - ${document.name} </g:link>
                ${document.project.name}</li>

            </g:each>
        </ul>

        <g:form action="updateName" style="margin: 0 auto; width:320px"> 
            <g:textField name="name" value="" />
            <g:submitButton name="Update name" />
        </g:form>

        
    </section>
</div>

</body>
</html>
