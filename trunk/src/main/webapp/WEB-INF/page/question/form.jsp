<%@ include file="../common/taglibs.jsp" %>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="menu" content="UserMenu"/>
  <title>Ask a question | OJQA</title>
</head>
<h3>Ask a question</h3>
<form action="<c:url value="add"/>" method="post">
  <ul>
    <li class="info">
      <p>
        Please fill your question in the form.
      </p>
    </li>
    <div class="wwlbl">
    </div>
    <input type="text" name="title" class="text large" value="${entity.title}">
    <input type="text" name="tagNames" class="text large" value="${entity.tagNames}">
    <input type="text" name="body" class="text large" value="${entity.body}">
    </li>
    <li>
      <input type="submit" value="Submit"/><input type="reset"/>
    </li>
  </ul>
</form>