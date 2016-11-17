<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/public/head.jspf"%>
<script type="text/javascript">
	$(function() {
		//注册事件
		$(".text").change(
				function() {
					//验证数据的有效性
					var number = this.value; //也可以使用$(this).val();
					//isNaN(number)表示若number不是数字就返回真	
					if (!isNaN(number) && parseInt(number) == number
							&& number > 0) {
						//如果合法，同步更新的数
						$(this).attr("lang", number);
						//找到当前标签中第一个是tr的父节点，然后拿到属性为lang的值，也就是商品的id
						var pid = $(this).parents("tr:first").attr("lang");
						//发送Ajax请求，传输当前的数量与商品的id，返回修改数量后的总价格,total为回调后的参数。number和product.id为sorder类中相应的域
						$.post("sorder_updateSorder.action", {
							number : number,
							'product.id' : pid
						}, function(total) {
							$("#total").html(total); //所有商品的小计
							var yunfei = $("#yunfei").html();
							$("#totalAll").html(
									(total * 1 + yunfei * 1).toFixed(2)); //所有商品小计和运费的和
						}, "text");
						//计算单个商品的小计，保留两位小数
						var price = ($(this).parent().prev().html() * number)
								.toFixed(2);
						$(this).parent().next().html(price);
					} else {
						//如果非法，还原为刚刚合法的数
						this.value = $(this).attr("lang");
					}
				})

	})

	function searchProduct() {
		alert($("#key").val());
		window.location.href = "product_search.action?name=" + $("#key").val();
	}
	
	if(window.performance)

		{
		
		if(performance.navigation.type  == 1 )
		          {
		            /* window.location.href = "${shop}/sorder_addSorder.action?refresh=1"; */
		          }
		}
</script>
<body>
	
	<div class="wrapper">
		<s:include value="/head.jsp"></s:include>
		<!-- 头部结束 -->
		<!-- 导航栏 -->
		<div class="navigation_container">
			<!---->
			<div class="nav">
				<ul class="primary_nav">
					<li class="active highlight"><a href="#"><s:text
								name="women" /></a></li>
					<li><a href="#"><s:text name="man" /></a></li>
					<li><a href="#"><s:text name="children" /></a></li>
					<li><a href="#"><s:text name="fashion" /></a></li>
					<li><a href="#"><s:text name="deco" /> </a></li>
				</ul>
			</div>
		</div>
		<!--导航栏结束-->
		<div class="section_container">
			<!-- 购物车 -->
			<div id="shopping_cart">
				<div class="message success">My cart</div>
				<c:choose>
					<c:when test="${fn:length(sessionScope.shoppingcart.sorders)==0}">
						<h3>The cart is empty,you can add something!</h3>
						
					</c:when>
					<c:otherwise>
						<table class="data-table cart-table" cellpadding="0"
							cellspacing="0">
							<tr>
								<th class="align_center" width="10%">Code</th>
								<th class="align_center" width="20%">Pic</th>
								<th class="align_center" width="20%">Name</th>
								<th class="align_center" width="10%">Price</th>
								<th class="align_center" width="20%">Nums</th>
								<th class="align_center" width="15%">Subtotal</th>
								<th class="align_center" width="10%">Delete</th>
							</tr>
							<c:forEach items="${sessionScope.shoppingcart.sorders }"
								var="sorder" varStatus="num">
								<tr lang="${sorder.product.id}">
									<td class="align_center"><a href="#" class="edit">${num.count }</a>
									</td>
									<td class="align_center" width="80px"><img
										src="${shop}/files/${sorder.product.pic}" width="80"
										height="80" /></td>
									<td class="align_center"><a class="pr_name" href="#">${sorder.name }</a>
									</td>
									<td class="align_center vline">${sorder.price }</td>
									<td class="align_center vline">
										<!-- 文本框 --> <input class="text" style="height: 20px;"
										value="${sorder.number }" lang="${sorder.number }">
									</td>
									<td class="align_center vline">${sorder.price*sorder.number }
									</td>
									<td class="align_center vline"><a href="#" class="remove"></a>
									</td>
								</tr>
							</c:forEach>

						</table>
						<!-- 结算 -->
						<div class="totals">
							<table id="totals-table">
								<tbody>
									<tr>
										<td width="60%" colspan="1" class="align_left"><strong>Subtotal</strong>
										</td>
										<td class="align_right" style=""><strong>$<span
												class="price" id="total">${sessionScope.shoppingcart.total}</span>
										</strong></td>
									</tr>
									<tr>
										<td width="60%" colspan="1" class="align_left">Freight</td>
										<td class="align_right" style="">$<span class="price"
											id="yunfei">0.00</span>
										</td>
									</tr>
									<tr>
										<td width="60%" colspan="1" class="align_left total"><strong>Total</strong>
										</td>
										<td class="align_right" style="">$<span class="total"
											id="totalAll"><strong>${sessionScope.shoppingcart.total}</strong>
										</span>
										</td>
									</tr>
								</tbody>
							</table>
							<input type="hidden" >
							
							<div class="action_buttonbar">
								<font><a href="${shop}/user/confirm.jsp">
										<button type="button" title="" class="checkout fr"
											style="background-color: #f38256;">Order Confirm</button>
								</a></font>
								<button type="button" title="" class=" fr">
									<font><font>Clear Cart</font> </font>
								</button>
								<a href="${shop}/index.jsp">
									<button type="button" title="" class="continue fr">
										<font>Contiune Shopping</font>
									</button>
								</a>
								<div style="clear:both"></div>
							</div>
						</div>

					</c:otherwise>


				</c:choose>


			</div>
			<!-- 导航栏结束 -->
			<s:include value="foot.jsp"></s:include>
		</div>
	</div>
</body>
</html>
