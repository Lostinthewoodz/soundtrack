package com.example.soundtrack.service;

import com.example.soundtrack.model.Entry;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

@Service
public class EntryService{

    RestTemplate restTemplate = new RestTemplate();

    IamOptions options = new IamOptions.Builder()
            .apiKey("Na5FNSHtZbfo2lX20E9px36gWGs6h6kHSfY1r9WC2zp8")
            .build();

    public String getSentiment() {
        return "howdy";
    }

    public Entry sampleGetEntry() {
        /* https://www.baeldung.com/rest-template for further reference */
        String url = "http://demo9104540.mockable.io/test";
        Entry entry = restTemplate.getForObject(url, Entry.class); // Gets the JSON from the url and converts to Entry object
        return entry;
    }

    public ToneAnalysis analyzeToneWatson(String text) {
        ToneAnalyzer toneAnalyzer = new ToneAnalyzer("2016-05-19", options);

        ToneOptions toneOptions = new ToneOptions.Builder()
                .text(text)
                .build();

        ToneAnalysis toneAnalysis = toneAnalyzer.tone(toneOptions).execute();

        return toneAnalysis;
    }

}
