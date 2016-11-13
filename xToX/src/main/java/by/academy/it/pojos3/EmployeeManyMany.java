package by.academy.it.pojos3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class EmployeeManyMany implements Serializable{
    private static final long serialVersionUID = 2L;
    private Integer eid;
    private String name;
    private String surname;
    private Set<MeetingManyMany> meetings = new HashSet<MeetingManyMany>();

    public EmployeeManyMany() {}

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

    public Set<MeetingManyMany> getMeetings() {
        return meetings;
    }

    public void setMeetings(Set<MeetingManyMany> meetings) {
        this.meetings = meetings;
    }

    @Override
    public String toString() {
        String allMeetings = "";
        for (MeetingManyMany meet : meetings) {
            allMeetings = allMeetings.concat(meet + ", ");
        }
        return "EmployeeManyMany{" +
                "eid=" + eid +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", meetings=" + allMeetings +
                '}';
    }
}
