package montyhall;

public class Application {

    private static final GameshowService gameshowService = new GameshowService();

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Please provide all 3 arguments: boxPreference, shouldSwitch & amountOfAttempts");
        }
        int boxPreference = Integer.parseInt(args[0]);
        boolean shouldSwitch = Boolean.parseBoolean(args[1]);
        int amountOfAttempts = Integer.parseInt(args[2]);

        int wins = 0;
        for (int i = 0; i < amountOfAttempts; i++) {
            var win = gameshowService.playGame(boxPreference, shouldSwitch);
            if (win) {
                wins++;
            }
        }
        System.out.println("You won " + ((float) wins/amountOfAttempts) * 100 + "% out of " + amountOfAttempts + " attempts");
    }
}
