package api.USER_Service;

import helpers.ApiHelper;
import helpers.Params;
import helpers.RequestHelper;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.awaitility.Awaitility;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pojos.userService.FailResponse;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
@Epic("API")
@Feature("1. USER_Service")
@Story("EP-2.0 Получение кода верификации")
@DisplayName("EP-2.0 Получение кода верификации")
public class VerificationTest extends ApiHelper {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    RequestHelper requestHelper = new RequestHelper();


    @Test
    @TmsLink("6066883")
    @DisplayName("EP-2.0 Получение кода верификации")
    public void getVerificationCode() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("email", "kewetes791@wwgoc.com", Params.ParamType.PARAM));
        response = requestHelper.sendRequest(
                prop.getPropertyByKey("verificationService"),
                "",
                "PATCH", params, "");

        assertThat(response.getStatusCode(), equalTo(200));
    }

    @Test
    @Order(3)
    @TmsLink("6233653")
    @DisplayName("EP-2.0 Проверка 30 секундной блокировки переотправки сообщений с верификационным кодом на почту")
    public void repeatVerificationCode() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("email", "kewetes791@wwgoc.com", Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("verificationService"),
                "",
                "PATCH", params, "");

        assertThat(response.getStatusCode(), equalTo(400));
        String json = response.getBody().asString();
        FailResponse failResponse = MAPPER.readValue(json, FailResponse.class);
        assertThat(failResponse.getFailReason(), equalTo("EmailSendingBlocked"));
    }

    @Test
    @TmsLink("6235288")
    @DisplayName("EP-2.0 Проверка отправки верификационного кода на не существующую почту")
    public void emailNotExist() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("email", "majitow131@mirtox.cm", Params.ParamType.PARAM));

        response = requestHelper.sendRequest(
                prop.getPropertyByKey("verificationService"),
                "",
                "PATCH", params, "");

        assertThat(response.getStatusCode(), equalTo(421));
    }
}
