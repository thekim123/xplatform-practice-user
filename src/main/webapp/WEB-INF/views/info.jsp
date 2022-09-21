<%@ page import = "java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
out.println("==========================================================================<br/>");
out.println("Client User-Agent Information<br/>");
out.println("==========================================================================<br/>");
java.util.Enumeration headerNames = request.getHeaderNames();   
while(headerNames.hasMoreElements()) {   
   String headerName = headerNames.nextElement().toString();   
   String headerValue = request.getHeader(headerName);   
   out.println(headerName+"&nbsp;:&nbsp;"+headerValue);
}
out.println("<br/><br/>");

out.println("==========================================================================<br/>");
out.println("Server Environment Information<br/>");
out.println("==========================================================================<br/>");
out.println("SERVER_PROTOCOL : " + request.getProtocol() + "<br/>");   
out.println("SERVER_PORT : " + request.getServerPort() + "<br/>");    
out.println("REQUEST_METHOD : " + request.getMethod() + "<br/>");   
out.println("PATH_INFO : " + request.getPathInfo() + "<br/>");   
out.println("PATH_TRANSLATED : " + request.getPathTranslated() + "<br/>");   
out.println("SCRIPT_NAME : " + request.getServletPath() + "<br/>");   
out.println("DOCUMENT_ROOT : " + request.getRealPath("/") + "<br/>");   
out.println("QUERY_STRING : " + request.getQueryString() + "<br/>");   
out.println("REMOTE_HOST : " + request.getRemoteHost() + "<br/>");   
out.println("REMOTE_ADDR : " + request.getRemoteAddr() + "<br/>");   
out.println("AUTH_TYPE : " + request.getAuthType() + "<br/>");   
out.println("REMOTE_USER : " + request.getRemoteUser() + "<br/>");   
out.println("CONTENT_TYPE : " + request.getContentType() + "<br/>");   
out.println("CONTENT_LENGTH : " + request.getContentLength() + "<br/>");   
out.println("HTTP_ACCEPT : " + request.getHeader("Accept") + "<br/>");   
out.println("HTTP_USER_AGENT : " + request.getHeader("User-Agent") + "<br/>");   
out.println("HTTP_REFERER : " + request.getHeader("Referer") + "<br/>");   
out.println("CONTEXT_PATH : " + request.getContextPath() + "<br/>");

%>
