<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Manager</title>
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-link active" aria-current="page" href="#">Bán hàng</a>
                        <a class="nav-link" href="/san-pham/index">Quản lý sản phẩm</a>
                        <a class="nav-link" href="#">Quản lý hoá đơn</a>
                        <a class="nav-link" href="/nhan-vien/index">Quản lý nhân viên</a>
                        <a class="nav-link" href="/khach-hang/index">Quản lý khách hàng</a>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Quản lý thuộc tính
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="mau-sac/index">Màu sắc</a></li>
                                <li><a class="dropdown-item" href="kich-thuoc/index">Kích thước</a></li>
                            </ul>
                        </li>

                    </div>
                </div>
            </div>
        </nav>
    </div>
</body>
</html>