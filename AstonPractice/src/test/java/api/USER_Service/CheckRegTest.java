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
import pojos.userService.StatusResponse;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
@Epic("API")
@Feature("1. USER_Service")
@Story("EP-1. Проверка регистрации пользователя")
@DisplayName("EP-1. Проверка регистрации пользователя")
public class CheckRegTest extends ApiHelper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    RequestHelper requestHelper = new RequestHelper();

    @Test
    @TmsLink("6052412")
    @DisplayName("EP-1. Статус ACTIVE")
    public void activeUser() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("mobilephone", prop.getPropertyByKey("user3.mobilePhone"), Params.ParamType.PARAM),
                new Params("email", prop.getPropertyByKey("user3.email"), Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(200));
        String json = response.getBody().asString();
        StatusResponse statusResponse = MAPPER.readValue(json, StatusResponse.class);
        assertThat(statusResponse.getMobilePhone(), equalTo(prop.getPropertyByKey("user3.mobilePhone")));
        assertThat(statusResponse.getClientStatus(), equalTo("Active"));
    }
    @Test
    @TmsLink("6056741")
    @DisplayName("EP-1. Статус NOT_ACTIVE")
    public void notActiveUser() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("mobilephone", prop.getPropertyByKey("user4.mobilePhone"), Params.ParamType.PARAM),
                new Params("email", prop.getPropertyByKey("user4.email"), Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(200));
        String json = response.getBody().asString();
        StatusResponse statusResponse = MAPPER.readValue(json, StatusResponse.class);
        assertThat(statusResponse.getMobilePhone(), equalTo(prop.getPropertyByKey("user4.mobilePhone")));
        assertThat(statusResponse.getClientStatus(), equalTo("NotActive"));
    }
    @Test
    @TmsLink("6056744")
    @DisplayName("EP-1. Статус NOT_REGISTERED")
    public void notRegisteredUser() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("mobilephone", prop.getPropertyByKey("user1.mobilePhone"), Params.ParamType.PARAM),
                new Params("email", prop.getPropertyByKey("user1.email"), Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(200));
        String json = response.getBody().asString();
        StatusResponse statusResponse = MAPPER.readValue(json, StatusResponse.class);
        assertThat(statusResponse.getMobilePhone(), equalTo(prop.getPropertyByKey("user1.mobilePhone")));
        assertThat(statusResponse.getClientStatus(), equalTo("NotRegistered"));
    }
    @Test
    @TmsLink("6121514")
    @DisplayName("EP-1. Статус NotClientAceptableEmail")
    public void notAceptableEmailUser() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("mobilephone", prop.getPropertyByKey("user5.mobilePhone"), Params.ParamType.PARAM),
                new Params("email", prop.getPropertyByKey("user5.email"), Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(200));
        String json = response.getBody().asString();
        StatusResponse statusResponse = MAPPER.readValue(json, StatusResponse.class);
        assertThat(statusResponse.getMobilePhone(), equalTo(prop.getPropertyByKey("user5.mobilePhone")));
        assertThat(statusResponse.getClientStatus(), equalTo("NotClientAceptableEmail"));
    }
    @Test
    @TmsLink("6185415")
    @DisplayName("EP-1. Проверка на DuplicatedEmail")
    public void duplicatedEmail() throws IOException {
        log.info("  - 'Test failed'");
        List<Params> params = List.of(
                new Params("mobilephone", prop.getPropertyByKey("user3.mobilePhone"), Params.ParamType.PARAM),
                new Params("email", prop.getPropertyByKey("user3.email"), Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(200));
        String json = response.getBody().asString();
        StatusResponse statusResponse = MAPPER.readValue(json, StatusResponse.class);
        assertThat(statusResponse.getMobilePhone(), equalTo(prop.getPropertyByKey("user3.mobilePhone")));
        assertThat(statusResponse.getClientStatus(), equalTo("DuplicatedEmail"));
    }
    @Test
    @TmsLink("6186402")
    @DisplayName("EP-1. Проверка на InvalidEmail")
    public void invalidEmail() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("mobilephone", prop.getPropertyByKey("user4.mobilePhone"), Params.ParamType.PARAM),
                new Params("email", "pec@40mail.ru", Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(200));
        String json = response.getBody().asString();
        StatusResponse statusResponse = MAPPER.readValue(json, StatusResponse.class);
        assertThat(statusResponse.getMobilePhone(), equalTo(prop.getPropertyByKey("user4.mobilePhone")));
        assertThat(statusResponse.getClientStatus(), equalTo("InvalidEmail"));
    }
    @Test
    @TmsLink("6054297")
    @DisplayName("EP-1. Ответ без введенного номера телефона")
    public void emptyMobilePhone() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("mobilephone", "", Params.ParamType.PARAM),
                new Params("email", prop.getPropertyByKey("user4.email"), Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getMobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_PHONE));
    }

    @Test
    @TmsLink("6235183")
    @DisplayName("EP-1. Получение ответа при незаполненных параметрах")
    public void emptyParams() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("mobilephone", "", Params.ParamType.PARAM),
                new Params("email", "", Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getEmailErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_EMAIL));
        assertThat(errorResponse.getMobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_EMPTY_PHONE));
    }
    @Test
    @TmsLink("6054339")
    @DisplayName("EP-1. Регистрация на невалидных данных телефона: больше 11-ти символов")
    public void moreDigitsMobilePhone() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("mobilephone", "792134712345", Params.ParamType.PARAM),
                new Params("email", "test@te.st", Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getMobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_PHONE));
    }
    @Test
    @TmsLink("6054680")
    @DisplayName("EP-1. Регистрация на невалидных данных телефона: содержит цифры и буквы")
    public void notValidMobilePhone() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("mobilephone", "7675привет5", Params.ParamType.PARAM),
                new Params("email", "test@te.st", Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("regUser"),
                "",
                "GET", params, "");

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        ErrorResponse errorResponse = MAPPER.readValue(json, ErrorResponse.class);
        assertThat(errorResponse.getMobilePhoneErrors().get(0),
                equalTo(TestData.ERROR_MESSAGE_400_PHONE));
    }
}
