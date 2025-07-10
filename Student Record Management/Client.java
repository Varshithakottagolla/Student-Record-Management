import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        BusinessLogicService service = new BusinessLogicService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student s = new Student(id, name, course);
                    if (service.addStudent(s))
                        System.out.println("Student added.");
                    else
                        System.out.println("ID already exists.");
                    break;

                case 2:
                    for (Student student : service.getAllStudents()) {
                        System.out.println(student);
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();
                    Student foundStudent = service.getStudent(searchId);
                    if (foundStudent != null)
                        System.out.println(foundStudent);
                    else
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();
                    if (service.updateStudent(updateId, newName, newCourse))
                        System.out.println("Updated successfully.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    if (service.deleteStudent(deleteId))
                        System.out.println("Deleted successfully.");
                    else
                        System.out.println("Student not found.");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
