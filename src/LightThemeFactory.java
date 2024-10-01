public class LightThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LightThemeButton();
    }
}
