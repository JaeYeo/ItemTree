<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	function fn_paging(curPage) {
		location.href = "postList?curPage=" + curPage;
		}
	$(document).ready(function() {
		$(".type").each(function(index, item) {
			$(".overview").each(function(i, ite) {
				
			})
		})
	})
</script>
</head>
<body>
	<table>
	<colgroup>
		<col style="width:7%">
		<col style="width:15%">
		<col style="width:40%">
		<col style="width:10%">
		<col style="width:15%">
		<col style="width:10%">
	</colgroup>
	<thead>
		<tr>
			<th>물품타입</th>
			<th>게임명/서버명</th>
			<th>물품제목</th>
			<th>판매수량</th>
			<th>가격</th>
			<th>등록일</th>
		</tr>
	</thead>
	<c:forEach var="list" items="${List }" varStatus="status">
	<tbody>
		<tr>
			<td class="type" style="text-align: center;">${list.type }</td>
			<td>${list.gamename } / ${list.servername }</td>
			<td><c:if test="${list.type != '거래완료' }"><a href="postOverview?no=${list.no}">${list.title }</a></c:if>
				<c:if test="${list.type == '거래완료' }">${list.title }</c:if>
			</td>
			<td>${list.amount }</td>
			<td>${list.price }</td>
			<td>${list.regdate }</td>
		</tr>
		
	</tbody>
	</c:forEach>	
	</table>
	<div>
                    <c:if test="${pagedto.curRange ne 1 }">
                        <a href="#" onClick="fn_paging(1)">[처음]</a> 
                    </c:if>
                    <c:if test="${pagedto.curPage ne 1}">
                        <a href="#" onClick="fn_paging('${pagedto.prevPage }')">[이전]</a> 
                    </c:if>
                    <c:forEach var="pageNum" begin="${pagedto.startPage }" end="${pagedto.endPage }">
                        <c:choose>
                            <c:when test="${pageNum eq  pagedto.curPage}">
                                <span style="font-weight: bold;"><a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a></span> 
                            </c:when>
                            <c:otherwise>
                                <a href="#" onClick="fn_paging('${pageNum }')">${pageNum }</a> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${pagedto.curPage ne pagedto.pageCnt && pagedto.pageCnt > 0}">
                        <a href="#" onClick="fn_paging('${pagedto.nextPage }')">[다음]</a> 
                    </c:if>
                    <c:if test="${pagedto.curRange ne pagedto.rangeCnt && pagedto.rangeCnt > 0}">
                        <a href="#" onClick="fn_paging('${pagedto.pageCnt }')">[끝]</a> 
                    </c:if>
                </div>
                
                <div>
                    총 게시글 수 : ${pagedto.listCnt } /    총 페이지 수 : ${pagedto.pageCnt } / 현재 페이지 : ${pagedto.curPage } / 현재 블럭 : ${pagedto.curRange } / 총 블럭 수 : ${pagedto.rangeCnt }
                </div>
</body>
</html>