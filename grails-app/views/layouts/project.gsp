<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Docs Catalog"/>
    </title>
    <g:javascript library="jquery" />
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>
<body>

    <div class="navbar navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <div class="nav" role="navigation">
                    <ul>
                        <li><asset:image src="logoSomma.png" style="width: 80px;"/></li>
                            <li><g:link action="index">
                            Home</g:link></li>
                            <li> <g:each in="${domainsProjectList}" status="i" var="domain">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <li><g:link action="domain" id="${domain.id}">${domain.name}</g:link></li>
                                </tr>
                            </g:each></li>
                        </ul>                        
                    </div>
                </div>
            </div>
        </div>

        
    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

</body>
</html>