package by.academy.it.pojos3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DepartmentOneMany implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer did;
    private String depName;
    private Set<EmployeeOneMany> employees = new HashSet<EmployeeOneMany>();

    public DepartmentOneMany() {}

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<EmployeeOneMany> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeOneMany> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "DepartmentOneMany{" +
                "employees.size=" + employees.size() +
                ", depName='" + depName + '\'' +
                '}';
    }
}
