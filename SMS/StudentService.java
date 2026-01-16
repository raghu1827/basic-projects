package SMS;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentService {

    // List to Store students details
    private List<Student> students = new ArrayList<>();

    // CRUD Operations on Student

    // Add student
    public boolean addStudent(Student student) {
        if (student == null || findStudentById(student.getStud_id()) != null) {
            return false;
        }
        students.add(student);
        return true;
    }

    // Get all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Find student by ID
    public Student findStudentById(int id) {
        for (Student stud : students) {
            if (stud.getStud_id() == id) {
                return stud;
            }
        }
        return null;
    }

    // Update student
    public boolean updateStudent(int id, String name, int age) {
        Student student = findStudentById(id);
        if (student == null) {
            return false;
        }

        student.setStud_name(name);
        student.setStud_age(age);
        return true;
    }

    // Delete student
    public boolean deleteStudent(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getStud_id() == id) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }
}
