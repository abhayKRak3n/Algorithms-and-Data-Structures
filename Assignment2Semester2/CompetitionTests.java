import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CompetitionTests {

    @Test
    public void testDijkstraConstructor() {
        CompetitionDijkstra dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50, 80, 60);
        assertEquals("Constructor test with valid input", dijkstra.slowest, 50);
    }

    @Test
    public void testDijkstra() {
        CompetitionDijkstra dijkstra = new CompetitionDijkstra("tinyEWD.txt", 50,80,60);
        assertEquals("Test competition with tinyEWD", 38, dijkstra.timeRequiredforCompetition());

        CompetitionDijkstra dijkstra1 = new CompetitionDijkstra("notAFile.txt", 50, 80, 60);
        assertEquals("Test competition with invalid filename", -1, dijkstra1.timeRequiredforCompetition());

        CompetitionDijkstra dijkstra2 = new CompetitionDijkstra("tinyEWD.txt", -1, 80, 60);
        assertEquals("Test competition with negative speed", -1, dijkstra2.timeRequiredforCompetition());

        CompetitionDijkstra dijkstra3 = new CompetitionDijkstra(null, 50, 80, 60);
        assertEquals("Test competition with null filename", -1, dijkstra3.timeRequiredforCompetition());

        CompetitionDijkstra dijkstra5 = new CompetitionDijkstra("input-J.txt", 98, 70, 84);
        assertEquals("Test competition with 0 0 file", -1, dijkstra5.timeRequiredforCompetition());

        CompetitionDijkstra dijkstra6 = new CompetitionDijkstra("tinyEWD.txt", 5, 80, 60);
        assertEquals("Test competition with less than 50 speed", -1, dijkstra6.timeRequiredforCompetition());

        CompetitionDijkstra dijkstra7 = new CompetitionDijkstra("input-C.txt", 50, 100, 67);
        assertEquals("Test competition with less than 50 speed", -1, dijkstra7.timeRequiredforCompetition());
   
        CompetitionDijkstra dijkstra8 = new CompetitionDijkstra("input-D.txt", 50, 80, 60);
        assertEquals("More test competitions from webcat", 38, dijkstra8.timeRequiredforCompetition());
        
        CompetitionDijkstra dijkstra9 = new CompetitionDijkstra("input-I.txt", 72, 70, 65);
        assertEquals("More test competitions from webcat", 185, dijkstra9.timeRequiredforCompetition());
        
        CompetitionDijkstra dijkstra10 = new CompetitionDijkstra("input-B.txt", 60, 80, 74);
        assertEquals("More test competitions from webcat", 8334, dijkstra10.timeRequiredforCompetition());   
        }


    @Test
    public void testFWConstructor() {
        CompetitionFloydWarshall floyWar = new CompetitionFloydWarshall("input-I.txt", 60,70,84);
        assertEquals("constructor failed with valid input", floyWar.slowest, 60);
    }

    @Test
    public void testFloyWarshall() {
        CompetitionFloydWarshall floyWar = new CompetitionFloydWarshall("tinyEWD.txt", 50,80,60);
        assertEquals("Test competition with tinyEWD", 38, floyWar.timeRequiredforCompetition());

        CompetitionFloydWarshall floyWar1 = new CompetitionFloydWarshall("notAFile.txt", 50, 80, 60);
        assertEquals("Test competition with invalid filename", -1, floyWar1.timeRequiredforCompetition());

        CompetitionFloydWarshall floyWar2 = new CompetitionFloydWarshall("tinyEWD.txt", -1, 80, 60);
        assertEquals("Test competition with negative speed", -1, floyWar2.timeRequiredforCompetition());

        CompetitionFloydWarshall floyWar3 = new CompetitionFloydWarshall(null, 50, 80, 60);
        assertEquals("Test competition with null filename", -1, floyWar3.timeRequiredforCompetition());

        CompetitionFloydWarshall floyWar5 = new CompetitionFloydWarshall("input-J.txt", 98, 70, 84);
        assertEquals("Test competition with 0 0 file", -1, floyWar5.timeRequiredforCompetition());

        CompetitionFloydWarshall floyWar6 = new CompetitionFloydWarshall("tinyEWD.txt", 5, 80, 60);
        assertEquals("Test competition with less than 50 speed", -1, floyWar6.timeRequiredforCompetition());

        CompetitionFloydWarshall floyWar7 = new CompetitionFloydWarshall("input-C.txt", 50, 100, 67);
        assertEquals("Test competition with less than 50 speed", -1, floyWar7.timeRequiredforCompetition());

        CompetitionFloydWarshall floyWar8 = new CompetitionFloydWarshall("input-D.txt", 50, 80, 60);
        assertEquals("More test competitions from webcat", 38, floyWar8.timeRequiredforCompetition());
        
        CompetitionFloydWarshall floyWar9 = new CompetitionFloydWarshall("input-I.txt", 72, 70, 65);
        assertEquals("More test competitions from webcat", 185, floyWar9.timeRequiredforCompetition());
        
        CompetitionFloydWarshall floyWar10 = new CompetitionFloydWarshall("input-B.txt", 60, 80, 74);
        assertEquals("More test competitions from webcat", 8334, floyWar10.timeRequiredforCompetition());       
     }
}