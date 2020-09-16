import montyhall.GameshowService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameShowServiceTest {

    GameshowService gameshowService = new GameshowService();

    @Test
    public void testPlayOnce() {
        gameshowService.playGame(0, false);
    }

    @Test
    public void testPlayTenThousandGames_noSwitch() {
        int losses = 0;
        int wins = 0;
        for (int i = 0; i < 10000; i++) {
            var win = gameshowService.playGame(0, false);
            if (win) {
                wins++;
            } else {
                losses++;
            }
        }
        assertThat(wins).isLessThan(losses);
    }

    @Test
    public void testPlayTenThousandGames_withSwitch() {
        int losses = 0;
        int wins = 0;
        for (int i = 0; i < 10000; i++) {
            var win = gameshowService.playGame(0, true);
            if (win) {
                wins++;
            } else {
                losses++;
            }
        }
        assertThat(wins).isGreaterThan(losses);
    }
}
