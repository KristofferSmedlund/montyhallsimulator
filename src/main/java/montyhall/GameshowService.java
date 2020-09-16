package montyhall;

public class GameshowService {
    public boolean playGame(int selectedBox, boolean wantToSwitch) {
        GameShow gameshow = new GameShow(selectedBox);
        gameshow.removeBox();
        if (wantToSwitch) {
            gameshow.switchBox();
        }
        return gameshow.hasWon();
    }
}
