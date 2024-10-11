import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class ElectricityBillingSystemServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Electricity Billing System</h1>");
        out.println("<form method='post'>");
        out.println("Customer Name: <input type='text' name='customerName'><br>");
        out.println("Units Consumed: <input type='text' name='unitsConsumed'><br>");
        out.println("<input type='submit' value='Calculate Bill'>");
        out.println("</form>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getParameter("customerName");
        int unitsConsumed = Integer.parseInt(request.getParameter("unitsConsumed"));
        double billAmount = calculateBill(unitsConsumed);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Electricity Bill</h1>");
        out.println("Customer Name: " + customerName + "<br>");
        out.println("Units Consumed: " + unitsConsumed + "<br>");
        out.println("Bill Amount: ₹" + billAmount + "<br>");
        out.println("</body></html>");
    }

    private double calculateBill(int units) {
        double amount;
        if (units <= 100) {
            amount = units * 1.50;
        } else if (units <= 200) {
            amount = 100 * 1.50 + (units - 100) * 2.00;
        } else {
            amount = 100 * 1.50 + 100 * 2.00 + (units - 200) * 3.00;
        }
        return amount;
    }
}
