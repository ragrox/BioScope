
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="content-type" content="text/html; charset=UTF-8">
  <title>jquery autocomplete xml search from beginning - jsFiddle demo by jensbits</title>
  
  <script type='text/javascript' src='js/jquery-1.6.3.js'></script>
  
  
  
  
  <script type="text/javascript" src="js/jquery-ui.js"></script>
  
  
  <link rel="stylesheet" type="text/css" href="/css/result-light.css">
  
    
      <link rel="stylesheet" type="text/css" href="js/jquery-ui.css">
    
  
  <style type='text/css'>
    .red {color: red}
  </style>
  


<script type='text/javascript'>
var data = [
    		{"label" : "Aragorn"},
    		{"label" : "Arwen"},
    		{"label" : "Bilbo Baggins"},
    		{"label" : "Boromir"},
    		{"label" : "Frodo Baggins"},
    		{"label" : "Gandalf"},
    		{"label" : "Gimli"},
    		{"label" : "Gollum"},
    		{"label" : "Legolas"},
    		{"label" : "Meriadoc Merry Brandybuck"},
    		{"label" : "Peregrin Pippin Took"},
    		{"label" : "Samwise Gamgee"}
    		];
$(function() {

	$( "#search" ).autocomplete(
	{
		source:data,
		select: function( event, ui ) {
			$( "#search" ).val( ui.item.label + " / " + ui.item.actor );
			return false;
		}
	}).data( "autocomplete" )._renderItem = function( ul, item ) {
		return $( "<li></li>" )
			.data( "item.autocomplete", item )
			.append( "<a><strong>" + item.label + "</strong> / " + item.actor + "</a>" )
			.appendTo( ul );
		};		

});
</script>



</head>
<body>
 <input type="text" id="search" />
  
</body>


</html>

