package com.example.XuongSP24_JavaWeb1.controllers;

import com.example.XuongSP24_JavaWeb1.entities.SanPham;
import com.example.XuongSP24_JavaWeb1.entities.custom_entity.SanPhamChiTietCustom;
import com.example.XuongSP24_JavaWeb1.repositories.jdbc.SanPhamChiTietRepository;
import com.example.XuongSP24_JavaWeb1.repositories.jdbc.SanPhamRepository;
import com.example.XuongSP24_JavaWeb1.request.spct.IndexRequest;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamChiTietServlet", value = {
        "/sp-chi-tiet/index",
        "/sp-chi-tiet/create",
        "/sp-chi-tiet/store",
        "/sp-chi-tiet/edit",
        "/sp-chi-tiet/update",
        "/sp-chi-tiet/delete",
})
public class SanPhamChiTietServlet extends HttpServlet {
    private SanPhamChiTietRepository spctRepo;
    private SanPhamRepository spRepo;
    private com.example.XuongSP24_JavaWeb1.repositories.jpa.SanPhamChiTietRepository spctRepoJPA;


    public SanPhamChiTietServlet() {
        this.spctRepo = new SanPhamChiTietRepository();
        this.spRepo = new SanPhamRepository();
        this.spctRepoJPA = new com.example.XuongSP24_JavaWeb1.repositories.jpa.SanPhamChiTietRepository();

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

    private void delete(HttpServletRequest request, HttpServletResponse response) {
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) {
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IndexRequest req = IndexRequest.make(request.getParameterMap());
        if (req.getIdSanPham()==null){
            response.sendRedirect("/san-pham/index");
        }else {
            SanPham sp = this.spRepo.findById(req.getIdSanPham());
            List<SanPhamChiTietCustom> ds = this.spctRepoJPA.findAllWithPropName(req);
            request.setAttribute("data", ds);
            request.setAttribute("sp" , sp);
            request.setAttribute("errors", req.getErrors());
            request.getRequestDispatcher("/views/san_pham_chi_tiet/index.jsp")
                    .forward(request, response);
        }
//        if (request.getParameter("san_pham_id") == null) {
//            response.sendRedirect("/san-pham/index");
//        } else {
//            int spId = Integer.parseInt(request.getParameter("san_pham_id"));
//            List<SanPhamChiTietCustom> ds = this.sanPhamChiTietRepositoryJPA.findAllWithPopName(spId);
//            SanPham sp = this.spRepo.findById(spId);
//            request.setAttribute("data", ds);
//            request.setAttribute("sp" , sp);
//            request.getRequestDispatcher("/views/san_pham_chi_tiet/index.jsp")
//                    .forward(request, response);
//        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}




