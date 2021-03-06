package website.automate.waml.io.model.action;

import website.automate.waml.io.model.CriterionValue;

public abstract class TimeLimitedAction extends ConditionalAction {

    private CriterionValue timeout;

    public CriterionValue getTimeout() {
        return timeout;
    }

    public void setTimeout(Object timeout){
        this.timeout = new CriterionValue(timeout);
    }
}
