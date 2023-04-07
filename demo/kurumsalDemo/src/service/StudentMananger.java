package service;

import entities.Student;
import repository.InMemoryStudent;

import java.util.List;
import java.util.stream.Collectors;

public class StudentMananger implements  StudentService{

    private InMemoryStudent inMemoryStudent;

    public StudentMananger(InMemoryStudent inMemoryStudent){
        this.inMemoryStudent = inMemoryStudent;
    }

    @Override
    public List<Student> getAllStudents() {
        return inMemoryStudent.getAllStudents();
    }

    @Override
    public void add(Student student) {
        checkStudentForCreate(student.getStudentNo(),student.getNationalIdentity());
        inMemoryStudent.add(student);
    }

    @Override
    public void updateByStudentNo(String studentNo, Student updateStudent) {
        checkIfStudentExistsByStudentNo(studentNo);
        inMemoryStudent.updateByStudentNo(studentNo,updateStudent);
    }

    @Override
    public void updateByNationalIdentity(String nationalIdentity, Student updateStudent) {
        checkIfStudentExistsByNationalIdentity(nationalIdentity);
        inMemoryStudent.updateByNationalIdentity(nationalIdentity,updateStudent);
    }

    @Override
    public void deleteByStudentNo(String studentNo) {
        checkIfStudentExistsByStudentNo(studentNo);
        inMemoryStudent.deleteByStudentNo(studentNo);
    }

    @Override
    public void deleteByNationalIdentity(String nationalIdentity) {
        checkIfStudentExistsByNationalIdentity(nationalIdentity);
        inMemoryStudent.deleteByNationalIdentity(nationalIdentity);
    }



    private void checkStudentForCreate(String stundentNo, String nationalIdentity){
        if(inMemoryStudent.findByStudentNo(stundentNo).isPresent())
            throw  new RuntimeException(stundentNo+" numaralı öğrenci zaten mevcut");
        else if (inMemoryStudent.findByNationalIdentity(nationalIdentity).isPresent())
            throw  new RuntimeException(nationalIdentity+" kimlik numaralı öğrenci zaten mevcuttur.");
        else
            System.out.println("Kontrol başarılı, öğrenci eklenebilir.");
    }


    private void checkIfStudentExistsByStudentNo(String studentNo){
        if(inMemoryStudent.findByStudentNo(studentNo).isEmpty())
            throw  new RuntimeException(studentNo+" numaralı öğrenci mevcut değildir");
    }

    private void checkIfStudentExistsByNationalIdentity(String nationalIdentity){
        if(inMemoryStudent.findByNationalIdentity(nationalIdentity).isEmpty())
            throw new RuntimeException(nationalIdentity+" kimlik numaralı öğrenci mevcut değildir");
    }
}
