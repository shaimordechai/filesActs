package acts;

import java.util.Collections;
import java.util.List;

public class ActionReverse implements Action {
    @Override
    public void doAction(List<String> lines) {
        Collections.reverse(lines);
    }
}
