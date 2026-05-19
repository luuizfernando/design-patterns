package behavioral.observer;

/**
 * Role: Concrete Observer
 *
 * Represents a Discord Bot that post score updates
 * to a Discord channel
 */
public class DiscordSportsBot implements ScoreObserver {

    @Override
    public void updateScore(int homeTeamScore, int awayTeamScore) {
        System.out.println("[Discord Sports Bot] - Home: " +  homeTeamScore + " | Away: " + awayTeamScore);
    }

}