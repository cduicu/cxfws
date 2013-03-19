//==========================================================================
// $Id: SubRestWS.java,v 0.1 May 11, 2012 8:27:58 AM cristiand Exp $
// (@) Copyright Sigma Systems (Canada)
// * Based on CVS log
//==========================================================================
package com.sigma.proto.jaxrs.rest.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sigma.proto.jaxrs.rest.Parm;
import com.sigma.proto.jaxrs.rest.Query;
import com.sigma.proto.jaxrs.rest.QueryResult;
import com.sigma.proto.jaxrs.rest.Sub;
import com.sigma.proto.jaxrs.rest.SubRest;

/**
 * The WebService implementation. This is a REST WebService that supports both XML and JSON. This is
 * done by leveraging JAXB and a plugin for JSON for JAXB (from Jackson)
 *
 * @version $Revision: $
 * @author $Author: cristiand $
 * @since $Date: May 11, 2012 $
 */
public class SubRestImpl implements SubRest {

    private static Logger log = LoggerFactory.getLogger(SubRestImpl.class);

    /* (non-Javadoc)
     * @see org.nooni.ws.rest.SubRest#getSub(java.lang.String)
     */
    public Sub getSub(String subid) {
        Sub sub = new Sub();
        sub.setSubid(subid);
        sub.setEmail("sub@gmail.com");
        sub.setPhone("416-943-9696");
        log.debug("getSub(" + subid + ")");
        return sub;
    }

    /* (non-Javadoc)
     * @see org.nooni.ws.rest.SubRest#makeQuery(java.lang.String)
     */
    public Query makeQuery(String qnm) {
        Query res = new Query();
        res.setName(qnm);
        Parm p1 = new Parm();
        p1.setName("firstName"); p1.setValue("Abby");
        Parm p2 = new Parm();
        p2.setName("lastName"); p2.setValue("Alligator");
        res.getParm().add(p1);
        res.getParm().add(p2);
        return res;
    }

    /* (non-Javadoc)
     * @see org.nooni.ws.rest.SubRest#query(org.nooni.ws.rest.QueryType)
     */
    public QueryResult query(Query query) throws IOException {
        log.info("POST query: " + query.getName() + "; parms: " + query.getParm());
        QueryResult res = new QueryResult();
        res.setStart(0);

        Sub sub = new Sub();
        sub.setSubid("123");
        sub.setEmail("sub@gmail.com");
        sub.setPhone("416-943-9696");

        res.getSub().add(sub);
        return res;
    }

}
