package com.serverless;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverless.model.Annons;
import com.serverless.model.Arbetsplats;
import com.serverless.model.VardeNamn;
import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AnnonsHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = Logger.getLogger(AnnonsHandler.class);

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        LOG.info("received input: " + input);
        HashMap queryStringParameters = (HashMap) input.get("queryStringParameters");
        ApiGatewayResponse apiGatewayResponse;
        String id;

        if (queryStringParameters != null && queryStringParameters.containsKey("id")) {
            id = (String) queryStringParameters.get("id");
            LOG.info("id = " + id);

            Response responseBody = new Response(body1(id), input);
            apiGatewayResponse = ApiGatewayResponse.builder()
                    .setStatusCode(200)
                    .setObjectBody(responseBody)
                    .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                    .build();

        } else {
            LOG.info("unable to find key \"id\"! ");
            Response responseBody = new Response("Go Serverless v1.x! Your function executed successfully!", input);
            apiGatewayResponse = ApiGatewayResponse.builder()
                    .setStatusCode(200)
                    .setObjectBody(responseBody)
                    .setHeaders(Collections.singletonMap("X-Powered-By", "AWS Lambda & serverless"))
                    .build();
        }

        return apiGatewayResponse;
    }


    private String body1(String id) {
        Annons annons = new Annons();

        annons.setId(id);
        Arbetsplats arbetsplats = new Arbetsplats();
        arbetsplats.setAdress("Norra Stationsgatan61");
        VardeNamn kommun = new VardeNamn();
        kommun.setNamn("stockholm");
        kommun.setVarde("stockholm");
        arbetsplats.setKommun(kommun);

        annons.setArbetsplats(arbetsplats);

        String message = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            message = mapper.writeValueAsString(annons);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return message;
    }
}
