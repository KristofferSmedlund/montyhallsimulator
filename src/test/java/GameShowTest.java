import montyhall.GameShow;
import montyhall.GameshowBox;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameShowTest {

    @Test
    public void constructGameshow_createsThreeBoxes() {
        GameShow gameshow = new GameShow(1);
        assertThat(gameshow.getBoxes().size()).isEqualTo(3);
    }

    @Test
    public void constructGameshow_hasExactlyOneBoxWithPrice() {
        GameShow gameshow = new GameShow(1);
        assertThat(gameshow.getBoxes().stream().filter(GameshowBox::isHasPrize).count()).isEqualTo(1);
    }

    @Test
    public void constructGameshow_withOutOfRangeSelectedBox_isIllegal() {
        assertThatThrownBy(() -> new GameShow(4)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void switchBox_onlyOneSelected() {
        GameShow gameshow = new GameShow(1);
        gameshow.switchBox();
        assertThat(gameshow.getBoxes().stream().filter(GameshowBox::isSelected).count()).isEqualTo(1);
    }

    @Test
    public void removeBox_isRemoved() {
        GameShow gameshow = new GameShow(1);
        gameshow.removeBox();
        assertThat(gameshow.getBoxes().stream().filter(box -> !box.isRemoved()).count()).isEqualTo(2);
    }


}
