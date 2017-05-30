package timofeeva.learn.time.entity;

/**
 * Created by toshiba on 24.03.2017.
 */
public class Students {
    private int id;
    private String password;
    private String name;
    private String login;
    private String eMail;


    public Students(int id, String password, String name, String login) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.login = login;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Students(int id) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", password=" + password +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
