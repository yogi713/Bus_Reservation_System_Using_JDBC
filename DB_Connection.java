package Java_Sql_JDBC;
import java.sql.*;
public class DB_Connection {
    private static final String url="jdbc:mysql://localhost:3306/bus_reservation";
    private static final String username="root";
    private static final String password="YOGIcr7123";

    public static Connection connect_DB() throws SQLException{
        return DriverManager.getConnection(url , username , password);
    }
}
