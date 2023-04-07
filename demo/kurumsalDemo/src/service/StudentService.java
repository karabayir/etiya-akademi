package service;

import entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();
    void add(Student student);

    void updateByStudentNo(String studentNo, Student updateStudent);

    void updateByNationalIdentity(String nationalIdentity, Student updateStudent);
    void deleteByStudentNo(String studentNo);

    void deleteByNationalIdentity(String nationalIdentity);

}
