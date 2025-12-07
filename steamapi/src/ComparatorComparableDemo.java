import java.lang.reflect.Array;
import java.util.*;

class Student{
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public double getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}

class Employee implements  Comparable<Employee>{
    private String name;
    private int id;

    public Employee(String name, int marks) {
        this.name = name;
        this.id = marks;
    }

    public double getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Employee thatEmployee) {
        if(this.getId() > thatEmployee.getId()){
            return 1;
        }
        else if(this.getId() < thatEmployee.getId()){
            return -1;
        }
        else{
            return 0;
        }
    }
}

public class ComparatorComparableDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(44, 71, 37, 14, 29, 87);

        Collections.sort(nums);
        // we can do this only if Integer class implements Comparable interface and has defined sorting logic in the compareTo method.


        Comparator<Integer> comparator = (i1, i2) -> {
                if(i1 % 10 > i2 % 10) return 1; // return 1 if wanted to swap
                else if(i1 % 10 < i2 % 10) return -1;
                return 0;
            };

        Collections.sort(nums, comparator); // we can define the custom sort ordering by having comparator.

        System.out.println("Numbers:");
        System.out.println(nums);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Soham", 80));
        students.add(new Student("Veer", 95));
        students.add(new Student("Varad", 90));
        students.add(new Student("Bob", 85));

        // Collections.sort(students); // we can not do this b/c Student does not implement the Comparable interface.

        Collections.sort(students, (Student s1, Student s2) -> {
            if(s1.getMarks() > s2.getMarks()){
                return -1;
            }
            else if(s1.getMarks() < s2.getMarks()){
                return 1;
            }
            return 0;
        });

        System.out.println("Students:");
        System.out.println(students);


        // Comparable interface
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Soham", 12));
        employees.add(new Employee("Veer", 95));
        employees.add(new Employee("Varad", 90));
        employees.add(new Employee("Bob", 85));

        Collections.sort(employees); // default sorting

        System.out.println("Employees:");
        System.out.println(employees);

        Collections.sort(employees, (Employee s1, Employee s2) -> {
            if(s1.getName().length() > s2.getName().length()){
                return 1;
            }
            else if(s1.getName().length() < s2.getName().length()){
                return -1;
            }
            return 0;
        }); // Custom sorting

        System.out.println("Employees:");
        System.out.println(employees);


        // Comparator interface
        List<Book> books = new ArrayList<>();
        books.add(new Book("System design", 400));
        books.add(new Book("OOP", 300));
        books.add(new Book("Computer network", 300));
        books.add(new Book("Operating systems", 180));

        Comparator<Book> bookComparator = Comparator.comparing(Book::getPrice).reversed().thenComparing(Book::getName);

//        Collections.sort(books, bookComparator);

        books.sort(bookComparator);

        System.out.println("Books: ");
        System.out.println(books);
    }
}

class Book{
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}