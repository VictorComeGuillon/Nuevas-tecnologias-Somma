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
                <a class="navbar-brand" href="/home/index">
                    <i class="fa grails-icon">
                        <asset:image src="logoSomma.png"/>
                        </i> Home
                </a>
                <a href="/home/domain/1" class="navbar-brand">
                    Plans Architecte
                </a>
                <a href="/home/project" class="navbar-brand">
                    Lots
                </a>
                <a href="/home/domain/2" class="navbar-brand">
                    Rapports
                </a>
                <a href="/home/domain/3" class="navbar-brand">
                    Controls
                </a>
            </div>
            <div class="navbar-collapse collapse" aria-expanded="false" style="height: 0.8px;">
                <ul class="nav navbar-nav navbar-right">
                    <g:pageProperty name="page.nav" />
                </ul>
            </div>
        </div>
    </div>

    <g:layoutBody/>

    <div class="footer" role="contentinfo"></div>

</body>
</html>