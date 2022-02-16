package src.com.company.task8.Mediator;

public class VisibleCheckbox implements Component {
    private Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void click() {
        this.mediator.toggleShow();
    }
    @Override
    public ComponentType getType() {
        return ComponentType.VisibleCheckbox;
    }
}
