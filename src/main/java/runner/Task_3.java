package runner;

import entity.Game;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

//3. Вывести игры выбранной датой

public class Task_3 {

    public static void Task_3(Session session) {

        List<Game> games = session.createQuery("FROM Game").list();

        Date curDate = new Date(122, 4, 2);

        for (Game game : games) {
            if (curDate.getYear() == game.getGameDate().getYear() && curDate.getMonth() == game.getGameDate().getMonth() && curDate.getDay() == game.getGameDate().getDay()) {
                System.out.println(game.getId());
            }
        }
    }
}
