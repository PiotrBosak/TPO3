package servlets.views;

import servlets.models.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/view")
public class SumView extends HttpServlet {
    private static final String MODEL = "Model";
    private static final String CONTENT = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Addition</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "\n" +
            "<h2>Addition</h2>\n" +
            "<hr>\n" +
            "<form method=get action=\"http://localhost:8080/web_war_exploded/sum\">\n" +
            "    Operand1<input type=text size=100 name=op1><br>\n" +
            "    Operand2<input type=text size=100 name=op2><br>\n" +
            "    <br><input type=submit value=Get>\n" +
            "</form>\n" +
            "<form method=post action=\"http://localhost:8080/web_war_exploded/sum\">\n" +
            "    Operand1<input type=text size=100 name=op1><br>\n" +
            "    Operand2<input type=text size=100 name=op2><br>\n" +
            "    <br><input type=submit value=Post>\n" +
            "</form>\n" +
            "\n";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        serviceImpl(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        serviceImpl(request, response);
    }


    private void serviceImpl(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        out.println(CONTENT);
        Model attribute = (Model) request.getAttribute(MODEL);
        if (attribute == null) {
            printEndTag(out);
            out.close();
            return;
        }
        String result = attribute.getResult();
        System.out.println(result.isEmpty());
        out.println("<br>" + result + "</br");
        System.out.println(result);
        printEndTag(out);
        out.close();
    }

    private static void printEndTag(PrintWriter out) {
        out.println("</body></html>");
    }
}
