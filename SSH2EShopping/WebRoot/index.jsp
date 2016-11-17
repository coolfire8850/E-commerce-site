<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
  	<script type="text/javascript">
  		function searchProduct(){
  			
  			window.location.href="product_search.action?name="+$("#key").val();
  		}
  	</script>
  	
  	
  </head>
  
  <body>
  
  	<div class="wrapper">
        
    	<s:include value="head.jsp"/>
    	
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
            <!--左侧导航-->
            <div id="side_nav">
                <div class="sideNavCategories">
                    <h1><s:text name="women"/></h1>
                    <ul class="category departments">
                        <li class="header"><s:text name="category"/></li>
                        <li><a href="#"><s:text name="sweater"/></a></li>
                        <li><a href="#"><s:text name="knit"/> </a></li>
                        <li><a href="#"><s:text name="shirt"/> </a></li>
                        <li><a href="#"><s:text name="t-shirt"/></a></li>
                        <li><a href="#"><s:text name="shorts"/></a></li>
                        <li><a href="#"><s:text name="jeans"/></a></li>
                        <li><a href="#"><s:text name="casualpants"/></a></li>
                        <li><a href="#"><s:text name="windbreaker"/> </a></li>
                    </ul>
                </div>
                
            </div>
            <!-- 右侧焦点图区域 -->
            <div id="main_content ">
                <div > <img src="images/lm_banner_1.jpg" /> </div>
            </div>
        </div>

        
       


            <!-- 产品列表  大循环拿到biglist  -->
            <c:forEach items="${applicationScope.bigList}" var="list">
	            <div class="products_list products_slider clear">
	            	<!-- 显示类别名称  拿到商品所属类别的名称-->
	                <h2 class="sub_title">${list[0].category.type}</h2>
	                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
	                	<!-- 小循环显示具体商品 -->
	                    <c:forEach items="${list}" var="product">
		                    <li> 
		                    	<a href="${shop}/product_get.action?id=${product.id}" class="product_image"><img src="${shop}/files/${product.pic}" /></a>
		                        <div class="product_info">
		                            <h3><a href="#"><s:text name="productname"/>:${product.name }</a></h3>
		                            <small><s:text name="description"/>:${product.remark}</small> </div>
		                        <div class="price_info"> 
		                        	<%-- <%int temp=(int)(Math.floor(Math.random()*1000000000));session.setAttribute("token1",temp);%> --%>
		                            <a href="${shop}/sorder_addSorder.action?product.Id=${product.id}"><button><span class="pr_add"><s:text name="addcart"/></span></button></a>
		                            <button class="price_add" title="" type="button">
		                            	<span class="pr_price">$${product.price}</span>
		                            </button>
		                        </div>
		                    </li>
	                    </c:forEach>
	                </ul>
	            </div>
            </c:forEach>
            
            
        <!--产品列表结束  -->

         
     	<s:include value="foot.jsp"/>
    </div>

  </body>
</html>