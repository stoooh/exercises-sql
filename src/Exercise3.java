import java.sql.*;

public class Exercise3 {

    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "password");
            Statement statement = conn.createStatement();

            String altertable = "ALTER TABLE students ADD country VARCHAR(30)";
            statement.executeUpdate(altertable);

            String query1 = "UPDATE students SET country = 'Italy' WHERE last_name = 'Walker'";
            String query2 = "UPDATE students SET country = 'Italy' WHERE last_name = 'Brown'";
            String query3 = "UPDATE students SET country = 'Germany' WHERE last_name = 'Gardens'";
            String query4 = "UPDATE students SET country = 'Germany' WHERE last_name = 'Sanders'";

            statement.executeUpdate(query1);
            statement.executeUpdate(query2);
            statement.executeUpdate(query3);
            statement.executeUpdate(query4);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while(resultSet.next()){
                System.out.println(resultSet.getString("country"));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}