<%@ include file="../common/taglibs.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="menu" content="UserMenu"/>
	<title>Search Demo</title>
</head>

<h3>User Profile</h3>
<form action="<c:url value=""/>" method="post">
    <ul>
        <li>
	        <a href="<c:url value="/search/index"/>" class="href-button add-button">
	            <fmt:message key='search.index.button'/>
	        </a>
        </li>
	    <li class="info">
	        <p>Please input your key word.</p>
	    </li>
	    <li>
    	     <input type="text" name="name" class="text middle">
    	</li>
    </ul>
</form>