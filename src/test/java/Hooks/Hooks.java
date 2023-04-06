package Hooks;

import SqlData.SqlData;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class Hooks {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999"); }

    @AfterAll
    static void clean() {
        SqlData.cleanData();
    }
}