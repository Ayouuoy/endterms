package patterns;

public class AppConfigSingleton {

    private static AppConfigSingleton instance;

    private AppConfigSingleton() {}

    public static AppConfigSingleton getInstance() {
        if (instance == null) {
            instance = new AppConfigSingleton();
        }
        return instance;
    }
}
