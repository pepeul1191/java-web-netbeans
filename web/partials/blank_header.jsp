<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%= request.getAttribute("css") %>
  <title>JSP Page</title>
</head>
<body>
  <h1>Header</h1>
  BASE_URL: ${pageContext.request.contextPath} <br>