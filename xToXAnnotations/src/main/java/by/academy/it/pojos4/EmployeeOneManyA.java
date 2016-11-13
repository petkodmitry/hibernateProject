package by.academy.it.pojos4;

import java.io.Serializable;

public class EmployeeOneManyA implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer eid;
    private String name;
    private String surname;
    private DepartmentOneManyA department;

    public EmployeeOneManyA() {}

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DepartmentOneManyA getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentOneManyA department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeOneManyA{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department=" + department +
                '}';
    }
}
