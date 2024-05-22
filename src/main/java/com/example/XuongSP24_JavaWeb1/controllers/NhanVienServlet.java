package com.example.XuongSP24_JavaWeb1.controllers;

import com.example.XuongSP24_JavaWeb1.entities.NhanVien;
import com.example.XuongSP24_JavaWeb1.repositories.jdbc.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/index",
        "/nhan-vien/create",
        "/nhan-vien/store",
        "/nhan-vien/edit",
        "/nhan-vien/update",
        "/nhan-vien/delete",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nvRepo;

    //hàm khởi tạo
    public NhanVienServlet() {
        this.nvRepo = new NhanVienRepository();
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
        List<NhanVien> list = nvRepo.findAdd();
        request.setAttribute("data", list);
        request.getRequestDispatcher("/views/nhan_vien/index.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien nv = this.nvRepo.findById(id);
        if (nv != null) {
            this.nvRepo.delete(nv);
        }
        response.sendRedirect("/nhan-vien/index");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NhanVien nv = this.nvRepo.findById(id);
        if (nv != null) {
            request.setAttribute("data", nv);
            request.getRequestDispatcher("/views/nhan_vien/edit.jsp").forward(request, response);
        } else response.sendRedirect("/nhan-vien/index");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/nhan_vien/Create.jsp").forward(request, response);
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
        String ten = request.getParameter("ten");
        String ma = request.getParameter("ma");
        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        NhanVien nv = new NhanVien(id, ten, ma, tenDangNhap, matKhau, trangThai);
        this.nvRepo.update(nv);
        response.sendRedirect("/nhan-vien/index");
    }

    private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id")) ;
        String ten = request.getParameter("ten");
        String ma = request.getParameter("ma");
        String tenDangNhap = request.getParameter("tenDangNhap");
        String matKhau = request.getParameter("matKhau");
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        NhanVien nv = new NhanVien(id, ten, ma, tenDangNhap, matKhau, trangThai);
        this.nvRepo.insert(nv);
        response.sendRedirect("/nhan-vien/index");

    }
}
