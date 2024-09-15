package JavaProject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

class Student {
    private String name;
    private String rollNumber;
    private String grade;
    private Integer age;
    private String address;

    public Student(String name, String rollNumber, String grade, Integer age, String address) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.age = age;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + ", Age: " + age + ", Address: " + address;
    }
}
class StudentManagementSystem {
    private List<Student> students;
    public StudentManagementSystem() {
        students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(String rollNumber) {
        students.removeIf(student -> student.getRollNumber().equals(rollNumber));
    }
    public Student searchStudent(String rollNumber) {
        Optional<Student> student = students.stream()
                                             .filter(s -> s.getRollNumber().equals(rollNumber))
                                             .findFirst();
        return student.orElse(null);
    }
    public void displayAllStudents() {
        students.forEach(System.out::println);
    }
}
public class Studentmanagement {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty.");
                        continue;
                    }
                    System.out.print("Enter student's roll number: ");
                    String rollNumber = scanner.nextLine();
                    if (rollNumber.isEmpty()) {
                        System.out.println("Roll number cannot be empty.");
                        continue;
                    }
                    System.out.print("Enter student's grade: ");
                    String grade = scanner.nextLine();
                    if (grade.isEmpty()) {
                        System.out.println("Grade cannot be empty.");
                        continue;
                    }
                    System.out.print("Enter student's age (optional): ");
                    String ageInput = scanner.nextLine();
                    Integer age = ageInput.isEmpty() ? null : Integer.parseInt(ageInput);
                    System.out.print("Enter student's address (optional): ");
                    String address = scanner.nextLine();
                    Student student = new Student(name, rollNumber, grade, age, address);
                    sms.addStudent(student);
                    break;
                case "2":
                    System.out.print("Enter student's roll number to remove: ");
                    rollNumber = scanner.nextLine();
                    sms.removeStudent(rollNumber);
                    break;
                case "3":
                    System.out.print("Enter student's roll number to search: ");
                    rollNumber = scanner.nextLine();
                    Student foundStudent = sms.searchStudent(rollNumber);
                    if (foundStudent != null) {
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case "4":
                    sms.displayAllStudents();
                    break;
                case "5":
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
