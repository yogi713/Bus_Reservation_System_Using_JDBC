package Java_Sql_JDBC;
import java.util.Date;
import java.sql.*;
public class SqlBooking {
    public static int getBookedCount(int busNo , Date date) throws SQLException{
        Connection con = DB_Connection.connect_DB();
        String query = "Select count(passenger_name) from booking where bus_no =? and travel_date =?";
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        pst.setInt(1,busNo);
        pst.setDate(2,sqlDate);
        ResultSet result = pst.executeQuery();
        result.next();
        return result.getInt(1);
    }
    public static void add_Booking(Booking booking) throws SQLException{
        Connection con = DB_Connection.connect_DB();
        String query = "insert into booking values(?,?,?)";
        java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, booking.passengerName);
        pst.setInt(2, booking.busNo);
        pst.setDate(3, sqlDate);
        pst.executeUpdate();
    }
    public static void print_all_bookings() throws SQLException{
        Connection con = DB_Connection.connect_DB();
        String query = "Slect * from booking";
        Statement st = con.createStatement();
        ResultSet res = st.executeQuery(query);
        System.out.println("      ALL PASSENGERS DETAILS");
        System.out.println("**********************************");
        while(res.next()){
            System.out.print(res.getString(1)+"\t");
            System.out.print(res.getInt(2)+"\t");
            System.out.println(res.getDate(3)+"\t");
        }
        System.out.println("**********************************");
        con.close();
    }
}
