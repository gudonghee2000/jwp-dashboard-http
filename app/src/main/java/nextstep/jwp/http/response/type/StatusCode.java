package nextstep.jwp.http.response.type;

public enum StatusCode {
    OK("OK", "200"),
    FOUND("Found", "302"),
    NOT_FOUND("Not Found", "404"),
    UNAUTHORIZED("Unauthorized", "401");

    private final String message;
    private final String code;

    StatusCode(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}