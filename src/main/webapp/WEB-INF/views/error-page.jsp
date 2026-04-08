<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lỗi hệ thống</title>
    <style>
        .box { border: 2px solid red; padding: 20px; background: #fff0f0; border-radius: 8px; }
    </style>
</head>
<body>
<div class="box">
    <h2 style="color: red;">Cảnh báo dữ liệu không hợp lệ</h2>
    <p>${error}</p>
    <p>Hệ thống đã chặn yêu cầu để tránh gây treo ứng dụng.</p>
    <a href="${pageContext.request.contextPath}/admin/tables/list">Quay về trang chính</a>
</div>
</body>
</html>