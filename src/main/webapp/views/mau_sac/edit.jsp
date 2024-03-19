
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form action="/mau-sac/update?id=${data.id}" method="POST">

    <div class="form-group">
        <label>Mã màu</label>
        <input name="ma" type="text" value="${data.ma}">
    </div>

    <div>
        <label>Tên</label>
        <input type="text" name="ten" value="${data.ten}" />
    </div>

    <div>
        <label>Trạng thái</label>
        <input type="radio" name="trangThai" value="1"
        ${ data.trangThai == 1 ? "checked" : "" }/>
        <label>Đang hoạt động</label>
        <input type="radio" name="trangThai" value="0"
        ${ data.trangThai == 0 ? "checked" : "" }/>
        <label>Ngừng hoạt động</label>
    </div>
    <button>Thêm</button>
</form>
</body>
</html>
