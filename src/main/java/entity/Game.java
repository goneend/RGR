package entity;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "games")
public class Game implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTournament", nullable = false)
    private Tournament tournament;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTeam1", nullable = false)
    private Team team1;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTeam2", nullable = false)
    private Team team2;

    @Temporal(TemporalType.DATE)
    @Column(name = "gameDate", length = 10)
    private Date gameDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "statusDate", length = 10)
    private Date statusDate;

    public Game() {

    }

    public Game(String status, Tournament tournament, Date gameDate, Date statusDate) {
        this.status = status;
        this.tournament = tournament;
        this.gameDate = gameDate;
        this.statusDate = statusDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Date getGameDate() {
        return gameDate;
    }

    public void setGameDate(Date gameDate) {
        this.gameDate = gameDate;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return " ";
    }
}