package timofeeva.learn.time.entity;

/**
 * Created by toshiba on 24.03.2017.
 */
public class Tests {
    private int id;
    private int number_of_attempts;
    private int timeLimit;
    private int ballToPass;
    private  int topicId;

    public Tests(int id, int number_of_attempts, int timeLimit, int ballToPass, int topicId) {
        this.id = id;
        this.number_of_attempts = number_of_attempts;
        this.timeLimit = timeLimit;
        this.ballToPass = ballToPass;
        this.topicId = topicId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_of_attempts() {
        return number_of_attempts;
    }

    public void setNumber_of_attempts(int number_of_attempts) {
        this.number_of_attempts = number_of_attempts;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getBallToPass() {
        return ballToPass;
    }

    public void setBallToPass(int ballToPass) {
        this.ballToPass = ballToPass;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
}
