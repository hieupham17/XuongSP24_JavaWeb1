
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Update</title>
</head>
<body>
<div class="container-sm">

    <form method="POST" action="/kich-thuoc/update?id=${data.id}">
        <div class="form-group">
            <label class="form-label">Mã</label>
            <input class="form-control" type="text" name="ma" value="${data.ma}" />
        </div>
        <div class="form-group">
            <label class="form-label">Tên</label>
            <input class="form-control" type="text" name="ten" value="${data.ten}" />
        </div>
        <div class="form-group">
            <label class="form-label">Trạng thái</label>
            <input class="form-check-input" type="radio" name="trangThai" value="1"
            ${ data.trangThai == 1 ? "checked" : "" }/> Đang hoạt động

            <input class="form-check-input" type="radio" name="trangThai" value="0"
            ${ data.trangThai == 0 ? "checked" : "" }/> Ngừng hoạt động

        </div>
        <div class="form-group">
            <button class="btn btn-warning">Cập nhật</button>
        </div>
    </form>
</div>
</body>
</html>
