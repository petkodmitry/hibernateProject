package by.academy.it.pojos4;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class EmployeeManyManyA implements Serializable{
    private static final long serialVersionUID = 2L;
    private Integer eid;
    private String name;
    private String surname;
    private Set<MeetingManyManyA> meetings = new HashSet<MeetingManyManyA>();

    public EmployeeManyManyA() {}

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

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
