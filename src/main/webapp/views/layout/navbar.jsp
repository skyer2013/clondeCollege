<%@ page language="java" pageEncoding="utf-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">cloud college</a>
    </div>
        <div id="navbar" class="navbar-collapse collapse">
          <% if (session.getAttribute("user")!=null){
            %>
          <div class="navbar-brand navbar-right white">欢迎您，${user.name}<a href="<%=request.getContextPath()%>/account/logout">[登出]</a></div>
          <%
          }else{
          %>
          <form class="navbar-form navbar-right" action="<%=request.getContextPath()%>/account/login" method="post">

            <div class="form-group">
              <input type="text" placeholder="Username" class="form-control" name="username">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control" name="password">
            </div>
            <a id="btn_submit" href="javascript:;" class="btn btn-success">登录</a>
            <a href="<%=request.getContextPath()%>/account/register" class="btn btn-success">注册</a>
          </form>
          <%
            }
          %>
        </div><!--/.navbar-collapse -->

  </div>
</nav>