import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

// k

/*
 * @author Andrew and Sarah
 */

public class Mroz {



    public static void main(String[] args) {
        System.out.println("Mroz had a little lamb");
        String url = "http://erdani.com/tdpl/hamlet.txt";
        String urlString = urlToString(url);
        System.out.println(urlString);





    }



    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static final String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
}
