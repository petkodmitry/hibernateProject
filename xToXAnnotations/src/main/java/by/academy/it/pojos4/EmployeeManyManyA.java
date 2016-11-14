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
@Table(name = "t_person_manymany")
public class EmployeeManyManyA implements Serializable {
    private static final long serialVersionUID = 2L;
    private Integer eid;
    private String name;
    private String surname;
    private Set<MeetingManyManyA> meetings = new HashSet<MeetingManyManyA>();

    public EmployeeManyManyA() {}

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @ManyToMany(targetEntity = MeetingManyManyA.class)
    @Cascade(CascadeType.SAVE_UPDATE)   // обновляет все связанные митинги
//    @Cascade(CascadeType.ALL)           // удаляет все связанные митинги
    @JoinTable(name = "t_employee_meeting"
            , joinColumns = @JoinColumn(name = "f_eid2")
            , inverseJoinColumns = @JoinColumn(name = "f_mid2")
    )
    public Set<MeetingManyManyA> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<MeetingManyManyA> meetings) {
        this.meetings = meetings;
    }

    @Override
    public String toString() {
        String allMeetings = "";
        for (MeetingManyManyA meet : meetings) {
            allMeetings = allMeetings.concat(meet + ", ");
        }
        return "EmployeeManyManyA{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", meetings=" + allMeetings +
                '}';
    }
}
