package org.crawljax_owtf.main;

import com.crawljax.browser.EmbeddedBrowser.BrowserType;
import com.crawljax.core.CrawljaxRunner;
import com.crawljax.core.configuration.BrowserConfiguration;
import com.crawljax.core.configuration.CrawljaxConfiguration;
import com.crawljax.core.configuration.CrawljaxConfiguration.CrawljaxConfigurationBuilder;
import com.crawljax.plugins.crawloverview.CrawlOverview;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class Builder {

    public static void main(String[] args) throws Exception {
        System.getProperties().put("http.proxyHost", "127.0.0.1");
        System.getProperties().put("http.proxyPort", "8008");

        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/viyat/IdeaProjects/owtf-crawljax/config.json"));
            String message = org.apache.commons.io.IOUtils.toString(reader);
            map = mapper.readValue(message, HashMap.class);

        } catch  (IOException e) {
            e.printStackTrace();
        }

        CrawljaxConfigurationBuilder builder = CrawljaxConfiguration.builderFor(map.get("target").toString());

        builder.crawlRules().insertRandomDataInInputForms(false);

        // click these elements
        builder.crawlRules().clickDefaultElements();

        int c = ((ArrayList<Object>)map.get("clickElements")).size();

        for(int i=0; i < c; i++) {
            builder.crawlRules().click(map.get("clickElements").toString());
        }

        builder.setMaximumStates((int)map.get("maxStates"));
        builder.setMaximumDepth((int)map.get("depth"));
        builder.crawlRules().clickElementsInRandomOrder(true);

        // Set timeouts
        builder.crawlRules().waitAfterReloadUrl((int)map.get("waitAfterReload"), TimeUnit.MILLISECONDS);
        builder.crawlRules().waitAfterEvent((int)map.get("waitAfterEvent"), TimeUnit.MILLISECONDS);

        // use two browsers simultaneously.
        builder.setBrowserConfig(new BrowserConfiguration(BrowserType.FIREFOX, 2));
        builder.addPlugin(new CrawlOverview());

        CrawljaxRunner crawljax = new CrawljaxRunner(builder.build());
        crawljax.call();
    }
}
