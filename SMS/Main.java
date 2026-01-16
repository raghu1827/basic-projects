package SMS;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Student Service class object
        StudentService service = new StudentService();

        // Scanner object
        Scanner scan = new Scanner(System.in);

        // To choose menu option
        int choice;

        do {
            // Student Menu
            System.out.println("***** Student Managament System*****");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Find Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("Enter choice: ");

            choice = scan.nextInt();

            switch (choice) {

                // Add student
                case 1:
                    System.out.println("Enter ID: ");
                    int id = scan.nextInt();
                    scan.nextLine();

                    System.out.println("Enter Name: ");
                    String name = scan.nextLine();

                    System.out.println("Enter Age: ");
                    int age = scan.nextInt();

                    Student student = new Student(id, name, age);
                    if (service.addStudent(student)) {
                        System.out.println("Student added successfully.");
                    } else {
                        System.out.println("Student already exists or invalid input.");
                    }
                    break;

                // View All Students
                case 2:
                    List<Student> students = service.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        students.forEach(System.out::println);
                    }
                    break;

                // Find Student
                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = scan.nextInt();
                    Student found = service.findStudentById(searchId);
                    System.out.println(found != null ? found : "Student not found.");
                    break;

                // Update Student
                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = scan.nextInt();
                    scan.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scan.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = scan.nextInt();

                    if (service.updateStudent(updateId, newName, newAge)) {
                        System.out.println("Student updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                // Delete Student
                case 5: // Delete Student
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scan.nextInt();

                    if (service.deleteStudent(deleteId)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                // Exit
                case 6:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
        scan.close();
    }
}
