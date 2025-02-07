import java.sql.*;

public class Database {
    public static Connection connectDB() {
        String url="jdbc:postgresql://localhost:5432/MariaDB";
        String user="postgres";
        String password="1540";

        try{
            Connection con=DriverManager.getConnection(url,user,password);
            return DriverManager.getConnection(url,user,password);
        }catch(SQLException e){
            System.out.println(e);
            return null;
        }
    }
}
