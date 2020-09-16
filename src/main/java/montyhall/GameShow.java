package montyhall;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Value
public class GameShow {

    List<GameshowBox> boxes;

    public GameShow(int selectedBox) {
        validateBoxIndex(selectedBox);
        this.boxes = new ArrayList<>();
        boxes.add(new GameshowBox(false, false, false));
        boxes.add(new GameshowBox(false, false, false));
        boxes.add(selectedBox, new GameshowBox(false, false, true));
        int randomNumber = new Random().nextInt(3);
        boxes.get(randomNumber).setIsPrice();
    }

    public void removeBox() {
        List<GameshowBox> gameShowBoxes = new ArrayList<>(this.boxes);
        var selectedBox = boxes.stream().filter(GameshowBox::isSelected).findFirst().orElseThrow(IllegalStateException::new);
        gameShowBoxes.remove(selectedBox);
        var prizeIsLeft = gameShowBoxes.stream().anyMatch(GameshowBox::isHasPrize);
        GameshowBox boxToRemove;
        if (prizeIsLeft) {
            boxToRemove = gameShowBoxes.stream()
                    .filter(box -> !box.isHasPrize()).findFirst().orElseThrow(IllegalStateException::new);
        } else {
            int randomNum = (Math.random() <= 0.5) ? 0 : 1;
            boxToRemove = gameShowBoxes.get(randomNum);
        }
        boxToRemove.remove();
    }

    public void switchBox() {
        var boxToSelect = boxes.stream()
                .filter(box -> !box.isSelected() && !box.isRemoved())
                .findFirst().orElseThrow(IllegalStateException::new);
        var previouslySelectedBox = boxes.stream().filter(GameshowBox::isSelected)
                .findFirst();
        previouslySelectedBox.ifPresent(GameshowBox::unSelect);
        boxToSelect.select();
    }

    public boolean hasWon() {
        var selectedBox = boxes.stream().filter(GameshowBox::isSelected).findFirst();
        return selectedBox.map(GameshowBox::isHasPrize).orElse(false);
    }

    private void validateBoxIndex(int index) {
        boolean isValidSelectedBox = index == 0 || index == 1 || index == 2;
        if (!isValidSelectedBox) {
            throw new IllegalArgumentException("selected box has to be 0,1,2");
        }
    }
}
