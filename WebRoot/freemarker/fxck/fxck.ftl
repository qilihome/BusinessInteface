<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="author" content="" />
<meta name="viewport"  content="width=device-width; initial-scale=1;  minimum-scale=1.0; maximum-scale=2.0;user-scalable=no;" /> 
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta name="MobileOptimized" content=""/>
<meta name="apple-mobile-web-app-capable" content="yes" />
<link href="${domain}/include/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="${domain}/include/js/common/jquery.js"></script>
<script type="text/javascript" src="${domain}/include/js/common/bootstrap.min.js"></script>
<style>
.close_btn{width:54px;height:54px; background:url(${domain}/images/gb.png) no-repeat; display:block; position:absolute;right:0;top:0; z-index:99999999;}
</style>
</head>
<body style="background:#000;padding：0;">
<a href="../../fxjj.html"  class="close_btn"></a>
   <div class="container">
	<div class="carousel slide" id="carousel-539886">
		<div class="carousel-inner">
			<#if customerTemplateContentList??>
				<#list customerTemplateContentList as each>
					<#if each.contenttype == 5>
						<#list each.photoList as photo>
							<div class="item<#if photo_index == 0> active</#if>">
								<img src="${domain}/${photo.savefile }" />
								<div class="carousel-caption">
								<h4>
									${photo.photoname?default("")}
										${photo_index+1}/${each.photoList?size}
								</h4>
								<p>
									${photo.photosummary?default("")}
								</p>
								</div>
							</div>
						</#list>
					</#if>
				</#list>
			</#if>
		</div>
		<a data-slide="prev" href="#carousel-539886" class="left carousel-control">‹</a>
		<a data-slide="next" href="#carousel-539886" class="right carousel-control">›</a>
	</div>
	</div>
</body>
</html>