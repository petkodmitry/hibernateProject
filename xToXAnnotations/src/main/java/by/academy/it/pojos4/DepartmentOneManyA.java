package by.academy.it.pojos4;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class DepartmentOneManyA implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer did;
    private String depName;
    private Set<EmployeeOneManyA> employees = new HashSet<EmployeeOneManyA>();

    public DepartmentOneManyA() {}

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

    public Set<EmployeeOneManyA> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeOneManyA> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        String allEmployees = "";
        for (EmployeeOneManyA empl : employees) {
            allEmployees = allEmployees.concat(empl.getEid() + ", ");
        }
        return "DepartmentOneManyA{" +
                "depName='" + depName + '\'' +
                ", employees=" + allEmployees +
                '}';
    }
}
