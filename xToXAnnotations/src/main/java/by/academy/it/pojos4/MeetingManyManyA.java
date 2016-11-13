package by.academy.it.pojos4;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MeetingManyManyA implements Serializable{
    private static final long serialVersionUID = 2L;
    private int mid;
    private String subject;
    private Set<EmployeeManyManyA> employees = new HashSet<EmployeeManyManyA>();

    public MeetingManyManyA() {}

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Set<EmployeeManyManyA> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeManyManyA> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        String allEmployees = "";
        for (EmployeeManyManyA empl : employees) {
            allEmployees = allEmployees.concat(empl.getEid() + ", ");
        }
        return "MeetingManyManyA{" +
                "subject='" + subject + '\'' +
                ", employees=" + allEmployees +
                '}';
    }
}
