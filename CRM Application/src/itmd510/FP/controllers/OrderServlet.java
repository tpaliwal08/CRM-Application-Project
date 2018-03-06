package itmd510.FP.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import itmd510.FP.dao.OrderDAO;
import itmd510.FP.models.Order;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static String INSERT_OR_EDIT = "/order.jsp";
    private static String LIST_order = "/listorder.jsp";
    private OrderDAO dao;
    
    public OrderServlet() throws SQLException {
        super();
        dao = new OrderDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        try{
        if (action.equalsIgnoreCase("delete")){
            String ordId = request.getParameter("OrdId");
            dao.deleteOrder(ordId);
            forward = LIST_order;
            request.setAttribute("orders", dao.getAllOrders());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            String ordId = request.getParameter("OrdId");
            Order ord = dao.getOrderById(ordId);
            request.setAttribute("order", ord);
        } else if (action.equalsIgnoreCase("listorder")){
            forward = LIST_order;
            request.setAttribute("orders", dao.getAllOrders());
        } else {
            forward = INSERT_OR_EDIT;
        }
 
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   	 
    	try{
    	Order order = new Order();
//    	order.setOrdId(Integer.parseInt(request.getParameter("OrdId")));
    	order.setAccId(Integer.parseInt(request.getParameter("AccId")));
    	order.setOrdDesc(request.getParameter("OrdDesc"));
    	order.setOrdDate(request.getParameter("OrdDate"));
    	order.setOrdQuantity(Double.parseDouble(request.getParameter("OrdQuantity")));
    	order.setOrdAmount(Double.parseDouble(request.getParameter("OrdAmount")));
    	order.setOrdType(request.getParameter("OrdType"));
    	
    	
    	String ordId = request.getParameter("OrdType");
    	order.setOrdType(ordId);
        dao.checkOrder(order);
        RequestDispatcher view = request.getRequestDispatcher(LIST_order);
        request.setAttribute("orders", dao.getAllOrders());
        view.forward(request, response);
    }catch (Exception e) {
        e.printStackTrace();
    }
}
}
