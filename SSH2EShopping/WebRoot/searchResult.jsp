<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/public/head.jspf"%>
	<script type="text/javascript">
		function searchProduct() {
	
			window.location.href = "product_search.action?name=" + $("#key").val();
		}
	</script>
</head>

<body>

	<div class="wrapper">
		<s:include value="head.jsp"/>
		
	   <c:choose>
			<c:when test="${fn:length(product)==0||product==null}">

				<div class="products_list products_slider clear">
					<!-- 显示类别名称  拿到商品所属类别的名称-->
					<h2 class="sub_title">Sorry,there no product in our store</h2>

				</div>
			</c:when>
			<c:otherwise>
				<!-- 产品列表  大循环拿到biglist  -->
				<c:forEach items="${product}" var="product">
					<div class="products_list products_slider clear">
						<!-- 显示类别名称  拿到商品所属类别的名称-->
						<h2 class="sub_title">${product.category.type}</h2>
						<ul id="first-carousel"
							class="first-and-second-carousel jcarousel-skin-tango">
							<!-- 小循环显示具体商品 -->

							<li><a href="${shop}/product_get.action?id=${product.id}"
								class="product_image"><img
									src="${shop}/files/${product.pic}" /></a>
								<div class="product_info">
									<h3>
										<a href="#"><s:text name="productname"></s:text>：${product.name }</a>
									</h3>
									<small><s:text name="description"></s:text>：${product.remark}</small>
								</div>
								<div class="price_info">
									<a
										href="${shop}/sorder_addSorder.action?product.Id=${product.id}"><button>
											<span class="pr_add"><s:text name="addcart"></s:text></span>
										</button></a>
									<button class="price_add" title="" type="button">
										<span class="pr_price">$${product.price}</span>
									</button>
								</div></li>

						</ul>
					</div>
				</c:forEach>
			</c:otherwise>
		</c:choose>

		<!--产品列表结束  -->


		
		<s:include value="foot.jsp" />
	</div>

</body>
</html>