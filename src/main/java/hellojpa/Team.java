package hellojpa;


import javax.persistence.*;
import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
@Id @GeneratedValue
@Column(name = "TEAM_ID")
    private Long id;
private String  name;
@OneToMany(fetch = FetchType.LAZY)
private List<Member>    members=new ArrayList<>();
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
        this.members.add(member);
        if (!member.getTeam().equals(this))


        member.setTeam(this);
    }
}
