public class MenuAbleFactory {
    public MenuAble getMenuAble(String MenuAbleItem, String MenuAbleItemName) {
        switch(MenuAbleItem) {
            case "PasswordsMenuItem":
                return new PasswordsMenuItem(MenuAbleItemName);
            case "PasswordAddMenuItem":
                return new PasswordAddMenuItem(MenuAbleItemName);
            case "GeneratePasswordWithLengthItem":
                return new GeneratePasswordWithLengthItem(MenuAbleItemName);
            case "ExitItem":
                return new ExitItem(MenuAbleItemName);
            case "MainMenuItem":
                return new MainMenuItem(MenuAbleItemName);
        }
        return null;
    }
    public MenuAble getMenuAble(String MenuAbleItem, String MenuAbleItemName, Password password) {
        switch(MenuAbleItem) {
            case "DeletePasswordItem":
                return new DeletePasswordItem(MenuAbleItemName, password);
            case "AnalyzePasswordItem":
                return new AnalyzePasswordItem(MenuAbleItemName, password);
        }
        return null;
    }
}