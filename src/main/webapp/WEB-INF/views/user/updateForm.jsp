<%--
  Created by IntelliJ IDEA.
  User: psj
  Date: 2021-06-13
  Time: 오후 8:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../layout/header.jsp" %>
<div class="container">
    
    <form>
        <input type="hidden" id="id" value="${principal.user.id}"/>
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text"  value="${principal.user.username}" class="form-control" placeholder="Enter username" id="username" readonly>
        </div>
        
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password"  class="form-control" placeholder="Enter password" id="password">
        </div>
        
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email"  value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email" >
        </div>
        
        
        
    </form>
    <button id="btn_update" class="btn btn-primary">회원수정완료</button>


</div>

<script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>



