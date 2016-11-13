package by.academy.it.pojos2;

public class StudentJoined extends PersonJoined{
    private static final long serialVersionUID = 4L;
    private String faculty;
    private Double mark;

    public StudentJoined() {
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
        return "StudentJoined{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age='" + getAge() + '\'' +
                ", faculty='" + faculty + '\'' +
                ", mark=" + mark +
                '}';
    }
}
