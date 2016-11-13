package by.academy.it.pojos2;

public class EmployeeSubclass extends PersonSubclass{
    private static final long serialVersionUID = 3L;
    private String company;
    private Double salary;

    public EmployeeSubclass() {
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
        return "EmployeeSubclass{" +
                "company='" + company + '\'' +
                ", salary=" + salary +
                '}';
    }
}
