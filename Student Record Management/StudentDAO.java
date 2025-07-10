import java.util.*;

public class StudentDAO {
    private Map<Integer, Student> studentMap = new HashMap<>();

    public void save(Student student) {
        studentMap.put(student.getId(), student);
    }

    public Student findById(int id) {
        return studentMap.get(id);
    }

    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    public void delete(int id) {
        studentMap.remove(id);
    }

    public boolean exists(int id) {
        return studentMap.containsKey(id);
    }
}
