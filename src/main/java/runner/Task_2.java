package runner;

import entity.Player;
import entity.Team;
import entity.Tournament;
import org.hibernate.Session;

import java.util.List;

//2. Вывести всех игроков турниров каждой команды

public class Task_2 {

    public static void Task_2(Session session) {

        List<Tournament> tournaments = session.createQuery("FROM Tournament").list();

        for (Tournament tournament : tournaments) {
            System.out.println(tournament);

            for (Team team : tournament.getTeams()) {
                if (team.getPlayers().size() != 0) {
                    System.out.println("Игроки команды " + team.getName());
                    for (Player player : team.getPlayers()) {
                        System.out.println(player.getNickname());
                    }
                }
                else System.out.println("Команда " + team.getName() + " не имеет игроков.");
            }
        }
    }
}
