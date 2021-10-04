package enums;

import acts.Action;
import acts.ActionReverse;
import acts.ActionShuffle;
import acts.ActionSort;

public enum ActionEnum {
    SORT{
        @Override
        public ActionSort getInstance() {
            return action == null ? new ActionSort() : (ActionSort) action;
        }
    },
    SHUFFLE{
        @Override
        public ActionShuffle getInstance() {
            return action == null ? new ActionShuffle() : (ActionShuffle) action;
        }
    },
    REVERSE{
        @Override
        public ActionReverse getInstance() {
            return action == null ? new ActionReverse() : (ActionReverse) action;
        }
    };

    public abstract Action getInstance();
    protected Action action;
}

