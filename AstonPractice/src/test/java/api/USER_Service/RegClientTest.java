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
@Story("EP-4. Регистрация клиента в приложении")
@DisplayName("EP-4. Регистрация клиента в приложении")
public class RegClientTest extends ApiHelper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    RequestHelper requestHelper = new RequestHelper();

    @Test
    @TmsLink("6061804")
    @DisplayName("EP-4. Регистрация клиента с указанием всех параметров в теле")
    public void regWithAllParams() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                prop.getPropertyByKey("user1.mobilePhone"),
                prop.getPropertyByKey("user1.email"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("userProfileMethod"),
                "PATCH", params, body);

        assertThat(response.getStatusCode(), equalTo(200));
    }


    @Test
    @TmsLink("6062837")
    @DisplayName("EP-4. Регистрация клиента без мобильного телефона")
    public void regWithoutPhone() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                null,
                prop.getPropertyByKey("user1.email"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("userProfileMethod"),
                "PATCH", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getMobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_PHONE));
    }
    @Test
    @TmsLink("6062845")
    @DisplayName("EP-4. Регистрация клиента без Email")
    public void regWithoutEmail() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                prop.getPropertyByKey("user1.mobilePhone"),
                null);

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("userProfileMethod"),
                "PATCH", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getEmailErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_EMAIL));
    }

    @Test
    @TmsLink("6062884")
    @DisplayName("EP-4. Регистрация клиента + в начале мобильного номера")
    public void regPlusInPhone() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfile userProfile = createUserProfileBody(
                "+" + prop.getPropertyByKey("user1.mobilePhone"),
                prop.getPropertyByKey("user1.email"));

        String body = MAPPER.writeValueAsString(userProfile);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("userProfileMethod"),
                "PATCH", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getMobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_PHONE));
    }


    @Test
    @TmsLink("6062844")
    @DisplayName("EP-4. Регистрация клиента - номер телефона без кавычек (long)")
    public void regLongPhone() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("Content-Type", "application/json", Params.ParamType.HEADER));

        UserProfileLong userProfileLong = createUserProfileLongBody(75335238419L);

        String body = MAPPER.writeValueAsString(userProfileLong);

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                prop.getPropertyByKey("userProfileMethod"),
                "PATCH", params, body);

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.get$MobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_LONG_PHONE));
    }
    private UserProfile createUserProfileBody(String mobilePhone, String email) throws IOException {
        return UserProfile.builder()
                .mobilePhone(mobilePhone)
                .password(prop.getPropertyByKey("user1.password"))
                .securityQuestion(prop.getPropertyByKey("user1.securityQuestion"))
                .securityAnswer(prop.getPropertyByKey("user1.securityAnswer"))
                .email(email)
                .build();
    }
    private UserProfileLong createUserProfileLongBody(long mobilePhone) throws IOException {
        return UserProfileLong.builder()
                .mobilePhone(mobilePhone)
                .password(prop.getPropertyByKey("user1.password"))
                .securityQuestion(prop.getPropertyByKey("user1.securityQuestion"))
                .securityAnswer(prop.getPropertyByKey("user1.securityAnswer"))
                .email(prop.getPropertyByKey("user1.email"))
                .build();
    }
}