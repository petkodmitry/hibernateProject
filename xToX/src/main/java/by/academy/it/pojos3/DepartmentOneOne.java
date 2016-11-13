package by.academy.it.pojos3;

import java.io.Serializable;

public class DepartmentOneOne implements Serializable{
    private static final long serialVersionUID = 2L;
    private Integer eid;
    private String street;
    private String city;
    private String state;
    private EmployeeOneOne employee;

    public DepartmentOneOne() {}

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer did) {
        this.eid = did;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public EmployeeOneOne getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeOneOne employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DepartmentOneOne{" +
                "eid=" + eid +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
