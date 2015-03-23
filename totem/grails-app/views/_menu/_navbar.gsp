<nav id="Navbar" class="navbar navbar-fixed-top navbar-inverse" role="navigation">
	<div class="container">
	
	    <div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
        		<span class="sr-only">Toggle navigation</span>
        		<span class="icon-bar"></span>
	           	<span class="icon-bar"></span>
	           	<span class="icon-bar"></span>
			</button>
	
			<a class="navbar-brand" href="${createLink(uri: '/')}">
				<img class="logo" src="${resource(plugin: 'kickstart-with-bootstrap', dir:'kickstart/img', file:'grails.png')}" alt="${meta(name:'app.name')}" width="16px" height="16px"/> 
				${meta(name:'app.name')}
				<small> v${meta(name:'app.version')}</small>
			</a>
		</div>

		<div class="collapse navbar-collapse navbar-ex1-collapse" role="navigation">

		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#">Browse <b class="caret"></b></a>
				<ul class="dropdown-menu">
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <li class="controller">
							<g:if test="${c.fullName.contains('HomeController') || c.fullName.contains('DemoPageController') || c.fullName.contains('DbdocController')}">
					    		
							</g:if>
							
                             <g:else>
                             <g:link controller="${c.logicalPropertyName}">
                            ${c.fullName.substring(c.fullName.lastIndexOf('.')+1)}
                            </g:link>
                            </g:else>
                    	
                    </li>
                    </g:each>
				</ul>
			</li>
		</ul>


		</div>
	</div>
</nav>
