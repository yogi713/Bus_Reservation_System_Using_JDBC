package Java_Sql_JDBC;
import java.sql.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            SqlBus.print_bus_info();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1.Book  2.exit");
                int choice = scanner.nextInt();
                if (choice == 2) {
                    SqlBooking.print_all_bookings();
                    break;
                }
                if (choice == 1) {
                    Booking booking = new Booking();
                    if (booking.check_is_available()) {
                        SqlBooking.add_Booking(booking);
                        System.out.println("Your booking is confirmed");
                    } else System.out.println("This Bus is full.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
