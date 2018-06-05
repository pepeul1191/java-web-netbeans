<%@page contentType="text/html" pageEncoding="UTF-8"%>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bower_components/swp-backbone/assets/css/dashboard.css" />

<jsp:include page="../partials/blank_header.jsp">
  <jsp:param name="title" value="Main title" />
</jsp:include>
<%=request.getAttribute("name")%>
<jsp:include page="../partials/blank_footer.jsp">
  <jsp:param name="title" value="Main title" />
</jsp:include>