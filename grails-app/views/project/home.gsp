
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Project Page</title>
</head>
<body>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <h1>Last changes / update</h1> 

            <p>There are ${documentTotal} documents in the project database.</p> 

            <ul>
                <g:each in="${documentList}" var="document">
                <li><g:link controller="document" action="show" id="${document.id}">
                ${document.creation_date} - ${document.name} </g:link>
                ${document.project.name}</li>

            </g:each>
        </ul>

        
    </section>
</div>

</body>
</html>
