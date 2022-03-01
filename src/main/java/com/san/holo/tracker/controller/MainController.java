package com.san.holo.tracker.controller;

import com.san.holo.tracker.service.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private CrawlService crawlService;

    @GetMapping(path = "/v1/crawl")
    public String crawl() {
        crawlService.crawlProduct();
        return "Submitted";
    }
}
