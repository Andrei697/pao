import java.sql.*;

public class ExamRepository {

    public void addExam(String d, String g) {
        String insertPersonSql = "INSERT INTO exams(date, grupa) VALUES(?,?)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertPersonSql);
            preparedStatement.setString(1, d);
            preparedStatement.setString(2, g);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CallableStatement
    public void insertExam(Exam exam) {
        String preparedSql = "{call insertExam(?,?,?)}";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(2, exam.getDate());
            cstmt.setString(3,exam.getGrupa_care_sustine());

            cstmt.registerOutParameter(1, Types.INTEGER); //out param (result of the procedure call)

            cstmt.execute();
            System.out.println("Added exam with id:" + cstmt.getInt(1));    //out param (result of the procedure call)
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // PreparedStatement - use when we have parameters
    public Exam getExamById(int id) {
        String selectSql = "SELECT * FROM exams WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToExam(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // PreparedStatement
    public void updateDetails(String details, int id) {
        String updateNameSql = "UPDATE teachers SET date=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, details);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteExam(String dat){
        String deleteTSql = "DELETE FROM exams WHERE date=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteTSql);
            preparedStatement.setString(1, dat);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    private Exam mapToExam(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Exam(resultSet.getInt(1),resultSet.getString(1), resultSet.getString(2));
        }
        return null;
    }

}