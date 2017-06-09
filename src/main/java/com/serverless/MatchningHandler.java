package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class MatchningHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = Logger.getLogger(MatchningHandler.class);
    private String PBAPI_URL = System.getenv("PBAPI_URL");
    private String PBAPI_VERSION = System.getenv("PBAPI_VERSION");
    private String COMPLETE_URL = PBAPI_URL + PBAPI_VERSION;

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        Response response = getResponse(COMPLETE_URL);
        com.serverless.Response responseBody = new com.serverless.Response("Hi! from matchningHandler", input);
        ApiGatewayResponse apiGatewayResponse = ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody(responseBody)
                .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                .build();

        return apiGatewayResponse;
    }

    private Response getResponse(String url) {
        Response response = null;
        try {
            response = getClient()
                    .target(url)
                    .request()
                    .get();
        } catch (ProcessingException processing) {
            String message = String.format("Call to ledigtarbete with urlPath: '%s' took to long and was aborted. Thrown exception: '%s'", url, processing.getCause());
            LOG.error(message);
        } catch (Exception exception) {
            String message = String.format("An exception occurred while calling ledigtarbete rest service with URL'. Thrown exception: '%s'", url, exception);
            LOG.error(message);
            //throw new TjanstOtillgangligException(String.format("Failed to connect to arbetsgivare with URL: '%s'. Thrown Exception: '%s'", url, exception));
        }

        return response;
    }

    private ResteasyClient getClient() {
        return new ResteasyClientBuilder()
                .establishConnectionTimeout(1000, TimeUnit.MILLISECONDS)
                .socketTimeout(1000, TimeUnit.MILLISECONDS)
                .build();
    }
}
