import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

// k kool k

/*
 * @author Andrew and Sarah
 */

public class Mroz {



    public static void main(String[] args) {
        System.out.println("Mroz had a little lamb");
        String url = "http://erdani.com/tdpl/hamlet.txt";
        String urlString = urlToString(url);
        //String urlString = " Hamlet was a dank memer. Hamlet had his love life. Aelmao Hamlet.";
        //System.out.println(urlString);

        int stringLength = urlString.length();
        char space = ' ';
        int g = 1;
        int g2 = 0;
        String word = "hamlet";
        int z = 0;
        boolean kek;

        for(int x = 0; x < stringLength; x++) {
           if(urlString.charAt(x) == space || urlString.charAt(x) == '.') {
               if(urlString.charAt(x) == '.') {
                   g = x;
                   x++;
                   kek = true;
               }
               else {
                   kek = false;
                   g = x;
               }
               if(g != g2) {
                   if(urlString.substring(g2 + 1, g).toLowerCase().compareTo(word) == 0)
                       z++;

                   //System.out.print((g2 + 1) + " to " + (g - 1) + ": ");
                   //System.out.println(urlString.substring(g2 + 1, g));
               if(g>g2 && !kek)
                   g2 = g;
               else
                   g2 = g + 1;
               }
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
