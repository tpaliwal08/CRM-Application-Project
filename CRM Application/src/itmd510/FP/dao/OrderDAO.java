package itmd510.FP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import itmd510.FP.models.Order;
import itmd510.FP.util.Connector;

public class OrderDAO {
	private Connection connection;
	
	public OrderDAO() throws SQLException {
    	Connector con = new Connector();
        connection = con.getDBConnect();
    }
	
	 public void addorder(Order order) {
	    	try {
	            PreparedStatement preparedStatement = connection.prepareStatement("insert into tbl_Orders(AccId, OrdDesc, OrdDate, OrdQuantity, OrdAmount,OrdType) values (?, ?, ?, ?,?, ?)");
	            // Parameters start with 1
	            preparedStatement.setInt(1, order.getAccId());
	            preparedStatement.setString(2, order.getOrdDesc());
	            preparedStatement.setString(3, order.getOrdDate());  
	            preparedStatement.setDouble(4, order.getOrdQuantity());
	            preparedStatement.setDouble(5, order.getOrdAmount());
	            preparedStatement.setString(6, order.getOrdType());
	            preparedStatement.executeUpdate();
	 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
	public Object getAllOrders() {
		
		List<Order> order = new ArrayList<Order>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tbl_Orders");
            while (rs.next()) {
                Order orderobj = new Order();
                orderobj.setOrdId(Integer.parseInt(rs.getString("OrdId")));
                orderobj.setAccId(Integer.parseInt(rs.getString("AccId")));
                orderobj.setOrdDesc(rs.getString("OrdDesc"));
                orderobj.setOrdType(rs.getString("OrdType"));
                orderobj.setOrdAmount(rs.getDouble("OrdAmount"));
                orderobj.setOrdQuantity(rs.getDouble("OrdQuantity"));
                orderobj.setOrdDate(rs.getString("OrdDate"));
            	
                order.add(orderobj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return order;
		
	}


	public void deleteOrder(String ordId) {
		
		try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from tbl_Orders where OrdId=?");
            // Parameters start with 1
            preparedStatement.setString(1, ordId);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	
	private void updateOrder(Order ord) {
		
		try {
			 PreparedStatement preparedStatement = connection.prepareStatement("update tbl_Orders set OrdDesc=?, OrdAmount=?, OrdQuantity=?, OrdType=?, OrdDate=?"
	                    + "where OrdDesc=?");
            // Parameters start with 1
            
            preparedStatement.setString(1, ord.getOrdDesc());
            preparedStatement.setDouble(2, ord.getOrdAmount());            
            preparedStatement.setDouble(3, ord.getOrdQuantity());
            preparedStatement.setString(4, ord.getOrdType());
            preparedStatement.setString(5, ord.getOrdDate());
            preparedStatement.setString(6, ord.getOrdDesc());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public Order getOrderById(String ordId) {
		
		Order order = new Order();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_Orders where OrdId=?");
            preparedStatement.setString(1, ordId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
            	order.setOrdId(rs.getInt("OrdId"));
                order.setAccId(rs.getInt("AccId"));
            	order.setOrdDesc(rs.getString("OrdDesc"));
                order.setOrdType(rs.getString("OrdType"));
                order.setOrdAmount(rs.getDouble("OrdAmount"));
                order.setOrdQuantity(rs.getDouble("OrdQuantity"));
                order.setOrdDate(rs.getString("OrdDate"));
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return order;
		}

	public void checkOrder(Order order) {
		
		try {
            PreparedStatement ps = connection.prepareStatement("select OrdDesc from tbl_Orders where OrdDesc = ?");
            ps.setString(1, order.getOrdDesc());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateOrder(order);
            } else {
                addorder(order);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
	}
	}


