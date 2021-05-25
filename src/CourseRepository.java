import java.sql.*;

public class CourseRepository {

    // CallableStatement

    public void addCourse(String n, Integer g, String s) {
        String insertPersonSql = "INSERT INTO courses(course_name, id_prof,perioada) VALUES(?,?,?)";

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

    public void insertCourse(Course course) {
        String preparedSql = "{call insertCourse(?,?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(2, course.getCourse_name());
            cstmt.setInt(3, course.getCourse_teacher1());
            cstmt.setString(4,course.getPerioada_predare());

            cstmt.registerOutParameter(1, Types.INTEGER); //out param (result of the procedure call)

            cstmt.execute();
            System.out.println("Added course with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // PreparedStatement - use when we have parameters
    public Course getCourseById(int id) {
        String selectSql = "SELECT * FROM courses WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToCourse(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // PreparedStatement
    public void updateCourseName(String name, int id) {
        String updateNameSql = "UPDATE courses SET course_name=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCourse(String name){
        String deleteTSql = "DELETE FROM courses WHERE course_name=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteTSql);
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    private Course mapToCourse(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            TeacherRepository tr = new TeacherRepository();
            Teacher aux = tr.getPersonById(resultSet.getInt(3));
            return new Course(resultSet.getInt(1), resultSet.getString(2), aux, resultSet.getString(4));
        }
        return null;
    }

}