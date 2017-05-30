package timofeeva.learn.time.entity;

import java.util.List;

/**
 * Created by toshiba on 24.03.2017.
 */
public class Courses {
    private int id;
    private String name;
    private int price;
    private int time;
    private List test_id;

    public List getTest_id() {
        return test_id;
    }

    public void setTest_id(List test_id) {
        this.test_id = test_id;
    }

    public Courses(int id, String name, int price, int time) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = time;
    }

    public void setId(int id){
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
