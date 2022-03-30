<#if modelList??>
	<option value=""> Select Any Sector</option>
	<#list modelList as model>
		<optgroup label="${model.type}">
			<#list model.sectors as sector>
            	<option value="${sector.id}">${sector.name}</option>
            </#list>
        </optgroup>
	</#list>
</#if>