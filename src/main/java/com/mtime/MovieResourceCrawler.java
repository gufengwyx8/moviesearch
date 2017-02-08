package com.mtime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mtime.model.Movie;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yixiong.wyx
 */
public class MovieResourceCrawler extends WebCrawler {

    private static final Logger log = LoggerFactory.getLogger(MovieResourceCrawler.class);

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp3|zip|gz))$");

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && href.startsWith("http://bbs.btwuji.com/read.php?tid=");
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();
        System.out.println("URL: " + url);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            if (isResourcePage(url)) {
                Movie movie = parse(htmlParseData.getText(), url);
                log.info("{}", movie);
            }
        }
    }

    private boolean isResourcePage(String url) {
        return url.startsWith("http://bbs.btwuji.com/read.php?tid=");
    }

    private Movie parse(String text, String url) {
        String allText = text.replaceAll("([\\S\\s]*(?<=无极电影 » 精品电影交流 » ))|((?= 本帖地址：)[\\S\\s]*)", "");
        Pattern p = Pattern.compile("\\[(\\S+?)\\]");
        Matcher m = p.matcher(allText);
        Movie movie = new Movie();
        m.find();
        movie.setTime(m.group(1));
        m.find();
        movie.setCountry(m.group(1));
        m.find();
        movie.setName(m.group(1));
        m.find();
        movie.setType(m.group(1));
        m.find();
        movie.setCategory(m.group(1));
        movie.setResource(url);
        return movie;
    }
}
