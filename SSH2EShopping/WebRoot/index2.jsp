<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML P
UBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@ include file="/public/head.jspf" %>  
	
  </head>
  
  <body>
    <!-- 下面两种方法都可以写 --></span>
    <a href="${pageContext.request.contextPath}/category_update.action?id=1&type=jackets&hot=false">访问update</a>
    <a href="category_save.action?id=1&type=haha&hot=false">测试ModelDriven</a><br/>
    <a href="category_query.action">查询所有类别</a><br/>
    <a href="send_main_aindex.action">测试到后台</a>
    ---------request----
    -----------<br/>
    <c:forEach items="${
    requestScope.categorylist }" var="category">
    	${category.id } | ${
    	category.type } | ${category.hot }<br/>
    </c:forEach>
    ---------session---------------<br/>
    <c:forEach items="${sessionScope.categorylist }" var="category">
    	${category.id } | ${category.type } | ${category.hot }<br/>
    </c:forEach>
    ---------application---------------<br/>
    <c:forEach items="${applicationScope.categorylist }" var="category">
    
    	${category.id } | ${category.ty
    	pe } | ${category.hot }<br/>
    </c:forEach>
  </body>
</html>
