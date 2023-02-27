package Java_Sql_JDBC;
import java.sql.*;
public class SqlBus {
    public static void print_bus_info() throws SQLException{
        Connection con = DB_Connection.connect_DB();
        String query = "Select * from bus";
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(query);
        System.out.println("Bus\tAc\tCapacity");
        while(result.next()){
            System.out.print(result.getInt(1)+"\t");
            System.out.print(result.getInt(2)+"\t");
            System.out.println(result.getInt(3));
        }
        con.close();
    }
    public static int getCapacity(int id) throws SQLException{
        Connection con = DB_Connection.connect_DB();
        String query = "Select capacity from bus where id="+id;
        Statement st = con.createStatement();
        ResultSet result = st.executeQuery(query);
        result.next();
        return result.getInt(1);
    }
}
