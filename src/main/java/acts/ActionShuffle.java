package acts;

import java.util.Collections;
import java.util.List;

public class ActionShuffle implements Action {
    @Override
    public void doAction(List<String> lines) {
        Collections.shuffle(lines);
    }
}
