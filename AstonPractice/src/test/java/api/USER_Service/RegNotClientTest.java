package api.USER_Service;

import helpers.ApiHelper;
import helpers.Params;
import helpers.RequestHelper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pojos.userService.ErrorResponse;
import pojos.userService.UserProfile;
import pojos.userService.UserProfileLong;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Slf4j
@Epic("API")
@Feature("1. USER_Service")
@Story("EP-5. Регистрация не клиента в приложении")
@DisplayName("EP-5. Регистрация не клиента в приложении")
public class RegNotClientTest extends ApiHelper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    RequestHelper requestHelper = new RequestHelper();

    @Test
    @TmsLink("6061814")
    @DisplayName("EP-5. Регистрация не клиента в приложении")
    public void regWithAllParams() throws IOException {
        log.info("  - 'Test failed'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                prop.getPropertyByKey("user2.mobilePhone"),
                prop.getPropertyByKey("user2.password"),
                prop.getPropertyByKey("user2.securityQuestion"),
                prop.getPropertyByKey("user2.email"),
                prop.getPropertyByKey("user2.passportNumber"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(200));
    }

    @Test
    @TmsLink("6078116")
    @DisplayName("EP-5. Невалидный мобильный номер")
    public void nonValidMobilePhone() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                "777177777",
                prop.getPropertyByKey("user2.password"),
                prop.getPropertyByKey("user2.securityQuestion"),
                prop.getPropertyByKey("user2.email"),
                prop.getPropertyByKey("user2.passportNumber"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getMobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_PHONE));
    }

    @Test
    @TmsLink("6078122")
    @DisplayName("EP-5. В начале мобильного номера стоит +")
    public void mobilePhoneWithPlus() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                "+" + prop.getPropertyByKey("user2.mobilePhone"),
                prop.getPropertyByKey("user2.password"),
                prop.getPropertyByKey("user2.securityQuestion"),
                prop.getPropertyByKey("user2.email"),
                prop.getPropertyByKey("user2.passportNumber"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getMobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_PHONE));
    }

    @Test
    @TmsLink("6078119")
    @DisplayName("EP-5. Невалидный пароль")
    public void nonValidPass() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                prop.getPropertyByKey("user2.mobilePhone"),
                "77777",
                prop.getPropertyByKey("user2.securityQuestion"),
                prop.getPropertyByKey("user2.email"),
                prop.getPropertyByKey("user2.passportNumber"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getPasswordErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_PASSWORD));
    }

    @Test
    @TmsLink("6071821")
    @DisplayName("EP-5. Без E-mail")
    public void noEmail() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                prop.getPropertyByKey("user2.mobilePhone"),
                prop.getPropertyByKey("user2.password"),
                prop.getPropertyByKey("user2.securityQuestion"),
                null,
                prop.getPropertyByKey("user2.passportNumber"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getEmailErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_EMAIL));
    }

    @Test
    @TmsLink("6071830")
    @DisplayName("EP-5. Без пароля")
    public void noPassword() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                prop.getPropertyByKey("user2.mobilePhone"),
                null,
                prop.getPropertyByKey("user2.securityQuestion"),
                prop.getPropertyByKey("user2.email"),
                prop.getPropertyByKey("user2.passportNumber"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getPasswordErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_PASSWORD));
    }

    @Test
    @TmsLink("6094517")
    @DisplayName("EP-5. Без контрольного вопроса")
    public void noSecurityQuestion() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                prop.getPropertyByKey("user2.mobilePhone"),
                prop.getPropertyByKey("user2.password"),
                null,
                prop.getPropertyByKey("user2.email"),
                prop.getPropertyByKey("user2.passportNumber"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getSecurityQuestionErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_SQ));
    }

    @Test
    @TmsLink("6094519")
    @DisplayName("EP-5. Без телефона")
    public void noMobilePhone() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                null,
                prop.getPropertyByKey("user2.password"),
                prop.getPropertyByKey("user2.securityQuestion"),
                prop.getPropertyByKey("user2.email"),
                prop.getPropertyByKey("user2.passportNumber"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getMobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_PHONE));
    }

    @Test
    @TmsLink("6094521")
    @DisplayName("EP-5. Без паспорта")
    public void noPassportNumber() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                prop.getPropertyByKey("user2.mobilePhone"),
                prop.getPropertyByKey("user2.password"),
                prop.getPropertyByKey("user2.securityQuestion"),
                prop.getPropertyByKey("user2.email"),
                null);

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getPassportNumberErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_PASSPORT));
    }

    @Test
    @TmsLink("6170974")
    @DisplayName("EP-5. Регистрация не клиента в приложении. C cуществующими Номером Паспорта,Email и Телефоном в БД")
    public void userExistInDB() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                prop.getPropertyByKey("user2.mobilePhone"),
                prop.getPropertyByKey("user2.password"),
                prop.getPropertyByKey("user2.securityQuestion"),
                prop.getPropertyByKey("user2.email"),
                prop.getPropertyByKey("user2.passportNumber"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(409));
    }

    @Test
    @TmsLink("6078126")
    @DisplayName("EP-5. Номер телефона без кавычек (long)")
    public void longPhone() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfileLong userProfileLong = createUserProfileLongBody(75335238419L);

        String body = MAPPER.writeValueAsString(userProfileLong);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("newUserProfileMethod"),
                "POST", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.get$MobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_LONG_PHONE));
    }

    private UserProfile createUserProfileBody(String mobilePhone, String password, String securityQuestion,
                                              String email, String passportNumber) throws IOException {
        return UserProfile.builder()
                .mobilePhone(mobilePhone)
                .password(password)
                .securityQuestion(securityQuestion)
                .securityAnswer(prop.getPropertyByKey("user2.securityAnswer"))
                .email(email)
                .firstName(prop.getPropertyByKey("user2.firstName"))
                .lastName(prop.getPropertyByKey("user2.lastName"))
                .middleName(prop.getPropertyByKey("user2.middleName"))
                .passportNumber(passportNumber)
                .countryOfResidence(true)
                .build();
    }
    private UserProfileLong createUserProfileLongBody(long mobilePhone) throws IOException {
        return UserProfileLong.builder()
                .mobilePhone(mobilePhone)
                .password(prop.getPropertyByKey("user2.password"))
                .securityQuestion(prop.getPropertyByKey("user2.securityQuestion"))
                .securityAnswer(prop.getPropertyByKey("user2.securityAnswer"))
                .email(prop.getPropertyByKey("user2.email"))
                .firstName(prop.getPropertyByKey("user2.firstName"))
                .lastName(prop.getPropertyByKey("user2.lastName"))
                .middleName(prop.getPropertyByKey("user2.middleName"))
                .passportNumber(prop.getPropertyByKey("user2.passportNumber"))
                .countryOfResidence(true)
                .build();
    }
}
