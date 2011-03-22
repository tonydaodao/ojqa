/**
 * 
 */
package org.ojqa.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.ojqa.domain.pojo.Activity;

/**
 * @author Isaac.Yu
 * 
 */
@Path("/activities/{}")
public class ActivityService {

    @GET
    public List<Activity> getActivity() {
        return null;
    }
}
