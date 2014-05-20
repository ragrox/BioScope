<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:forEach var="review" items="${listReviews}" varStatus="loopStatus">
	<c:out value='${review.userName}' />
	<c:out value='${review.rating}' />
	<c:out value='${review.reviewDescription}' />
	<c:if test="${!loopStatus.last}"> | </c:if>
</c:forEach> --%>
<c:forEach var="review" items="${listReviews}" varStatus="loopStatus">
<div class="recently_watched" style="height: 100px; width: 600px;">

            <div class="content_top_user_review" style="text-align: left;padding: 10px 20px;
            border: 1px solid #EBE8E8;
            background: url(../images/strip-bg.gif) repeat-x #F6F6F6;
            width: 400px;">
                <div class="heading" >
                    <h3 id="user_info_heading"><c:out value='${review.userName}' /> (Rated - <c:out value='${review.rating}' />) </h3>
                </div>
            </div>

            <div style="margin-top: 2px; margin-left: 2px;text-shadow: 2px 3px 2px #715833;

            color: #260403;
            display: inline;
            float: left;
            font-family: Georgia, "Times New Roman", Times, serif;
            font-size: 14px;
            font-style: italic;
            margin: 12px 0 10px;
            padding: 0 20px;
            text-decoration: none;">
                <h4 ><c:out value='${review.reviewDescription}' /></h4></br>
             
            </div>

        </div>
        </c:forEach>