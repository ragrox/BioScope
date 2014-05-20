<!DOCTYPE HTML>
<head>
	<title>The Bioscope</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
	<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
	<script type="text/javascript" src="js/move-top.js"></script>
	<script type="text/javascript" src="js/easing.js"></script>
</head>
<body>
	<div class="header">
		<div class="headertop_desc">
			<div class="wrap">
				<div class="nav_list">
				<a href="index.html"><img src="images/logo.png" alt="" height="70px" width="300px" /></a>
							
					</div>
				
				<div class="clear"></div>
			</div>
		</div>
		<div class="wrap">
			<div class="header_top">
				
			
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<div class="main">
		<div class="wrap">
			<div class="content">
			
				<div class="section group">
					<div class="col span_2_of_3">
						<div class="contact-form">
							<h2>Add Movie</h2>
							<form method="post" action="saveMovie.html">
								<div>
									<span><label>Movie Name</label></span>
									<span>
										<input name="movieName" type="text" class="textbox" >
									</span>
								</div>
								
								
								<div>
									<span><label>Movie Description</label></span>
									<span>
										<input name="movieDescription" type="text" class="textbox">
									</span>
								</div>
								
									<div>
									<span><label>Movie Rating</label></span>
									<span>
										<input name="movieRating" type="text" class="textbox">
									</span>
								</div>
								
									<div>
									<span><label>Movie Casting</label></span>
									<span>
										<input name="movieCasting" type="text" class="textbox">
									</span>
								</div>
								<div>
							
									<span>
										<input type="submit" value="Add Movie"  class="mybutton">
									</span>
								</div>
							</form>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	
			<div class="copy_right_login">
				<p>
					All Rights Reserved @Teemo
				</p>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
	<a href="#" id="toTop"><span id="toTopHover"> </span></a>
</body>
</html>

