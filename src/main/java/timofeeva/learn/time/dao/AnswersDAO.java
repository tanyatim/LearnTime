package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Answers;
import timofeeva.learn.time.entity.Students;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 07.04.2017.
 */
public class AnswersDAO extends AbstractDAO<Answers> {
    @Override
    protected Answers resultSetToEntity(ResultSet rs) throws SQLException {
        Answers answer = null;
        while(rs.next()){
            answer = new Answers(rs.getInt(1), rs.getString(2),
                    rs.getInt(3), rs.getInt(4));
        }
        return answer;
    }

    @Override
    protected String getTableName() {
        return "answers";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE answers SET text=?, ball=?, questionId=? WHERE id=?";
    }

    @Override
    protected List<Answers> resultSetToEntities(ResultSet rs) throws SQLException {
        List <Answers> answers = new ArrayList<>();
        while (rs.next()){
            Answers answer = new Answers(rs.getInt(1), rs.getString(2),
                    rs.getInt(3), rs.getInt(4));

            answers.add(answer);
        }
        return answers;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, Answers answers) throws SQLException {
        ps.setInt(1,answers.getId());
        ps.setString(2, answers.getText());
        ps.setInt(3,answers.getBall());
        ps.setInt(4,answers.getQuestionId());
    }

    @Override
    protected String getSaveQuery() {

        return "INSERT INTO answers VALUES(null, ?, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, Answers answers) throws SQLException {
        ps.setString(1, answers.getText());
        ps.setInt(2, answers.getBall());
        ps.setInt(3, answers.getQuestionId());
    }
}
