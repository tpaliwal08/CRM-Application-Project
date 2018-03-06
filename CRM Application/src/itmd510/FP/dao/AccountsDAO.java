package itmd510.FP.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import itmd510.FP.models.Accounts;

import itmd510.FP.util.Connector;

public class AccountsDAO {
	private Connection connection;
	 
    public AccountsDAO() throws SQLException {
    	Connector con = new Connector();
        connection = con.getDBConnect();
    }

    public void addaccount(Accounts account) {
    	try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tbl_Accounts(OppId,AccName, AccNo, AccPhone, AccFax, AccEmailId, AccAddress) values (?, ?, ?, ?,?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, account.getOppId());
            preparedStatement.setString(2, account.getAccName());
            preparedStatement.setString(3, account.getAccNo());            
            preparedStatement.setInt(4, account.getAccPhone());
            preparedStatement.setInt(5, account.getAccFax());
            preparedStatement.setString(6, account.getAccEmail());
            preparedStatement.setString(7, account.getAccAddress());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public void deleteAccount(String accId) {
		try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from tbl_Accounts where AccId=?");
            // Parameters start with 1
            preparedStatement.setString(1, accId);
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public void updateAccount(Accounts account) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update tbl_Accounts set AccName=?, AccNo=?, AccPhone=?, AccEmailId=?,AccFax=?, AccAddress=?"
                    + "where AccNo=? and AccName=?");
            // Parameters start with 1
            
            preparedStatement.setString(1, account.getAccName());
            preparedStatement.setString(2, account.getAccNo());            
            preparedStatement.setInt(3, account.getAccPhone());
            preparedStatement.setString(4, account.getAccEmail());
            preparedStatement.setInt(5, account.getAccFax());
            preparedStatement.setString(6, account.getAccAddress());
            preparedStatement.setString(7, account.getAccNo());
            preparedStatement.setString(8, account.getAccName());
            preparedStatement.executeUpdate();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	public Object getAllAccounts() {
		
		List<Accounts> account = new ArrayList<Accounts>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from tbl_Accounts");
            while (rs.next()) {
                Accounts accountObj = new Accounts();
                accountObj.setAccId(rs.getInt("AccId"));
                accountObj.setOppId(rs.getInt("OppId"));
                accountObj.setAccName(rs.getString("AccName"));
                accountObj.setAccNo(rs.getString("AccNo"));
                accountObj.setAccPhone(rs.getInt("AccPhone"));
                accountObj.setAccAddress(rs.getString("AccAddress"));
                accountObj.setAccEmail(rs.getString("AccEmailId"));
                accountObj.setAccFax(rs.getInt("AccFax"));
            	
                account.add(accountObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return account;
		
	}

	public Accounts getAccountsById(String accId) {
		Accounts account = new Accounts();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tbl_Accounts where AccId=?");
            preparedStatement.setString(1, accId);
            ResultSet rs = preparedStatement.executeQuery();
 
            if (rs.next()) {
            	account.setOppId(rs.getInt("OppId"));
            	account.setAccId(rs.getInt("AccId"));
            	account.setAccName(rs.getString("AccName"));
                account.setAccNo(rs.getString("AccNo"));
                account.setAccPhone(rs.getInt("AccPhone"));
                account.setAccAddress(rs.getString("AccAddress"));
                account.setAccEmail(rs.getString("AccEmailId"));
                account.setAccFax(rs.getInt("AccFax"));
            	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return account;
		}

	public void checkAccount(Accounts account) {
		
		try {
            PreparedStatement ps = connection.prepareStatement("select AccName from tbl_Accounts where AccName = ?");
            ps.setString(1, account.getAccName());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                updateAccount(account);
            } else {
                addaccount(account);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
	}

	
}
