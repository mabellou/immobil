package com.mabellou.immobil.scrapper;

import com.mabellou.immobil.ImmobilApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ImmobilApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("unit")
public class ScrapperServiceTest {

    @Autowired
    private ScrapperService scrapperService;

    @LocalServerPort
    protected int port;

    @Test
    public void scrapTest() throws Exception{
        scrapperService.scrap();
        System.out.println("hello");
    }
}
