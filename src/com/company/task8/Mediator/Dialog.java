package src.com.company.task8.Mediator;

public class Dialog implements Mediator {
    Form form;
    SubmitButton submitButton;
    VisibleCheckbox visibleCheckbox;
    public void add(Component component) {
        if(component.getType() == ComponentType.Form) {
            this.form = (Form)component;
        } else if(component.getType() == ComponentType.SubmitBtn) {
            this.submitButton = (SubmitButton)component;
        } else if(component.getType() == ComponentType.VisibleCheckbox) {
            this.visibleCheckbox = (VisibleCheckbox)component;
        }
        component.setMediator(this);
    }
    @Override
    public void submit() {
        form.submit();
    }

    @Override
    public void clear() {
        form.clear();
    }

    @Override
    public void toggleShow() {
        form.toggle();
    }
}
