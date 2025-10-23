public class Student {
    private String studentID;
    private String name;
    private Object department;
    private String address;

    public Student(String studentID, String name, Object department, String address) {
        this.studentID = studentID;
        this.name = name;
        this.department = department;
        this.address = address;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public Object getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(Object department) {
        this.department = department;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ID: " + studentID + ", Name: " + name + ", Department: " + department + ", Address: " + address;
    }
}