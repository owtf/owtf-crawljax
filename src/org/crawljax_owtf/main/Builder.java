package org.crawljax_owtf.main;

import com.crawljax.browser.EmbeddedBrowser.BrowserType;
import com.crawljax.core.CrawljaxRunner;
import com.crawljax.core.configuration.BrowserConfiguration;
import com.crawljax.core.configuration.CrawljaxConfiguration;
import com.crawljax.core.configuration.CrawljaxConfiguration.CrawljaxConfigurationBuilder;
import com.crawljax.plugins.crawloverview.CrawlOverview;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Builder {

    public static void main(String[] args) throws Exception {
        System.getProperties().put("http.proxyHost", "127.0.0.1");
        System.getProperties().put("http.proxyPort", "8008");
        //System.getProperties().put("http.proxyUser", "someUserName");
        //System.getProperties().put("http.proxyPassword", "somePassword");

        Gson gson = new Gson();
        Config conf = new Config();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/viyat/IdeaProjects/owtf-crawljax/config.json"));

            conf = gson.fromJson(reader, Config.class);

        } catch  (IOException e) {
            e.printStackTrace();
        }

        CrawljaxConfigurationBuilder builder = CrawljaxConfiguration.builderFor(conf.getTarget());

        builder.crawlRules().insertRandomDataInInputForms(false);

        // click these elements
        builder.crawlRules().clickDefaultElements();

        int c = conf.getClickElements().size();

        for(int i=0; i < c; i++) {
            builder.crawlRules().click(conf.getClickElements().get(i));
        }

        builder.setMaximumStates(conf.getMaxStates());
        builder.setMaximumDepth(conf.getDepth());
        builder.crawlRules().clickElementsInRandomOrder(true);

        // Set timeouts
        builder.crawlRules().waitAfterReloadUrl(conf.getWaitAfterReload(), TimeUnit.MILLISECONDS);
        builder.crawlRules().waitAfterEvent(conf.getWaitAfterEvent(), TimeUnit.MILLISECONDS);

        // use two browsers simultaneously.
        builder.setBrowserConfig(new BrowserConfiguration(BrowserType.FIREFOX, 2));
        builder.addPlugin(new CrawlOverview());

        CrawljaxRunner crawljax = new CrawljaxRunner(builder.build());
        crawljax.call();
    }
}
