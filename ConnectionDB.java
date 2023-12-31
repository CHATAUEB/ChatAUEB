import java.sql.*;

public class ConnectionDB {

    private static final String dbName = "DB55"; // Input your database name
    private static final String dbUser = "G555"; // input user that has access to the database
    private static final String dbPassword = "598f4_304"; // input user's password

    public static void download() {

        Connection dbcon = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSet rs1 = null;

        String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;"
                + "databaseName=" + dbName + ";user=" + dbUser + ";password=" + dbPassword
                + ";encrypt=true;trustServerCertificate=true;";

        /* Step 1 -> Dynamically load the driver's class file into memory */
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("connected");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println("ClassNotFoundException: " + e.getMessage());
            System.exit(0);
        }

        /*
         * Step 2 -> Establish a connection with the database and initializes the
         * Connection object (dbcon)
         */
        try {

            dbcon = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.exit(0);

        }

        /* Execute SQL statements */
        try {

            stmt = dbcon.createStatement();
            rs = stmt.executeQuery("SELECT * FROM UserN");
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("pass");
                // User(username, password);
                System.out.printf(username + password);
                Statement stmt2 = dbcon.createStatement();
                rs1 = stmt2.executeQuery("SELECT * FROM Answers WHERE username='" + username + "'");
                int i = 0;
                while (rs1.next()) {
                    String answer = rs1.getString("answer");
                    System.out.println(answer);
                    // User.answer[i] = answer;// eisagwgh apanthswn se pinaka

                    i++;
                }
            }

            rs.close();
            stmt.close();
            dbcon.close();

        } catch (SQLException e) {

            System.out.println("SQLException: " + e.getMessage());

        } finally {
            try {
                dbcon.close();
            } catch (SQLException e) {

            }
        }
    }

    // BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB
    public static void uploadCred() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;"
                + "databaseName=" + dbName + ";user=" + dbUser + ";password=" + dbPassword
                + ";encrypt=true;trustServerCertificate=true;";

        try {
            // Load the SQLServerDriver class
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish a connection
            connection = DriverManager.getConnection(url);

            // SQL insert statement
            String insertQuery = "INSERT INTO UserN (username, pass) VALUES (?, ?)";

            // Create a PreparedStatement with the insert query
            preparedStatement = connection.prepareStatement(insertQuery);

            // Check if the PreparedStatement is not null
            if (preparedStatement != null) {
                // Set parameters for the insert (replace with your actual column names and
                // values)
                preparedStatement.setString(1, "sss");// vazw to username apo tin klasi user

                preparedStatement.setString(2, "ssssss");

                // Execute the insert
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the number of rows affected
                System.out.println("Rows affected: " + rowsAffected);
            } else {
                System.out.println("PreparedStatement is null");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the PreparedStatement and Connection
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB
    public static void uptadeAns(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String url = "jdbc:sqlserver://sqlserver.dmst.aueb.gr:1433;"
                + "databaseName=" + dbName + ";user=" + dbUser + ";password=" + dbPassword
                + ";encrypt=true;trustServerCertificate=true;";

        try {
            // Load the SQLServerDriver class
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish a connection
            connection = DriverManager.getConnection(url);

            // SQL insert statement
            String insertQuery = "INSERT INTO Answers (username, answer) VALUES (?, ?)";

            // Create a PreparedStatement with the insert query
            preparedStatement = connection.prepareStatement(insertQuery);

            // Check if the PreparedStatement is not null
            if (preparedStatement != null) {
                // Set parameters for the insert (replace with your actual column names and
                // values)
                int i = 0;
                int x = 2;// plithos erwtisewn
                while (i < x) {
                    preparedStatement.setString(1, "Stavros");// vazw to username apo tin klasi user

                    preparedStatement.setInt(2, 2);// vazw ton pinaka answer[i]
                    i++;
                    int rowsAffected = preparedStatement.executeUpdate();
                }

                // Execute the insert
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the number of rows affected
                System.out.println("Rows affected: " + rowsAffected);
            } else {
                System.out.println("PreparedStatement is null");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the PreparedStatement and Connection
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
