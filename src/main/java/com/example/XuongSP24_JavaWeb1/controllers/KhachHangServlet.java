package com.example.XuongSP24_JavaWeb1.controllers;

import com.example.XuongSP24_JavaWeb1.entities.KhachHang;
import com.example.XuongSP24_JavaWeb1.entities.NhanVien;
import com.example.XuongSP24_JavaWeb1.repositories.KhachHangRepository;
import com.example.XuongSP24_JavaWeb1.repositories.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/index",
        "/khach-hang/create",
        "/khach-hang/store",
        "/khach-hang/edit",
        "/khach-hang/update",
        "/khach-hang/delete",
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khRepo;

    //hàm khởi tạo
    public KhachHangServlet() {
        this.khRepo = new KhachHangRepository();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> list = this.khRepo.findAdd();
        request.setAttribute("data", list);
        request.getRequestDispatcher("/views/khach_hang/index.jsp").forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang kh = this.khRepo.findById(id);
        if (kh != null){
            this.khRepo.delete(kh);
        }
        response.sendRedirect("/khach-hang/index");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        KhachHang kh = this.khRepo.findById(id);
        if (kh != null) {
            request.setAttribute("data", kh);
            request.getRequestDispatcher("/views/khach_hang/edit.jsp").forward(request, response);
        } else response.sendRedirect("/khach-hang/index");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khach_hang/Create.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        KhachHang kh = new KhachHang(id, ma, ten, sdt, trangThai);
        this.khRepo.update(kh);
        response.sendRedirect("/khach-hang/index");
    }

    private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        KhachHang kh = new KhachHang(id, ma, ten, sdt, trangThai);
        this.khRepo.insert(kh);
        response.sendRedirect("/khach-hang/index");
    }
}
