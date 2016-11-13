package by.academy.it.pojos3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class MeetingManyMany implements Serializable{
    private static final long serialVersionUID = 2L;
    private int mid;
    private String subject;
    private Set<EmployeeManyMany> employees = new HashSet<EmployeeManyMany>();

    public MeetingManyMany() {}

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

    public Set<EmployeeManyMany> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeManyMany> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        String allEmployees = "";
        for (EmployeeManyMany empl : employees) {
            allEmployees = allEmployees.concat(empl.getEid() + ", ");
        }
        return "MeetingManyMany{" +
                "subject='" + subject + '\'' +
                ", employees=" + allEmployees +
                '}';
    }
}
