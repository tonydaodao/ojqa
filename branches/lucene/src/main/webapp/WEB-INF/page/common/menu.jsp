<%@ include file="taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
	<ul id="primary-nav" class="menuList">
	    <li class="pad">&nbsp;</li>
	    <menu:displayMenu name="SearchMenu"/>
	    <!-- 
	    <menu:displayMenu name="UserMenu"/>
	    <menu:displayMenu name="AdminMenu"/>
	    <menu:displayMenu name="Logout"/>
		<div class="last">
	    	<menu:displayMenu name="AskQuestion"/>
		</div>
	     -->
	</ul>
</menu:useMenuDisplayer>