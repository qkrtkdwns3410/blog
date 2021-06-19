<%--
  Created by IntelliJ IDEA.
  User: psj
  Date: 2021-06-13
  Time: 오후 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="layout/header.jsp" %>
<div class="container">
    <c:forEach var="board" items="${boards.content}">
        <div class="card m-3">
            <div class="card-body">
                <h4 class="card-title">${board.title}</h4>
                <a href="#" class="btn btn-primary">상세보기</a>
            </div>
        </div>
    </c:forEach>
    
    <ul class="pagination justify-content-center">
        <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
        <li class="page-item"><a class="page-link" href="?page=1">Next</a></li>
    </ul>
</div>

<%@ include file="layout/footer.jsp" %>



