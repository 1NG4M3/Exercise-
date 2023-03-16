package gui.E_1_Registration_and_Autorization_in_PowerBank;

import com.codeborne.selenide.Condition;
import gui.GUIBaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.MainPage;

import static com.codeborne.selenide.Condition.*;
@Slf4j
@Epic("GUI")
@Feature("E-1. Registration & Authorization in PowerBank")
@Story("US-1.2 Авторизация (вход в приложение)")
@DisplayName("US-1.2 Авторизация (вход в приложение)")
public class AuthorizationPageTest extends GUIBaseTest {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Вход по номеру телефона. Вход по номеру телефона")
    @TmsLink("6091077")

    public void logInByTelephoneNumberTest() {
        log.info("  - 'Test starts'");
        mainPage.loginWithTelephoneNumberButton.click();
        mainPage.loginWithTelephoneNumberButton.shouldHave(Condition.attribute("ariaSelected",
                "true"));
        mainPage.loginWithPassportButton.shouldBe(Condition.attribute("ariaSelected", "false"));

        mainPage.inputMobilePhone.click();

        mainPage.inputMobilePhone.shouldBe(focused);
        mainPage.telephoneLabel.shouldBe(exist);

        mainPage.placeHolder7.shouldBe(exist);

        mainPage.activeTelephonePlaceholder.shouldBe(exist);

        mainPage.root.click();
        mainPage.inputMobilePhone.shouldNotBe(focused);
        mainPage.telephoneLabel.shouldNotBe(exist);
    }

    @Test
    @DisplayName("Вход по номеру телефона.Проверка возможности редактирования плейсхолдера")
    @TmsLink("6124845")
    public void editPlaceholderTest() {
        log.info("  - 'Test starts'");
        mainPage.inputMobilePhone.click();
        mainPage.inputMobilePhone.shouldBe(focused);
        mainPage.inputMobilePhone.shouldBe(empty);
    }

    @Test
    @DisplayName("Вход по номеру телефона. Проверка текста валидационного сообщения поля \"Телефон\"")
    @TmsLink("6124855")

    public void telephoneValidationTextTest() {
        log.info("  - 'Test failed'");
        mainPage.inputMobilePhone.setValue("1");
        mainPage.submitButton.click();
        mainPage.fillTheFieldTelephoneMessage.shouldBe(exist);
    }

    @Test
    @DisplayName("Вход по номеру телефона. Поле \"Телефон\" не заполнено")
    @TmsLink("6174383")
    public void exclamationPointTest() {
        log.info("  - 'Test starts'");
        mainPage.submitButton.click();
        mainPage.telephoneRedBorder.shouldBe(exist);
        mainPage.exclamationPoint.shouldBe(exist);
        mainPage.fillTheFieldTelephoneMessage.shouldBe(exist);
    }

    @Test
    @DisplayName("Вход по номеру телефона. Невалидные данные: 3 цифры")
    @TmsLink("6174381")
    public void notValidTelephoneInput3numbersTest() {
        log.info("  - 'Test failed'");
        mainPage.inputMobilePhone.setValue("356");
        mainPage.submitButton.click();
        mainPage.fillTheFieldTelephoneMessage.shouldBe(exist);
    }

    @Test
    @DisplayName("Вход по номеру телефона. Невалидные данные: номер больше 10 цифр")
    @TmsLink("6106512")
    public void notValidTelephoneInput12numbersTest() {
        log.info("  - 'Test starts'");
        mainPage.inputMobilePhone.setValue("123456789011");
        mainPage.inputMobilePhone.shouldHave(value("123 456 7890"));
    }

    @Test
    @DisplayName("Вход по номеру телефона. Невалидные данные: символы, не относящиеся к цифрам")
    @TmsLink("6106513")
    public void notValidTelephoneInputNotNumbersTest() {
        log.info("  - 'Test failed'");
        mainPage.inputMobilePhone.setValue("и");
        mainPage.inputMobilePhone.shouldBe(empty);
        mainPage.inputMobilePhone.setValue("U");
        mainPage.inputMobilePhone.shouldBe(empty);
        mainPage.inputMobilePhone.setValue("&");
        mainPage.inputMobilePhone.shouldBe(empty);
        mainPage.inputMobilePhone.setValue("■");
        mainPage.inputMobilePhone.shouldBe(empty);
    }

    @Test
    @DisplayName("Вход по паспорту. Поле \"Номер паспорта\" не заполнено")
    @TmsLink("6174386")
    public void emptyInputPassportTest() {
        log.info("  - 'Test failed'");
        mainPage.loginWithPassportButton.click();
        mainPage.inputPassportNumber.click();
        mainPage.inputPassportNumber.shouldBe(focused);
        mainPage.submitButton.click();
        mainPage.passportRedBorder.shouldBe(exist);
        mainPage.exclamationPoint.shouldBe(exist);
        mainPage.fillTheFieldPassportMessage.shouldBe(exist);
    }

    @Test
    @DisplayName("Вход по паспорту. Невалидные данные. Меньше 3 символов")
    @TmsLink("6106541")
    public void notValidPassportInputLess3SymbolsTest() {
        log.info("  - 'Test starts'");
        mainPage.loginWithPassportButton.click();
        mainPage.inputPassportNumber.setValue("G");
        mainPage.submitButton.click();
        mainPage.passportRedBorder.shouldBe(exist);
        mainPage.exclamationPoint.shouldBe(exist);
        mainPage.fillTheFieldPassportMessage.shouldBe(exist);
        mainPage.inputPassportNumber.sendKeys(Keys.BACK_SPACE);
        mainPage.inputPassportNumber.shouldBe(empty);
        mainPage.passportRedBorder.shouldBe(exist);
        mainPage.exclamationPoint.shouldBe(exist);
        mainPage.fillTheFieldPassportMessage.shouldBe(exist);
        mainPage.loginWithPassportButton.click();
        mainPage.inputPassportNumber.setValue("S1");
        mainPage.submitButton.click();
        mainPage.passportRedBorder.shouldBe(exist);
        mainPage.exclamationPoint.shouldBe(exist);
        mainPage.fillTheFieldPassportMessage.shouldBe(exist);
    }

    @Test
    @DisplayName("Вход по паспорту. Невалидные данные. Более 15 символов")
    @TmsLink("6106542")
    public void notValidPassportInputMore15SymbolsTest() {
        log.info("  - 'Test starts'");
        mainPage.loginWithPassportButton.click();
        mainPage.inputPassportNumber.setValue("1234567812345678");
        mainPage.submitButton.click();
        mainPage.passportRedBorder.shouldBe(exist);
        mainPage.exclamationPoint.shouldBe(exist);
        mainPage.tooManyNumbersPassportMessage.shouldBe(exist);
    }

    @Test
    @DisplayName("Вход по паспорту. Невалидные данные: специальные символы")
    @TmsLink("6106539")
    public void notValidPassportInputSymbolsTest() {
        log.info("  - 'Test starts'");
        mainPage.loginWithPassportButton.click();
        mainPage.inputPassportNumber.setValue("%^&");
        mainPage.submitButton.click();
        mainPage.passportRedBorder.shouldBe(exist);
        mainPage.exclamationPoint.shouldBe(exist);
        mainPage.noSymbolsPassportMessage.shouldBe(exist);
    }

    @Test
    @DisplayName("Вход по паспорту. Невалидные данные: заглавные и строчные буквы кириллицы")
    @TmsLink("6124873")
    public void notValidPassportInputCyrillicSymbolsTest() {
        log.info("  - 'Test failed'");
        mainPage.loginWithPassportButton.click();
        mainPage.inputPassportNumber.setValue("АТрДу");
        mainPage.submitButton.click();
        mainPage.passportRedBorder.shouldBe(exist);
        mainPage.exclamationPoint.shouldBe(exist);
        mainPage.noSymbolsPassportMessage.shouldBe(exist);
    }
}
