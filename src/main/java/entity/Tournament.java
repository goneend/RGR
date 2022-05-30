package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tournaments")
public class Tournament implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "prizeFund", nullable = false, length = 30)
    private double prizeFund;

    @Column(name = "venue", nullable = false, length = 50)
    private String venue;

    @ManyToMany
    @JoinTable (name="t_teams_tournaments",
            joinColumns=@JoinColumn (name="tournament_id"),
            inverseJoinColumns=@JoinColumn(name="team_id"))
    private List<Team> teams;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tournament")
    private List<Game> games;

    @Temporal(TemporalType.DATE)
    @Column(name = "statusDate", length = 10)
    private Date statusDate;

    public Tournament() {

    }

    public Tournament(String name, double prizeFund, String venue, Date statusDate) {
        this.name = name;
        this.prizeFund = prizeFund;
        this.venue = venue;
        this.statusDate = statusDate;
    }

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

    public double getPrizeFund() {
        return prizeFund;
    }

    public void setPrizeFund(double prizeFund) {
        this.prizeFund = prizeFund;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public String toString() {
        return "Турнир " + this.getName() + " в " + this.getVenue();
    }
}
