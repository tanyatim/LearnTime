package timofeeva.learn.time.entity;

/**
 * Created by toshiba on 24.03.2017.
 */
public class Questions {
    private  int id;
    public String question;
    private  int testId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }
}
