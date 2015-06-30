<%@ page language="java" pageEncoding="utf-8"%>

<jsp:include page="/layout/header"></jsp:include>

</head>
<body>
<jsp:include page="/layout/navbar"></jsp:include>
<!-- main content -->
<div id="register">
<div class="container">
      <form class="form-signin" action="<%=request.getContextPath()%>/account/register.do" method="post">
        <h2 class="form-signin-heading">Please register</h2>
        <label for="inputNickName" class="sr-only">Nick Name</label>
        <input type="text" id="inputNickName" class="form-control" placeholder="Nick Name" required="true" autofocus="" name="nickname">
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="true" name="username">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="true" name="password">
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me" name="autoLogin"> 直接登录
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
      </form>
</div>
</div>
<!-- main content end -->
<jsp:include page="/layout/footer" />

</body>
</html>