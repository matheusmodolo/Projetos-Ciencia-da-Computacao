package fibonacci.servlets;

/**
 *
 * @author nmmat
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FiboServlet", urlPatterns = {"/fibo"})

public class FiboServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        for (int i = 0; i <= 30; i++) {
            System.out.printf("fibonacci(%d):retorna %d\n", i, fibo(i));
        }

    }

    static long fibo(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }
}
