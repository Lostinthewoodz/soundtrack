package com.example.soundtrack.controllers;

import com.example.soundtrack.models.Entry;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/entries")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class EntryResource {

    @GET
    public String healthCheck() {
        String healthCheck = "YO " + Math.random();
        return healthCheck;
    }

    @POST
    public Entry processEntry(Entry entry) {
        // TODO: get sentiment
        return entry;
    }

}

