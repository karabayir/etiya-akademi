package repository;

import entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryStudent {

    List<Student> studentList = new ArrayList<>();

    public List<Student> getAllStudents(){
        return studentList;
    }


    public Student add(Student student){
        studentList.add(student);
        System.out.println(student.getFirstName()+" eklendi");
        return  student;
    }

    public void deleteByStudentNo(String studentNo){

        Student student = findByStudentNo(studentNo).get();
        studentList.remove(student);
        System.out.println(studentNo+" numaralı öğrenci kaldırıldı");
    }

    public void deleteByNationalIdentity(String nationalIdentity){
        Student student = findByNationalIdentity(nationalIdentity).get();
        studentList.remove(student);
        System.out.println(nationalIdentity+" kimlik numaralı öğrenci kaldırıldı");
    }

    public void updateByStudentNo(String studentNo, Student updateStudent){
        Student student=findByStudentNo(studentNo).get();
        studentList.set(studentList.indexOf(student),updateStudent);
        System.out.println(studentNo+" numaralı öğrenci güncellendi");
    }

    public void updateByNationalIdentity(String nationalIdentity, Student updateStudent){
        Student student = findByNationalIdentity(nationalIdentity).get();
        studentList.set(studentList.indexOf(student),updateStudent);
        System.out.println(nationalIdentity+" kimlik numaralı öğrenci güncellendi.");
    }


    public Optional<Student>  findByStudentNo(String studentNo){
        return  studentList.stream()
                .filter(s-> s.getStudentNo().equals(studentNo))
                .findAny();

    }

    public Optional<Student> findByNationalIdentity(String nationalIdentity){
        return studentList.stream()
                .filter(s-> s.getNationalIdentity().equals(nationalIdentity))
                .findAny();
    }
}
