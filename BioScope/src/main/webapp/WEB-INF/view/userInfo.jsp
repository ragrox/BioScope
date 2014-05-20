<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"></jsp:include>
		</div>
	</div>
	<!------------End Header ------------>
	<div id="container_userinfo">
	<div class="main">
		<div class="wrap">
			<div class="content_index">
				<div class="content_top_userinfo" style="text-align: right;">
					<div class="recently_watched" style="height: 200px; width: 400px;">

            <div class="content_top_user_review" style="text-align: left;padding: 10px 20px;
            border: 1px solid #EBE8E8;
            background: url(../images/strip-bg.gif) repeat-x #F6F6F6;
            width: 358px;">
                <div class="heading" >
                    <h3 id="user_info_heading">User Information</h3>
                </div>
            </div>

            <div style="margin-top: 20px; margin-left: 20px;text-shadow: 2px 3px 2px #715833;

            color: #260403;
            display: inline;
            float: left;
            font-family: Georgia, "Times New Roman", Times, serif;
            font-size: 14px;
            font-style: italic;
            margin: 12px 0 10px;
            padding: 0 20px;
            text-decoration: none;">
                <h4 >User Name :<c:out value='${user.userName}' /></h4></br>
                <h4 >Email :<c:out value='${user.email}' /></h4></br>
            </div>

        </div>
				</div>
				<div class="section group">
					<div id="left_div">
						<div class="recently_watched" style="height: 300px; width: 300px;">

							<div class="content_top" style="text-align: left;">
								<div class="heading" >
									<h3 id="user_info_heading">Movies Rated</h3>
								</div>
							</div>
							<div class="price-details">

								<div class="add-cart">
								<c:forEach var="movie" items="${listMovies}" varStatus="loopStatus">
									<h4 ><a href="movieInfo.html?movieName=<c:out value='${movie}' />" ><c:out value='${movie}' /></a></h4></br>
									</c:forEach>
									</div>
								<div class="clear"></div>
							</div>
						</div>
				
					</div><!--left div-->

					

				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="footer">
		<div class="wrap">

			<div class="copy_right">
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

