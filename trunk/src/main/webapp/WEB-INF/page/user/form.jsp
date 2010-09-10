<%@ include file="../common/taglibs.jsp"%>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="menu" content="UserMenu"/>
	<title>User Setting | ACTM</title>
</head>

<h3>User Profile</h3>
<form action="<c:url value="add"/>" method="post">
	<input type="hidden" name="id" value="${entity.id}"/>
    <ul>
	    <li class="info">
	        <p>Please update your information using the form below.</p>
	    </li>
	    <li>
	         <div class="wwlbl">
                <label class="desc" for="addUser_user_name">Name<span class="req">*</span>
	                <form:errors path="entity.name" cssClass="errorMessage"/>
                </label>
             </div>
    	     <input type="text" name="name" class="text large" value="${entity.name}">
	         <div>
	             <div class="left">
	                 <label class="desc" for="addUser_user_password">Password <span class="req">*</span>
	                 	<form:errors path="entity.password" cssClass="errorMessage"/>
	                 </label>
	                 <input type="password" name="password" class="text medium" value="${entity.password}"/>
	             </div>
	             <div>
	                 <label class="desc" for="addUser_user_confirmPassword">ConfirmPassword <span class="req">*</span>
		                 <form:errors path="entity.confirmPassword" cssClass="errorMessage"/>
	                 </label>
	                 <input type="password" name="confirmPassword" class="text medium" value="${entity.confirmPassword}"/>
	             </div>
	         </div>
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