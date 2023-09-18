import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {
    private int id;
    private String title;
    private String body;
    private int userId;
}
