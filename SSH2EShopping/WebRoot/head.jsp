<%--  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">--%>
<html>
  <head>
  <%@ include file="/public/head.jspf" %>
  </head> 
  
  <body>
     <div class="header">
            <div class="header_container">
                <!--头部开始-->
                        <div class="top_bar clear">
                            <!--头部小导航-->
                            <div class="welcom fl"> 
                            <s:text name="welcome"></s:text>
                            <c:choose>
                            	<c:when test="${sessionScope.user==null }">
                            	guest
                            	</c:when>
                            	<c:otherwise>
                            		${sessionScope.user.name }
                            	</c:otherwise>
                            </c:choose>
                           
                            </div>
                            <ul class="top_links fr">
                                <li class="highlight"><a href="${shop }/index.jsp"><s:text name="accueil"/></a></li>
                                <li><a href="#"><s:text name="compte"/></a></li>
                                <li><a href="${shop }/showCart.jsp"><s:text name="cart"/></a></li>
                                <li><a href="${shop }/register.jsp"><s:text name="register"/></a></li>
                                <li ><a href="${shop }/ulogin.jsp"><s:text name="login"/></a></li>
                                <li ><a href="${shop }/send_main_aindex.action">back-end</a></li>
                                <li> <a href="${shop }/input.action?request_locale=en&returnUrl=<%=request.getRequestURI()%>">En</a> </li>
                                <li> <a href="${shop }/input.action?request_locale=fr&returnUrl=<%=request.getRequestURI()%>">Fr</a> </li>
                                
                            </ul>
                            <!--头部小导航结束-->
                            <!-- logo -->
                            <h1 class="logo clear fl"> <a href="index.html"><img src="images/logo.png" /></a> </h1>
                            <!-- 购物车 -->
                            <div class="minicart">
                                <a class="minicart_link" href="#">
                                   <b>${fn:length(sessionScope.shoppingcart.sorders)}</b></span> 
								<span class="price"> <b>$<fmt:formatNumber value="${sessionScope.shoppingcart.total}" pattern="##.##" minFractionDigits="2"/></b> </span> 
                                </a>
                            </div>
                            <!-- 购物车结束 -->
                            <!-- 搜索框 -->
                            <div class="header_search">
                                <div class="form-search ">
                                    <input  class="input-text" id="key" onkeydown="javascript:if(event.keyCode==13) searchProduct();" type="text" placeholder="<s:text name="searchint"/>" />
                                    <button type="submit" title="Search" onclick="searchProduct()"></button>
                                </div>
                            </div>
                   
                        </div>
                    
            </div>
        </div>
        <!-- 头部结束 -->

       

        
         
 </body>
</html> 
