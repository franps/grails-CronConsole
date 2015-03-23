<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">document.body.innerHTML = ''</script>
        <title>Grails Totem</title>
        <script src="../js/jquery-2.0.3.js"></script>
        <script src="../assets/angular-1.2.26/angular.min.js"></script>
        <script src="../assets/angular-1.2.26/angular-route.js"></script>
        <script src="../js/ui-bootstrap-tpls-0.12.1.min.js"></script>
        <script src="../js/angular-app/app.js"></script>
        <script src="../js/angular-app/services.js"></script>
        <script src="../js/angular-app/controllers.js"></script>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel='stylesheet' media='screen' href='../css/font-awesome.css' />
        <link rel='stylesheet' media='screen' href='../css/lesser-dark.css' />
        <link rel='stylesheet' media='screen' href='../css/app.css' />
    </head>
    <body ng-app="grailsCronApp" data-theme="lesser-dark">
    <div class="navbar navbar-fixed-top">
    <span class="navbar-brand">Grails Totem</span>
        <ul class="nav nav-tabs">
            <li role="presentation" ><a href="#editor">Editor</a></li>
            <li role="presentation"><a href="/totem/code/list">Lista Scripts</a></li>
        </ul>
    </div>
       
        <style type="text/css">
          .CodeMirror {border-top: 1px solid #eee; border-bottom: 1px solid #eee; line-height: 1.3; height: 500px}
          .CodeMirror-linenumbers { padding: 0 8px; }
          .cm-s-monokai.CodeMirror {height: 500px}
        </style>
            <ng-view></ng-view>
    </body>
</html>
