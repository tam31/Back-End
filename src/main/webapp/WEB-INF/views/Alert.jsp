<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림</title>
</head>
<body>

	<script type="text/javascript">
		alert('${msg}');
		location.href = "${root}/"; // 메인으로 보내버리기. root는 Header.jsp
	</script>
</body>
</html>