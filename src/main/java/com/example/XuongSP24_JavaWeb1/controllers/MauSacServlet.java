package com.example.XuongSP24_JavaWeb1.controllers;

import com.example.XuongSP24_JavaWeb1.entities.MauSac;
import com.example.XuongSP24_JavaWeb1.repositories.jdbc.MauSacRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

/*
    @author: admin Date: 012/12/03/2024 Time: 13:33
*/
@WebServlet({ // ánh xạ đường dẫn
        "/mau-sac/index",
        "/mau-sac/create",
        "/mau-sac/store",
        "/mau-sac/edit",
        "/mau-sac/update",
        "/mau-sac/delete",
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository msRepo;
    private com.example.XuongSP24_JavaWeb1.repositories.jpa.MauSacRepository msRepoJPA;

    //Hàm khởi tạo
    public MauSacServlet() {
        this.msRepo = new MauSacRepository();
        this.msRepoJPA = new com.example.XuongSP24_JavaWeb1.repositories.jpa.MauSacRepository();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Tìm kiếm, filter
        //List<MauSac> listMS = this.msRepo.getList();
//        String ma = request.getParameter("ma") != null ? request.getParameter("ma").trim() : "";
//        String ten = request.getParameter("ten") != null ? request.getParameter("ten").trim() : "";
//        String tts = request.getParameter("trangThai") != null ? request.getParameter("trangThai").trim() : "";
//        Integer trangThai = tts.length() != 0 ? Integer.parseInt(tts) : null;
//        List<MauSac> listMS = msRepo.findAll(ma, ten, trangThai);
//        request.setAttribute("data", listMS);
//        if (ma.length() != 0) {
//            request.setAttribute("ma", ma);
//        }
//
//        if (ten.length() != 0) {
//            request.setAttribute("ten", ten);
//        }
//
//        if (trangThai != null) {
//            request.setAttribute("trangThai", trangThai);
//        }
        //  request.getRequestDispatcher("/views/mau_sac/index.jsp").forward(request, response);

        //Phân trang
//        String ma = request.getParameter("ma") != null ? request.getParameter("ma").trim() : "";
//        String ten = request.getParameter("ten") != null ? request.getParameter("ten").trim() : "";
//        String tts = request.getParameter("trangThai") != null ? request.getParameter("trangThai").trim() : "";
//        Integer trangThai = tts.length() != 0 ? Integer.parseInt(tts) : null;
//        List<MauSac> listMS = msRepo.findAll(ma, ten, trangThai);
//        request.setAttribute("data", listMS);
//        if (ma.length() != 0) {
//            request.setAttribute("ma", ma);
//        }
//
//        if (ten.length() != 0) {
//            request.setAttribute("ten", ten);
//        }
//
//        if (trangThai != null) {
//            request.setAttribute("trangThai", trangThai);
//        }
//
//        String pageS = request.getParameter("page");
//        String limitS = request.getParameter("limit");
//
//        int page = pageS == null || pageS.trim().length() == 0 ? 1 : Integer.parseInt(pageS);
//        int limit = limitS == null || limitS.trim().length() == 0 ? 5 : Integer.parseInt(limitS);
//        List<MauSac> ds = this.msRepo.paging(Optional.of(page), Optional.of(limit));
//        int totalPage = this.msRepo.count() / limit + 1;
//        request.setAttribute("totalPage", totalPage);
//        request.setAttribute("data", ds);
//        //END PHÂN TRANG

        //Hiển thị lên form với JPA
        List<MauSac> list = msRepoJPA.getAll();
        request.setAttribute("data", list);
        request.getRequestDispatcher("/views/mau_sac/index.jsp").forward(request, response);
        //END Hiển thị lên form với JPA
    }


    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/mau_sac/Create.jsp").forward(request, response);
    }


    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Update với JDBC
//        String idS = request.getParameter("id");
//        int id = Integer.parseInt(idS);
//        MauSac ms = this.msRepo.findById(id);
//        if (ms != null) {
//            request.setAttribute("data", ms);
//            request.getRequestDispatcher("/views/mau_sac/edit.jsp")
//                    .forward(request, response);
//        } else {
//            response.sendRedirect("/mau-sac/index");
//        }
        //END Update với JDBC

        //Update với JPA
        // lấy id và tìm ra Màu sắc có id đó
        Integer id = Integer.parseInt(request.getParameter("id"));
        MauSac mauSac = msRepoJPA.getOne(id);
        //set attribute
        request.setAttribute("data", mauSac);
        request.getRequestDispatcher("/views/mau_sac/edit.jsp")
                .forward(request, response);
        //END update với JPA
    }


    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        // Add với JDBC
//        String idString = request.getParameter("id");
//        int id = Integer.parseInt(idString);
//
//        MauSac ms = this.msRepo.findById(id);
//        if (ms != null) {
//            this.msRepo.delete(ms);
//        }
//        response.sendRedirect("/mau-sac/index");
//        //END add với JDBC

        //ADD với JPA
        Integer id = Integer.parseInt(request.getParameter("id"));
        MauSac ms = this.msRepoJPA.getOne(id);
        msRepoJPA.delete(ms);
        response.sendRedirect("/mau-sac/index");
        //END Add với JPA
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {

        //Add với JDBC
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
//        // MauSac ms = new MauSac(ma, ten, trangThai);
//        MauSac ms1 = new MauSac(null, ma, ten, trangThai);
//        this.msRepo.insert(ms1);
//        response.sendRedirect("/mau-sac/index");
//        END add với JDBC

        //Add với JPA
        //Sử dụng Beanutil
        //Khởi tạo 1 đối tượng màu sắc
        MauSac ms = new MauSac();
        //Gọi BeanUtil
        BeanUtils.populate(ms, request.getParameterMap());
        msRepoJPA.addMauSac(ms);
        response.sendRedirect("/mau-sac/index");
        // //END Add với JPA
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {

        // Update với JDBC
//        int id = Integer.parseInt(request.getParameter("id"));
//        String ma = request.getParameter("ma");
//        String ten = request.getParameter("ten");
//        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
//        MauSac ms = new MauSac(id, ma, ten, trangThai);
//        this.msRepo.update(ms);
//        response.sendRedirect("/mau-sac/index");
        //END

        //Update với JPA
        Integer id = Integer.parseInt(request.getParameter("id"));
        MauSac ms = msRepoJPA.getOne(id);
        BeanUtils.populate(ms, request.getParameterMap());
        msRepoJPA.update(ms);
        response.sendRedirect("/mau-sac/index");
        //END

    }

}
