<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Quản lý bàn ăn</title>
    <style>
        .error { color: red; font-weight: bold; }
        table { border-collapse: collapse; width: 80%; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #f4f4f4; }
        .btn-delete { color: white; background-color: #ff4d4d; border: none; padding: 5px 10px; cursor: pointer; border-radius: 3px; }
    </style>
</head>
<body>
<h2>Danh sách bàn ăn</h2>

<form action="list" method="get">
    Lọc sức chứa tối thiểu:
    <input name="cap" type="number" value="${param.cap}">
    <button type="submit">Tìm kiếm</button>
</form>

<c:if test="${not empty error}">
    <p class="error">${error}</p>
</c:if>

<p style="color: blue;">${message}</p>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên bàn</th>
        <th>Sức chứa</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tables}" var="t">
        <tr>
            <td>${t.id}</td>
            <td>${t.name}</td>
            <td>${t.capacity}</td>
            <td>
                <span style="color: ${t.status == 'Trống' ? 'green' : 'orange'}">
                        ${t.status}
                </span>
            </td>
            <td>
                <a href="view/${t.id}">Chi tiết</a> |
                <form action="delete/${t.id}" method="post" style="display:inline">
                    <button type="submit" class="btn-delete"
                            onclick="return confirm('Bạn chắc chắn muốn xóa ${t.name}?')">
                        Xóa
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>

    <c:if test="${empty tables}">
        <tr>
            <td colspan="5" style="text-align: center;">Không tìm thấy bàn nào phù hợp.</td>
        </tr>
    </c:if>
    </tbody>
</table>

</body>
</html>