<%@ include file="../common/taglibs.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="menu" content="UserMenu"/>
	<title>Search Result | OJQA</title>
</head>
<h3>Search Result</h3>

<display:table id="searchresults" name="hits" requestURI="getsearch" pagesize="5" class="table" sort="list" >
    <display:column property="keyword" sortable="true"/>
    <display:column property="probability" sortable="true"/>
    <display:column property="location" sortable="true"/>
    <display:column property="linenumber"/>
    <display:column property="text" sortable="true"/>
</display:table>