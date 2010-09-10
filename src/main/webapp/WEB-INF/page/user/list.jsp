<%@ include file="../common/taglibs.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="menu" content="UserMenu"/>
	<title>User Setting | ACTM</title>
</head>
<h3>User Profile</h3>

<display:table id="users" name="userList"  pagesize="5" class="table" requestURI="" export="true" sort="list">
    <display:column property="id" sortable="true"/>
    <display:column title="Name" sortable="true">
      <a href="<c:url value="/user/${users.id}"/>">
      	<c:out value="${users.name}"/>
      </a>
    </display:column>
    <display:setProperty name="export.excel.filename" value="UsersList.xls"/>
    <display:setProperty name="export.csv.filename" value="UsersList.csv"/>
    <display:setProperty name="export.pdf.filename" value="UsersList.pdf"/>
</display:table>
<a href="<c:url value="/user/"/>" class="href-button add-button">
    <fmt:message key='button.add.user'/>
</a>