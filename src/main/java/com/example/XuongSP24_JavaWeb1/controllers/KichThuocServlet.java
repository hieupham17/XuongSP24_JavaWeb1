package com.example.XuongSP24_JavaWeb1.controllers;

import com.example.XuongSP24_JavaWeb1.entities.KichThuoc;
import com.example.XuongSP24_JavaWeb1.repositories.jdbc.KichThuocRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

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
    private com.example.XuongSP24_JavaWeb1.repositories.jpa.KichThuocRepository ktRepoJPA;

    public KichThuocServlet() {
        this.ktRepo = new KichThuocRepository();
        this.ktRepoJPA = new com.example.XuongSP24_JavaWeb1.repositories.jpa.KichThuocRepository();

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
//        List<KichThuoc> listKT = this.ktRepo.findAll();
//        request.setAttribute("data", listKT);
//        request.getRequestDispatcher("/views/kich_thuoc/index.jsp").forward(request, response);
        //Phan trang
//        String pageString = request.getParameter("page");
//        String limitString = request.getParameter("limit");
//        int page = pageString == null || pageString.trim().length() == 0 ? 1 : Integer.parseInt(pageString);
//        int limit = limitString == null || limitString.trim().length() == 0 ? 5 : Integer.parseInt(limitString);
//        List<KichThuoc> ds = this.ktRepo.paging(Optional.of(page), Optional.of(limit));
//        int totalPage = this.ktRepo.count() / limit + 1;
//        request.setAttribute("data", ds);
//        request.setAttribute("totalPage", totalPage);
//        request.getRequestDispatcher("/views/kich_thuoc/index.jsp").forward(request, response);
        //END phân trang

        //Hiển thị data với JPA
        List<KichThuoc> kt = ktRepoJPA.getAll();
        request.setAttribute("data", kt);
        request.getRequestDispatcher("/views/kich_thuoc/index.jsp").forward(request, response);
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        KichThuoc kt = this.ktRepoJPA.getOne(id);
        if (kt != null) {
            this.ktRepoJPA.delete(kt);
        }
        response.sendRedirect("/kich-thuoc/index");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //jdbc
//        int id = Integer.parseInt(request.getParameter("id"));
//        KichThuoc kt = this.ktRepo.findById(id);
//        if (kt != null) {
//            request.setAttribute("data", kt);
//            request.getRequestDispatcher("/views/kich_thuoc/edit.jsp").forward(request, response);
//
//        } else {
//            response.sendRedirect("/kich-thuoc/index");
//        }
        //jpa
        int id = Integer.parseInt(request.getParameter("id"));
        KichThuoc kt = ktRepoJPA.getOne(id);
        request.setAttribute("data", kt);
        request.getRequestDispatcher("/views/kich_thuoc/edit.jsp").forward(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/kich_thuoc/Create.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
// update với jdbc
        //int id = Integer.parseInt(request.getParameter("id"));
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
//        KichThuoc kt = new KichThuoc(id, ma, ten, trangThai);
//        this.ktRepo.update(kt);
//        response.sendRedirect("/kich-thuoc/index");
        //update
        int id = Integer.parseInt(request.getParameter("id"));
        KichThuoc kt = ktRepoJPA.getOne(id);
        BeanUtils.populate(kt, request.getParameterMap());
        ktRepoJPA.update(kt);
        response.sendRedirect("/kich-thuoc/index");
        //end
    }

    private void store(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        // lấy data từ trên form
        // Add với JDBC
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//        int trangthai = Integer.parseInt(request.getParameter("trangThai"));
//        KichThuoc kt = new KichThuoc(null, ma, ten, trangthai);
//        this.ktRepo.insert(kt);
//        response.sendRedirect("/kich-thuoc/index");
        //END
        // Add với BeanUtils JPA
        KichThuoc kt = new KichThuoc();
        BeanUtils.populate(kt, request.getParameterMap());
        ktRepoJPA.addKichThuoc(kt);
        response.sendRedirect("/kich-thuoc/index");
    }
}
