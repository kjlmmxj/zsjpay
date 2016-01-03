

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() ;
%>
<c:set var="ctx" value="<%=basePath %>" />