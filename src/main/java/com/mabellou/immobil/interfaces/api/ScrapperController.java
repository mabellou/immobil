package com.mabellou.immobil.interfaces.api;

import com.mabellou.immobil.scrapper.ScrapperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScrapperController {

    private ScrapperService scrapperService;

    public ScrapperController(ScrapperService scrapperService) {
        this.scrapperService = scrapperService;
    }

    @PutMapping("/scrapper")
    public ResponseEntity scrap() throws Exception{
        scrapperService.scrap();
        return ResponseEntity.noContent().build();
    }
}
