import org.junit.Before;
import org.junit.Test;
import timofeeva.learn.time.dao.StudentsDAO;
import timofeeva.learn.time.entity.Students;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by toshiba on 24.03.2017.
 */
public class StudentsDAOTest {

    StudentsDAO dao;

    @Before
    public void init(){
        dao = new StudentsDAO();
    }
    @Test
    public void getAllStudents() throws Exception {
        List<Students> list = dao.getAllStudents();
        System.out.println(list);
    }

    @Test
    public void getById(int i) throws Exception {
        Students student = dao.getStudentById(2);
        System.out.println(student);
    }



    @Test
    public void saveNewContact() throws Exception {
        List<Students> list = dao.getAllStudents();
        int oldSize = list.size();

        dao.saveNewStudent(new Students(1,12345,"testName","testLogin"));
        list = dao.getAllStudents();
        int newsize = list.size();

        assertEquals(oldSize + 1, newsize);
    }

    @Test
    public void deleteOldStudent() throws Exception {
        List<Students> list = dao.getAllStudents();
        int oldSize = list.size();

        dao.deleteOldStudents(getId(1));
        list = dao.getAllStudents();
        int newsize = list.size();

        assertEquals(oldSize - 1, newsize);
    }


}
