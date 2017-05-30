package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;
import timofeeva.learn.time.entity.StudentsCourses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 08.04.2017.
 */
public class StudentsCoursesDAO extends AbstractDAO <StudentsCourses>{
    @Override
    protected StudentsCourses resultSetToEntity(ResultSet rs) throws SQLException {
        StudentsCourses studentCourse = null;
        while(rs.next()){
            studentCourse = new StudentsCourses(rs.getInt(1), rs.getInt(2),
                    rs.getInt(3));
        }
        return studentCourse;
    }

    @Override
    protected String getTableName() {
        return "studentsCourses";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE studentsCourses SET studentId=?, courseId=? WHERE id=?";
    }

    @Override
    protected List<StudentsCourses> resultSetToEntities(ResultSet rs) throws SQLException {
        List <StudentsCourses> studentsCourses = new ArrayList<>();
        while (rs.next()){
            StudentsCourses studentCourse = new StudentsCourses(rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3));
            studentsCourses.add(studentCourse);
        }
        return studentsCourses;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, StudentsCourses studentsCourses) throws SQLException {
        ps.setInt(1,studentsCourses.getId());
        ps.setInt(2,studentsCourses.getStudentId());
        ps.setInt(3, studentsCourses.getCourseId());
    }

    @Override
    protected String getSaveQuery() {
        return "INSERT INTO studentsCourses VALUES(null, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, StudentsCourses studentsCourses) throws SQLException {
        ps.setInt(1, studentsCourses.getStudentId());
        ps.setInt(2, studentsCourses.getCourseId());
    }
}
