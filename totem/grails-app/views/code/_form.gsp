<%@ page import="totem.Code" %>



			<div class="control-group fieldcontain ${hasErrors(bean: codeInstance, field: 'code', 'error')} ">
				<label for="code" class="control-label"><g:message code="code.code.label" default="Code" /></label>
				<div class="controls">
					<g:textArea name="code" cols="40" rows="5" maxlength="5000" value="${codeInstance?.code}"/>
					<span class="help-inline">${hasErrors(bean: codeInstance, field: 'code', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: codeInstance, field: 'hour', 'error')} required">
				<label for="hour" class="control-label"><g:message code="code.hour.label" default="Hour" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<g:field type="number" name="hour" required="" value="${codeInstance.hour}"/>
					<span class="help-inline">${hasErrors(bean: codeInstance, field: 'hour', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: codeInstance, field: 'isActive', 'error')} ">
				<label for="isActive" class="control-label"><g:message code="code.isActive.label" default="Is Active" /></label>
				<div class="controls">
					<bs:checkBox name="isActive" value="${codeInstance?.isActive}" />
					<span class="help-inline">${hasErrors(bean: codeInstance, field: 'isActive', 'error')}</span>
				</div>
			</div>

			<div class="control-group fieldcontain ${hasErrors(bean: codeInstance, field: 'lastRun', 'error')} required">
				<label for="lastRun" class="control-label"><g:message code="code.lastRun.label" default="Last Run" /><span class="required-indicator">*</span></label>
				<div class="controls">
					<bs:datePicker name="lastRun" precision="day"  value="${codeInstance?.lastRun}"  />
					<span class="help-inline">${hasErrors(bean: codeInstance, field: 'lastRun', 'error')}</span>
				</div>
			</div>

