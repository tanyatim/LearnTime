package timofeeva.learn.time.entity;

/**
 * Created by toshiba on 24.03.2017.
 */
public class Teachers {
    private int id;
    private int password;
    public String name;
    public String login;

    public Teachers(int id, int password, String name, String login) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
