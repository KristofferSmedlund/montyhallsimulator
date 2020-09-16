package montyhall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@AllArgsConstructor
@Getter
public class GameshowBox {
    private boolean hasPrize;
    private boolean removed;
    private boolean selected;

    public void remove() {
        removed = true;
    }

    public void unSelect() {
        selected = false;
    }

    public void select() {
        selected = true;
    }

    public void setIsPrice() {
        hasPrize = true;
    }
}
