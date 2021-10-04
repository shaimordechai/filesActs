package acts;

import java.util.Collections;
import java.util.List;

public class ActionSort implements Action {
    @Override
    public void doAction(List<String> lines) {
        Collections.sort(lines);
    }
}
