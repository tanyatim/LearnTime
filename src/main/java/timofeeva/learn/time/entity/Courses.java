package timofeeva.learn.time.entity;

/**
 * Created by toshiba on 24.03.2017.
 */
public class Courses {
    private int id;
    public String name;
    public  int price;
    public  int time;

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
