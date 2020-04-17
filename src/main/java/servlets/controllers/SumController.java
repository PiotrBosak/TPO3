package servlets.controllers;

import servlets.Input;
import servlets.models.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sum")
public class SumController extends HttpServlet {
    private static final String MODEL = "Model";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        handleRequest(request,response);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
        handleRequest(req, resp);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter1 = request.getParameter("op1");
        String parameter2 = request.getParameter("op2");
        Input input = new Input(parameter1,parameter2);
        Model model = new Model(input.calculateSum());
        System.out.println(model);

        request.setAttribute(MODEL,model);
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/view");
        dispatcher.forward(request,response);
    }

}

