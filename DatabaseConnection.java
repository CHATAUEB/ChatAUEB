import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.StatementEvent;

public class DatabaseConnection {
    public static void main(String[] args) {
        // JDBC URL, username, and password of SQL Server
        String url = "jdbc:sqlserver://your_server:1433;databaseName=your_database";
        String username = "your_username";
        String password = "your_password";
        List<User> userList = new ArrayList<>();

        try {
            // Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Do something with the connection (e.g., execute SQL queries)
            Statement st = connection.createStatement();

            
            ResultSet resultSet1 = st.executeQuery("select username from users");
            ResultSet resultSet2 = st.executeQuery("select password from users");\
            ResultSet resultSet3 = st.executeQuery("select answers from answers");
            

            while (resultSet1.next() && resultSet2.next()) {
                String[] ansers = new String[30];
                String uname = resultSet1.getString("username");
                String upass = resultSet2.getString("password");
                while (resultSet3.next() && uname == resultSet1()){ // mporei na min doulevei o elegxos ginetai h antistixisi username kai answers pinaka diaforetikos 
                    int i = 0;
                    ansers[i]= resultSet3.getString("answers");
                    i++;
                }
                User user = new User(uname,upass,ansers);
                //add sto araylist prepei na ginei
            }
            

            // Close the connection when done
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}