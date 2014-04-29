<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
		</div>
	</div>
	<div id="container">
		<div class="main">
			<div class="wrap">
				
				<div class="section group">
					<div class="cont-desc span_1_of_2">
						<div class="product-details">
							<div class="grid images_3_of_2">
								<img src="images/preview.jpg" alt="" />
							</div>
							<div class="desc span_3_of_2">
								<h2><c:out value='${movie.movieName}' /> </h2>
								<h2>YEAR/GENRE </h2>
								<p>
									CASTING/CASTING/CASTING
								</p>
								<div class="price">
									<p>
										RATING:<c:out value='${movie.review.rating}' />
									</p>
								</div>
								

							</div>
							<div class="clear"></div>
						</div>
						<div class="product_desc">
							<h2>Details :</h2>
							<p>
								<c:out value='${movie.movieDescription}' />
							</p>
							
						</div>
					</div>

				</div>
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

