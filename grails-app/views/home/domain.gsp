<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="domain">
        <title>Document List</title>
    </head>
    <body>
        
        <div class="content scaffold-list" role="main">
            <h1>Document List in ${domain.name}</h1>
            <g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
            <table>
                <thead>
                    <tr>
                        <g:sortableColumn property="name" title="Name" />
                        <g:sortableColumn property="creation_date" title="Creation Date" />
                        <g:sortableColumn property="user.id" title="Created by" />
                    </tr>
                </thead>
                <tbody>
                <g:each in="${documentList}" status="i" var="document">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td><g:link action="download" id="${document.id}">${document.name}</g:link></td>
                        <td><g:formatDate date="${document.creation_date}" /></td>
                        <td>${document.user.username}</td>

                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </body>
</html>