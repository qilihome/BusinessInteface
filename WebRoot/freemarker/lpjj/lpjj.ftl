	<#include "/common/head.ftl">
	<#include "/common/plugin.ftl"/>
	<body>
		<#if customerTemplateContentList??>
			<#list customerTemplateContentList as each>
				<#if each.contenttype == 1>
					<@textPlugin each/>
				</#if>
				<#if each.contenttype == 2>
					<@imgPlugin each/>
				</#if>
				<#if each.contenttype == 3>
					<@videoPlugin each/>
				</#if>
				<#if each.contenttype == 4>
					<@mapPlugin each/>
				</#if>
			</#list>
		</#if>
	</body>
</html>