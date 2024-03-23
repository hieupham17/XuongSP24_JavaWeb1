package com.example.XuongSP24_JavaWeb1.controllers;

import com.example.XuongSP24_JavaWeb1.entities.MauSac;
import com.example.XuongSP24_JavaWeb1.repositories.MauSacRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

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

    public MauSacServlet() {
        this.msRepo = new MauSacRepository();

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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //List<MauSac> listMS = this.msRepo.getList();
        List<MauSac> listMS = msRepo.findAll();
        request.setAttribute("data", listMS);
        request.getRequestDispatcher("/views/mau_sac/index.jsp").forward(request, response);
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/mau_sac/Create.jsp").forward(request, response);

    }


    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idS = request.getParameter("id");
        int id = Integer.parseInt(idS);
        MauSac ms = this.msRepo.findById(id);
        if (ms != null)
        {
            request.setAttribute("data", ms);
            request.getRequestDispatcher("/views/mau_sac/edit.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect("/mau-sac/index");
        }
    }


    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);

        MauSac ms = this.msRepo.findById(id);
        if (ms != null) {
            this.msRepo.delete(ms);
        }
        response.sendRedirect("/mau-sac/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        // MauSac ms = new MauSac(ma, ten, trangThai);
        MauSac ms1 = new MauSac( ma, ten, trangThai);
        this.msRepo.insert(ms1);
        response.sendRedirect("/mau-sac/index");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        int trangThai = Integer.parseInt(request.getParameter("trangThai"));
        MauSac ms = new MauSac(id, ma, ten, trangThai);
        this.msRepo.update(ms);
        response.sendRedirect("/mau-sac/index");
    }
}
