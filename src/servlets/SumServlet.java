package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Scanner;

@WebServlet("/sum")
public class SumServlet extends HttpServlet {
    public static final String GET = "get";
    public static final String POST = "post";


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        handleRequest(req,resp,GET);
    }
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            handleRequest(req,resp,POST);
        }


        private void handleRequest(HttpServletRequest req, HttpServletResponse resp,String methodType) throws IOException {
            PrintWriter out = resp.getWriter();
            var par1 = req.getParameter("op1");
            var par2 = req.getParameter("op2");
            String sum = "";
            if(par1 != null && par2 != null)
                try {
                    sum = Integer.parseInt(par1) + Integer.parseInt(par2) + "";
                }
                catch (NumberFormatException e){
                    sum = "You didn't put correct values";
                }
            String form = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta http-equiv=\"Content-Type\" content=\"text/html\" charset=\"UTF-8\">\n" +
                    "    <title>Form</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<center><h2>Parameter test</h2></center>\n" +
                    "<hr>\n" +
                    "<form method=\""+methodType+"\" action=\"http://localhost:8080/web_war_exploded/sum\">\n" +
                    "    operand1<input type=\"text\" size=\"100\" name=\"op1\"><br>\n" +
                    "    operand2<input type=\"text\" size=\"100\" name=\"op2\"><br>\n" +
                    "\n" +
                    "\n" +
                    "    <br><input type=\"submit\" value=\"Get\">\n" +
                    "    <br><input type=\"submit\" value=\"Post\">\n" +
                    "</form>\n" +
                    "<br>" + sum + "</br" +
                    "</body>\n" +
                    "</html>\n";

            Scanner scanner = new Scanner(form);
            while (scanner.hasNextLine())
                out.println(scanner.next());

        }


}
