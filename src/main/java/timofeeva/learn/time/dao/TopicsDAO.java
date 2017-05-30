package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;
import timofeeva.learn.time.entity.Topics;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 06.04.2017.
 */
public class TopicsDAO extends AbstractDAO <Topics> {
    @Override
    protected Topics resultSetToEntity(ResultSet rs) throws SQLException {
        Topics topic = null;
        while(rs.next()){
            topic = new Topics(rs.getInt(1),
                    rs.getString(2),  rs.getInt(3));
        }
        return topic;
    }

    @Override
    protected String getTableName() {
        return "topics";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE topics SET name=?, courseId=? WHERE id=?";
    }

    @Override
    protected List<Topics> resultSetToEntities(ResultSet rs) throws SQLException {
        List <Topics> topics = new ArrayList<>();
        while (rs.next()){
            Topics topic = new Topics(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3));

            topics.add(topic);
        }
        return topics;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, Topics topics) throws SQLException {
        ps.setInt(1,topics.getId());
        ps.setString(2, topics.getName());
        ps.setInt(3, topics.getCourseId());
    }

    @Override
    protected String getSaveQuery() {
        return "INSERT INTO topics VALUES(null, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, Topics topics) throws SQLException {
        ps.setString(1,topics.getName());
        ps.setInt(2, topics.getCourseId());
    }
}
