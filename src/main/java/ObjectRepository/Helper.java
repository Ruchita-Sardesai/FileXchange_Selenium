package ObjectRepository;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * An example of loading jQuery dynamically using WebDriver.
 */
public class Helper {

    // its nice to keep JavaScript snippets in separate files.
    private static final String JQUERY_LOAD_SCRIPT = "resources\\jQuerify.js";

    // driver
    public static void main(String[] args) throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        String jQueryLoader = readFile(JQUERY_LOAD_SCRIPT);

        // give jQuery time to load asynchronously
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript(jQueryLoader /*, http://localhost:8080/jquery-1.7.2.js */);

        // ready to rock
        js.executeScript(
            "jQuery(function($) { " +
                " $('input[name=\"q\"]').val('bada-bing').closest('form').submit(); " +
            " }); "
        );
    }

    // helper method
    private static String readFile(String file) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(file);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        }
        finally {
            stream.close();
        }        
    }
}