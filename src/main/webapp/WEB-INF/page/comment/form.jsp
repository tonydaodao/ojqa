<%@ include file="../common/taglibs.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="menu" content="CommentMenu"/>
	<title>User Setting | OJQA</title>
</head>

<h3>Comment Profile</h3>
<form action="<c:url value="add"/>" method="post">
	<input type="hidden" name="id" value="${entity.id}"/>
    <ul>
	    <li class="info">
	        <p>Please update your information using the form below.</p>
	    </li>
	    <li>
	         <div class="wwlbl">
                <label class="desc" for="addUser_user_name">Comment<span class="req">*</span>
	                <form:errors path="entity.content" cssClass="errorMessage"/>
                </label>
             </div>
    	     <input type="text" name="content" class="text large" value="${entity.content}">
	     </li>
	     <li>
	         <input type="submit" value="Submit"/> <input type="reset"/>
	         <c:if test="${!empty entity.id}">
	             <a href="<c:url value="delete"/>/${entity.id}" class="href-button delete-button">
	                 Delete
	             </a>
	         </c:if>
	     </li>
    </ul>
</form>