package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;
import timofeeva.learn.time.entity.TestsHistory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 06.04.2017.
 */
public class TestsHistoryDAO extends AbstractDAO <TestsHistory> {
    @Override
    protected TestsHistory resultSetToEntity(ResultSet rs) throws SQLException {
        TestsHistory testHistory = null;
        while(rs.next()){
            testHistory = new TestsHistory(rs.getInt(1), rs.getInt(2),
                    rs.getInt(3), rs.getInt(4), rs.getInt(5));
        }
        return testHistory;
    }

    @Override
    protected String getTableName() {
        return "testsHistory";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE testsHistory SET numberOfTry=?, dateTime=?, countBall=?, studentId=?" +
                " WHERE id=?";
    }

    @Override
    protected List<TestsHistory> resultSetToEntities(ResultSet rs) throws SQLException {
        List <TestsHistory> testsHistory = new ArrayList<>();
        while (rs.next()){
            TestsHistory testHistory = new TestsHistory(rs.getInt(1), rs.getInt(2),
                    rs.getInt(3), rs.getInt(4), rs.getInt(5));

            testsHistory.add(testHistory);
        }
        return testsHistory;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, TestsHistory testsHistory) throws SQLException {
        ps.setInt(1,testsHistory.getId());
        ps.setInt(2,testsHistory.getNumberOfTry());
        ps.setInt(3,testsHistory.getDateTime());
        ps.setInt(4,testsHistory.getCountBall());
        ps.setInt(5,testsHistory.getStudentId());
    }

    @Override
    protected String getSaveQuery() {
        return "INSERT INTO testsHistory VALUES(null, ?, ?, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, TestsHistory testsHistory) throws SQLException {
        ps.setInt(1, testsHistory.getNumberOfTry());
        ps.setInt(2, testsHistory.getDateTime());
        ps.setInt(3, testsHistory.getCountBall());
        ps.setInt(4, testsHistory.getStudentId());
    }
}
