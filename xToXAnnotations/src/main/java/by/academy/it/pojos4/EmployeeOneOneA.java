package by.academy.it.pojos4;

import javax.persistence.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_person_oneone")
public class EmployeeOneOneA implements Serializable{
    private static final long serialVersionUID = 2L;
    private Integer eid;
    private String name;
    private String surname;
    private DepartmentOneOneA details;

    public EmployeeOneOneA() {}

    @Id
    @Column(name = "f_eid", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    @Column(name = "f_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "f_surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
//    @JoinColumn(name = "f_eid", referencedColumnName = "eid")
    public DepartmentOneOneA getDetails() {
        return details;
    }

    public void setDetails(DepartmentOneOneA details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "EmployeeOneOneA{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", details=" + details +
                '}';
    }
}
