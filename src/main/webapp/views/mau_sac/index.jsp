<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 012/12/03/2024
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<div class="container-sm">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="#">Bán hàng</a>
                    <a class="nav-link" href="#">Quản lý sản phẩm</a>
                    <a class="nav-link" href="#">Quản lý hoá đơn</a>
                    <a class="nav-link" href="#">Quản lý nhân viên</a>
                    <a class="nav-link" href="#">Quản lý khách hàng</a>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Quản lý thuộc tính
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="mau-sac/index">Màu sắc</a></li>
                            <li><a class="dropdown-item" href="#">Kích thước</a></li>
                        </ul>
                    </li>

                </div>
            </div>
        </div>
    </nav>
    <a href="/mau-sac/create" class=" btn btn-success my-2">Thêm mới</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ms" items="${ data }" >
            <tr>
                <td>${ms.id}</td>
                <td>${ms.ma}</td>
                <td>${ms.ten}</td>
                <td>${ms.trangThai}</td>
                <td>
                    <a href="/mau-sac/edit?id=${ms.id}" class="btn btn-warning">Update</a>
                    <a href="/mau-sac/delete?id=${ms.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
