//==========================================================================
// $Id: RestWSClient.java,v 0.1 May 11, 2012 8:36:12 AM cristiand Exp $
// (@) Copyright Sigma Systems (Canada)
// * Based on CVS log
//==========================================================================
package com.sigma.proto.jaxrs.rest.test;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sigma.proto.jaxrs.rest.Sub;
import com.sigma.proto.jaxrs.rest.SubRest;
//import org.codehaus.jackson.map.annotate.JsonSerialize;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

/**
 * @version $Revision: $
 * @author $Author: cristiand $
 * @since $Date: May 11, 2012 $
 */
public class RestWSClient {


    private static final String WS_JSON = "http://localhost:8080/json/";
    private static final String WS_XML = "http://localhost:8080/rest/";
    private static String WS = WS_JSON;

    private static String toJson(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(obj);
    }

    private static void testWS() throws Exception {
        SubRest rest = JAXRSClientFactory.create(WS_XML, SubRest.class);
        Sub sub = rest.getSub("222");
        System.out.println("Test with XML:\n\t" + toJson(sub));
    }

    private static void testRS() throws Exception {
        ArrayList providers = new ArrayList();
        JacksonJaxbJsonProvider p = new JacksonJaxbJsonProvider();
        providers.add(p);
        SubRest rest = JAXRSClientFactory.create(WS_JSON, SubRest.class, providers);
        Sub sub = rest.getSub("1111");
//        WebClient client = WebClient.create(WS, providers);
//        client = client.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON);
//        Sub sub = client.path("sub(2222)").get(Sub.class);
        System.out.println("Test with JSON:\n\t" + toJson(sub));
    }

    public static void main(String[] args) throws Exception {
        testWS();
        testRS();
    }
}
