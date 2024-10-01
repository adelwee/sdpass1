public class DarkThemeFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new DarkThemeButton();
    }
}

