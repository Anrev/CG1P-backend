package com.app.todo.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;

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

    @ApiOperation(value = "Retrieve a list of FAQs from a website", response = Iterable.class)
    @GetMapping(path = "/faq/scrape")
    public List<FAQ> retrieveImage(@RequestParam String URL) {
        List<String> scrappedSrc = scraperService.scrapeFAQ(URL);
        return faqService.retrieveAllFAQ(scrappedSrc);
    }

    @ApiOperation(value = "Scrape all the updated FAQs from a website", response = Iterable.class)
    @GetMapping(path = "/faq/update")
    public List<FAQ> updateFAQ(@RequestParam String URL) {
        List<String> scrappedSrc = scraperService.scrapeFAQ(URL);
        return faqService.updateFAQ(scrappedSrc);
    }

    @ApiOperation(value = "Retrieve all the FAQs stored in database", response = Iterable.class)
    @GetMapping(path = "faq/retrieveFromDB")
    public List<FAQ> retrieveFromDB() {
        return faqService.getAllFAQ();
    }
}
