package src.com.company.task8.Mediator;

public class Form implements Component{
    private boolean show = true;
    private Mediator mediator;
    public void clear() {
        System.out.println("clear form");
    }
    public void submit() {
        System.out.println("data sender");
        this.clear();
    }
    public void toggle() {
        show = !show;
        System.out.println(show ? "Поля формы видны" : "Поля формы скрыты");
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
     @Override
     public ComponentType getType() {
        return ComponentType.Form;
     }
}
