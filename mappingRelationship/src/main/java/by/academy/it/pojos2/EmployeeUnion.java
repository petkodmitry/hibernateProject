package by.academy.it.pojos2;

public class EmployeeUnion extends PersonUnion{
    private static final long serialVersionUID = 5L;
    private String company;
    private Double salary;

    public EmployeeUnion() {
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
        return "EmployeeUnion{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age='" + getAge() + '\'' +
                ", company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }
}
