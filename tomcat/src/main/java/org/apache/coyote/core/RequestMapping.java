package org.apache.coyote.core;

import nextstep.jwp.http.reqeust.HttpRequest;
import org.apache.coyote.core.controller.Controller;
import org.apache.coyote.core.controller.IndexController;
import org.apache.coyote.core.controller.LoginController;
import org.apache.coyote.core.controller.RootController;

public class RequestMapping {

    public Controller getController(final HttpRequest request) {
        String path = request.getPath();
        if (path.equals("/")) {
            return new RootController();
        }
        if (path.equals("/index.html") || path.equals("/css/styles.css")) {
            return new IndexController();
        }
        if (path.equals("/login.html")) {
            return new LoginController();
        }
        throw new IllegalArgumentException();
    }
}
