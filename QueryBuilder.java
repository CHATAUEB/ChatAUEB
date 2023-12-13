import java.sql.*;
public class QueryBuilder{
    public static void main(String[] args) {
        int n = 30 ; // arithmos erwthsewn
        //connection with sql
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database_name";
        String username = "your_username";//allazoume afta edw 
        String password = "your_password";
        //connection with sql
        try(connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
            ResultSet resultSet = statement.executeQuery(sql);
            DefaultTableModel tableModel = new DefaultTableModel();
            String sql = "SELECT * FROM your_table_name"; //allazoume to onoma mono
         
          
            String[] x = new String[2];
            StringBuilder stringBuilder = new StringBuilder();
    //xtaixnw to message sto ai
            for (String row : x) {
                stringBuilder.append(row).append("\n");
            }
            String Message = stringBuilder.toString();
            System.out.println(Message);
      
    
    
    }catch(SQLException e){
        System.out.println("bro sql error");
    }
}
    




   // try(connection connection = DriverManager.getConnection(jdbcUrl, username, password)){
   //     String sql = "SELECT * FROM your_table_name"; //allazoume to onoma mono

//    }
    //String info = "to opa apotelei"; // info gia to panepistimio
    

}