package by.academy.it.pojos2;

public class EmployeeJoined extends PersonJoined{
    private static final long serialVersionUID = 4L;
    private String company;
    private Double salary;

    public EmployeeJoined() {
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeJoined{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age='" + getAge() + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }
}
