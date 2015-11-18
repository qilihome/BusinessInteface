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
		<!--touchTouch-->
		<link rel="stylesheet" href="${domain}/plugin/touchTouch/css/styles.css" />
		<link rel="stylesheet" href="${domain}/plugin/touchTouch/touchTouch/touchTouch.css" />
		<!-- Google Fonts -->
		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Dancing+Script" />
		<!--[if lt IE 9]>
          <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
		<!-- 全局样式-->
	</head>

	<#include "/common/plugin.ftl"/>
	<body>
		<#if customerTemplateContentList??>
			<#list customerTemplateContentList as each>
				<#if each.contenttype == 2>
					<@imgPlugin each/>
				<#elseif each.contenttype == 5>
					<@photosPluginStyle2 each.photoList/>
				</#if>
			</#list>
		</#if>
		<script src="${domain}/plugin/touchTouch/touchTouch/touchTouch.jquery.js"></script>
		<script src="${domain}/plugin/touchTouch/js/script.js"></script>
	</body>
</html>