<%@ include file="taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
	<ul id="primary-nav" class="menuList">
	    <li class="pad">&nbsp;</li>
	    <menu:displayMenu name="CommentMenu"/>
	    <menu:displayMenu name="UserMenu"/>
	    <menu:displayMenu name="AdminMenu"/>
	    <menu:displayMenu name="Logout"/>
	    <menu:displayMenu name="AskQuestion"/>
	</ul>
</menu:useMenuDisplayer>