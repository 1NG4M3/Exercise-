package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends BasePage {

    // SelenideElement - public, это нормально?

public final SelenideElement root = $x("//*[@id=\"root\"]");

public final SelenideElement powerBankLogo = $x("//div[@class = 'MuiBox-root css-70qvj9']");
public final SelenideElement powerBankText = $x("//div[@class = 'MuiBox-root css-6nols5']");

public final SelenideElement officesAndATMsButton = $x("//*[text()='Банкоматы и отделения']");
public final SelenideElement officesAndATMsLogo = $x("//*[text()='Банкоматы и отделения']/parent::div");

public final SelenideElement exchangeRatesButton = $x("//*[text()='Курсы валют']");
public final SelenideElement exchangeRatesLogo = $x("//*[text()='Курсы валют']/parent::div");

public final SelenideElement contactsButton = $x("//*[text()='Контакты']");
public final SelenideElement contactsLogo = $x("//*[text()='Контакты']/parent::div");

public final SelenideElement slider = $x("//div[@class ='css-1lzo7i2']");
public final ElementsCollection backGroundImages = $$x("//div[@class ='css-1l7c0cy']");

public final SelenideElement downloadOnTheAppStoreButton = $x("//a[@href='https://appstoreconnect.apple.com']");
public final SelenideElement getItOnGooglePlayButton = $x("//a[@href='https://play.google.com/store/apps']");

public final SelenideElement loginWindow = $x("//div[@class = 'MuiBox-root css-t2wcwl']");
public final SelenideElement loginWithTelephoneNumberButton = $x("//button[text()='По телефону']");
public final SelenideElement loginWithPassportButton = $x("//button[text()='По паспорту']");
public final SelenideElement inputMobilePhone = $x("//input[@name='mobilePhone']");
public final SelenideElement inputPassportNumber = $x("//input[@name='passportNumber']");
public final SelenideElement inputPasswordEncode = $x("//input[@name='passwordEncode']");
public final SelenideElement submitButton = $x("//button[text()='Войти']");
public final SelenideElement registrationButton = $x("//button[text()='Зарегистрироваться']");
public final SelenideElement forgetPassword = $x("//a[@href='/recovery']");

public final SelenideElement telephoneLabel = $x("//div[@class = 'MuiBox-root css-186imxo']/*[contains(@class, \"isLabelVisible css-1h3pvkn\")]");
public final SelenideElement placeHolder7 = $x("//div[@class = 'MuiBox-root css-186imxo']//*[contains(@class, \"isLabelVisible css-1uhnkfr\")]");
public final SelenideElement activeTelephonePlaceholder = $x("//input[@name='mobilePhone'][@placeholder = \"xxx xxx xxxx\"]");
public final SelenideElement telephoneRedBorder = $x("//div[@class = 'MuiBox-root css-186imxo']//div[contains(@class,'Mui-error')]");

public final SelenideElement passportLabel = $x("//div[@class = 'MuiBox-root css-1ibtg82']/*[contains(@class, \"isLabelVisible css-18eqs3k\")]");

public final SelenideElement fillTheFieldTelephoneMessage = $x("//p[contains(@class, 'Mui-error')][text()='Введите номер телефона']");
public final SelenideElement exclamationPoint = $x("//*[contains(@fill, 'red')]");

public final SelenideElement passportRedBorder = $x("//label[text()='Номер паспорта']/following-sibling::div[contains(@class,'Mui-error')]");
public final SelenideElement fillTheFieldPassportMessage = $x("//p[contains(@class, 'Mui-error')][text()='Заполните поле']");
public final SelenideElement tooManyNumbersPassportMessage = $x("//p[contains(@class, 'Mui-error')][text()='Номер паспорта должен быть не длиннее 15 символов']");
public final SelenideElement noSymbolsPassportMessage = $x("//p[contains(@class, 'Mui-error')][text()='Номер паспорта может состоять из заглавных латинских букв и цифр']");
public final SelenideElement capsLockMessage = $x("//p[text()='Включен Caps Lock']");

public final SelenideElement alertMessage = $x("//*[text()='hello world']");

public final SelenideElement passwordLabel = $x("//*[contains(@class, 'isLabelVisible')]");
public final SelenideElement eyeButton = $x("//button[contains(@class,'css-1a0k7dm')]");
}
