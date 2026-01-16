package SMS;

//POJO class that encapsulates a students data
public class Student {

    // Student private Fields
    private int stud_id;
    private String stud_name;
    private int stud_age;

    // Parameterized Constructor Method
    public Student(int stud_id, String stud_name, int stud_age) {
        this.stud_id = stud_id;
        this.stud_name = stud_name;
        this.stud_age = stud_age;
    }

    // Public Getters and Setters Method

    // Student ID
    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    // Student Name
    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    // Student Age
    public int getStud_age() {
        return stud_age;
    }

    public void setStud_age(int stud_age) {
        this.stud_age = stud_age;
    }

    // Student details display using toString method
    @Override
    public String toString() {
        return "Student ID: " + stud_id + ", Name: " + stud_name + ", Age: " + stud_age;
    }
}