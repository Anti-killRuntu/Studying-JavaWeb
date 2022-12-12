<%--
  Created by IntelliJ IDEA.
  User: Yhun
  Date: 2022/11/11
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--分页条开始--%>
<div id="page_nav">
    <c:if test="${requestScope.page.pageNumber > 1}">
        <a href="${ requestScope.page.url }&pageNumber=1">首页</a>
        <a href="${ requestScope.page.url }&pageNumber=${requestScope.page.pageNumber-1}">上一页</a>
        <a href="${ requestScope.page.url }&pageNumber=${requestScope.page.pageNumber-1}">${requestScope.page.pageNumber-1}</a>
    </c:if>
    【${requestScope.page.pageNumber}】
    <c:if test="${requestScope.page.pageNumber < requestScope.page.pageTotal}">
        <a href="${ requestScope.page.url }&pageNumber=${requestScope.page.pageNumber+1}">${requestScope.page.pageNumber+1}</a>
        <a href="${ requestScope.page.url }&pageNumber=${requestScope.page.pageNumber+1}">下一页</a>
        <a href="${ requestScope.page.url }&pageNumber=${requestScope.page.pageTotal}">末页</a>
    </c:if>
    共${requestScope.page.pageTotal}页，${requestScope.page.pageTotalCount}条记录
    到第<input value="" name="pn" id="pn_input" />页
    <input id="hrefbottom" type="button" value="确定">
    <script type="text/javascript">
        $(function () {
            //调到指定页码
            $("#hrefbottom").click(function () {
                var pageNumber = $("#pn_input").val()
                if (pageNumber < 1){
                    pageNumber = 1
                }
                if (pageNumber > ${requestScope.page.pageTotal}){
                    pageNumber = ${requestScope.page.pageTotal}
                }
                location.href = "${pageScope.basePath}${ requestScope.page.url }&pageNumber=" + pageNumber
            })
        })
    </script>
</div>
<%--分页条结束--%>