package hellojpa;

import javax.persistence.*;

@Entity
public class Member {
@Id @GeneratedValue
private Long id;
private String username;
private int age;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "TEAM_ID")
private Team team;
@Enumerated(EnumType.STRING)
private MemberType type;
    public Member(Long id, String username, int age, Team team) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.team = team;
    }

    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void changeTeam(Team team)
    {
        this.team=team;
        this.team.addMember(this);
    }
    public void setTeam(Team team) {
        this.team=team;
        if (team.getMembers().contains(this)) return;
        else
          this.team.addMember(this);
    }
}