import java.sql.*;

public class TeacherRepository {

    // CallableStatement
    public void insertTeacher(Teacher teacher) {
        String preparedSql = "{call insertTeacher(?,?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(2, teacher.getName());
            cstmt.setInt(3, teacher.getGrade());
            cstmt.setString(4,teacher.getSalary());

            cstmt.registerOutParameter(1, Types.INTEGER); //out param (result of the procedure call)

            cstmt.execute();
            System.out.println("Added user with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // PreparedStatement - use when we have parameters
    public Teacher getPersonById(int id) {
        String selectSql = "SELECT * FROM teachers WHERE id=?";


        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToTeacher(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // PreparedStatement
    public void updatePersonName(String name, int id) {
        String updateNameSql = "UPDATE teachers SET name=? WHERE id=?";

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

    public void deleteTeacher(String name){
        String deleteTSql = "DELETE FROM teachers WHERE name=?";
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

    private Teacher mapToTeacher(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Teacher(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
        }
        return null;
    }

}