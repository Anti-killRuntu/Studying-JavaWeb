<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%--   静态包含base标签，css样式，jQuery文件  --%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			/**
			 * 给删除标签绑定事件
			 * confirm是确认提示框函数
			 */
			$("a.delete").click(function () {
				return confirm("你确定要【" + $(this).parent().parent().find("td:first").text() + "】删除吗！");
			});

		});
	</script>
</head>
<body>

	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">图书管理系统</span>
			<%--静态包含菜单--%>
			<%@include file="/pages/common/manager_memu.jsp"%>
	</div>
	
	<div id="main">

		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>		
			<c:forEach items="${ requestScope.page.items }" var="books">
				<tr>
					<td>${ books.name }</td>
					<td>${ books.price }</td>
					<td>${ books.author }</td>
					<td>${ books.sales }</td>
					<td>${ books.stock }</td>
					<td><a href="manager/bookServlet?action=getBook&id=${books.id}&pageNumber=${requestScope.page.pageNumber}">修改</a></td>
					<td><a class="delete" href="manager/bookServlet?action=delete&id=${books.id}&pageNumber=${requestScope.page.pageNumber}">删除</a></td>
				</tr>
			</c:forEach>

			
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp?pageNumber=${requestScope.page.pageTotal}">添加图书</a></td>
			</tr>	
		</table>

		<%--静态包含分页条--%>
		<%@include file="/pages/common/page_nav.jsp" %>
	</div>

	<%--	静态包含页脚--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>