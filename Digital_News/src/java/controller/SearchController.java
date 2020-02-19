/*
* Search.java
*
* All Right Reserved
* Copyright (c) 2019 FPT University
 */
package controller;

import dao.NewsDao;
import entity.News;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Search.<br>
 *
 * <pre>
 * Class thực hiện việc tìm kiếm bài báo theo tiêu đề
 * Trong class này sẽ tiến hành các xử lí dưới đây.
 *
 * . ProcessRequest.
 * . DoGet.
 * . DoPost.
 *
 *
 * </pre>
 *
 * @author FU QuanLHHE130736
 * @version 1.0
 */
@WebServlet(name = "SearchController", urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. Lấy tiêu đề đã nhầm vào ô tìm kiếm , tiến hành tìm kiếm và phân
     * trang
     *
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            NewsDao dao = new NewsDao();
            String text = request.getParameter("inputSearch");

            String page_raw = request.getParameter("page");
            int pageCount = dao.countNewsWhenSearch(text);
            System.out.println("page count = " + pageCount);
            pageCount = (pageCount % 3 == 0) ? pageCount / 3 : pageCount / 3 + 1;
            ArrayList<Integer> listCount = new ArrayList<>();
            for (int i = 1; i <= pageCount; i++) {
                listCount.add(i);
            }
            if (page_raw == null) {
                page_raw = "1";
            }
            int pageindex = Integer.parseInt(page_raw);

            ArrayList<News> listNews = dao.searchNewsByTitle(text, pageindex, 3);
            ArrayList<News> listTop5 = dao.getTop5NewsRecent();
            request.setAttribute("page", pageindex);
            request.setAttribute("text", text);
            request.setAttribute("listNews", listNews);
            request.setAttribute("listCount", listCount);
            request.setAttribute("listTop5", listTop5);

            request.getRequestDispatcher("client/search.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. Gọi method processRequest
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method. Gọi method processRequest
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
