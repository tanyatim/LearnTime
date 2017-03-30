package timofeeva.learn.time.entity;

/**
 * Created by toshiba on 24.03.2017.
 */
public class GivenAnswers {
    private int historyId;
    private  int answerId;

    public void setId(int historyId){
        this.historyId = historyId;
    }

    public int getHistoryId() {
        return historyId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
