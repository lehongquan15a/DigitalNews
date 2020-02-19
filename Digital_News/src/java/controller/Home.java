/*
* Home.java
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
 * Home.<br>
 * 
 * <pre>
 Class lấy dữ liệu từ database Thông qua class NewsDao và đẩy dữ liệu lên view để hiển thị lên trình duyệt
 Trong class này sẽ tiến hành các xử lí dưới đây.
 
 . ProcessRequest.
 . DoGet.
 . DoPost.
  
  
 </pre>
 * 
 * @author FU QuanLHHE130736
 * @version 1.0
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Lấy xuống id và trả về bài báo theo id
     * lấy ra top 5 bài báo gần đây
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
            String raw_id = request.getParameter("id");
            
            News currentNew;
            if(raw_id == null){
                currentNew=dao.getTop1NewsById();
            }else{
                //Gọi phương thức getNewById để lấy bài báo có id bằng id truyền vào
                currentNew =dao.getNewById(Integer.parseInt(raw_id));
            }
            
            //Gọi phương thức getTop5NewsRecent để lấy ra top 5 bài báo gần đây
            ArrayList<News> listTop5 = dao.getTop5NewsRecent();

            request.setAttribute("currentNew", currentNew);
            request.setAttribute("listTop5", listTop5);
            
            //Đẩy dữ liệu lên index.jsp
            request.getRequestDispatcher("client/index.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * Gọi method processRequest
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
     * Handles the HTTP <code>POST</code> method.
     * Gọi method processRequest
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
