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
		<!--Photoswipe-->
		<link rel="stylesheet" media="screen" href="${domain}/plugin/photoswipe/css/photoswipe.css" />
		<!-- 全局样式-->
		<script type="text/javascript" src="${domain}/plugin/photoswipe/lib/klass.min.js"></script>
		<script type="text/javascript" src="${domain}/plugin/photoswipe/js/code.photoswipe-3.0.5.min.js"></script>
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
	    <script type="application/x-javascript">
		    //隐藏地址栏，iPhone有效
			addEventListener("load", function() { setTimeout(hideURLbar, 0);}, false);
			function hideURLbar(){
				window.scrollTo(0,1);
			} 
			(function(window, PhotoSwipe){
				document.addEventListener('DOMContentLoaded', function(){
					var options = {}, instance = PhotoSwipe.attach( window.document.querySelectorAll('.imgholder a'), options );
				}, false);
			}(window, window.Code.PhotoSwipe));
				
			function getRootPath(){
				var strFullPath=window.document.location.href;
				var strPath=window.document.location.pathname;
				var pos=strFullPath.indexOf(strPath);
				var prePath=strFullPath.substring(0,pos);
				var postPath=strPath.substring(0,strPath.substr(1).indexOf('/')+1);
				return(prePath+postPath);
			}
		    var rootpath=getRootPath();
		
		    function getQueryString(name) {
		    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
		    var r = window.location.search.substr(1).match(reg);
		    if (r != null) return unescape(r[2]); return null;
		    }
		    var id=getQueryString('id');
		</script>
	</head>

	<#include "/common/plugin.ftl"/>
	<body>
		<#if customerTemplateContentList??>
			<#list customerTemplateContentList as each>
				<#if each.contenttype == 2>
					<@imgPlugin each/>
				<#elseif each.contenttype == 5>
					<@photosPlugin each.photoList/>
				</#if>
			</#list>
		</#if>
	</body>
</html>