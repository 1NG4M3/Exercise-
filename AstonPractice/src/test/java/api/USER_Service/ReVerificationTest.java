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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Slf4j
@Epic("API")
@Feature("1. USER_Service")
@Story("EP-2.2 Повторное получение кода верификации")
@DisplayName("EP-2.2 Повторное получение кода верификации")
public class ReVerificationTest extends ApiHelper {
    RequestHelper requestHelper = new RequestHelper();

    @Order(1)
    @Test
    @TmsLink("6061961")
    @DisplayName("EP-2.2 Получение кода верификации")
    public void verificationCodeTwo() throws IOException {
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("email", "xomed32127@wireps.com", Params.ParamType.PARAM));
        response = requestHelper.sendRequest(
                prop.getPropertyByKey("verificationService"),
                "",
                "PATCH", params, "");
        assertThat(response.getStatusCode(), equalTo(200));
    }
    @SneakyThrows
    @Order(2)
    @Test
    @TmsLink("6061961")
    @DisplayName("EP-2.2 Повторное получение кода верификации")
    public void reVerificationCode() throws IOException {
        Thread.sleep(30000);
        log.info("  - 'Test starts'");
        List<Params> params = List.of(
                new Params("email", "xomed32127@wireps.com", Params.ParamType.PARAM));
        response = requestHelper.sendRequest(
                prop.getPropertyByKey("verificationService"),
                "",
                "PATCH", params, "");
        assertThat(response.getStatusCode(), equalTo(200));
    }
}
