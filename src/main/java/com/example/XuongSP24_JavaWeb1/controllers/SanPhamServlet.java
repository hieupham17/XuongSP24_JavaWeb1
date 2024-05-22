package com.example.XuongSP24_JavaWeb1.controllers;

import com.example.XuongSP24_JavaWeb1.entities.SanPham;
import com.example.XuongSP24_JavaWeb1.repositories.jdbc.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/index",
        "/san-pham/create",
        "/san-pham/store",
        "/san-pham/edit",
        "/san-pham/update",
        "/san-pham/delete",
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository spRepo;
    public SanPhamServlet() {
        this.spRepo = new SanPhamRepository();
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
        List<SanPham> listSP = this.spRepo.findAll();
        request.setAttribute("data", listSP);
        request.getRequestDispatcher("/views/san_pham/index.jsp").forward(request,response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        SanPham kt = this.spRepo.findById(id);
        if ( kt!=null){
            this.spRepo.delete(kt);
        }
        response.sendRedirect("/san-pham/index");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SanPham sp = this.spRepo.findById(id);
        if (sp != null){
            request.setAttribute("data", sp);
            request.getRequestDispatcher("/views/san_pham/edit.jsp").forward(request, response);

        }else {
            response.sendRedirect("/san-pham/index");
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/san_pham/Create.jsp").forward(request, response);

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
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        SanPham sp = new SanPham(id, ma, ten, trangThai);
        this.spRepo.update(sp);
        response.sendRedirect("/san-pham/index");
    }

    private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        int trangthai = Integer.parseInt(request.getParameter("trangThai")) ;
        SanPham sp =  new SanPham (null , ma, ten, trangthai);
        this.spRepo.insert(sp);
        response.sendRedirect("/san-pham/index");
    }
}
