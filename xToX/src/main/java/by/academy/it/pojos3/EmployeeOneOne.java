package by.academy.it.pojos3;

import java.io.Serializable;

public class EmployeeOneOne implements Serializable{
    private static final long serialVersionUID = 2L;
    private Integer eid;
    private String name;
    private String surname;

    private DepartmentOneOne details;

    public EmployeeOneOne() {}

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

    public DepartmentOneOne getDetails() {
        return details;
    }

    public void setDetails(DepartmentOneOne details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "EmployeeOneOne{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", details=" + details +
                '}';
    }
}
