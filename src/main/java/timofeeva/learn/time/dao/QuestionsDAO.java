package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Questions;
import timofeeva.learn.time.entity.Students;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 07.04.2017.
 */
public class QuestionsDAO extends AbstractDAO <Questions> {
    @Override
    protected Questions resultSetToEntity(ResultSet rs) throws SQLException {
        Questions question = null;
        while(rs.next()){
            question = new Questions(rs.getInt(1), rs.getString(2),
                    rs.getInt(3));
        }
        return question;
    }

    @Override
    protected String getTableName() {
        return "questions";
    }

    @Override
    protected String getUpdateQuery() {

        return "UPDATE questions SET question=?, testId=?, WHERE id=?";
    }



    @Override
    protected List<Questions> resultSetToEntities(ResultSet rs) throws SQLException {
        List <Questions> questions = new ArrayList<>();
        while (rs.next()){
            Questions question = new Questions(rs.getInt(1), rs.getString(2),
                    rs.getInt(3));

            questions.add(question);
        }
        return questions;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, Questions questions) throws SQLException {
        ps.setString(1, questions.getQuestion());
        ps.setInt(2, questions.getTestId());
    }

    @Override
    protected String getSaveQuery() {
        return "INSERT INTO questions VALUES(null, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, Questions questions) throws SQLException {
        ps.setString(1, questions.getQuestion());
        ps.setInt(2, questions.getTestId());
    }
}
