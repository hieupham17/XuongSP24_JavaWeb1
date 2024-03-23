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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<div class="container-sm">
    <%--tìm kiếm , filter--%>
    <form action="/mau-sac/index" method="GET">
        <div class="row mt-2">
            <div class="col-6">
                <label>Mã</label>
                <input type="text" name="ma" class="form-control" value="${ma}"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <input type="text" name="ten" class="form-control" value="${ten}"/>
            </div>
        </div>
        <div class="row mt-2">
            <div class="col-6">
                <label>Trạng thái</label>
                <div class="col-12">
                    <input type="radio" name="trangThai" class="form-check-inline" value="1"
                    ${trangThai == 1 ? "checked" : ""}/>
                    <label>Đang hoạt động</label>
                    <input type="radio" name="trangThai" class="form-check-inline" value="0"
                    ${trangThai == 0 ? "checked" : ""}/>
                    <label>Ngừng hoạt động</label>
                </div>
            </div>
        </div>
        <div class="mt-2 text-center">
            <button class="btn btn-primary">Tìm kiếm</button>
            <a href="/mau-sac/index" class="btn btn-light">Làm mới</a>
        </div>
    </form>

    <%--
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
  --%>
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
        <c:forEach var="sp" items="${ data }">
            <tr>
                <td>${sp.id}</td>
                <td>${sp.ma}</td>
                <td>${sp.ten}</td>
<%--                <td>${sp.trangThai}</td>--%>
                <td>${sp.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/mau-sac/edit?id=${sp.id}" class="btn btn-warning">Update</a>
                    <a href="/mau-sac/delete?id=${sp.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

        <nav aria-label="">
            <ul class="pagination pagination-md">
                <c:forEach begin="1" end="${ totalPage }" var="page">
                    <c:if test="${ page < 4 || page > totalPage - 3 }">
                        <li class="page-item"><a class="page-link" href="/mau-sac/index?page=${page}">${page}</a></li>
                    </c:if>

                    <c:if test="${ totalPage > 6 && page == 4 }">
                        <li class="page-item"><span class="page-link" href="">...</span></li>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>

</div>

</body>
</html>
