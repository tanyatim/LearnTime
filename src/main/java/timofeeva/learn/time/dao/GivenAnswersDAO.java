package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.GivenAnswers;
import timofeeva.learn.time.entity.Students;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 07.04.2017.
 */
public class GivenAnswersDAO extends AbstractDAO <GivenAnswers> {
    @Override
    protected GivenAnswers resultSetToEntity(ResultSet rs) throws SQLException {
        GivenAnswers givenAnswers = null;
        while(rs.next()){
            givenAnswers = new GivenAnswers(rs.getInt(1), rs.getInt(2),
                    rs.getInt(3));
        }
        return givenAnswers;
    }

    @Override
    protected String getTableName() {
        return "givenAnswers";
    }

    @Override
    protected String getUpdateQuery() {

        return "UPDATE givenAnswers SET historyId=?, answerId=? WHERE id=?";
    }



    @Override
    protected List<GivenAnswers> resultSetToEntities(ResultSet rs) throws SQLException {
        List <GivenAnswers> givenAnswers = new ArrayList<>();
        while (rs.next()){
            GivenAnswers givenAnswer = new GivenAnswers(rs.getInt(1),
                     rs.getInt(2), rs.getInt(3));

            givenAnswers.add(givenAnswer);
        }
        return givenAnswers;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, GivenAnswers givenAnswers) throws SQLException {
        ps.setInt(1,givenAnswers.getId());
        ps.setInt(2,givenAnswers.getHistoryId());
        ps.setInt(3,givenAnswers.getAnswerId());
    }

    @Override
    protected String getSaveQuery() {
        return "INSERT INTO givenAnswers VALUES(null, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, GivenAnswers givenAnswers) throws SQLException {
        ps.setInt(1, givenAnswers.getHistoryId());
        ps.setInt(2, givenAnswers.getAnswerId());
    }
}
