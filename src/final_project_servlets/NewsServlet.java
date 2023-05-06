package final_project_servlets;

import final_project.DBConnection;
import final_project.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/news")
public class NewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ArrayList<News> news = DBConnection.getNews();
        request.setAttribute("news", news);
        request.getRequestDispatcher("/news.jsp").forward(request, response);
    }

}
