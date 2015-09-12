package game123;

/**
 * Created by Fabian Gillholm on 2015-09-12.
 */
public class Play123Main {
    public static void main(String[] args) {
        Game123 game = new Game123();
        int wins = 0;
        int numberOfGames = 10000;

        for(int i = 0; i < numberOfGames; i++) {
            if(game.play()) {
                wins++;
            }
        }

        double winPercentage = ((double)wins / (double)numberOfGames) * 100;
        String roundedWinPercentage = String.format("%.2f", winPercentage);
        System.out.println("Percentage of games won: " + roundedWinPercentage + "%");
    }
}
