<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="../layout/header.jsp" %>
<div class="container">
  
  <form action="#" method="post">
    <div class="form-group">
      <label for="username">Username</label>
      <input type="text" name="username" class="form-control" placeholder="Enter username" id="username">
    </div>
    
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" name="password" class="form-control" placeholder="Enter password" id="password">
    </div>
    
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox"> 아이디 기억하기
      </label>
    </div>
    
    
  </form>
    <button name = "remember" id="btn-login" class="btn btn-primary">로그인</button>

</div>
<script src ="/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>
