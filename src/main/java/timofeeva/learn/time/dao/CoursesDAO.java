package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Courses;
import timofeeva.learn.time.entity.Students;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 06.04.2017.
 */
public class CoursesDAO extends AbstractDAO <Courses> {
    @Override
    protected Courses resultSetToEntity(ResultSet rs) throws SQLException {
        Courses course = null;
        while(rs.next()){
            course = new Courses(rs.getInt(1),
                    rs.getString(2), rs.getInt(3),
                    rs.getInt(4));
        }
        return course;
    }

    @Override
    protected String getTableName() {
        return "courses";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE courses SET name=?, price=?, time=? WHERE id=?";
    }

    @Override
    protected List<Courses> resultSetToEntities(ResultSet rs) throws SQLException {
        List <Courses> courses = new ArrayList<>();
        while (rs.next()){
            Courses course = new Courses(rs.getInt(1),
                    rs.getString(2), rs.getInt(3),
                    rs.getInt(4));

            courses.add(course);
        }
        return courses;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, Courses courses) throws SQLException {
        ps.setInt(1,courses.getId());
        ps.setString(2, courses.getName());
        ps.setInt(3,courses.getPrice());
        ps.setInt(4,courses.getTime());
    }

    @Override
    protected String getSaveQuery() {
        return "INSERT INTO courses VALUES(null, ?, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, Courses courses) throws SQLException {
        ps.setString(1, courses.getName());
        ps.setInt(2, courses.getPrice());
        ps.setInt(3, courses.getTime());
    }
}
