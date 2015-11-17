	<!-- 文本模板 -->
	<#macro textPlugin customerTemplateContent>
		<div class="main-content-wr">
     		<h3 class="main-title">${customerTemplateContent.title}</h3>
     		<div class="main-content-txt main-content-txt-intro">
     			${customerTemplateContent.content}
     		</div>
	     	<div class="main-content-btn">
	     		<span title="更多" class="show-all-txt">更多</span>
	     	</div>
     	</div>
	</#macro>
	
	<!-- 图片模板 -->
	<#macro imgPlugin customerTemplateContent>
		<div class="top-banner-wr">
	    	<img src="${domain}/${customerTemplateContent.content}" />
	    </div>
	</#macro>
	
	<!-- 视频模板 -->
	<#macro videoPlugin customerTemplateContent>
     	<div class="main-content-wr">
     		<h3 class="main-title">${customerTemplateContent.title}</h3>
     		<div class="main-content-txt">
     			<video class="video" width="100%" height="217" preload controls> 
					<source src="${domain}/${customerTemplateContent.content}" type='video/mp4; codecs="avc1.42E01E, mp4a.40.2"' /></source>
				</video>
     		</div>
     	</div>
	</#macro>
	
	<!-- 地图模板 -->
	<#macro mapPlugin customerTemplateContent>
     	<div class="main-content-wr">
     		<h3 class="main-title">地图</h3>
     		<div class="main-content-txt">
     			<div class="box">
     				<div class="box_map">
     					<div class="map_area">
     						<!-- <a href="http://map.soso.com/?type=poi&what=${customerTemplateContent.title}&${customerTemplateContent.content}"> -->
     						<a href='${customerTemplateContent.backup1?default("#")}'>
     							<img title="${customerTemplateContent.title}" alt="${customerTemplateContent.title}" src="http://st.map.soso.com/api?${customerTemplateContent.content}" />
     						</a>
     					</div>
     				</div>
     			</div> 
     			${customerTemplateContent.summary}
     		</div>
     		<div class="main-content-btn">
     			<span title="更多" class="show-all-txt">更多</span>
     		</div>
     	</div>
	</#macro>
	
	<!-- 相集模板 -->
	<#macro malbumsPlugin albumList>
     	<div id="container" style="height: 876px;">
     		<#list albumList as e>
				<div class="grid">
					<div class="imgholder">
						<a href="${e.albumPhotoStaticHtml }">
							<img src="${domain}/${e.savepath }" />
						</a>
					</div>
					<p>${e.albumname }</p>
				</div>
			</#list>
		</div>
	</#macro>
	
	<!-- 相册模板 -->
	<#macro photosPlugin photoList>
     	<div id="container" style="height: 876px;">
     		<#list photoList as e>
				<div class="grid">
					<div class="imgholder">
						<a href="${domain}/${e.savefile }">
							<img src="${domain}/${e.savefile }" />
						</a>
					</div>
				</div>
			</#list>
		</div>
	</#macro>
	
	<!-- 相册模板：风格2 -->
	<#macro photosPluginStyle2 photoList>
     	<div id="thumbs">
     		<#list photoList as e>
     			<a href="${domain}/${e.savefile }" style="background-image:url(${domain}/${e.savefile })" title='${(e.photoname)?default("相片") }'></a>
     		</#list>
     	</div>
	</#macro>