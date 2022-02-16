package src.com.company.task8.Mediator;

public class SubmitButton implements Component {
    private Mediator mediator;
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void click() {
        this.mediator.submit();
    }
    @Override
    public ComponentType getType() {
        return ComponentType.SubmitBtn;
    }
}
