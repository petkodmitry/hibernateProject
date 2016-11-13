package by.academy.it.pojos2;

public class StudentSubclass extends PersonSubclass{
    private static final long serialVersionUID = 3L;
    private String faculty;
    private Double mark;

    public StudentSubclass() {
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "EmployeeSubclass{" +
                "faculty='" + faculty + '\'' +
                ", mark=" + mark +
                '}';
    }
}
