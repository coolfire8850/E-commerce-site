<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/public/head.jspf"%>
<!-- 前台jsp页面可以设置让浏览器不缓存数据 -->
<%
	response.setHeader("cache-control", "no-store");
%>
<script type="text/javascript">
	function searchProduct() {

		window.location.href = "product_search.action?name=" + $("#key").val();
	}
</script>
</head>
<body>
	<c:if test="${empty sessionScope.shoppingcart.sorders }">
		<!-- 如果购物车中的购物项为空，则跳转到首页 -->
		<c:redirect url="/index.jsp" />
	</c:if>
	<div class="wrapper">
		<div class="header">
			<div class="header_container">
				<!--头部开始-->
				<div class="top_bar clear">
					<!--头部小导航-->
					<div class="welcom fl">
						<s:text name="welcome" />
						：${user.name }
					</div>
					<ul class="top_links fr">
						<li><a href="${shop}/index.jsp"><s:text name="accueil"/></a></li>
						<li><a href="#"><s:text name="compte" /></a></li>
						<li class="highlight"><a href="${shop }/showCart.jsp"><s:text
									name="cart" /></a></li>

						<li><a
							href="${shop }/input.action?request_locale=en&returnUrl=<%=request.getRequestURI()%>">En</a>
						</li>
						<li><a
							href="${shop }/input.action?request_locale=fr&returnUrl=<%=request.getRequestURI()%>">Fr</a>
						</li>
					</ul>
					<!--头部小导航结束-->
					<!-- logo -->
					<h1 class="logo clear fl">
						<a href="index.html"> <img src="images/logo.png" />
						</a>
					</h1>
					<!-- 小购物车 -->
					<div class="minicart">
						<a class="minicart_link" href="#"> <span class="item">
								<b>${fn:length(sessionScope.shoppingcart.sorders)}</b> 件/
						</span> <span class="price"> <b>￥${sessionScope.shoppingcart.total}</b>
						</span>
						</a>
					</div>
					<!-- 小购物车结束 -->
					<!-- 搜索框 -->
					<div class="header_search">
						<div class="form-search ">
							<input class="input-text" id="key"
								onkeydown="javascript:if(event.keyCode==13) searchProduct();"
								type="text" placeholder="<s:text name="searchint"/>" />
							<button type="submit" title="Search" onclick="searchProduct()"></button>
						</div>
					</div>

				</div>

			</div>
		</div>
		<!-- 头部结束 -->

		<!-- 导航栏 -->
		<div class="navigation_container">
			<!---->
			 <div class="nav">
            <ul class="primary_nav">
                <li class="active highlight"><a href="#"><s:text name="women"/></a></li>
                <li><a href="#"><s:text name="man"/></a></li>
                <li><a href="#"><s:text name="children"/></a></li>
                <li><a href="#"><s:text name="fashion"/></a></li>
                <li><a href="#"><s:text name="deco"/> </a></li>
            </ul>
        </div>
		</div>
		<!--导航栏结束-->

		<div class="section_container">
			<!-- 购物车 -->
			<ul class="breadcrumb">
				<li><a href="#">Add to Cart</a></li>
				<li class="active"><a href="#">Confirmation of order</a></li>
				<li><a href="#">Order Finished</a></li>
			</ul>
			<!-- 确认订单信息 -->
			<div class="check-stup">
				<!-- 商品确认 -->
				<div class="pro-check check ">
					<h1>Confirmation</h1>
					<table class="data-table cart-table" cellpadding="0"
						cellspacing="0">
						<tr>
							<th class="align_center" width="10%">Code</th>
							<th class="align_left" width="35%" colspan="2">Name</th>
							<th class="align_center" width="10%">Price</th>
							<th class="align_center" width="20%">Quantities</th>
							<th class="align_center" width="15%">Subtotal</th>
						</tr>
						<c:forEach items="${sessionScope.shoppingcart.sorders}"
							var="sorder" varStatus="num">
							<tr lang="${sorder.product.id}">
								<td class="align_center"><a href="#" class="edit">${num.count}</a>
								</td>
								<td width="80px"><img
									src="${shop}/files/${sorder.product.pic}" width="80"
									height="80" /></td>
								<td class="align_left"><a class="pr_name" href="#">${sorder.name}</a>
								</td>
								<td class="align_center vline">￥ ${sorder.price}</td>
								<td class="align_center vline">${sorder.number}</td>
								<td class="align_center vline">￥${sorder.price*sorder.number}</td>
							</tr>
						</c:forEach>
					</table>

					<div class="sum">
						<div class="fr">
							<span>Total：</span><b>￥${shoppingcart.total}</b>
						</div>
					</div>

				</div>
				<!-- 订购人确认 -->
				<form action="${shop}/shoppingcart_save.action" method="post">
					<div class="person-check check">
						<h1>Buyer Information</h1>
						<div class="person-checkinner">
							<div>
								<label><s:text name="name"/>:</label> <input type="text" name="name"
									value="${user.name }" /><!--两张方法都能访问到 -->
							</div>
							<div>
								<label><s:text name="tel"/>:</label> <input type="text" name="phone"
									value="${sessionScope.user.phone }" />
							</div>
							<div>
								<label><s:text name="zip"/>:</label> <input type="text" name="post" />
							</div>
							<div>
								<label><s:text name="address"/>:</label> <input type="text" name="address" />
							</div>
						</div>
					</div>
					<!-- 卖家留言 -->
					<div class="person-check check">
						<h1><s:text name="comment"></s:text></h1>
						<textarea style="margin: 5px;" name="remark" cols="120" rows="2" placeholder="you can write your comments here"></textarea>
						<div class="submit">
							<input type="submit" class="sub-logo fr"
								style="margin: 0px;padding: 0px; border: 0px;" value='<s:text name="submit"/>' />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- 确认订单信息结束 -->
</body>
</html>
