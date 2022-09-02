package nextstep.jwp.http.response;

public class HttpResponseCreator {

    public static HttpResponse okResponse(final String contentType, final String responseBody) {
        return new HttpResponseBuilder()
                .version()
                .status("OK")
                .contentType(contentType)
                .contentLength(responseBody.getBytes().length)
                .responseBody(responseBody)
                .build();
    }
}