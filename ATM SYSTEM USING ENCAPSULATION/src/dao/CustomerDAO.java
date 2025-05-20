import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (id, name, pin, my_account_num, transactions, total) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getPin());
            stmt.setInt(4, customer.getMyAccountNum());
            stmt.setInt(5, customer.getTransactions());
            stmt.setInt(6, customer.getTotal());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getCustomerById(String id) {
        String sql = "SELECT * FROM customers WHERE id = ?";
        Customer customer = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                customer = new Customer(
                    rs.getString("name"),
                    rs.getString("id"),
                    rs.getString("pin")
                );
                customer.setMyAccountNum(rs.getInt("my_account_num"));
                customer.setTransactions(rs.getInt("transactions"));
                customer.setTotal(rs.getInt("total"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    public void updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET name=?, pin=?, my_account_num=?, transactions=?, total=? WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPin());
            stmt.setInt(3, customer.getMyAccountNum());
            stmt.setInt(4, customer.getTransactions());
            stmt.setInt(5, customer.getTotal());
            stmt.setString(6, customer.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(String id) {
        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
