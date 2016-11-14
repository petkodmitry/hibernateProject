package by.academy.it.pojos4;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_person_onemany")
public class EmployeeOneManyA implements Serializable{
    private static final long serialVersionUID = 1L;
    private Integer eid;
    private String name;
    private String surname;
    private DepartmentOneManyA department;

    public EmployeeOneManyA() {}

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

    @ManyToOne
    @Cascade(CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "f_did")
    public DepartmentOneManyA getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentOneManyA department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeOneManyA{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department=" + department +
                '}';
    }
}
