package org.crawljax_owtf.main;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Config {

    @Expose
    private String target;
    @Expose
    private String browser;
    @Expose
    private List<String> clickElements = new ArrayList<String>();
    @Expose
    private Integer depth;
    @Expose
    private String log;
    @Expose
    private String output;
    @Expose
    private Boolean fillForms;
    @Expose
    private Integer parallelBrowsers;
    @Expose
    private Integer maxStates;
    @Expose
    private Integer maxCrawlTime;
    @Expose
    private Integer waitAfterEvent;
    @Expose
    private Integer waitAfterReload;

    /**
     *
     * @return
     * The target
     */
    public String getTarget() {
        return target;
    }

    /**
     *
     * @param target
     * The target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     *
     * @return
     * The browser
     */
    public String getBrowser() {
        return browser;
    }

    /**
     *
     * @param browser
     * The browser
     */
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    /**
     *
     * @return
     * The clickElements
     */
    public List<String> getClickElements() {
        return clickElements;
    }

    /**
     *
     * @param clickElements
     * The clickElements
     */
    public void setClickElements(List<String> clickElements) {
        this.clickElements = clickElements;
    }

    /**
     *
     * @return
     * The depth
     */
    public Integer getDepth() {
        return depth;
    }

    /**
     *
     * @param depth
     * The depth
     */
    public void setDepth(Integer depth) {
        this.depth = depth;
    }

    /**
     *
     * @return
     * The log
     */
    public String getLog() {
        return log;
    }

    /**
     *
     * @param log
     * The log
     */
    public void setLog(String log) {
        this.log = log;
    }

    /**
     *
     * @return
     * The output
     */
    public String getOutput() {
        return output;
    }

    /**
     *
     * @param output
     * The output
     */
    public void setOutput(String output) {
        this.output = output;
    }

    /**
     *
     * @return
     * The fillForms
     */
    public Boolean getFillForms() {
        return fillForms;
    }

    /**
     *
     * @param fillForms
     * The fillForms
     */
    public void setFillForms(Boolean fillForms) {
        this.fillForms = fillForms;
    }

    /**
     *
     * @return
     * The parallelBrowsers
     */
    public Integer getParallelBrowsers() {
        return parallelBrowsers;
    }

    /**
     *
     * @param parallelBrowsers
     * The parallelBrowsers
     */
    public void setParallelBrowsers(Integer parallelBrowsers) {
        this.parallelBrowsers = parallelBrowsers;
    }

    /**
     *
     * @return
     * The maxStates
     */
    public Integer getMaxStates() {
        return maxStates;
    }

    /**
     *
     * @param maxStates
     * The maxStates
     */
    public void setMaxStates(Integer maxStates) {
        this.maxStates = maxStates;
    }

    /**
     *
     * @return
     * The maxCrawlTime
     */
    public Integer getMaxCrawlTime() {
        return maxCrawlTime;
    }

    /**
     *
     * @param maxCrawlTime
     * The maxCrawlTime
     */
    public void setMaxCrawlTime(Integer maxCrawlTime) {
        this.maxCrawlTime = maxCrawlTime;
    }

    /**
     *
     * @return
     * The waitAfterEvent
     */
    public Integer getWaitAfterEvent() {
        return waitAfterEvent;
    }

    /**
     *
     * @param waitAfterEvent
     * The waitAfterEvent
     */
    public void setWaitAfterEvent(Integer waitAfterEvent) {
        this.waitAfterEvent = waitAfterEvent;
    }

    /**
     *
     * @return
     * The waitAfterReload
     */
    public Integer getWaitAfterReload() {
        return waitAfterReload;
    }

    /**
     *
     * @param waitAfterReload
     * The waitAfterReload
     */
    public void setWaitAfterReload(Integer waitAfterReload) {
        this.waitAfterReload = waitAfterReload;
    }

}