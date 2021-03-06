<%@page import="com.test.WeatherDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.test.WeatherDAO"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<%
	// 사용자가 선택한 지역 데이터 수신
	String stnId = request.getParameter("stnId");

	if (stnId == null)
		stnId = "108";	//-- 전국 날씨 정보
	
	StringBuffer sb = new StringBuffer();
	WeatherDAO dao = new WeatherDAO(stnId);
	
	// 타이틀
	String title = dao.weatherTitle();
	
	// 육상 중기 예보
	String weatherInfo = dao.weatherInfo();
	
	// 도시 정보 및 날짜 시간 별 날씨 정보
	ArrayList<String> cityList = dao.weatherCityList();
	for (int i=0; i<cityList.size(); i++)
	{
		sb.append(String.format("<h3>%s</h3>", cityList.get(i)));
		
		
		ArrayList<WeatherDTO> weatherList = dao.weatherList(String.valueOf(i+1));
				
		//sb.append("test");
		
		// 테이블 동적 생성		
		sb.append("<table class='table'>");
		sb.append("<tr>");
		sb.append("<th>날짜</th>");
		sb.append("<th>날씨</th>");
		sb.append("<th>최저/최고 기온</th>");
		sb.append("<th>강수확률</th>");
		sb.append("</tr>");
		
		for (WeatherDTO w : weatherList)
		{
			sb.append("<tr>");
			sb.append(String.format("<td>%s</td>", w.getTmEf()));						// 날짜
			sb.append(String.format("<td><img src='images/%s'/> %s</td>", w.getImg(), w.getWf()));							// 날씨
			sb.append(String.format("<td>%s℃ ~ %s℃</td>", w.getTmn(), w.getTmx()));	// 최저/최고 기온
			sb.append(String.format("<td>%s</td>", w.getRnSt()));						// 강수확률
			sb.append("</tr>");
		}
		
		
		sb.append("</table>");
		
	}
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기상청 육상 중기 예보(WeatherInfo.jsp)</title>
<!-- 부트스트랩 3.3.2 CDN -->
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript">

	$(document).ready(function()
	{
		//$(":radio[value='108']").attr("checked", "checked");	-- 전국으로 선택 돌아가게
		$(":radio[value='<%=stnId %>']").attr("checked", "checked");
	});

</script>
</head>
<body>
<!-- 
stnId=108   전국
stnId=109   서울, 경기
stnId=105   강원
stnId=131   충북
stnId=133   충남
stnId=146   전북
stnId=156   전남
stnId=143   경북
stnId=159   경남
stnId=184   제주특별자치도
-->

<div class="container">

	<h2>
		기상 정보 <small>중기 예보</small>
	</h2>
	
	<div class="panel-group" role="group">
		
		<div class="panel panel-default" role="group">
		
			<div class="panel-heading">지역 선택</div>
			<div class="panel-body">
			
				<!-- action 속성 생략 → 요청 및 수신처는 자기 자신 ~!!! -->
				<form method="get" role="form">
					<input type="radio" name="stnId" value="108" checked="checked" /> 전국
					<input type="radio" name="stnId" value="109" /> 서울, 경기
					<input type="radio" name="stnId" value="105" /> 강원
					<input type="radio" name="stnId" value="131" /> 충북
					<input type="radio" name="stnId" value="133" /> 충남
					<input type="radio" name="stnId" value="146" /> 전북
					<input type="radio" name="stnId" value="156" /> 전남
					<input type="radio" name="stnId" value="143" /> 경북
					<input type="radio" name="stnId" value="159" /> 경남
					<input type="radio" name="stnId" value="184" /> 제주특별자치도
					
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div><!-- close .panel-body -->

		</div><!-- close .panel .panel-default -->
		
		<div class="panel panel-default" role="group">
		
			<div class="panel-heading">기상 정보 출력</div>
			<div class="panel-body">
				<p>
					<b><%=title %></b>
				</p>
				<p><%=weatherInfo %></p>
				
				
				<!--
					<h3>서울</h3> 
					<table class="table">
					<thead>
					<tr>
						<th>날짜</th>
						<th>날씨</th>
						<th>최저/최고 기온</th>
						<th>강수확률</th>
					</tr>
					</thead>
					<tbody>
						<tr>
							<td>2022-06-20 00:00</td>
							<td>구름많음</td>
							<td>22</td>
							<td>30</td>
						</tr>
						<tr>
							<td>2022-06-20 12:00</td>
							<td>구름많음</td>
							<td>22</td>
							<td>20</td>
						</tr>
						<tr>
							<td>2022-06-21 00:00</td>
							<td>구름많음</td>
							<td>22</td>
							<td>30</td>
						</tr>
						<tr>
							<td>2022-06-21 12:00</td>
							<td>구름많음</td>
							<td>22</td>
							<td>20</td>
						</tr>
					</tbody>
				</table> -->
				<%=sb.toString() %>
			</div>
		
		</div>
		
	</div>
	

</div>



</body>
</html>