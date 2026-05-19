package behavioral.observer;

/**
 * Role: Client / Demo / Driver
 *
 * Sets up the Subject and the Observers, then simulate score changes.
 */
public class MainApp {
    public static void main(String[] args) {

        GameScoreboardServer scoreboard = new GameScoreboardServer();

        ScoreObserver jumbotron = new JumbotronDisplay();
        ScoreObserver mobile = new MobileAppDisplay();
        ScoreObserver discordBot = new DiscordSportsBot();

        // Observers subscribe
        System.out.println("=== Registering Observers ===");
        scoreboard.registerObserver(jumbotron);
        scoreboard.registerObserver(mobile);
        scoreboard.registerObserver(discordBot);

        // Simulate score changes
        System.out.println("=== Setting scores ===");
        scoreboard.setScore(2, 3);
        System.out.println();
        scoreboard.setScore(3, 4);
        System.out.println();

        // One observer leaves
        System.out.println("Removing observer: mobile");
        scoreboard.removeObserver(mobile);

        // Mobile App no longer receives the updates
        System.out.println("=== Setting scores ===");
        scoreboard.setScore(5, 4);

    }
}