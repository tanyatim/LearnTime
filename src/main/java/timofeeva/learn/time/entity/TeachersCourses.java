package timofeeva.learn.time.entity;

/**
 * Created by toshiba on 24.03.2017.
 */
public class TeachersCourses {
    private int id;
    private  int teacherId;
    private  int courseId;

    public TeachersCourses(int id, int teacherId, int courseId) {
        this.id = id;
        this.teacherId = teacherId;
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
