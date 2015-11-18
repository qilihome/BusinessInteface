<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="textml; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="author" content="" />
		<meta name="viewport"  content="width=device-width; initial-scale=1;  minimum-scale=1.0; maximum-scale=2.0;user-scalable=no;" /> 
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<meta name="MobileOptimized" content=""/>
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<link rel="stylesheet" media="screen" href="${domain}/include/css/album-style.css" /><!-- 全局样式-->
		<link rel="stylesheet" media="screen and (orientation:portrait)" href="${domain}/include/css/mobile-portrait.css" /><!-- 竖屏模式-->
		<link rel="stylesheet" media="screen and (orientation:landscape)" href="${domain}/include/css/mobile-landscape.css" /><!-- 横屏模式-->
		<script type="text/javascript" src="${domain}/include/js/common/jquery.js"></script>
		<script type="text/javascript" src="${domain}/include/js/common/blocksit.min.js"></script>
	    <script type="text/javascript">
	     	$(document).ready(function() {
				//blocksit define
				$(window).load( function() {
					$('#container').BlocksIt({
						numOfCol: 2,
						offsetX: 4,
						offsetY: 4
					});
				});
			});
	    </script>
	</head>
	
	<#include "/common/plugin.ftl"/>
	<body>
		<#if customerTemplateContentList??>
			<#list customerTemplateContentList as each>
				<#if each.contenttype == 1>
					<@textPlugin each/>
				<#elseif each.contenttype == 2>
					<@imgPlugin each/>
				<#elseif each.contenttype == 3>
					<@videoPlugin each/>
				<#elseif each.contenttype == 4>
					<@mapPlugin each/>
				<#elseif each.contenttype == 6>
					<@malbumsPlugin each.albumList/>
				</#if>
			</#list>
		</#if>
	</body>
</html>