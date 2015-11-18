<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="Content-Type" content="textml; charset=utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta name="author" content="" />
		<meta name="viewport"  content="width=device-width; initial-scale=1;  minimum-scale=1.0; maximum-scale=2.0;user-scalable=no;" /> 
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<meta name="MobileOptimized" content=""/>
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<link rel="stylesheet" media="screen and (orientation:portrait)" href="${domain}/include/css/mobile-portrait.css" /><!-- 竖屏模式-->
		<link rel="stylesheet" media="screen and (orientation:landscape)" href="${domain}/include/css/mobile-landscape.css" /><!-- 横屏模式-->
		<title></title>
		<script type="text/javascript" src="${domain}/include/js/common/jquery.js"></script>
		<style type="text/css">
			*{margin:0;padding:0;}
			body{ background:#363634; font-size:12px; font-family:"Microsoft Yahei";}
			ul,li{ list-style-type:none;}
			a{ text-decoration:none;}
			.top_menu{height:46px; background:#3c3c3b; box-shadow:0 0 5px #2b2b2b;}
			.top_menu a{width:50%;height:46px; display:inline-block; text-align:center; font-size:14px; color:#fff; text-shadow:0 0 1px #333; line-height:46px;}
			.top_menu .on{ line-height:46px; border-top:3px #0782f7 solid;height:43px; background:#353535; font-weight:bold; color:#a8d3fc;}
			.fri_div{padding:10px;}
			.fri_div p{ color:#939388; line-height:22px;}
			
			/*@media screen and (orientation:landscape) {
			.box_01{width:190px;height:190px; background:#fc6e05; color:#FFF;margin-right:6px; float:left;}
			.box_01 a{ display:block;padding-top:65px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:125px;}
			.box_02{width:252px;height:99px; float:left; background:#a5eb09;margin-bottom:5px;}
			.box_02 a{display:block;padding-top:18px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:81px;}
			.box_03{width:252px;height:86px; float:left; background:#07c2fb;margin-bottom:5px;}
			.box_03 a{display:block;padding-top:14px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:72px;}
			.box{ clear:both;}
			.box_04{width:112px;height:80px; float:left; background:#df1104;margin-bottom:5px;margin-right:6px;}
			.box_04 a{display:block;padding-top:10px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:70px;}
			.box_05{width:105px;height:80px; float:left; background:#357df3;margin-bottom:5px;margin-right:6px;}
			.box_05 a{display:block;padding-top:10px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:70px;}
			.box_06{width:81px;height:80px; float:left; background:#c8348e;margin-bottom:5px;margin-right:6px;}
			.box_06 a{display:block;padding-top:10px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:70px;}
			.box_07{width:132px;height:80px; float:left; background:#fbac03;margin-bottom:5px;margin-right:6px;}
			.box_07 a{display:block;padding-top:10px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:16px;height:70px; overflow:hidden;}
			.box_07 a em{ font-size:40px; font-style:normal; line-height:16px;}
			}*/
			.zj_div{ clear:both;}
			.zj_div_a{padding:10px 10px 15px; background:url(${domain}/images/jt_03.jpg) no-repeat 45px bottom #595959;}
			.zj_div_a img{width:79px;height:79px; border:3px #FFF solid; float:left;margin-right:10px;margin-top:2px;}
			.zj_div_a h3{ font-size:16px; color:#FFF;}
			.zj_div_a h4{ font-size:14px; color:#ecd303;}
			.zj_div_a p{ color:#bbb; line-height:20px;}
			.zj_div_b{ background:#26292b;padding:10px;}
			.zj_div_b h5{ color:#afaeae; font-size:16px;}
			
			.box-top-wr {
			    overflow:hidden;
			    height:190px;
			    -webkit-box-orient:horizontal;
			    -moz-box-orient:horizontal;
			    -o-box-orient:horizontal;
			    -ms-box-orient:horizontal;
			    box-orient:horizontal;
			    display:-webkit-box;
			    display:-moz-box;
			    display:box;
			}
			.box-top-left,.box-top-right {
			    overflow:hidden;
			    -webkit-box-flex:1;
			    -moz-box-flex:1;
			    -o-box-flex:1;
			    -ms-box-flex:1;
			    box-flex:1;
			}
			.box-top-right {
			    -webkit-box-orient:vertical;
			    -moz-box-orient:vertical;
			    -o-box-orient:vertical;
			    -ms-box-orient:vertical;
			    box-orient:vertical;
			    display:-webkit-box;
			    display:-moz-box;
			    display:box;
			}
			.box-top-right .box-top {
			    overflow:hidden;
			    -webkit-box-flex:1;
			    -moz-box-flex:1;
			    -o-box-flex:1;
			    -ms-box-flex:1;
			    box-flex:1;
			}
			.box-bottom-wr {
			    overflow:hidden;
			    height:80px;
			    -webkit-box-orient:horizontal;
			    -moz-box-orient:horizontal;
			    -o-box-orient:horizontal;
			    -ms-box-orient:horizontal;
			    box-orient:horizontal;
			    display:-webkit-box;
			    display:-moz-box;
			    display:box;
			    margin-top:5px;
			}
			.box-bottom-wr .box-bottom {
			    overflow:hidden;
			    -webkit-box-flex:1;
			    -moz-box-flex:1;
			    -o-box-flex:1;
			    -ms-box-flex:1;
			    box-flex:1;
			}
			.box_01{/*width:127px;height:190px; float:left; */background:#fc6e05; color:#FFF;margin-right:5px;}
			.box_01 a{ display:block;padding-top:65px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:125px;}
			.box_02{/*width:168px;height:99px; float:left;*/ background:#a5eb09;margin-bottom:5px;}
			.box_02 a{display:block;padding-top:18px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:81px;}
			.box_03{/*width:168px;height:86px; float:left;*/ background:#07c2fb;}
			.box_03 a{display:block;padding-top:14px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:72px;}
			.box{ clear:both;}
			.box_04{/*width:76px;height:80px; float:left;*/ background:#df1104;margin-bottom:5px;margin-right:5px;}
			.box_04 a{display:block;padding-top:10px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:70px;}
			.box_05{/*width:69px;height:80px; float:left;*/ background:#357df3;margin-bottom:5px;margin-right:5px;}
			.box_05 a{display:block;padding-top:10px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:70px;}
			.box_06{/*width:54px;height:80px; float:left;*/ background:#c8348e;margin-bottom:5px;margin-right:5px;}
			.box_06 a{display:block;padding-top:10px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:20px;height:70px;}
			.box_07{/*width:86px;height:80px; float:left;*/ background:#fbac03;margin-bottom:5px;}
			.box_07 a{display:block;padding-top:10px; font-size:14px; color:#FFF; text-align:center; font-weight:bold; line-height:16px;height:70px; overflow:hidden;}
			.box_07 a em{ font-size:40px; font-style:normal; line-height:16px;}
		</style>
		<script type="text/javascript">
			$(function(){
				$("#btn_fyyx").click(function(){
					$("#btn_jjdp").removeClass("on");
					$(this).addClass("on");
					$("#div_fyyx").show();
					$("#div_jjdp").hide();
				});
				$("#btn_jjdp").click(function(){
					$("#btn_fyyx").removeClass("on");
					$(this).addClass("on");
					$("#div_jjdp").show();
					$("#div_fyyx").hide();
				});
			});
			function addReviewRote(oId, vId){
				$.post("${domain}/voteOptionAction_addReviewRote.action?t="+Math.random(),{'voteOptionForm.id':oId},function(data){
					if(data.result){
						getCustomerVote(vId);
						alert("印象添加成功！");
					}else{
						alert("哎呀~出了点儿小问题，点击刷新试试吧~");
					}
				});
			}
			function getCustomerVote(vId){
				$.post("${domain}/voteAction_getCustomerVote.action?t="+Math.random(),{'voteForm.id':vId},function(data){
					if(data.result == true){
						var voteName = data.name;
						var voteHtml = "<p><strong>选择或添加您的"+voteName+"</strong></p>";
						$("#btn_fyyx").html(voteName);
						for (var i = 0; i < data.options.length; i++) {
							var option = data.options[i];
							if(i < 3){
								if(i == 0){
									voteHtml += '<div class="box-top-wr">';
									voteHtml += '<div class="box-top-left">';
									voteHtml += '<div class="box-top box_01"><a onclick="addReviewRote('+option.id+','+data.id+')" href="#">'+option.name+'<br />'+option.voteRate+'</a></div>';
									voteHtml += '</div>';
								}else if(i == 1){
									voteHtml += '<div class="box-top-right">';
									voteHtml += '<div class="box-top box_02"><a onclick="addReviewRote('+option.id+','+data.id+')" href="#">'+option.name+'<br />'+option.voteRate+'</a></div>';
								}else{
									voteHtml += '<div class="box-top box_03"><a onclick="addReviewRote('+option.id+','+data.id+')" href="#">'+option.name+'<br />'+option.voteRate+'</a></div>';
									voteHtml += '</div>';
									voteHtml += '</div>';
								}
							}else{
								if(i == 3){
									voteHtml += '<div class="box-bottom-wr">';
								}
								voteHtml += '<div class="box-bottom box_0'+(i+1)+'"><a onclick="addReviewRote('+option.id+','+data.id+')" href="#">'+option.name+'<br />'+option.voteRate+'</a></div>';
								if(i == (data.options.length - 1)){
									//voteHtml += '<div class="box-bottom box_07"><a onclick="addReviewRote('+option.id+','+data.id+')" href="#">'+option.name+'<br />'+option.voteRate+'</a></div>';
									voteHtml += '</div>';
								}
							}
						}
						$("#div_fyyx").empty().html(voteHtml);
					}
				});
			}
		</script> 
	</head>
	<body>
		<div class="top_menu"><a href="#" class="on" id="btn_fyyx"></a><a href="#" id="btn_jjdp">专家点评</a></div>
		<#if customerTemplateContentList??>
			<#list customerTemplateContentList as each>
				<#if each.contenttype == 7>
					<!--房友印象 s-->
					<div class="fri_div" id="div_fyyx">
					</div>
					<script type="text/javascript">getCustomerVote('${each.content}');</script>
					<!--房友印象 e-->
				</#if>
				<#if each.contenttype == 8>
					<!--专家点评 s-->
					<div class="fri_div" style="display: none;" id="div_jjdp">
						<#if (each.reviewList)??>
							<#list each.reviewList as e>
								<div class="zj_div">
							        <div class="zj_div_a">
							             <img src="${domain}/${e.headsculpture }" width="79" height="79">
							             <h3>${e.name }</h3>
							             <h4>${e.title }</h4>
							             <p>${e.honor }</p>
							         </div>
							        <div class="zj_div_b">
							             <h5>${e.reviewsubject}</h5>
							             <p>${e.reviewcontent}</p>
							        </div>
							    </div>
							</#list>
						</#if>
					</div>
					<!--专家点评 e-->
				</#if>
			</#list>
		</#if>
	</body>
</html>