public class Student {
    private int rollno ;
    private String name ;
    private  static String college = "ABC";
    Student(int r,String n){
        rollno = r;
        name = n ;
    }

    public Student() {
    }

    static void  change(){
        college = "CODEGYM";
    }
    void display(){
        System.out.println(rollno + " "+ name + " "+ college);
    }
//    static Student student = new Student();

//    static {
//        System.out.println("static block is invoked");
//        System.exit(0);
//    }

    public static void main(String[] args) {
        Student.change();
        Student s1 =new Student(111,"Hoang");
        Student s2 = new Student(222,"Khanh");
        Student s3 = new Student(333,"Nam");
        s1.display();
        s2.display();
        s3.display();
    }
}
