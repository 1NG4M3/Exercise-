package pojos.userService;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
public class FailResponse {
    private String failReason;
    private Integer seconds;
}
