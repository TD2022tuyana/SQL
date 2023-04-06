package test;
import Data.DataHelper;
import Hooks.Hooks;
import Page.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import SqlData.SqlData;


public class LoginTest extends Hooks {
    DataHelper.UserData user = new DataHelper().getTheUserFirst();



    @Test
    void shouldBeValidAuthorization() {
        SqlData.createUser(user);

        new LoginPage().validLogin(user.getLogin(), user.getPassword()).validVerify(SqlData.getVerificationCode(user.getId()));
    }

    @Test
    void shouldBlockUserAfterInvalidPassword() {
        SqlData.createUser(user);

        new LoginPage()
                .invalidLogin(user.getLogin())
                .clearFields()
                .invalidLogin(user.getLogin())
                .clearFields()
                .invalidLogin(user.getLogin())
                .clearFields();

        String status = SqlData.getUserStatus(user.getId());

        Assertions.assertEquals("blocked", status);
    }
}
