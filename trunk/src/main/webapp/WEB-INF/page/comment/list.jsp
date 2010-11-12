<%@ include file="../common/taglibs.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="menu" content="CommentMenu"/>
	<title>Comment Setting | OJQA</title>
</head>
<h3>Comment Profile</h3>

<display:table id="comments" name="commentList"  pagesize="5" class="table" requestURI="" export="true" sort="list">
    <display:column property="id" sortable="true"/>
    <display:column property="createDate" sortable="true"/>
    <display:column property="content" sortable="false"/>
    <display:setProperty name="export.excel.filename" value="UsersList.xls"/>
    <display:setProperty name="export.csv.filename" value="UsersList.csv"/>
    <display:setProperty name="export.pdf.filename" value="UsersList.pdf"/>
</display:table>
<a href="<c:url value="/comment/"/>" class="href-button add-button">
    <fmt:message key='button.add.comment'/>
</a>