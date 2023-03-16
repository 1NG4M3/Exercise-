package pojos.userService;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileLong {
    private long mobilePhone;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
    private String email;
    private String firstName;
    private String lastName;
    private String middleName;
    private String passportNumber;
    private boolean countryOfResidence;
}