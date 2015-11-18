<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
		<title></title>
		<link href="<%=request.getContextPath()%>/include/css/common/master.css" rel="stylesheet" type="text/css"/>
		<link href="<%=request.getContextPath()%>/include/css/dhtmlxtree/dhtmlxtree.css" rel="stylesheet" type="text/css"/>
		<link href="<%=request.getContextPath()%>/plugin/uploadify/css/uploadify.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath()%>/plugin/kissy_editor/themes/default/editor-min.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="location" id="location">
			<span class="location_l"></span>
			<span class="location_bg">修改商品</span>
			<span class="location_r"></span>
		</div>
		<form  name="editForm" id="editForm" action="productAction_edit.action" method="post">
			<input name="page" value="${page }" type="hidden" />
			<input name="searchForm.name" value="${searchForm.name }" type="hidden" />
			<input id="editProductId" name="productForm.id" value="${product.id }" type="hidden" />
			<input name="productForm.productTypeId" id="productTypeId" value="${product.productTypeId }" type="hidden" />
			<input name="productForm.numbers" value="${product.numbers }" type="hidden" />
			<input id="oldProductBrandId" value="${product.productBrandId }" type="hidden" />
			<input name="mainShowPicName" id="mainShowPicId" value="" type="hidden" />
			<div class="content_frame">
				<div class="frame_area" id="frame_area">
					<p>
						<label>商品名：</label>
						<input class="input_01" name="productForm.name" id="productName" value="${product.name }" title="商品名" type="text" maxlength="100"/>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>商品描述：</label>
						<input class="input_01" name="productForm.description" id="productDesc" value="${product.description }" title="商品描述" type="text" maxlength="200"/>
						<span class="unit"><span class="rd">*</span>商品描述，简介，商品推荐文字</span>
					</p>
					<p>
						<label>商品主推荐语：</label>
						<input class="input_01" name="productForm.recommendTip" id="productRecommendTip" value="${product.recommendTip }" title="商品主推荐语" type="text" maxlength="50"/>
						<span class="unit"><span class="rd">*</span>如：至尊享受</span>
					</p>
					<p>
						<label>商品广告语：</label>
						<input class="input_01" name="productForm.recommendAd" id="productRecommendAd" value="${product.recommendAd }" title="商品广告语" type="text" maxlength="100"/>
						<span class="unit"><span class="rd">*</span>如：帝王般享受，诱惑入人心</span>
					</p>
					<p>
						<label>商品市场价：</label>
						<input class="input_01" name="productForm.marketPrice" id="productMarketPrice" value="${product.marketPrice }" title="商品市场价" type="text" maxlength="6"/>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>商品销售价：</label>
						<input class="input_01" name="productForm.sellPrice" id="productSellPrice" value="${product.sellPrice }" title="商品销售价" type="text" maxlength="6"/>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>货到付款优惠价：</label>
						<input class="input_01" name="productForm.cashOnDeliveryPrice" id="productCashOnDeliveryPrice" value="${product.cashOnDeliveryPrice }" title="货到付款优惠价" type="text" maxlength="6"/>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>款到发货优惠价：</label>
						<input class="input_01" name="productForm.deliveryAfterCashPrice" id="productDeliveryAfterCashPrice" value="${product.deliveryAfterCashPrice }" title="款到发货优惠价" type="text" maxlength="6"/>
						<span class="unit"><span class="rd">*</span>或称邮购优惠价</span>
					</p>
					<p>
						<label>商品成本价：</label>
						<input class="input_01" name="productForm.costPrice" id="productCostPrice" value="${product.costPrice }" title="商品成本价" type="text" maxlength="6"/>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>运费：</label>
						<input class="input_01" name="productForm.fare" id="productFare" value="${product.fare }" title="运费" type="text" maxlength="6"/>
						<span class="unit"><span class="rd">*</span>为0表示免运费</span>
					</p>
					<p>
						<label>单位：</label>
						<select name="productForm.unitName" class="input_01">
							<option value="台" <c:if test="${productForm.unitName == '台' }">selected="selected"</c:if>>台</option>
							<option value="块" <c:if test="${productForm.unitName == '块' }">selected="selected"</c:if>>块</option>
							<option value="套" <c:if test="${productForm.unitName == '套' }">selected="selected"</c:if>>套</option>
							<option value="件" <c:if test="${productForm.unitName == '件' }">selected="selected"</c:if>>件</option>
							<option value="包" <c:if test="${productForm.unitName == '包' }">selected="selected"</c:if>>包</option>
							<option value="辆" <c:if test="${productForm.unitName == '辆' }">selected="selected"</c:if>>辆</option>
							<option value="盒" <c:if test="${productForm.unitName == '盒' }">selected="selected"</c:if>>盒</option>
							<option value="瓶" <c:if test="${productForm.unitName == '瓶' }">selected="selected"</c:if>>瓶</option>
							<option value="斤" <c:if test="${productForm.unitName == '斤' }">selected="selected"</c:if>>斤</option>
							<option value="箱" <c:if test="${productForm.unitName == '箱' }">selected="selected"</c:if>>箱</option>
						</select>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>是否支持邮购方式购买：</label>
						<select name="productForm.isSupportDeliveryAfterCash" class="input_01">
							<option value="1" <c:if test="${product.isSupportDeliveryAfterCash == 1 }">selected="selected"</c:if>>支持</option>
							<option value="2" <c:if test="${product.isSupportDeliveryAfterCash == 2 }">selected="selected"</c:if>>不支持</option>
						</select>
						<span class="unit"><span class="rd">*</span>先付款后发货</span>
					</p>
					<p>
						<label>是否支持货到付款购买：</label>
						<select name="productForm.isSupportCashOnDelivery" class="input_01">
							<option value="1" <c:if test="${product.isSupportCashOnDelivery == 1 }">selected="selected"</c:if>>支持</option>
							<option value="2" <c:if test="${product.isSupportCashOnDelivery == 2 }">selected="selected"</c:if>>不支持</option>
						</select>
						<span class="unit"><span class="rd">*</span>先发货后付款</span>
					</p>
					<p>
						<label>商品库存：</label>
						<input class="input_01" name="productForm.stock" id="productStock" value="${product.stock }" title="商品库存" type="text" maxlength="6"/>
						<span class="unit"><span class="rd">*</span>如果为负数表示库存无限制</span>
					</p>
					<p>
						<label>商品售出数量：</label>
						<input class="input_01" name="productForm.shipmentsNum" id="productShipmentsNum" value="${product.shipmentsNum }" title="商品售出数量" type="text" maxlength="6"/>
						<span class="unit"><span class="rd">*</span>发货量，订单确认后通过快递发货的数量</span>
					</p>
					<p>
						<label>是否推荐商品：</label>
						<select name="productForm.isRecommend" class="input_01">
							<option value="1" <c:if test="${product.isRecommend == 1 }">selected="selected"</c:if>>推荐</option>
							<option value="2" <c:if test="${product.isRecommend == 2 }">selected="selected"</c:if>>不推荐</option>
						</select>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>是否热销商品：</label>
						<select name="productForm.isHot" class="input_01">
							<option value="1" <c:if test="${product.isHot == 1 }">selected="selected"</c:if>>是</option>
							<option value="2" <c:if test="${product.isHot == 2 }">selected="selected"</c:if>>不是</option>
						</select>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p>
						<label>是否新款商品：</label>
						<select name="productForm.isNew" class="input_01">
							<option value="1" <c:if test="${product.isNew == 1 }">selected="selected"</c:if>>是</option>
							<option value="2" <c:if test="${product.isNew == 2 }">selected="selected"</c:if>>不是</option>
						</select>
						<span class="unit"><span class="rd">*</span></span>
					</p>
						<label>&nbsp;&nbsp;&nbsp;商品详情：</label>
						<textarea id="productDetail" name="productForm.detail" rows="50" cols="152" style="height: 295px">
                			${product.detail }
               	 		</textarea> 
					<p></p>
					<div class="purview">
						<span class="purview_l"></span>
						<span class="purview_bg">所属商品分类</span>
						<span class="purview_r"></span>
					</div>
					<div class="qxgl">
						<ul>
							<li>&nbsp;</li>
							<li class="gl"><div class="" id="treeboxbox_tree" style="overflow:auto;">
							</div></li>
						</ul>
					</div>
					<p></p>
					<div class="purview">
						<span class="purview_l"></span>
						<span class="purview_bg">所属商品品牌</span>
						<span class="purview_r"></span>
					</div>
					<p>
						<label>商品品牌：</label>
						<select name="productForm.productBrandId" id="productBrandId" title="商品品牌" class="input_01">
							<option value="0">请选择</option>
						</select>
						<span class="unit"><span class="rd">*</span></span>
					</p>
					<p></p>
					<div class="purview">
						<span class="purview_l"></span>
						<span class="purview_bg">对应商品分类下扩展参数</span>
						<span class="purview_r"></span>
					</div>
					<div id="extendParamDiv">
					
					</div>
					<p></p>
					<div class="purview">
						<span class="purview_l"></span>
						<span class="purview_bg">商品展示图片</span>
						<span class="purview_r"></span>
					</div>
					<p>
						<label>商品图片：</label>
						<input id="custom_file_upload" type="file" name="fileData" />
						<span class="unit"><span class="rd">*</span>支持同时选择多张图片上传，选择图片时同时按住"Ctrl"键或"Shift"键</span>
					</p>
					<p id="productPicPreviewArea">
						<c:forEach items="${productPicList}" var="each">
							<span id="pic_${each.id }">
								<label>&nbsp;</label><label>设置为主推图片：</label><input type='radio' name='isMainShowPic' value='${each.picUrl }' <c:if test="${each.isMainShowPic == 1}">checked="checked"</c:if> /> <input type="button" value="删除" onclick="delPic('pic_${each.id }')" />&nbsp;&nbsp;<input class='input_01' type='text' value='${each.picUrl }' /> <br /><label>&nbsp;</label><img src='<%=request.getContextPath()%>/${each.picUrl }' /><br /><br />
								<input name='productPicUrl' value='${each.picUrl }' type='hidden' />
							</span>
						</c:forEach>
					</p>
					<p>
						<label>&nbsp;</label><span class="unit"><span class="rd">1、支持${applicationScope.productPicUploadTypes}图片格式；2、上传图片大小应小于或等于${applicationScope.productPicUploadSize}KB。</span></span>
					</p>
				</div>
			</div>
			<div class="btn_bar_bg" id="btn_bar_bg">
				<input name="确定" type="button" onclick="javascript: edit()" class="btn_01" onmouseover="this.className='btn_01_on'" onmouseout="this.className='btn_01'" value=" 确 定 " />
				<input name="取消" type="button" onclick="javascript: historyGo()" class="btn_01" onmouseover="this.className='btn_01_on'" onmouseout="this.className='btn_01'" value=" 取 消 " />
			</div>
		</form>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/pngfix.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery-1.4.4.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/rightInit.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/dhtmlxtree/dhtmlxcommon.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/dhtmlxtree/dhtmlxtree.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/dhtmlxtree/ext/dhtmlxtree_json.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/swfobject.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/uploadify/scripts/jquery.uploadify.js" type="text/javascript"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/kissy_editor/editor-aio.js"></script>
		<script type="text/javascript">
		editorObj = KISSY.Editor("productDetail");
		
		var uploadIndex = 999999;
		$(function() {
			$('#custom_file_upload').uploadify({
				'uploader' : '<%=request.getContextPath()%>/plugin/uploadify/scripts/uploadify.swf',
				'script' : '<%=request.getContextPath()%>/fileUploadAction_upload.action?uploadPath=${applicationScope.productPicUploadUrl}',
				'cancelImg' : '<%=request.getContextPath()%>/plugin/uploadify/cancel.png',
				'buttonImg' : '<%=request.getContextPath()%>/plugin/uploadify/upload_pitcure.png',
				'sizeLimit' : ${applicationScope.productPicUploadSize}*1024,
				'multi' : true,
				'auto' : true,
				'fileExt' : '${applicationScope.productPicFileExt}',
				'fileDesc' : 'Image Files (${applicationScope.productPicUploadTypes})',
				'queueID' : 'custom-queue',
				'queueSizeLimit' : 10,
				'simUploadLimit' : 10,
				'removeCompleted' : false,
				'onSelectOnce' : function(event, data) {
				},
				'onComplete' : function(event, queueId, fileObj, response, data) {
					uploadIndex = uploadIndex+1;
					response = eval('('+response+')');
					var previewUrl = '<%=request.getContextPath()%>/' + response.path;
					var imgEle = "<span id='pic_"+ uploadIndex +"'><label>&nbsp;</label><label>设置为主推图片：</label><input type='radio' name='isMainShowPic' value='"+response.path+"' />&nbsp;&nbsp;<input type='button' value='删除' onclick=\"delPic('pic_"+uploadIndex+"')\" />&nbsp;&nbsp;<input class='input_01' type='text' value='"+previewUrl+"' /> <br /><label>&nbsp;</label><img src='" + previewUrl + "' /><br /><br /></span>";
					$(imgEle).appendTo($("#productPicPreviewArea"));
					var hideEle = "<input name='productPicUrl' value='" + response.path + "' type='hidden' />";
					$(hideEle).appendTo($("#editForm"));
				},
				'onError' : function (event, ID, fileObj, errorObj) {
						if (errorObj.type === "File Size"){
						alertMessage('修改商品图片','超过文件上传大小限制（${applicationScope.productPicUploadSize}KB）！');
						return;
						}
					}
				});
			});
		</script>
		<script type="text/javascript">
			$("#treeboxbox_tree").empty();
			tree = new dhtmlXTreeObject("treeboxbox_tree", "100%", "100%", 0);
			tree.enableCheckBoxes(1);
			tree.setImagePath("<%=request.getContextPath()%>/images/dhtmlxtree/csh_winstyle/");
			tree.setDataMode("json");
			tree.loadJSON('<%=request.getContextPath()%>/productTypeAction_productTypeTree.action', checkedOldProductTypeId);
			tree.setOnCheckHandler(toncheck);
			
			function checkedOldProductTypeId(){
				var oldProductTypeId = $("#productTypeId").val();
				if(oldProductTypeId > 0){
					tree.setCheck("p"+oldProductTypeId, true);
					toncheck("p"+oldProductTypeId, true);
				}
			}
			
			function toncheck(id,state){
				$("#productBrandId option").each(function() {
					if($(this).val() != 0) {
						$(this).remove();
					}
				});
					
				if(state){
					var selectNode = tree.getAllChecked();
					if(id != selectNode){
						var pArray = selectNode.split(",");
						for( i = 0; i < pArray.length; i++) {
							var eachP = pArray[i];
							if(eachP != id){
								tree.setCheck(eachP, false);
							}
						}
					}
					
					var oldProductBrandId = $("#oldProductBrandId").val();
					//异步加载该分类下所有品牌
					$.getJSON(encodeURI("<%=request.getContextPath()%>/productBrandAction_searchBrandByTypeId.action?typeId=" + id.substring(1) + '&rand=' + Math.random()), function(data) {
						if(data != null && data.items) {
							$.each(data.items, function(i, item) {
								if(item.id == oldProductBrandId){
									$("<option selected='selected' value='" + item.id + "'>" + item.name + "</option>").appendTo("#productBrandId");
								}else{
									$("<option value='" + item.id + "'>" + item.name + "</option>").appendTo("#productBrandId");
								}
							});
						}
					});
					
					//异步加载该分类下所有参数
					$.getJSON(encodeURI("<%=request.getContextPath()%>/productTypeAction_productTypeParamTree.action?typeId=" + id.substring(1) + '&productId=' + $("#editProductId").val() + '&rand=' + Math.random()), function(data) {
						if(data != null && data.items) {
							$.each(data.items, function(i, item) {
								//alert(item.name_zh);
								var newHtml = '<p>';
								newHtml = newHtml + '<label>' + item.name_zh +'：</label>';
								if(item.value){
									newHtml = newHtml + '<input class="input_04" name="' + item.name_en + '" id="'+item.name_en+'" value="'+item.value+'" title="'+item.name_zh+'" type="text" maxlength="200"/>';
								}else{
									newHtml = newHtml + '<input class="input_04" name="' + item.name_en + '" id="'+item.name_en+'" value="" title="'+item.name_zh+'" type="text" maxlength="200"/>';
								}
								newHtml = newHtml + '<span class="unit">';
								if(item.isMust == 1){
									newHtml = newHtml + '<span class="rd">*</span>';
								}
								if(item.paramSellType == 2){
									newHtml = newHtml + "销售参数，";
								}else{
									newHtml = newHtml + "普通参数，";
								}
								newHtml = newHtml + item.desc;
								newHtml = newHtml + '</span></p>';
								//alert(newHtml);
								$(newHtml).appendTo("#extendParamDiv");
							});
						}
					});
				}
			}
			
			function delPic(picId){
				$("#"+picId).remove();
			}
			
			function edit() {
				if(!verifyInputField("修改商品", "productName,productDesc,productRecommendTip,productRecommendAd,productMarketPrice,productSellPrice,productCashOnDeliveryPrice,productDeliveryAfterCashPrice,productCostPrice,productFare,productStock,productShipmentsNum")) {
					return;
				}
				var selectNode = tree.getAllChecked();
				if(selectNode){
					selectNode = selectNode.substring(1);
					$("#productTypeId").val(selectNode);
				}else{
					alert("修改商品：请选择所属商品分类");
					return;
				}
				if(!verifySelectField("修改商品", "productBrandId")) {
					return;
				}
				if($("input[name=productPicUrl]").length <= 0){
					alert("修改商品：请上传商品展示图片");
					$("#custom_file_upload").focus();
					return;
				}
				if($("input[name=isMainShowPic]:checked").length <= 0){
					alert("修改商品：请选择商品主推图片");
					$("#custom_file_upload").focus();
					return;
				}else{
					$("#mainShowPicId").val($("input[name=isMainShowPic]:checked").val());
				}
				$("#productDetail").val(editorObj.getData());
				$("#editForm").attr("action", "productAction_edit.action");
				$("#editForm").submit();
			}
	
			function historyGo() {
				$("#editForm").attr("action", "productAction_list.action");
				$("#editForm").submit();
			}
		</script>
	</body>
</html>
