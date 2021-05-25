import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class DataSetup {

    public void setUp() {
        String createTableSql = "CREATE TABLE IF NOT EXISTS persons" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                "age double)";
        String createTableSql1 = "CREATE TABLE IF NOT EXISTS teachers" +
                "(id int PRIMARY KEY AUTO_INCREMENT, name varchar(30)," +
                "grade int, salary varchar(30))";

        String createTableSql2 = "CREATE TABLE IF NOT EXISTS exams" +
                "(id int PRIMARY KEY AUTO_INCREMENT, date varchar(30)," +
                "grupa int)";

        String createTableSql3 = "CREATE TABLE IF NOT EXISTS courses"+
                    "(id int PRIMARY KEY AUTO_INCREMENT, course_name varchar(30), id_prof int, perioada varchar(30))";

        String altertable1=" ALTER TABLE courses  \n" +
                "ADD FOREIGN KEY (id_prof) REFERENCES teachers(id)";

        String createTableSql4 = "CREATE TABLE IF NOT EXISTS meets"+
                "(id int PRIMARY KEY AUTO_INCREMENT, data varchar(30), nr_participanti int)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            repositoryHelper.executeSql(databaseConnection, altertable1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql4);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addTeacher(String n, Integer g, String s) {
        String insertPersonSql = "INSERT INTO teachers(name, grade,salary) VALUES(?,?,?)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, n);
            preparedStatement.setInt(2, g);
            preparedStatement.setString(3, s);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayTeacher() {
        String selectSql = "SELECT * FROM teachers";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getInt(1));
                System.out.println("Name:" + resultSet.getString(2));
                System.out.println("Grade:" + resultSet.getInt(3));
                System.out.println("Salary:" + resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}