package org.apache.catalina.core.controller;


import nextstep.jwp.http.reqeust.HttpRequest;
import nextstep.jwp.http.response.HttpResponse;

public interface Controller {

    void service(final HttpRequest request, final HttpResponse response) throws Exception;
}