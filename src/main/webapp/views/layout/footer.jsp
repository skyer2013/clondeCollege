  <%@ page language="java" pageEncoding="utf-8"%>
 <footer class="footer">
       <hr>
       <div class="container">
         <p class="text-muted">right by young,wonder,visit to <a href="http://www.github.com/wonder27young">wonder27young</a> for detail</p>
       </div>
 </footer>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="<%=request.getContextPath() %>/webjars/jquery/2.1.4/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="<%=request.getContextPath() %>/webjars//bootstrap/3.1.0/js/bootstrap.min.js"></script>
  <script>
      basepath = "<%=request.getContextPath() %>";
  </script>
  <!-- commonjs -->
  <script src="<%=request.getContextPath() %>/resources/js/common.js"></script>
  <script>
      $(function(){
          initLogin($("#btn_submit"));
      });

  </script>