<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="project" />
        <g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>

                <section class="row colset-2-its">  
                                <h1>${session.project}</h1> 
 
                <h2>Documents List</h2>
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
                
            
        </section>
    </body>
</html>
