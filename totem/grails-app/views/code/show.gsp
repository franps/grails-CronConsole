
<%@ page import="totem.Code" %>
<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="layout" content="kickstart" />
	<g:set var="entityName" value="${message(code: 'code.label', default: 'Code')}" />
	<title><g:message code="default.show.label" args="[entityName]" /></title>
</head>

<body>

<section id="show-code" class="first">

	<table class="table">
		<tbody>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="code.code.label" default="Code" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: codeInstance, field: "code")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="code.hour.label" default="Hour" /></td>
				
				<td valign="top" class="value">${fieldValue(bean: codeInstance, field: "hour")}</td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="code.isActive.label" default="Is Active" /></td>
				
				<td valign="top" class="value"><g:formatBoolean boolean="${codeInstance?.isActive}" /></td>
				
			</tr>
		
			<tr class="prop">
				<td valign="top" class="name"><g:message code="code.lastRun.label" default="Last Run" /></td>
				
				<td valign="top" class="value"><g:formatDate date="${codeInstance?.lastRun}" /></td>
				
			</tr>
		
		</tbody>
	</table>
</section>

</body>

</html>
