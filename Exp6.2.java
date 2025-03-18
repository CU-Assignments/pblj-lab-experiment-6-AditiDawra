implement Java program that uses lambda expressions and Stream API to filter students who scored above 75%, sort them by marks, and display their names.

Step 1: Create the Student Class
- Define a Student class with attributes:
    name (String)
    marks (double)
- Implement a constructor to initialize these values.
- Add a display method to print student details.

Step 2: Create the StudentFilterSort Class
- Create a list of students with sample data.
- Use Streams Class to:
      Filter students who scored above 75%.
      Sort students by marks in descending order.
      Collect the results into a new list.
- Use forEach() with a method reference to display results.ts.


Test Case	                        Input Data	                                                 Expected Output
Case 1:         Normal Case	Alice (80), Bob (72), Charlie (90), David (65), Eve (85)	         Charlie, Eve, Alice (Sorted by marks)
Case 2:         All Below 75%	Bob (70), David (60), Frank (65)	                               No output (Empty List)
Case 3:         Same Marks	Alice (80), Bob (80), Charlie (85)                                 Charlie, Alice, Bob (Sorted by marks, then by name)
Case 4:         Single Student Above 75%	Alice (60), Bob (50), Charlie (90)	                 Charlie (Only one student)
    Code:
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private double marks;

    // Constructor
    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public String getName() { return name; }
    public double getMarks() { return marks; }

    // Display method
    public void display() {
        System.out.println("Name: " + name + ", Marks: " + marks);
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 78));
        students.add(new Student("Bob", 72));
        students.add(new Student("Charlie", 85));
        students.add(new Student("David", 90));
        students.add(new Student("Eve", 65));

        // Filter students with marks above 75%, sort by marks in descending order
        List<Student> filteredSortedStudents = students.stream()
                .filter(s -> s.getMarks() > 75) // Filter condition
                .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks())) // Sort in descending order
                .collect(Collectors.toList()); // Collect to a new list

        // Display the filtered and sorted students
        System.out.println("Students who scored above 75% (Sorted by Marks):");
        filteredSortedStudents.forEach(Student::display);
    }
}

