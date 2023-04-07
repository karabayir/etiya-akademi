package entities;

public class Student {

    private String firstName;
    private String lastName;
    private String studentNo;
    private String nationalIdentity;
    private int group;

    public Student() {
    }
    public Student(String firstName, String lastName, String nationalIdentity, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalIdentity = nationalIdentity;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getStudentNo() {
        String generateStudentNo=firstName.substring(0,2)+lastName.substring(0,2)+nationalIdentity.substring(0,4);
        return generateStudentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
