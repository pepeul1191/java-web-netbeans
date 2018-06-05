<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="shortcut icon" href="<%= request.getAttribute("static_url") %>img/favicon.ico">
  <%= request.getAttribute("css") %>
  <title><%= request.getAttribute("title") %></title>
  <script type="text/javascript">
    var BASE_URL = "<%= request.getAttribute("base_url") %>";
    var STATICS_URL  = "<%= request.getAttribute("static_url") %>";
    var CSRF = "";
  </script>
</head>
<body class="container">
  <!--BASE_URL: ${pageContext.request.contextPath} <br>-->