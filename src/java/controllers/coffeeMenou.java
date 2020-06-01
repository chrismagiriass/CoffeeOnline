
package controllers;

import entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sevices.ProductService;


public class coffeeMenou extends HttpServlet {

    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet coffeeMenou</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet coffeeMenou at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//       // processRequest(request, response);
//    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
              PrintWriter out = response.getWriter(); 

//       EntityManagerFactory emf=Persistence.createEntityManagerFactory("coffeeOnlinePU");  
//        EntityManager em=emf.createEntityManager();
//        Product p=em.find(Product.class, Integer.parseInt(request.getParameter("id")));
ProductService prService= new ProductService();
Product p=prService.findById(Integer.parseInt(request.getParameter("id")));
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet coffeeMenou</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>product is " +p + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
