package pojos.userService;

import java.util.List;
import java.util.Map;

public class ErrorResponse {
    private String type;
    private String title;
    private int status;
    private String traceId;
    private Map<String, List<String>> errors;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<String>> errors) {
        this.errors = errors;
    }

    public List<String> getMobilePhoneErrors() {
        if (errors.containsKey("mobilephone")) {
            return errors.get("mobilephone");
        } else return errors.getOrDefault("MobilePhone", null);
    }

    public List<String> getPasswordErrors() {
        return errors.get("Password");
    }

    public List<String> getEmailErrors() {
        if (errors.containsKey("email")) {
            return errors.get("email");
        } else return errors.getOrDefault("Email", null);
    }

    public List<String> getSecurityQuestionErrors() {
        return errors.get("SecurityQuestion");
    }

    public List<String> getPassportNumberErrors() {
        return errors.get("PassportNumber");
    }

    public List<String> get$MobilePhoneErrors() {
        return errors.get("$.mobilePhone");
    }

}
