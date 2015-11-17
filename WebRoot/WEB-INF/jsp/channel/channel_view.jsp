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
		<link href="<%=request.getContextPath()%>/plugin/kissy_editor/themes/default/editor-min.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<div class="location" id="location">
			<span class="location_l"></span>
			<span class="location_bg">查看商品详情</span>
			<span class="location_r"></span>
		</div>
		<form id="forwadForm" action="" method="post">
			<input name="page" value="${page }" type="hidden" />
			<input name="searchForm.name" value="${searchForm.name }" type="hidden" />
		</form>
		<input id="productTypeId" value="${product.productTypeId }" type="hidden" />
		<input id="editProductId" value="${product.id }" type="hidden" />
		<div class="content_frame" id="content_frame">
			<div class="viewInfo" id="viewInfo">
				<div>
					<dl>
						<dt>
							商品名：
						</dt>
						<dd>
							${product.name }
						</dd>
					</dl>
					<dl>
						<dt>
							商品描述：
						</dt>
						<dd>
							${product.description }
						</dd>
					</dl>
					<dl>
						<dt>
							商品市场价：
						</dt>
						<dd>
							${product.marketPrice }
						</dd>
					</dl>
					<dl>
						<dt>
							商品销售价：
						</dt>
						<dd>
							${product.sellPrice }
						</dd>
					</dl>
					<dl>
						<dt>
							货到付款优惠价：
						</dt>
						<dd>
							${product.cashOnDeliveryPrice }
						</dd>
					</dl>
					<dl>
						<dt>
							款到发货优惠价：
						</dt>
						<dd>
							${product.deliveryAfterCashPrice }
						</dd>
					</dl>
					<dl>
						<dt>
							商品成本价：
						</dt>
						<dd>
							${product.costPrice }
						</dd>
					</dl>
					<dl>
						<dt>
							运费：
						</dt>
						<dd>
							${product.fare }
						</dd>
					</dl>
					<dl>
						<dt>
							单位：
						</dt>
						<dd>
							${product.unitName }
						</dd>
					</dl>
					<dl>
						<dt>
							是否支持邮购方式购买：
						</dt>
						<dd>
							<c:if test="${product.isSupportDeliveryAfterCash == 1 }">支持</c:if>
							<c:if test="${product.isSupportDeliveryAfterCash == 2 }">不支持</c:if>
						</dd>
					</dl>
					<dl>
						<dt>
							是否支持货到付款购买：
						</dt>
						<dd>
							<c:if test="${product.isSupportCashOnDelivery == 1 }">支持</c:if>
							<c:if test="${product.isSupportCashOnDelivery == 2 }">不支持</c:if>
						</dd>
					</dl>
					<dl>
						<dt>
							商品库存：
						</dt>
						<dd>
							${product.stock }
						</dd>
					</dl>
					<dl>
						<dt>
							商品售出数量：
						</dt>
						<dd>
							${product.shipmentsNum }
						</dd>
					</dl>
					<dl>
						<dt>
							是否推荐商品：
						</dt>
						<dd>
							<c:if test="${product.isRecommend == 1 }">推荐</c:if>
							<c:if test="${product.isRecommend == 2 }">不推荐</c:if>
						</dd>
					</dl>
					<dl>
						<dt>
							是否热销商品：
						</dt>
						<dd>
							<c:if test="${product.isHot == 1 }">是</c:if>
							<c:if test="${product.isHot == 2 }">不是</c:if>
						</dd>
					</dl>
					<dl>
						<dt>
							是否新款商品：
						</dt>
						<dd>
							<c:if test="${product.isNew == 1 }">是</c:if>
							<c:if test="${product.isNew == 2 }">不是</c:if>
						</dd>
					</dl>
					<dl>
						<dt>
							商品详情：
						</dt>
						<dd>
							${product.detail }
						</dd>
					</dl>
					<dl>
						<dt>
							所属商品分类
						</dt>
						<dd>
							<div class="" id="treeboxbox_tree" style="overflow:auto;"></div>
						</dd>
					</dl>
					<dl>
						<dt>
							所属商品品牌
						</dt>
						<dd>
							<select name="productForm.productBrandId" id="productBrandId" title="商品品牌" class="input_01">
							</select>
						</dd>
					</dl>
					<dl>
						<dt>
							对应商品分类下扩展参数
						</dt>
						<dd>
							<div id="extendParamDiv">
					
							</div>
						</dd>
					</dl>
					<dl>
						<dt>
							商品展示图片
						</dt>
						<dd id="productPicPreviewArea">
							<c:forEach items="${productPicList}" var="each">
								<span id="pic_${each.id }">
									<label>&nbsp;</label>&nbsp;&nbsp;<input class='input_01' type='text' value='${each.picUrl }' /> <br /><label>&nbsp;</label><img src='<%=request.getContextPath()%>/${each.picUrl }' /><br /><br />
									<input name='productPicUrl' value='${each.picUrl }' type='hidden' />
								</span>
							</c:forEach>
						</dd>
					</dl>
				</div>
			</div>
		</div>
		<div class="btn_bar_bg" id="btn_bar_bg">
			<input name="返回" type="button" onclick="javascript: historyGo();" class="btn_01" onmouseover="this.className='btn_01_on'" onmouseout="this.className='btn_01'" value=" 返 回 " />
		</div>
	</body>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/pngfix.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/function.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/rightInit.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/dhtmlxtree/dhtmlxcommon.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/dhtmlxtree/dhtmlxtree.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/include/js/common/dhtmlxtree/ext/dhtmlxtree_json.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/plugin/kissy_editor/editor-aio.js"></script>
	<script type="text/javascript">
		//KISSY.Editor("productDetail");
		var hadNotLoad = true;
		$("#treeboxbox_tree").empty();
		tree = new dhtmlXTreeObject("treeboxbox_tree", "100%", "100%", 0);
		tree.enableCheckBoxes(1);
		tree.setImagePath("<%=request.getContextPath()%>/images/dhtmlxtree/csh_winstyle/");
		tree.setDataMode("json");
		tree.loadJSON('<%=request.getContextPath()%>/productTypeAction_productTypeTree.action');
		tree.setOnCheckHandler(toncheck);
		tree.attachEvent("onOpenEnd", function(id,state){
			if(hadNotLoad){
				hadNotLoad = false;
				var oldProductTypeId = $("#productTypeId").val();
				if(oldProductTypeId > 0){
					tree.setCheck("p"+oldProductTypeId, true);
					toncheck("p"+oldProductTypeId, true);
				}
			}
		});
		
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
							newHtml = newHtml + '<input class="input_04" name="' + item.name_en + '" id="'+item.name_en+'" value="'+item.value+'" title="'+item.name_zh+'" type="text" maxlength="200"/>';
							newHtml = newHtml + '</p>';
							//alert(newHtml);
							$(newHtml).appendTo("#extendParamDiv");
						});
					}
				});
			}
		}
		function historyGo() {
			$("#forwadForm").attr("action", "productAction_list.action");
			$("#forwadForm").submit();
		}
	</script>
</html>
