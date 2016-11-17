<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<link rel="stylesheet" href="${shop}/css/detail.css" />
	<script type="text/javascript">
		function searchProduct() {
	
			window.location.href = "product_search.action?name=" + $("#key").val();
		}
	</script>
</head>
<body>
    <div class="wrapper">
       <s:include value="head.jsp"/>
        <!-- 头部结束 -->
       
        <!--导航栏结束-->
        <div class="section_container">
            <!-- 面包屑 -->
            <ul class="breadcrumb">
                <li>
                    <a href="#"><s:text name="accueil"/></a>
                </li>
                <li>
                    <a href="#"><s:text name="women"/></a>
                </li>
                <li class="active">
                    <a href="#"><s:text name="skirt"/></a>
                </li>
            </ul>
            <!-- 产品详情 -->
            <div id="product_detail">
                <!--详情左侧-->
                <div class="product_leftcol fl">
                    <div id="jingdong">
                        <div class="datu">
                            <img src="${shop}/files/${product.pic}" />
                            <div id="fangdajing"></div>
                        </div>
                        <div class="xiaotu">
                            <div class="leftbut"></div>
                            <div class="tu">
                                <ul>
                                    <li>
                                        <img src="images/0.png" />
                                    </li>
                                    <li>
                                        <img src="images/1.png" />
                                    </li>
                                    <li>
                                        <img src="images/2.png" />
                                    </li>
                                    <li>
                                        <img src="images/3.png" />
                                    </li>
                                    <li>
                                        <img src="images/4.png" />
                                    </li>
                                    <li>
                                        <img src="images/5.png" />
                                    </li>
                                    <li>
                                        <img src="images/6.png" />
                                    </li>
                                    <li>
                                        <img src="images/7.png" />
                                    </li>
                                    <li>
                                        <img src="images/8.png" />
                                    </li>
                                </ul>
                            </div>
                            <div class="rightbut"></div>
                        </div>
                    </div>
                </div>
                <!--详情左侧结束-->
                <!--详情右侧-->
                <div class="product_rightcol fr">
                    <div id="name">
                        <h1>${product.name}</h1>
                    </div>
                    <ul id="summary">
                        <li id="summary-market">
                            <div class="dt">Price:&nbsp;</div>
                            <div class="dd"> <del id="page_maprice">$219.00</del>
                            </div>
                        </li>
                        <li id="summary-price">
                            <div class="dt">Discount:&nbsp;</div>
                            <div class="dd"> <strong class="p-price" id="jd-price">$${product.price}</strong>
                            </div>
                        </li>
                    </ul>
                    <ul id="choose" >
                        <li id="choose-color" class="choose-color-shouji">
                            <div class="dt">Color：</div>
                            <div class="dd">
                                <div class="item">
                                    <b></b>
                                    <a href="#none" title="white">
                                        <img data-img="1" src="images/11.jpg" width="25" height="25" alt="white">
                                    </a>
                                </div>
                                <div class="item  selected">
                                    <b></b>
                                    <a href="#none" title="black">
                                        <img data-img="1" src="images/22.jpg" width="25" height="25" alt="black ">
                                    </a>
                                </div>
                            </div>
                        </li>
                        <li id="choose-version">
                            <div class="dt">size：</div>
                            <div class="dd">
                                <div class="item">
                                    <b></b>
                                    <a href="#none" title="S" style="cursor: pointer;">S</a>
                                </div>
                                <div class="item  selected">
                                    <b></b>
                                    <a href="#none" title="M" style="cursor: pointer;">M</a>
                                </div>
                                <div class="item">
                                    <b></b>
                                    <a href="#none" title="L" style="cursor: pointer;">L</a>
                                </div>
                                <div class="item">
                                    <b></b>
                                    <a href="#none" title="XL" style="cursor: pointer;">XL</a>
                                </div>
                                <div class="item">
                                    <b></b>
                                    <a href="#none" title="XXL" style="cursor: pointer;">XXL</a>
                                </div>
                            </div>
                        </li>
                        <li id="choose-amount">
                            <div class="dt">quantity：</div>
                            <div class="dd">
								 <input value="1" size="2" >
                            </div>
                        </li>
                    </ul>
                    <div class="add_to_buttons">                   
                        <a href="${shop}/sorder_addSorder.action?product.id=${product.id}">
                        	<button class="add_cart"><s:text name="addcart"/></button>
                        </a>
                        
                    </div>
                </div>
                <!--详情右侧结束--> </div>
            <!--产品详情结束-->
            <!-- 产品列表 -->
            <div class="products_list products_slider clear">
                <h2 class="sub_title">New Arrival</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                    <li>
                        <a  href="#"class="product_image">
                            <img src="images/pr_l_1.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                        <button>
                            <span class="pr_add"><s:text name="addcart"/></span>
                        </button>
                        <button class="price_add" title="" type="button"></button>
                            <span class="pr_price">$76.00</span>
                        </div>
                    </li>
                    <li>
                        <a   href="#" class="product_image">
                            <img src="images/pr_l_2.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_3.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_5.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_1.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_2.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                </ul>
            </div>
            <!--产品列表结束  -->
            <!-- 产品列表 -->
            <div class="products_list products_slider clear">
                <h2 class="sub_title">New Arrival</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_1.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                        <button>
                            <span class="pr_add"><s:text name="addcart"/></span>
                        </button>
                        <button class="price_add" title="" type="button">
                            <span class="pr_price">$76.00</span></button>
                        </div>
                    </li>
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_2.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_3.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_5.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_1.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                    <li>
                        <a  href="#" class="product_image">
                            <img src="images/pr_l_2.jpg" />
                        </a>
                        <div class="product_info">
                            <h3>
                                <a href="#">Summer skirt</a>
                            </h3>
                            <small>100% cotton</small>
                        </div>
                        <div class="price_info">
                            <button>
                                <span class="pr_add"><s:text name="addcart"/></span>
                            </button>
                            <button class="price_add" title="" type="button">
                                <span class="pr_price">$76.00</span>
                            </button>
                        </div>
                    </li>
                </ul>
            </div>
            <!--产品列表结束  -->
            <!-- 导航栏结束 -->
            <s:include value="foot.jsp"></s:include>
         </div>
      </div>
	</body>
</html>

