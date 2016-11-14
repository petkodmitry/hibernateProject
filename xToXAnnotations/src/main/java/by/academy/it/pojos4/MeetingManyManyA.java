package by.academy.it.pojos4;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_meeting_manymany")
public class MeetingManyManyA implements Serializable{
    private static final long serialVersionUID = 2L;
    private int mid;
    private String subject;
    private Set<EmployeeManyManyA> employees = new HashSet<EmployeeManyManyA>();

    public MeetingManyManyA() {}

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Column
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @ManyToMany(targetEntity = EmployeeManyManyA.class, mappedBy = "meetings")
//    @Cascade(CascadeType.SAVE_UPDATE)
//    @Cascade(CascadeType.ALL)     // удаляет всех связанных работников
    /*@JoinTable(name = "t_employee_meeting"
            , joinColumns = @JoinColumn(name = "f_mid2")
            , inverseJoinColumns = @JoinColumn(name = "f_eid2")
    )*/
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
