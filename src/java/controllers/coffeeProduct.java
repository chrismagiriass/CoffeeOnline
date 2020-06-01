package controllers;

import entities.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sevices.ProductService;


public class coffeeProduct extends HttpServlet {

    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            EntityManagerFactory emf=Persistence.createEntityManagerFactory("coffeeOnlinePU");  
//        EntityManager em=emf.createEntityManager();
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet coffeeProduct</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet coffeeProduct at " + request.getContextPath() + "</h1>");
//            Product p1=em.find(Product.class,1);
//            out.println("product is "+p1);
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//        
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
                  response.setContentType("text/html");
ProductService prService= new ProductService();

//        EntityManagerFactory emf=Persistence.createEntityManagerFactory("coffeeOnlinePU");  
//        EntityManager em=emf.createEntityManager();
        Product p=new Product();
        p.setId(Integer.parseInt(request.getParameter("id")));
        p.setTitle(request.getParameter("title"));
        p.setDescription(request.getParameter("description"));
        p.setPrice((short)Integer.parseInt(request.getParameter("price")));
        //prService.saveProduct(p);
        prService.findAllProducts();
        List<Product>products = prService.findAllProducts();
        for(Product pr:products){
            System.out.println(pr.getTitle());
        }
        
        request.setAttribute("products", products);
        request.getRequestDispatcher("products.jsp").forward(request, response);
        
        response.sendRedirect("products.jsp");
//        em.getTransaction().begin();
//        em.persist(p);
//        em.getTransaction().commit();
        
        PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>");
       
        
        
        

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
