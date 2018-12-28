package com.example.soundtrack.controller;

import com.example.soundtrack.model.Entry;
import com.example.soundtrack.service.EntryService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/entries")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class EntryResource {

    EntryService entryService = new EntryService();

    @GET
    public String healthCheck() {
        String healthCheck = "YO " + Math.random();
        return healthCheck;
    }

    @GET
    @Path("example")
    public Entry getExample() {
        return entryService.sampleGetEntry();
    }

    @POST
    public Entry processEntry(Entry entry) {
        // TODO: get sentiment
        return entry;
    }

    @GET
    @Path("test-watson")
    public void testWatson() {
        entryService.testWatson();
    }

}

