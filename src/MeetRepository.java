import java.sql.*;

public class MeetRepository {


    // PreparedStatement - use when we have parameters
    public Meet getMeetById(int id) {
        String selectSql = "SELECT * FROM meets WHERE id=?";


        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToMeet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // PreparedStatement
    public void updateMeetParticipants(Integer nr, int id) {
        String updateNameSql = "UPDATE teachers SET nr_participanti=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, nr);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMeet(Integer id){
        String deleteTSql = "DELETE FROM meets WHERE id=?";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try{
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(deleteTSql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    private Meet mapToMeet(ResultSet resultSet) throws SQLException {
        if (resultSet.next()){
            return new Meet( resultSet.getInt(1),resultSet.getString(2), resultSet.getInt(3));
        }
        return null;
    }

}