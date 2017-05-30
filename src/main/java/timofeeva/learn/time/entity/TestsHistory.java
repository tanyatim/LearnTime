package timofeeva.learn.time.entity;

/**
 * Created by toshiba on 24.03.2017.
 */
public class TestsHistory {
    private int id;
    public  int numberOfTry;
    public int dateTime;
    public int countBall;
    private int studentId;

    public TestsHistory(int id, int numberOfTry, int dateTime, int countBall, int studentId) {
        this.id = id;
        this.numberOfTry = numberOfTry;
        this.dateTime = dateTime;
        this.countBall = countBall;
        this.studentId = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }

    public void setNumberOfTry(int numberOfTry) {
        this.numberOfTry = numberOfTry;
    }

    public int getDateTime() {
        return dateTime;
    }

    public void setDateTime(int dateTime) {
        this.dateTime = dateTime;
    }

    public int getCountBall() {
        return countBall;
    }

    public void setCountBall(int countBall) {
        this.countBall = countBall;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
