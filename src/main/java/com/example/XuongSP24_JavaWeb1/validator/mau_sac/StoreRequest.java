package com.example.XuongSP24_JavaWeb1.validator.mau_sac;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/mau-sac/store"
})
public class StoreRequest implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        //ép kiểu về Http
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        //lấy tham số trên form
        String ma = request.getParameter("ma");
        String ten = request.getParameter("ten");
        String tts = request.getParameter("trangThai");
        //String error = "";
        if (ma == null || ten == null || tts == null ||
        ma.trim().length() == 0 ||
                ten.trim().length() == 0 ||
                tts.trim().length() == 0
        ) {
            session.setAttribute("error" , "Không được để trống dữ liệu");
            response.sendRedirect("/mau-sac/create");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
