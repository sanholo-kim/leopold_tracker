package com.san.holo.tracker.service.impl;

import com.san.holo.tracker.service.CrawlService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CrawlServiceImpl implements CrawlService {

    @Value("${chrome.driver.path}")
    private String chromeDriverPath;
    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private static final String TEST_URL = "https://www.leopold.co.kr/Shop/ItemListKeyBoard.php";

    @Override
    public void crawlProduct() {
        System.setProperty(WEB_DRIVER_ID, chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--hide-scrollbars");
        options.addArguments("window-size=1080x1080");
        options.addArguments("disable-gpu");
        options.addArguments("--no-sandbox ");

        WebDriver driver = new ChromeDriver(options);
        driver.get(TEST_URL);
        System.out.println(driver.getPageSource());
        System.out.println(driver.getCurrentUrl());
    }
}
