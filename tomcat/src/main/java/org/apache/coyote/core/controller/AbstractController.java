package org.apache.coyote.core.controller;

import java.io.IOException;
import nextstep.jwp.exception.UncheckedServletException;
import nextstep.jwp.http.reqeust.HttpRequest;
import nextstep.jwp.http.response.HttpResponse;
import nextstep.jwp.io.ClassPathResource;

public abstract class AbstractController implements Controller {

    private static final String HTML_EXTENSION = ".html";
    private static final String FILE_EXTENSION_START = ".";

    protected static final String INDEX_PAGE_URL = "./index.html";

    @Override
    public void service(final HttpRequest request, final HttpResponse response)
            throws IOException, UncheckedServletException {
        if (request.hasPostMethod()) {
            doPost(request, response);
        }
        if (request.hasGetMethod()) {
            doGet(request, response);
        }
    }

    protected void doGet(final HttpRequest request, final HttpResponse response) throws UncheckedServletException {
        String path = resourcePath(request.getPath());
        String responseBody = new ClassPathResource().getStaticContent(path);

        response.setContentLength(responseBody.getBytes().length);
        response.setResponseBody(responseBody);
    }

    protected void doPost(final HttpRequest request, final HttpResponse response) throws UncheckedServletException {
        String path = resourcePath(request.getPath());
        String responseBody = new ClassPathResource().getStaticContent(path);

        response.setContentLength(responseBody.getBytes().length);
        response.setResponseBody(responseBody);
        response.sendRedirect(INDEX_PAGE_URL);
    }

    private String resourcePath(final String path) {
        if (!path.contains(FILE_EXTENSION_START)) {
            return path + HTML_EXTENSION;
        }
        return path;
    }
}
