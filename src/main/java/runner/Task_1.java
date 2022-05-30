package runner;

import entity.Game;
import entity.Player;
import entity.Tournament;
import org.hibernate.Session;

import java.util.List;

//1. Вывести даты игр определённого игрока

public class Task_1 {

    public static void Task_1(Session session) {

        List<Player> players = session.createQuery("FROM Player").list();

        System.out.println("Игрок " + players.get(0) + " играл: ");

        for (Tournament tournament : players.get(0).getTeam().getTournaments()) {
            for (Game game : tournament.getGames()) {
                System.out.println(game.getGameDate());
            }
        }
    }
}
