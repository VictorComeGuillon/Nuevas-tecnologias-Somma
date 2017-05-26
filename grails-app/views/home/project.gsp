<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="app" />
        <g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-project" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/test')}"><g:message code="default.home.label"/></a></li>
                <li> <g:each in="${domainsProjectList}" status="i" var="domain">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <li><g:link action="domain" id="${domain.id}">${domain.name}</g:link></li>
                    </tr>
                </g:each></li>
            </ul>
        </div>
        <div id="show-project" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:display bean="project" />
            
                <tbody>
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
                
        </div>
    </body>
</html>
