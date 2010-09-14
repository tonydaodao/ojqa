<%@ include file="../common/taglibs.jsp" %>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="menu" content="AskQuestion"/>
  <title>Ask a question | OJQA</title>
</head>
<div id="main-bar">
  <h3>Ask a question</h3>
</div>
<div>
  <form action="<c:url value="add"/>" method="post">
    <ul>
      <li>
        <label class="info">title:</label>
        <input type="text" name="title" class="text large" value="${entity.title}"/>
        <label class="desc">please enter a descriptive title for your question</label>
      </li>
      <li>
        <label class="info">title</label>
        <input type="text" name="tagNames" class="text large" value="${entity.tagNames}"/>
        <label class="desc">please enter a descriptive title for your question</label>
      </li>
      <li>
        <label class="info">title</label>
        <input type="text" name="tagNames" class="text large" value="${entity.tagNames}"/>
        <label class="desc">please enter a descriptive title for your question</label>
      </li>
      <li>
        <input type="submit" value="Submit"/><input type="reset"/>
      </li>
    </ul>
  </form>
</div>