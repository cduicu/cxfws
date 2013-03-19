//==========================================================================
// $Id: SubRest.java,v 0.1 Mar 19, 2013 10:23:35 AM cristiand Exp $
// (@) Copyright Sigma Systems (Canada)
// * Based on CVS log
//==========================================================================
package com.sigma.proto.jaxrs.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @version $Revision: $
 * @author $Author: cristiand $
 * @since $Date: Mar 19, 2013 $
 */
public interface SubRest {

    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @GET
    @Path("/sub({subid})")
    public abstract Sub getSub(@PathParam("subid") String subid);

    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @GET
    @Path("/makeQuery({qnm})")
    public abstract Query makeQuery(@PathParam("qnm") String qnm);

    /**
     * Accepts a POST request with a body looking like this:
     * <query name="subbrief" xmlns="http://nooni.org/ws/rest">
     *     <parm name="firstName">Ally</parm>
     *     <parm name="lastName">Alligator</parm>
     * </query>
     * and the content type must be set to: "application/xml" or "text/xml"
     *
     * @param query
     * @return
     * @throws IOException
     */
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @POST
    @Path("/query")
    public abstract QueryResult query(Query query) throws IOException;

}