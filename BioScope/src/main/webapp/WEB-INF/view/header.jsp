<!DOCTYPE HTML>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<title>The Bioscope</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="css/slider.css" rel="stylesheet" type="text/css" media="all"/>
	<script type='text/javascript' src='js/jquery-1.6.3.js'></script>
  
  
      <link rel="stylesheet" type="text/css" href="js/jquery-ui.css">
  
  
  <script type="text/javascript" src="js/jquery-ui.js"></script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			$('#slider').nivoSlider();
		});
	</script>
	<script type='text/javascript'>
	

   

var data = [
       	 <c:forEach var="movie" items="${list}">
    		{"label" : "<c:out value='${movie.movieName}'/>"},
    		  </c:forEach>
    		];
$(function() {
	
	$( "#searchBox" ).autocomplete(
	{
		source:data,
		select: function( event, ui ) {
			$( "#searchBox" ).val( ui.item.label);
			return false;
		}
	}).data( "autocomplete" )._renderItem = function( ul, item ) {
		return $( "<li></li>" )
			.data( "item.autocomplete", item )
			.append( "<a href=movieInfo.html?="+ item.label + "><strong>" + item.label + "</strong></a>" )
			.appendTo( ul );
		};		

});
</script>
			
</head>
<body>
	<div class="header">
		<div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
					<a href="index.html"><img src="images/logo.png" alt="" width="300px" height="70px"/></a>
						
					
				</div>
				
			</div>
	
		</div>
		<div class="wrap">
		
			<div class="header_top">
		
					<%-- 					<span style="float:left">
		<ul>
		<%
		if( session.getAttribute("uname") == null){
		%>
		<li><a href="login.html">Login</a></li>
		<li><a href="register.html">Register</a></li>
		<%}else{ %>
		<li> Hello <%= session.getAttribute("uname") %> !</li>
		<%if( session.getAttribute("role_user") != null){ %>
		<li> <a href="addMovie.html">Add a Movie</a></li>
		<%} }%>
		</ul>
		</span> --%>
		<div id="nav">
					<%
		if( session.getAttribute("uname") == null){
		%>
                    <a href="login.html">LOGIN</a>
                    <a href="register.html" id="lastchild">REGISTER</a>
<%}else{ %>
		
		<%if( session.getAttribute("urole") != null){ %>
		<a href="addMovie.html">Add Movie (admin)</a>
		<%} %>
		<a href='userInfo.html?userName=<%= session.getAttribute("uname") %>'> Hello <%= session.getAttribute("uname") %> !</a>
		<a href="logout.html" id="lastchild"> Logout</a>
<%}%>
                </div>
				<div class="header_top_right">

					<div class="search_box">
						<form action="movieInfo.html" method="GET">
							<input id="searchBox" name="movieName" type="text" size=200>
							<input type="submit" value="">
						</form>
					</div>
				</div>
			</div>