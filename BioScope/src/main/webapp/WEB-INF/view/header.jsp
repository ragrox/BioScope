<!DOCTYPE HTML>
<head>
	<title>The Bioscope</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<link href="css/slider.css" rel="stylesheet" type="text/css" media="all"/>
	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript" src="js/jquery.nivo.slider.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			$('#slider').nivoSlider();
		});
	</script>
	 <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
  <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="http://code.jquery.com/resources/demos/style.css">
  <style>
  .ui-autocomplete-loading { background: white url('images/ui-anim_basic_16x16.gif') right center no-repeat; }
  </style>
  <script>
  $(function() {
    function log( message ) {
      $( "<div/>" ).text( message ).prependTo( "#log" );
      $( "#log" ).attr( "scrollTop", 0 );
    }
 
    $.ajax({
      url: "listAllMovies.html",
      dataType: "xml",
      success: function( xmlResponse ) {
        var data = $( "Movies", xmlResponse ).map(function() {
          return {
            value: $( "movie", this ).text() 
          };
        }).get();
        $( "#searchBox" ).autocomplete({
          source: data,
          minLength: 2,
          select: function( event, ui ) {
            log( ui.item ?
              "Selected: " + ui.item.value : "No value" );
          }
        });
      }
    });
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
				
				<div class="header_top_right">
					<a href="login.html">Login</a>
					<div class="search_box">
						<form>
							<input id="searchBox" type="text" size=200   placeholder="Find Movies and more..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
							<input type="submit" value="">
						</form>
					</div>
				</div>
			</div>