package by.academy.it.pojos2;

public class StudentUnion extends PersonUnion{
    private static final long serialVersionUID = 5L;
    private String faculty;
    private Double mark;

    public StudentUnion() {
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
        return "StudentUnion{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age='" + getAge() + '\'' +
                ", faculty='" + faculty + '\'' +
                ", mark=" + mark +
                '}';
    }
}
