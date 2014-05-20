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
								
								<p><b>CASTING</b>
								<c:forEach var="casting" items="${movie.casting}" varStatus="loopStatus">
									<c:out value='${casting}'/>
									  <c:if test="${!loopStatus.last}"> | </c:if>
									</c:forEach>
								</p>
								<div class="price">
									<p>
										<b>RATING:</b><c:out value='${movie.rating}' />
									</p>
								</div>
								
									<div class="price">
									<p>
										<b>Rate Movie:</b>
										<form action="rateMovie.html"  method="POST">
										<input type="hidden" name="movieName" value="<c:out value='${movie.movieName}' />">
											<select name="urating">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											</select>
											<!-- <br/>Review<br/>
											<textarea rows="4" cols="30" name="reviewDescription"></textarea>
											 --><br/><input type="submit" value="Rate">
										</form>
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
					<%-- 	<div class="product_desc">
							<jsp:include page="showRatings.jsp"></jsp:include>
						</div> --%>
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

