
<%@ page import="totem.Code" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'code.label', default: 'Code')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
</head>

<body>
	
<section id="list-code" class="first">

	<table class="table table-bordered margin-top-medium">
		<thead>
			<tr>
			     <g:sortableColumn property="code" title="${message(code: 'code.code.label', default: 'Id')}" />
				<g:sortableColumn property="code" title="${message(code: 'code.code.label', default: 'Code')}" />
			
				<g:sortableColumn property="hour" title="${message(code: 'code.hour.label', default: 'Hour')}" />
			
				<g:sortableColumn property="isActive" title="${message(code: 'code.isActive.label', default: 'Is Active')}" />
			
				<g:sortableColumn property="lastRun" title="${message(code: 'code.lastRun.label', default: 'Last Run')}" />
			
			</tr>
		</thead>
		<tbody>
		<g:each in="${codeInstanceList}" status="i" var="codeInstance">
			<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
			     <td><g:link action="show" id="${codeInstance.id}">${fieldValue(bean: codeInstance, field: "id")}</g:link></td>
				<td><a href="http://localhost:8080/totem/cronConsole/index#/editor/${codeInstance.id}">${fieldValue(bean: codeInstance, field: "code")}</td>
			
				<td>${fieldValue(bean: codeInstance, field: "hour")}</td>
			
				<td><g:formatBoolean boolean="${codeInstance.isActive}" /></td>
			
				<td><g:formatDate date="${codeInstance.lastRun}" /></td>
			
			</tr>
		</g:each>
		</tbody>
	</table>
	<div class="container">
		<bs:paginate total="${codeInstanceTotal}" />
	</div>
</section>

</body>

</html>
