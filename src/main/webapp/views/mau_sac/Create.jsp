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
<form action="/mau-sac/create" method="post">
    <div class="form-group">
        <label>ID</label>
        <input name="id" type="text" placeholder="Nhập id">
    </div>
    <div class="form-group">
        <label>Mã màu</label>
        <input name="ma" type="text" placeholder="Nhập mã màu">
    </div>
    </div>
    <div class="form-group">
        <label>Tên</label>
        <input name="ten" type="text" placeholder="Nhập tên">
    </div><div class="form-group">
        <label>Trạng thái</label>
        <input name="trangThai" type="text" placeholder="Nhập tên">
    </div>
    <button>Thêm</button>
</form>
</body>
</html>
