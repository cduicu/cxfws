//==========================================================================
// $Id: RestWS.java,v 0.1 May 11, 2012 8:08:35 AM cristiand Exp $
// (@) Copyright Sigma Systems (Canada)
// * Based on CVS log
//==========================================================================
package com.sigma.proto.jaxrs.rest.test;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;

import com.sigma.proto.jaxrs.rest.impl.SubRestImpl;

/**
 * @version $Revision: $
 * @author $Author: cristiand $
 * @since $Date: May 11, 2012 $
 */
public class RestWSServer {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
        sf.setResourceClasses(SubRestImpl.class);
        sf.setAddress("http://localhost:8080/rest");
        sf.create();

        JAXRSServerFactoryBean sfjson = new JAXRSServerFactoryBean();
        sfjson.setResourceClasses(SubRestImpl.class);
        sfjson.setServiceClass(SubRestImpl.class);
        sfjson.setProvider(new JacksonJaxbJsonProvider());
        sfjson.setAddress("http://localhost:8080/json");
        sfjson.create();

        System.out.println("Started");
        Thread.sleep(10 * 60 * 1000);
        System.out.println("ended");
        System.exit(0);
    }

}
