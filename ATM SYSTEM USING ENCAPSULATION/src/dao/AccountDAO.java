import java.sql.*;

public class AccountDAO {

    public void addAccount(Account account) {
        String sql = "INSERT INTO accounts (number, balance, active, type) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, account.getNumber());
            stmt.setDouble(2, account.getBalance());
            stmt.setBoolean(3, account.getActive());
            stmt.setBoolean(4, account.getType());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account getAccount(String number) {
        String sql = "SELECT * FROM accounts WHERE number = ?";
        Account account = null;

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                account = new Account(Integer.parseInt(rs.getString("number")), 0);
                if (!rs.getBoolean("active")) account.setActiveFalse();
                if (rs.getBoolean("type")) account.setTypeSavings();
                else account.setTypeChecking();
                account.addDeposit(rs.getDouble("balance"));  // assuming balance = 0 before this
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }

    public void updateAccount(Account account) {
        String sql = "UPDATE accounts SET balance=?, active=?, type=? WHERE number=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, account.getBalance());
            stmt.setBoolean(2, account.getActive());
            stmt.setBoolean(3, account.getType());
            stmt.setString(4, account.getNumber());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(String number) {
        String sql = "DELETE FROM accounts WHERE number=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, number);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
