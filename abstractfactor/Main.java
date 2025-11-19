package abstractfactor;

public class Main {
    public static void main(String[] args) {
        UIFactory lightFactory = new LightThemeFactory();
        Button lightButton = lightFactory.createButton();
        Checkbox lightCheckbox = lightFactory.createCheckbox();

        System.out.println("Light Theme Components:");
        lightButton.render();
        lightCheckbox.render();

        System.out.println();

        UIFactory darkFactory = new DarkThemeFactory();
        Button darkButton = darkFactory.createButton();
        Checkbox darkCheckbox = darkFactory.createCheckbox();

        System.out.println("Dark Theme Components:");
        darkButton.render();
        darkCheckbox.render();
    }
}
