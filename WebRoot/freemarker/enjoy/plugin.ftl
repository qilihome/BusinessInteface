	<#macro txtLinkPlugin customerTemplateContent> 
		
		<#list customerTemplateContent.albumList as album>
				<li id="boxLi${tempVar}">                 
					<a href="javascript:void(0);" onClick="List.toggleList(${tempVar},${tempInnerVar});">                     
						<strong>${album.albumname}</strong>                     
						<span>${customerTemplateContent.title}</span>                     
						<em>${album.albumsummary?default("")}</em>				
					</a>         
					<div class="house_photo" style="display:none;">                     
						<a href="${album.albumPhotoStaticHtml?default("")}"  class="ico_type">户型图</a>				
					</div>             
				</li>
				<#assign tempVar = tempVar + 1 />
			</#list>
	</#macro>
	
	<#macro topImgPlugin customerTemplateContent>
		 <div class="act_top" id="actTop" style="display: block; ">
	        <div class="act_top_show">
	           <img src="${domain}/${customerTemplateContent.content}" width="720" height="130" id="bannerPic" />
	    	</div>
	    	</div>
	</#macro>
	
	