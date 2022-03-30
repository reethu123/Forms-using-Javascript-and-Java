<#if modelList??>
  <#list modelList as model>
	<tr>
		<td></td>
		<td>${model.name}</td>
		<td>${model.typeName}</td>
		<td>
			<a class="icon-action" href="#"><span class="glyphicon glyphicon-pencil show-modal" data-sectorId="${model.id}" data-name="${model.name}" data-type="${model.typeId}" onclick="getEditSectorTypeMenu(${model.id})" data-toggle="modal" data-target="#editPopup" title="Edit"></span></a>
			<!-- <a class="icon-action" href="#"  onclick="if (confirm('Delete selected item?')) { return deleteLinkFunction(${model.id})} else { return false; }"><span class="glyphicon glyphicon-trash"  title="Delete"></span></a> -->
		</td>
	</tr>
  </#list>
</#if>