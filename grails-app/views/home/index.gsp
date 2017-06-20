<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Home Page</title>
</head>
<body>

    <div id="content" role="main">
        <section class="row colset-2-its">   
        <h3>Welcome ${username}!</h3><br>
        

     <div id="list-project" class="content scaffold-list" role="main">
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                    <tr>
                        <g:sortableColumn property="name" title="Name" />
                        <g:sortableColumn property="location" title="location" />
                    </tr>
                </thead>
                <tbody>
                <g:each in="${userProjectList}" status="i" var="project">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td><g:link action="project" id="${project.id}">${project.name}</g:link></td>
                        <td>${project.location}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
        
    </section>
</div>

</body>
</html>
