import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

// k kool

/*
 * @author Andrew and Sarah
 */

public class Mroz {



    public static void main(String[] args) {
        System.out.println("Mroz had a little lamb");
        String url = "http://erdani.com/tdpl/hamlet.txt";
        String urlString = urlToString(url);
        //System.out.println(urlString);

        int stringLength = urlString.length();
        char space = ' ';
        int g = 0;
        int g2 = 0;
        String word = "prince";
        int z = 0;

        for(int x = 0; x < stringLength-1; x++) {
            if(urlString.charAt(x) == space); {
                g = x;
            }
            if(g2 > 0 && g > 0) {
                if(urlString.substring(g2, g).toLowerCase().compareTo(word) == 0) {
                    z++;
                }
            }
            if (g > g2) {
                g2 = g;
            }
        }
        System.out.println(z);





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
