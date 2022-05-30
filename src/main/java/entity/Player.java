package entity;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "players")
public class Player implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "nickname", nullable = false, length = 50)
    private String nickname;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTeam", nullable = false)
    private Team team;

    @Temporal(TemporalType.DATE)
    @Column(name = "statusDate", length = 10)
    private Date statusDate;

    public Player() {

    }

    public Player(String nickname, String email, Team team, Date statusDate) {
        this.nickname = nickname;
        this.email = email;
        this.team = team;
        this.statusDate = statusDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return getNickname();
    }
}