<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ include file="../common/taglibs.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <title><decorator:title default="Struts Starter" /></title>
    <link href="<spring:url value='/static/styles/main.css'/>" rel="stylesheet" type="text/css" media="all" />
    <script type="text/javascript" src="<c:url value='/static/scripts/jquery-1.4.2.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/scripts/jquery-ui-1.8.custom.min.js'/>"></script>
    <script type="text/javascript" src="<c:url value='/static/scripts/global.js'/>"></script>
    <decorator:head/>
  </head>
  <body id="page-home">
    <c:set var="currentMenu" scope="request">
      <decorator:getProperty property="meta.menu" />
    </c:set>
    <div id="page">
      <div id="header" class="clearfix">
        <div id="branding">
          <h1><a href="<c:url value='/'/>">OJQA</a></h1>
          <p>an OpenSource Q&A system</p>
        </div>
        <div id="nav">
          <div class="wrapper">
            <h2 class="accessibility">Navigation</h2>
            <jsp:include page="../common/menu.jsp" />
          </div><hr/>
        </div>
      </div>
      <div id="content" class="clearfix">
        <div id="main">
          <%@ include file="../common/messages.jsp" %><decorator:body/><hr/>
        </div>
        <div id="sub">
          <h3>Sub Content</h3>
        </div>
      </div>
      <div id="footer" class="clearfix">
        <div id="divider"></div>
        <span class="left">Version: 0.0.1</span>
        <span class="right">&copy; 2010-2010 <a href="#">Isaac</a></span>
      </div>
    </div>
    <div id="extra1">&nbsp;</div>
    <div id="extra2">&nbsp;</div>
  </body>
</html>
