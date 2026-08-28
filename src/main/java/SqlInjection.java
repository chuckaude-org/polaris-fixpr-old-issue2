// https://cheatsheetseries.owasp.org/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.html#anatomy-of-a-typical-sql-injection-vulnerability

import java.sql.*;
import javax.servlet.http.HttpServletRequest;

public class SqlInjection {
    public static ResultSet doQuery(HttpServletRequest request, Connection connection) throws SQLException {
        String customerName = request.getParameter("customerName");
        String query = "SELECT account_balance FROM user_data WHERE user_name = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, customerName);
        ResultSet results = pstmt.executeQuery();
        return(results);
    }
}
