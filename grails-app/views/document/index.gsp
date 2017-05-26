<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main">
        <title>Document List</title>
    </head>
    <body>
        <div class="nav" role="navigation">
            <ul><li><g:link class="create" action="create">Upload New Document</g:link></li></ul>
        </div>
        <div class="content scaffold-list" role="main">
            <h1>Document List</h1>
            <g:if test="${flash.message}"><div class="message" role="status">${flash.message}</div></g:if>
            <table>
                <thead>
                    <tr>
                        <g:sortableColumn property="name" title="Name" />
                        <g:sortableColumn property="creation_date" title="Creation Date" />
                    </tr>
                </thead>
                <tbody>
                <g:each in="${documentList}" status="i" var="document">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td><g:link action="download" id="${document.id}">${document.name}</g:link></td>
                        <td><g:formatDate date="${document.creation_date}" /></td>
                    </tr>
                </g:each>
                </tbody>
            </table>
            <div class="pagination">
                <g:paginate total="${documentCount}" />
            </div>
        </div>
    </body>
</html>