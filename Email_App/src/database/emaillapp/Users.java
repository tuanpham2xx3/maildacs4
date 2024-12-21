package database.emaillapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.emailapp.Customer;

public class Users {

    public List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;

        String sql = "SELECT * FROM users";  // 'customer' changed to 'users'

        try {
            pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();
            
                customer.setFullname(rs.getString("FULLNAME"));            
                customer.setUsername(rs.getString("USERNAME"));
                customer.setPassword(rs.getString("PASSWORD"));
                customer.setRetypepass(rs.getString("RETYPEPASS"));               

                customerList.add(customer);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return customerList;
    }

    public Customer getCustomerByUsername(String username) {
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;

        String sql = "SELECT * FROM users WHERE USERNAME = ?";  // Using USERNAME instead of ID

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setFullname(rs.getString("FULLNAME"));
                customer.setUsername(rs.getString("USERNAME"));
                customer.setPassword(rs.getString("PASSWORD"));
                customer.setRetypepass(rs.getString("RETYPEPASS"));

                return customer;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return null;
    }
    
    public void addCustomer(Customer customer) {
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "INSERT INTO users(FULLNAME, USERNAME, PASSWORD, RETYPEPASS) VALUE(?,?,?,?)";  // 'customer' changed to 'users'

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, customer.getFullname());
            pst.setString(2, customer.getUsername());
            pst.setString(3, customer.getPassword());
            pst.setString(4, customer.getRetypepass());       
            int rs = pst.executeUpdate();
            System.out.println(rs);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void updateCustomer(Customer customer) {
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "UPDATE users SET FULLNAME = ?, USERNAME = ?, PASSWORD = ?, RETYPEPASS = ? WHERE USERNAME = ?";  // Changed 'ID' to 'USERNAME'

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, customer.getFullname());
            pst.setString(2, customer.getUsername());
            pst.setString(3, customer.getPassword());
            pst.setString(4, customer.getRetypepass());
            pst.setString(5, customer.getUsername());  // WHERE condition on USERNAME

            int rs = pst.executeUpdate();
            System.out.println(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void deleteCustomer(String username) {
        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;
        String sql = "DELETE FROM users WHERE USERNAME = ?";  // Changed 'ID' to 'USERNAME'

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, username);  // Using USERNAME as parameter
            int rs = pst.executeUpdate();
            System.out.println(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    
    public List<Customer> searchCustomers(String valToSearch) {
        List<Customer> customerList = new ArrayList<>();

        Connection connection = JDBCConnection.getJDBCConnection();
        PreparedStatement pst = null;

        String sql = "SELECT * FROM users WHERE CONCAT(USERNAME, FULLNAME, AGE, PHONENUMBER) LIKE ?";  // Changed 'ID' to 'USERNAME'

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, "%" + valToSearch + "%");  // Using parameterized query to prevent SQL injection
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer();

                customer.setFullname(rs.getString("FULLNAME"));
                customer.setUsername(rs.getString("USERNAME"));
                customer.setPassword(rs.getString("PASSWORD"));
                customer.setRetypepass(rs.getString("RETYPEPASS"));                 

                customerList.add(customer);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return customerList;
    }
}
