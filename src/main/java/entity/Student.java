package entity;

public class Student {
    private String ID;
    private String name;
    private String semester;
    private float CGPA;

    public Student() {}

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(float CGPA) {
        this.CGPA = CGPA;
    }
}
