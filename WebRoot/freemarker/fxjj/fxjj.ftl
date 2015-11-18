	<#include "/enjoy/head.ftl">
	<#include "/enjoy/plugin.ftl"/>
	<body>
	
		<#if customerTemplateContentList??>
		<#assign tempVar = 100 />
		<#assign tempInnerVar =1/>
			<#list customerTemplateContentList as each>
				
				<#if each.contenttype == 2>
					<@topImgPlugin each/>
				</#if>
				
				<#if each.contenttype == 6>
					<div class="box 
					<#if (each.albumList?size <= 4)>
						<#if (each.albumList?size == 1)>
							<#if tempInnerVar != 1>
								box_up box_up${each.albumList?size}
							</#if>
						<#else>
							box_up box_up${each.albumList?size}
						</#if>
					</#if>" id="box${tempInnerVar}"> 
						<h3>${each.title}</h3>
							<div class="box_type">         
								<ul class="house_type">          
										<@txtLinkPlugin each/>
								</ul>
							</div>
						<#if (each.albumList?size > 4)>
							<a href="javascript:void(0);" onClick="List.switchList(this,${each.albumList?size},0);return false;" class="btn_more">         
								<span>查看全部户型(${each.albumList?size})</span>	
							</a>	
						</#if>
						</div>
						<#assign tempInnerVar = tempInnerVar + 1 />
				</#if>
			</#list>
			
		</#if>
	</body>
</html>