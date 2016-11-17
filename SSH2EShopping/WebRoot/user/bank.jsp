<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <%@ include file="/public/head.jspf" %>
  </head>
  <body>
  
  	    <div class="wrapper">
       	<s:include value="../head.jsp"></s:include>
        <!-- 头部结束 -->

        <!-- 导航栏 -->
        <div class="navigation_container">
            <!---->
           
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
            <div class="pay-step">
                <!-- 订购人确认 -->
                <div class="person-check check">
                    <h1>Your Order Information</h1>
                    <div class="person-checkinner">
                        <div><span>Order No.</span>：<span>${sessionScope.oldShoppingcart.id}</span></div>
                        <div><span><s:text name="name"/></span>：<span>${sessionScope.oldShoppingcart.name}</span></div>
                        <div><span><s:text name="address"/></span>：<span>${sessionScope.oldShoppingcart.address}</span></div>
                        <div><span><s:text name="zip"/></span>：<span>${sessionScope.oldShoppingcart.post}</span></div>
                        <div><span><s:text name="amount"/></span>：<span>${sessionScope.oldShoppingcart.total}</span></div>
                    </div>
                </div>
                <div class="pay">
                    <div class="pay-inner">
                        <div class="fl">Payment Method:</div>
                        <div class="fl yibao-logo">
                             <a href=""><img src="${shop}/images/yibao.png" width="110" height="35" alt="" /></a>
                        </div>
                        <div class="fr blue aa">A world-class provider of electronic payment applications and services
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a class="red"href="">Help?</a>
                        </div>

                    </div>
                </div>
                <div class="select-bank">
                	<form action="${shop}/pay_goBank.action" method="post">
                    <h1>Choose bank</h1>
                    <!--  {fn:indexOf(name,'.'))}  {fn:substring(zip, 6, -1)} -->
                    <div>
                        <ul>
                           <c:forEach items="${applicationScope.bankImageList}" var="bankImage">
	                            <li>
	                            	<!-- 去掉图标的后缀名称，将剩下的名字传给易宝服务器 -->
	                                <input type="radio" name="pd_FrpId" value="${fn:substring(bankImage, 0, fn:indexOf(bankImage, '.'))}" />&nbsp;
	                                <img src="${shop }/files/bankImages/${bankImage}" />
	                            </li>
                           </c:forEach>
                        </ul>
                    </div>
                    <div class="clear"></div>
                    <div class="reminder"><span>Please make sure your bank card has opened online banking payment function, otherwise there is no way to complete the payment</span></div>
                    <div class="pay-submit">
                    	<div class="pay-inner">
                    		<input type="submit" style="width: 80px; height: 40px;" value='<s:text name="submit"></s:text>' />
                    	</div>
            		</div>	
                    </form>
                </div>
                
            </div>
            
            

            <s:include value="../foot.jsp"></s:include>
  </body>
</html>

