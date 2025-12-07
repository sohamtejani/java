package wrapper;

public class Demo {
    public static void main(String[] args) {
        int a = 1;
        Integer b = 2;
        Integer c = Integer.valueOf(1); // behind the scene (boxing)

        int d = c.intValue(); // unboxing

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));

        Integer i1 = 1, i2 = 1;
        int x = 1, y = 1;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));
        System.out.println(x == y);


        String s = "123";
        Integer i = Integer.valueOf(s);

        Student stu = new Student(1);
        changeId(stu);
        System.out.println(stu.id);

        changeIdActually(stu);
        System.out.println(stu.id);

        int e = 10;
        Integer f = 10;

        half(f);
        half(e);

        System.out.println(f);
        System.out.println(e);

    }

    public static void half(int i){
        i = 5;
    }
    public static void half(Integer i){
        // currently i hold reference of actual 10, now reference is pointing to reference of new Integer(10)
        i = 5;
    }
    public static void changeId(Student s){
        Student s2 = new Student(2);
        s2 = s;
    }
    public static void changeIdActually(Student s){
        s.id = 2;
    }
}

class Student{
    int id;

    public Student(int id) {
        this.id = id;
    }
}
