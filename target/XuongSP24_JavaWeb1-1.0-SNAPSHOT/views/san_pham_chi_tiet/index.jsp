<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 026/26/03/2024
  Time: 12:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <c:if test="${ errros.get('idSanPham') != null }">
        <div class="alert alert-danger">
                ${errros.get('idSanPham')}
        </div>
    </c:if>

    <div class="mt-5 col-10 offset-1">
        <form method="get" action="/sp-chi-tiet/index">
            <input type="hidden" name="san_pham_id" value="${sp.id}" />
            <div class="row">
                <div class="col-6">
                    <label>Từ khóa</label>
                    <input type="text" name="keyword" class="form-control" />
                    <c:if test="${ errros.get('keyword') != null }">
                        <span class="alert alert-danger">
                                ${errros.get('keyword')}
                        </span>
                    </c:if>
                </div>
                <div class="col-6">
                    <label >Trạng thái</label>
                    <div>
                        <input type="radio" name="trangThai" class="form-check-input" id="rdoStatusActive" value="1" />
                        <label for="rdoStatusActive">Đang hoạt động</label>
                        <input type="radio" name="trangThai" class="form-check-input" id="rdoStatusInactive" value="0" />
                        <label for="rdoStatusInactive">Ngừng hoạt động</label>
                        <c:if test="${ errros.get('trangThai') != null }">
                        <span class="alert alert-danger">
                                ${errros.get('trangThai')}
                        </span>
                        </c:if>
                    </div>
                </div>
            </div>
            <div class="row d-flex align-items-center justify-content-center col-6 offset-3 mt-2">
                <div class="col-6 flex-row-reverse">
                    <button class="btn btn-primary">Tìm kiếm</button>
                </div>
                <div class="col-6">
                    <a class="btn btn-light" href="/sp-chi-tiet/index?san_pham_id=${sp.id}">Làm mới</a>
                </div>
            </div>
        </form>
    </div>
    <a href="/sp-chi-tiet/create" class=" btn btn-success my-2">Thêm mới</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã</th>
            <th>Sản phẩm</th>
            <th>Màu sắc</th>
            <th>Kich thước</th>
            <th>Số lượng</th>
            <th>Đơn giá</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="spct" items="${ data }">
            <tr>
                <td>${spct.id}</td>
                <td>${spct.maSanPhamChiTiet}</td>
                <td>${sp.ten}</td>
                <td>${spct.tenMauSac}</td>
                <td>${spct.tenKichThuoc}</td>
                <td>${spct.soLuong}</td>
                <td>${spct.donGia}</td>
                <td>${spct.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/sp-chi-tiet/edit?id=${spct.id}" class="btn btn-warning">Update</a>
<%--                    <a href="/san-pham/delete?id=${spct.id}" class="btn btn-danger">Delete</a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
