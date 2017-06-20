    <!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="app" />
        <g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#list-project" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/home/index')}"><g:message code="default.home.label"/></a></li>
            </ul>
        </div>
        <div id="list-project" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <table>
                <thead>
                    <tr>
                        <g:sortableColumn property="name" title="Name" />
                        <g:sortableColumn property="start_date" title="Start date" />
                    </tr>
                </thead>
                <tbody>
                <g:each in="${projectList}" status="i" var="project">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td><g:link action="project" id="${project.id}">${project.name}</g:link></td>
                        <td><g:formatDate date="${project.start_date}" /></td>
                    </tr>
                </g:each>
                </tbody>
            </table>

            <div class="pagination">
                <g:paginate total="${projectCount ?: 0}" />
            </div>
        </div>
    </body>
</html>