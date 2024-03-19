<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 012/12/03/2024
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/mau-sac/store" method="POST">
    <div>
        <label>Mã màu</label>
        <input name="ma" type="text">
    </div>

    <div>
        <label>Tên</label>
        <input name="ten" type="text">
    </div>

    <div>
        <label>Trạng thái</label>
        <input type="radio" name="trangThai" value="1"/>
        <label>Đang hoạt động</label>
        <input type="radio" name="trangThai" value="0"/>
        <label>Ngừng hoạt động</label>
    </div>
    <button>Thêm</button>
</form>
</body>
</html>
