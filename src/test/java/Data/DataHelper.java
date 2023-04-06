package Data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Locale;


public class DataHelper {
    public UserData getTheUserFirst() {
        Faker user = new Faker(new Locale("en"));
        String id = user.idNumber().valid();
        String name = user.name().firstName();
        String password = "qwerty123";
        String encryptedPassword = "$2a$10$VivJfbscqawl5XT8aZs4VOQkT51DGsDVr0Mk29eX/kgm7MtPWts6C";
        return new UserData(id, name, password, encryptedPassword);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserData {
        private String id;
        private String login;
        private String password;
        private String encryptedPassword;
    }
}