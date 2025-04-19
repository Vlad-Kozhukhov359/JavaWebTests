package tests;

import core.base.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        open(getBaseUrl());
    }
}
