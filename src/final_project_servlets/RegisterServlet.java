package final_project_servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import final_project.DBConnection;
import final_project.User;

import java.io.IOException;

@WebServlet(value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String rePassword = req.getParameter("re_password");
        String fullName = req.getParameter("full_name");

        User user = DBConnection.getUser(email);

        if(user==null){
            if(password.equals(rePassword)){

                User createUser = new User();
                createUser.setEmail(email);
                createUser.setPassword(password);
                createUser.setFullname(fullName);
                createUser.setRole(2);

                DBConnection.addUser(createUser);
                resp.sendRedirect("/register?success");

            }else{
                resp.sendRedirect("/register?passworderror");
            }

        }else{
            resp.sendRedirect("/register?emailerror");
        }
    }

}
