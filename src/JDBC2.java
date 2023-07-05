import java.sql.*;
import java.util.ArrayList;

public class JDBC2 {
    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "developer", "passwordhere");
            Statement statement = conn.createStatement();

           /* String createQuery = """
                    CREATE TABLE IF NOT EXISTS newdb.students
                    ( student_id INT(10) NOT NULL AUTO_INCREMENT,
                      last_name VARCHAR(30),
                      first_name VARCHAR(25),
                      CONSTRAINT students_pk PRIMARY KEY (student_id)
                    );
                    """;
            statement.executeUpdate(createQuery);
            System.out.println("Table 'students' created successfully.");

            String populateQuery = """
                    INSERT INTO newdb.students (last_name, first_name)
                    VALUES ('Walker', 'John'),('Brown', 'Lucy'),('Gardens', 'Pete'),('Sanders', 'Alice');
                    """;
            statement.executeUpdate(populateQuery);
            System.out.println("Data inserted successfully.");*/

            String query = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(query);

            ArrayList<String> surnames = new ArrayList<>();

            while (resultSet.next()) {
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                System.out.println(firstName + " " + lastName);
                surnames.add(lastName);
                surnames.add(firstName);
            }

            System.out.println("\nSurnames of students:");
            for (String surname : surnames) {
                System.out.println(surname);
            }

        } catch (SQLException var13) {
            System.out.println("An error occurred: " + var13.getMessage());
        }
    }
}
