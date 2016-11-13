package by.academy.it.pojos3;

import java.io.Serializable;

public class EmployeeOneMany implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer eid;
    private String name;
    private String surname;
    private DepartmentOneMany department;

    public EmployeeOneMany() {}

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

    public DepartmentOneMany getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentOneMany department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeOneMany{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department=" + department +
                '}';
    }
}
