package gui.E_1_Registration_and_Autorization_in_PowerBank;

import gui.GUIBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static pages.BasePage.*;
@Slf4j
@Epic("GUI")
@Feature("E-1. Registration & Authorization in PowerBank")
@Story("US-1.1 Главная страница")
@DisplayName("US-1.1 Главная страница")
public class MainPageTest extends GUIBaseTest {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Логотип")
    @TmsLink("6091072")

    public void mainLogoTest() {
        log.info("  - 'Test starts'");
        mainPage.powerBankText.shouldBe(hidden);

        mainPage.powerBankLogo.hover();
        mainPage.powerBankText.shouldBe(visible);

        mainPage.root.hover();
        mainPage.powerBankText.shouldBe(hidden);

        mainPage.powerBankLogo.click();
        assertThat(url(), containsStringIgnoringCase(BASE_URL));
    }

    @Test
    @DisplayName("Кнопка \"Банкоматы и отделения\"")
    @TmsLink("6091073")

    public void officesAndATMsButtonTest() {
        log.info("  - 'Test starts'");
        mainPage.officesAndATMsLogo.shouldBe(exist);

        mainPage.officesAndATMsButton.hover().shouldHave(cssValue("box-shadow", "rgb(255, 217, 84) 0px 1px 0px 0px"));

        mainPage.root.hover();
        mainPage.officesAndATMsButton.shouldHave(cssValue("box-shadow", "none"));

        mainPage.officesAndATMsButton.click();
        assertThat(url(), containsStringIgnoringCase(DEPARTMENTS_URL));
    }

    @Test
    @DisplayName("Кнопка \"Курсы валют\"")
    @TmsLink("6091074")

    public void exchangeRatesButtonTest() {
        log.info("  - 'Test starts'");
        mainPage.exchangeRatesLogo.shouldBe(exist);
        mainPage.exchangeRatesButton.hover().shouldHave(cssValue("box-shadow", "rgb(255, 217, 84) 0px 1px 0px 0px"));

        mainPage.root.hover();
        mainPage.exchangeRatesButton.shouldHave(cssValue("box-shadow", "none"));

        mainPage.exchangeRatesButton.click();
        assertThat(url(), containsStringIgnoringCase(CURRENCY_URL));
    }

    @Test
    @DisplayName("Кнопка \"Контакты\"")
    @TmsLink("6091075")

    public void contactsButtonTest() {
        log.info("  - 'Test starts'");
        mainPage.contactsLogo.shouldBe(exist);
        mainPage.contactsButton.hover().shouldHave(cssValue("box-shadow", "rgb(255, 217, 84) 0px 1px 0px 0px"));

        mainPage.root.hover();
        mainPage.contactsButton.shouldHave(cssValue("box-shadow", "none"));

        mainPage.contactsButton.click();
        assertThat(url(), containsStringIgnoringCase(CONTACTS_URL));
    }

    @Test
    @DisplayName("Кнопка \"Download on the AppStore\"")
    @TmsLink("6095165")

    public void downLoadOnTheAppStoreButtonTest() {
        log.info("  - 'Test starts'");
        mainPage.downloadOnTheAppStoreButton.click();
        assertThat(url(), containsStringIgnoringCase(APPSTORE_URL));
    }

    @Test
    @DisplayName("Кнопка \"Get it on Google Play\"")
    @TmsLink("6095166")

    public void getItOnGooglePlayButtonTest() {
        log.info("  - 'Test starts'");
        mainPage.getItOnGooglePlayButton.click();
        String currentUrl = url();
        assertThat(currentUrl, containsStringIgnoringCase(GOOGLEPLAY_URL));
    }

    @Test
    @DisplayName("Окно регистрации/входа")
    @TmsLink("6095167")

    public void loginWindowTest() {
        log.info("  - 'Test starts'");
    mainPage.loginWindow.shouldBe(exist);
    mainPage.loginWithTelephoneNumberButton.shouldBe(exist);

    mainPage.inputMobilePhone.shouldBe(exist);
    mainPage.inputPasswordEncode.shouldBe(exist);
    mainPage.submitButton.shouldBe(exist);
    mainPage.registrationButton.shouldBe(exist);
    mainPage.forgetPassword.shouldBe(exist);

    mainPage.loginWithPassportButton.shouldBe(exist);
    mainPage.loginWithPassportButton.click();

    mainPage.inputPassportNumber.shouldBe(exist);
    mainPage.inputPasswordEncode.shouldBe(exist);
    mainPage.submitButton.shouldBe(exist);
    mainPage.registrationButton.shouldBe(exist);
    mainPage.forgetPassword.shouldBe(exist);
    }
}
