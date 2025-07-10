import java.util.List;

public class BusinessLogicService {
    private StudentDAO dao = new StudentDAO();

    public boolean addStudent(Student student) {
        if (dao.exists(student.getId())) return false;
        dao.save(student);
        return true;
    }

    public List<Student> getAllStudents() {
        return dao.findAll();
    }

    public Student getStudent(int id) {
        return dao.findById(id);
    }

    public boolean deleteStudent(int id) {
        if (!dao.exists(id)) return false;
        dao.delete(id);
        return true;
    }

    public boolean updateStudent(int id, String name, String course) {
        Student s = dao.findById(id);
        if (s == null) return false;
        s.setName(name);
        s.setCourse(course);
        dao.save(s);  // re-save to update
        return true;
    }
}
