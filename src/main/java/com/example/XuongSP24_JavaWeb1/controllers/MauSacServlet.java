package com.example.XuongSP24_JavaWeb1.controllers;

import com.example.XuongSP24_JavaWeb1.entities.MauSac;
import com.example.XuongSP24_JavaWeb1.repositories.MauSacRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URI;
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
            this.create(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            //
        }
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MauSac> listMS = this.msRepo.getList();
        request.setAttribute("data", listMS);
        request.getRequestDispatcher("/views/mau_sac/index.jsp").forward(request, response);
    }
    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get parameters from the request
        String idStr = request.getParameter("id");
        Integer id = null;
        if (idStr != null && !idStr.isEmpty()) {
            id = Integer.parseInt(idStr);
        }


        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String trangThaiString = request.getParameter("trangThai");
        Integer trangThai = Integer.parseInt(trangThaiString);

        // Create a MauSac object
        MauSac mauSac = new MauSac(id, ma, ten, trangThai);
        this.msRepo.insert(mauSac);
        // Set the MauSac object as an attribute in the request
        request.setAttribute("data", mauSac);

        // Forward the request to the JSP page
       // request.getRequestDispatcher("/views/mau_sac/create.jsp").forward(request, response);
        response.sendRedirect("/mau-sac/index");
    }


    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        MauSac mauSac = this.msRepo.getOne(id);
        if (mauSac != null) {

            request.setAttribute("data", mauSac);
            request.getRequestDispatcher("/views/mau_sac/edit.jsp").forward(request, response);
        } else {
            response.sendRedirect("/mau-sac/index");
        }
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        MauSac ms = this.msRepo.getOne(id);
        if (ms != null) {
            this.msRepo.delete(ms);
        }
        response.sendRedirect("/mau-sac/index");
    }

    public void store(HttpServletRequest request, HttpServletResponse response) {

    }

    public void update(HttpServletRequest request, HttpServletResponse response) {

    }
}
