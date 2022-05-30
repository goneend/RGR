package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "teams")
public class Team implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "nameGame", nullable = false, length = 50)
    private String nameGame;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team")
    private List<Player> players;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team1")
    private Set<Game> games1;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "team2")
    private Set<Game> games2;

    @ManyToMany
    @JoinTable (name="t_teams_tournaments",
            joinColumns=@JoinColumn (name="team_id"),
            inverseJoinColumns=@JoinColumn(name="tournament_id"))
    private List<Tournament> tournaments;

    @Temporal(TemporalType.DATE)
    @Column(name = "statusDate", length = 10)
    private Date statusDate;

    public Team() {

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

    public String getNameGame() {
        return nameGame;
    }

    public void setNameGame(String nameGame) {
        this.nameGame = nameGame;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Set<Game> getGames1() {
        return games1;
    }

    public void setGames1(Set<Game> games1) {
        this.games1 = games1;
    }

    public Set<Game> getGames2() {
        return games2;
    }

    public void setGames2(Set<Game> games2) {
        this.games2 = games2;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
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