package com.example.XuongSP24_JavaWeb1.controllers;

import com.example.XuongSP24_JavaWeb1.entities.KichThuoc;
import com.example.XuongSP24_JavaWeb1.entities.MauSac;
import com.example.XuongSP24_JavaWeb1.repositories.KichThuocRepository;
import com.example.XuongSP24_JavaWeb1.repositories.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "KichThuocServlet", value = {
        "/kich-thuoc/index",
        "/kich-thuoc/create",
        "/kich-thuoc/store",
        "/kich-thuoc/edit",
        "/kich-thuoc/update",
        "/kich-thuoc/delete",
})
public class KichThuocServlet extends HttpServlet {
    private KichThuocRepository ktRepo;
    public KichThuocServlet() {
        this.ktRepo = new KichThuocRepository();

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
        // gọi findAll
        List<KichThuoc> listKT = this.ktRepo.findAll();
        request.setAttribute("data", listKT);
        request.getRequestDispatcher("/views/kich_thuoc/index.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        KichThuoc kt = this.ktRepo.findById(id);
        if ( kt!=null){
            this.ktRepo.delete(kt);
        }
        response.sendRedirect("/kich-thuoc/index");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KichThuoc kt = this.ktRepo.findById(id);
        if (kt != null){
            request.setAttribute("data", kt);
            request.getRequestDispatcher("/views/kich_thuoc/edit.jsp").forward(request, response);

        }else {
        response.sendRedirect("/kich-thuoc/index");
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/kich_thuoc/Create.jsp").forward(request, response);
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
        KichThuoc kt = new KichThuoc(id, ma, ten, trangThai);
        this.ktRepo.update(kt);
        response.sendRedirect("/kich-thuoc/index");
    }

    private void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // lấy data từ trên form
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        int trangthai = Integer.parseInt(request.getParameter("trangThai")) ;
        KichThuoc kt =  new KichThuoc( ma, ten, trangthai);
        this.ktRepo.insert(kt);
        response.sendRedirect("/kich-thuoc/index");
   }
}
