package final_project_servlets;

import final_project.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/add-news-page")
public class AddNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if(user!=null) {

            request.getRequestDispatcher("/addnews.jsp").forward(request, response);

        }else{
            response.sendRedirect("/login");
        }
    }
}
