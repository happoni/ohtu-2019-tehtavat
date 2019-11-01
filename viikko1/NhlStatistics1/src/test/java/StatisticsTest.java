
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.PlayerReader;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        } 
    };

    Statistics stats;

    @Before
    public void setUp() {
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchPlayerReturnsCorrectPlayer() {
        Player p1 = stats.search("Semenko");
        Player p2 = stats.search("Happola");
        assertEquals(null, p2);
        assertEquals("EDM", p1.getTeam());
    }
    
    @Test
    public void teamReturnsAllTeamsPlayers() {
        List<Player> players = stats.team("EDM");
        assertEquals(3, players.size());
    }
    
    @Test
    public void topScorersReturnsCorrectPlayers() {
        List<Player> scorers = stats.topScorers(3);
        assertEquals("Gretzky", scorers.get(0).getName());
        assertEquals("Lemieux", scorers.get(1).getName());
    }
    
    
}
