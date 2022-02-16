package src.com.company.task8.Mediator;

public class Test {
    public static void main(String[] args) {
        Dialog dialog = new Dialog();
        dialog.add(new SubmitButton());
        dialog.add(new VisibleCheckbox());
        dialog.add(new Form());
        dialog.visibleCheckbox.click();
        dialog.visibleCheckbox.click();
        dialog.submitButton.click();
    }
}
