<#if modelList??>
	<option value=""> Select Any Sector</option>
  <#list modelList as model>
    <option value="${model.id}">${model.type}</option>
  </#list>
</#if>