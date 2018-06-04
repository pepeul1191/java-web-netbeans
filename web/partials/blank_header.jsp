<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<c:url value='/resources/index.css' />" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/font-awesome/css/font-awesome.min.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/swp-backbone/assets/css/constants.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/swp-backbone/assets/css/dashboard.css" />
  <title>JSP Page</title>
</head>
<body>
  <h1>Header</h1>
  BASE_URL: ${pageContext.request.contextPath} <br>