package com.app.todo.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.app.todo.scraper.ScraperService;

@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200", "https://cg1p-frontend.herokuapp.com"})
@RestController
public class FAQController {
    private ScraperService scraperService;
    private FAQService faqService;

    @Autowired
    public FAQController(ScraperService scraperService, FAQService faqService) {
        this.scraperService = scraperService;
        this.faqService = faqService;
    }

    @GetMapping(path = "faq/scrape/{URL}")
    public List<FAQ> retrieveImage(@PathVariable(value = "URL") String URL) {
        List<String> scrappedSrc = scraperService.scrapeFAQ(URL);
        return faqService.retrieveAllFAQ(scrappedSrc);
    }
}
