package com.mabellou.immobil.scrapper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ScrapperService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScrapperService.class);

    public void scrap() throws IOException {
        Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        LOGGER.info(doc.title());
        Elements newsHeadlines = doc.select("#mp-itn b a");
        for (Element headline : newsHeadlines) {
            LOGGER.info("{}\n\t{}",
                    headline.attr("title"), headline.absUrl("href"));
        }
    }
}
