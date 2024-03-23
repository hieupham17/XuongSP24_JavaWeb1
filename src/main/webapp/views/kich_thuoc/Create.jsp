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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>

    <title>Title</title>
</head>
<body>
<div class="container-sm">

    <form action="/kich-thuoc/store" method="POST">
        <div class="form-group">
            <label class="form-label">Mã kích thước</label>
            <input class="form-control" name="ma" type="text">
        </div>

        <div class="form-group">
            <label class="form-label">Tên kích thước</label>
            <input class="form-control" name="ten" type="text">
        </div>

        <div class="form-group my-2">
            <label class="form-check-label">Trạng thái</label>
            <input class="form-check-input" type="radio" name="trangThai" value="1"/>Đang hoạt động
            <input class="form-check-input" type="radio" name="trangThai" value="0"/>Ngừng hoạt động
        </div>
        <div class="my-2">
            <button class="btn btn-success">Thêm</button>
        </div>
    </form>
</div>
</body>
</html>
