$(function() {
	//decorate button
	$("input:submit,input:reset,a.href-button").button();

	//highlight input and textarea
	$('input[type=text], input[type=password], textarea').focus(function() {
		$(this).addClass('highlight');
	}).mouseover(function() {
		$(this).addClass('highlight');
	}).blur(function() {
		$(this).removeClass('highlight');
	}).mouseout(function() {
		$(this).removeClass('highlight');
	});
	
	//highlight table and make tr clickable
	var previousClass = null; 
	$('#users tbody tr').mouseover(function() {
		previousClass=this.className;
		this.className+=' over';
	}).mouseout(function() {
		this.className=previousClass;
	}).click(function() {
		location.href=$(this).find('td a').attr('href');
		return false;
	});
	
});