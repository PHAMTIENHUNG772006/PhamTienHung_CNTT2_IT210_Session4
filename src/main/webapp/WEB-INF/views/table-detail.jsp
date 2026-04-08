<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết bàn</title>
</head>
<body>
<h2>Chi tiết định danh bàn ăn</h2>
<hr>
<p><strong>Mã số bàn (ID):</strong> ${id}</p>
<p><strong>Thông tin hệ thống:</strong> ${info}</p>

<br>
<a href="../list"> < Quay lại danh sách</a>

<hr>
<h4>Vận hành:</h4>
<form action="../update-status" method="post">
    <input type="hidden" name="id" value="${id}">
    <select name="status">
        <option value="Trống">Trống</option>
        <option value="Đang dùng">Đang dùng</option>
    </select>
    <button type="submit">Cập nhật trạng thái</button>
</form>
</body>
</html>