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
    <a href="/kich-thuoc/create" class=" btn btn-success my-2">Thêm mới</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Mã kích thước</th>
            <th>Tên kích thước</th>
            <th>Trạng thái</th>
            <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="spct" items="${ data }" >
            <tr>
                <td>${spct.id}</td>
                <td>${spct.ma}</td>
                <td>${spct.ten}</td>
                <td>${spct.trangThai == 1 ? "Đang hoạt động" : "Ngừng hoạt động"}</td>
                <td>
                    <a href="/kich-thuoc/edit?id=${spct.id}" class="btn btn-warning">Update</a>
                    <a href="/kich-thuoc/delete?id=${spct.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav class="d-flex flex-row-reverse">
        <ul class="pagination pagination-md">
            <c:forEach begin="1" end="${ totalPage }" var="page">
                <c:if test="${ page < 4 || page > totalPage - 3 }">
                    <li class="page-item"><a class="page-link" href="/kich-thuoc/index?page=${page}">${page}</a></li>
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
