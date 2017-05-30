package timofeeva.learn.time.dao;

import timofeeva.learn.time.entity.Students;
import timofeeva.learn.time.entity.Teachers;
import timofeeva.learn.time.entity.TeachersCourses;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by toshiba on 08.04.2017.
 */
public class TeachersCoursesDAO extends AbstractDAO<TeachersCourses> {
    @Override
    protected TeachersCourses resultSetToEntity(ResultSet rs) throws SQLException {
        TeachersCourses teacherCourse = null;
        while(rs.next()){
            teacherCourse = new TeachersCourses(rs.getInt(1), rs.getInt(2),
                    rs.getInt(3));      }
        return teacherCourse;
    }

    @Override
    protected String getTableName() {
        return "teachersCourses";
    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE teachersCourses SET teacherId=?, courseId=? WHERE id=?";
    }


    @Override
    protected List<TeachersCourses> resultSetToEntities(ResultSet rs) throws SQLException {
        List <TeachersCourses> teachersCourses = new ArrayList<>();
        while (rs.next()){
            TeachersCourses teacherCourse = new TeachersCourses(rs.getInt(1), rs.getInt(2),
                    rs.getInt(3));

            teachersCourses.add(teacherCourse);
        }
        return teachersCourses;
    }

    @Override
    protected void updateInsertQuery(PreparedStatement ps, TeachersCourses teachersCourses) throws SQLException {
        ps.setInt(1,teachersCourses.getId());
        ps.setInt(2,teachersCourses.getTeacherId());
        ps.setInt(2,teachersCourses.getCourseId());
    }

    @Override
    protected String getSaveQuery() {
        return  "INSERT INTO teachersCourses VALUES(null, ?, ?)";
    }

    @Override
    protected void saveInsertQuery(PreparedStatement ps, TeachersCourses teachersCourses) throws SQLException {
        ps.setInt(1, teachersCourses.getTeacherId());
        ps.setInt(2, teachersCourses.getCourseId());
    }
}
