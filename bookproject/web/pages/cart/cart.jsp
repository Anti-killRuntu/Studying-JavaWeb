<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--   静态包含base标签，css样式，jQuery文件  --%>
	<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			/**
			 * 给删除标签绑定事件
			 * confirm是确认提示框函数
			 */
			$("a.deleteItem").click(function () {
				return confirm("你确定要【" + $(this).parent().parent().find("td:first").text() + "】删除吗！");
			});
			/**
			 * 给清空购物车绑定事件
			 * confirm是确认提示框函数
			 */
			$("a.clearCart").click(function () {
				return confirm("你确定要【清空购物车】吗！");
			});
			/**
			 * 给修改商品数量绑定事件
			 * confirm是确认提示框函数
			 * change内容发生改变事假
			 */
			$(".updateCount").change(function () {
				var name = $(this).parent().parent().find("td:first").text();
				var count = this.value;
				var id = $(this).attr("bookid")
				if (confirm("你确定要修改【" + name + "】的数量为" + count + "吗！")){
					location.href = "http://localhost:8080/book/cartServlet?action=updateCount&id="+ id + "&count="+count;
				}else{
					this.value = this.defaultValue;
				}
			});

		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%--	静态包含登录成功后的菜单		--%>
		<%@ include file="/pages/common/login_success_memu.jsp"%>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">当前购物车为空，点击返回商品主页</a></td>
				</tr>
			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entey">
					<tr>
						<td>${entey.value.name}</td>
						<td>
							<input type="text" bookid="${entey.key}" class="updateCount" style="width: 80px" value="${entey.value.count}">
						</td>
						<td>${entey.value.price}</td>
						<td>${entey.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entey.value.id}">删除</a></td>
					</tr>
				</c:forEach>
			</c:if>
			

		</table>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a class="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>
	
	</div>

	<%--	静态包含页脚--%>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>