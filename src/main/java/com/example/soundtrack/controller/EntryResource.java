package com.example.soundtrack.controller;

import com.example.soundtrack.model.Entry;
import com.example.soundtrack.service.EntryService;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;

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

    @POST
    @Path("test-watson")
    public ToneAnalysis analyzeToneWatson(Entry entry) {
        return entryService.analyzeToneWatson(entry.getText());
    }

}

