package Java_Sql_JDBC;
import java.util.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of passenger: ");
        passengerName = scanner.next();
        System.out.println("Enter bus no: ");
        busNo = scanner.nextInt();
        System.out.println("Enter date dd-mm-yyyy");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public boolean check_is_available() throws SQLException {
        int capacity = SqlBus.getCapacity(busNo);
        int booked = SqlBooking.getBookedCount(busNo , date);
        return booked<capacity;

    }
}
