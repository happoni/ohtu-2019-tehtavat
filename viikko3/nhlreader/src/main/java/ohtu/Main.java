package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);

        ArrayList<Player> finns = new ArrayList<>();
        
        System.out.println("Players from Finland");
        System.out.println();
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                finns.add(player);
            }
        }
        for (Player f : finns) {
            System.out.println(f);
        }
    }

}
