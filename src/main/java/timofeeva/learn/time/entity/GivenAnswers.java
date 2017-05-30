package timofeeva.learn.time.entity;

/**
 * Created by toshiba on 24.03.2017.
 */
public class GivenAnswers {
    private  int id;
    private int historyId;
    private  int answerId;

    public GivenAnswers(int id, int historyId, int answerId) {
        this.id = id;
        this.historyId = historyId;
        this.answerId = answerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int historyId){
        this.historyId = historyId;
    }

    public int getHistoryId() {
        return historyId;
    }

    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
}
