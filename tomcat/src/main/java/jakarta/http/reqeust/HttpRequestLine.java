package jakarta.http.reqeust;

import java.net.URI;
import java.net.URISyntaxException;
import nextstep.jwp.exception.RequestLineFormatException;

public class HttpRequestLine {

    private static final String REQUEST_LINE_SEPARATOR = " ";
    private static final int REQUEST_LINE_CONTENT_COUNT = 3;
    private static final int METHOD_INDEX = 0;
    private static final int URI_INDEX = 1;
    private static final int VERSION_INDEX = 2;

    private String method;
    private String path;
    private QueryParams queryParams;
    private String version;

    public HttpRequestLine(final String method, final URI uri, final String version) {
        this.method = method;
        this.path = uri.getPath();
        this.queryParams = new QueryParams(uri.getQuery());
        this.version = version;
    }

    public static HttpRequestLine from(final String requestLine) {
        String[] requestLines = requestLine.split(REQUEST_LINE_SEPARATOR);
        validateRequestLineFormat(requestLines);

        String method = requestLines[METHOD_INDEX];
        URI uri = requestUri(requestLines[URI_INDEX]);
        String version = requestLines[VERSION_INDEX];

        return new HttpRequestLine(method, uri, version);
    }

    private static void validateRequestLineFormat(final String[] requestLines) {
        if (requestLines.length != REQUEST_LINE_CONTENT_COUNT) {
            throw new RequestLineFormatException("잘못된 RequestLine의 형식 입니다.");
        }
    }

    private static URI requestUri(final String uri) {
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            throw new RequestLineFormatException("잘못된 URI 형식입니다.");
        }
    }

    public boolean hasPostMethod() {
        return method.equals("POST");
    }

    public boolean hasGetMethod() {
        return method.equals("GET");
    }

    public String getPath() {
        return path;
    }
}
