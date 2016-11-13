package by.academy.it.pojos4;

import javax.persistence.Entity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_dep_oneone")
public class DepartmentOneOneA implements Serializable{
    private static final long serialVersionUID = 2L;
    private Integer eid;
    private String street;
    private String city;
    private String state;
    private EmployeeOneOneA employee;

    public DepartmentOneOneA() {}

    @Id
    @Column(name = "f_eid", nullable = false)
    @GenericGenerator(
            name = "gennady"
            , strategy = "foreign"
            , parameters = @Parameter(name = "property", value = "employee")
    )
    @GeneratedValue(generator = "gennady")
    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    @Column
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
//    @JoinColumn(name = "f_eid", referencedColumnName = "eid")
    public EmployeeOneOneA getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeOneOneA employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "DepartmentOneOneA{" +
                "eid=" + eid +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
