import entities.Student;
import repository.InMemoryStudent;
import service.StudentMananger;

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Tunahan","Karabayır","12345678910",0);
        Student s2 = new Student("Student2","S2","11111111111",1);
        Student s3 = new Student("Student3","S3","22222222222",1);
        Student s4 = new Student("Student4","S4","33333333333",1);
        Student s5 = new Student("Student5","S5","44444444444",2);
        Student s6 = new Student("Student5","S5","44444444444",2);



        InMemoryStudent inMemoryStudent = new InMemoryStudent();
        StudentMananger studentMananger = new StudentMananger(inMemoryStudent);



        studentMananger.add(s1);
        studentMananger.add(s2);
        studentMananger.add(s3);
        studentMananger.add(s4);
        studentMananger.add(s5);
       // studentMananger.add(s6);

        for(Student student :studentMananger.getAllStudents()){
            System.out.println(student.getStudentNo()+student.getFirstName());
        }

        studentMananger.deleteByNationalIdentity("44444444444");

        for(Student student :studentMananger.getAllStudents()){
            System.out.println(student.getStudentNo()+student.getFirstName());
        }

        studentMananger.updateByNationalIdentity("12345678910",new Student("Tunahan","www","12345678910",0));
        for(Student student :studentMananger.getAllStudents()){
            System.out.println(student.getStudentNo()+student.getFirstName());
        }
    }
}