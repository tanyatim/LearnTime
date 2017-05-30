package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;
import timofeeva.learn.time.entity.Tests;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 06.04.2017.
 */
public class TestsDAO extends AbstractDAO <Tests> {
    @Override
    protected Tests resultSetToEntity(ResultSet rs) throws SQLException {
        Tests test = null;
        while(rs.next()){
            test = new Tests(rs.getInt(1), rs.getInt(2),
                    rs.getInt(3), rs.getInt(4), rs.getInt(5));
        }
        return test;
    }

    @Override
    protected String getTableName() {
        return "tests";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE tests SET number_of_attempts=?, timeLimit=?, ballToPass=?, topicId=? WHERE id=?";
    }

    @Override
    protected List<Tests> resultSetToEntities(ResultSet rs) throws SQLException {
        List <Tests> tests = new ArrayList<>();
        while (rs.next()){
            Tests test = new Tests(rs.getInt(1), rs.getInt(2),
                    rs.getInt(3), rs.getInt(4),rs.getInt(5));

            tests.add(test);
        }
        return tests;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, Tests tests) throws SQLException {
        ps.setInt(1,tests.getId());
        ps.setInt(2,tests.getNumber_of_attempts());
        ps.setInt(3,tests.getTimeLimit());
        ps.setInt(4,tests.getBallToPass());
        ps.setInt(5,tests.getTopicId());
    }

    @Override
    protected String getSaveQuery() {
        return "INSERT INTO tests VALUES(null, ?, ?, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, Tests tests) throws SQLException {
        ps.setInt(1,tests.getNumber_of_attempts());
        ps.setInt(2, tests.getTimeLimit());
        ps.setInt(3, tests.getBallToPass());
        ps.setInt(4, tests.getTopicId());
    }
}
