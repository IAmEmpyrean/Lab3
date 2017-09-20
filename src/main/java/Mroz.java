import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/*
 * @author Andrew and Sarah
 */
public class Mroz {



    public static void main(String[] args) {
        System.out.println("Mroz had a little lamb"); // for fun
        String url = "http://erdani.com/tdpl/hamlet.txt"; // url string
        String urlString = urlToString(url); //parses destination to string
        //String urlString = " Hamlet was a dank memer. Hamlet had his love life. Aelmao Hamlet.";
        //System.out.println(urlString);

        int stringLength = urlString.length(); // length of parsed destination's string
        char space = ' '; // space char
        int g = 1; // last space
        int g2 = 0; // first space
        String word = "hamlet".toLowerCase(); // word you are searching for
        int z = 0; // count of the word in text
        boolean kek; // wether there was a '.' or not

        for (int x = 0; x < stringLength; x++) { // for loop to iterate through the string
           if (urlString.charAt(x) == space || urlString.charAt(x) == '.') { // checks for whitespace or periods
               if (urlString.charAt(x) == '.') { // if it's a period exclude it
                   g = x;
                   x++;
                   kek = true;
               } else { // if not operate normal
                   kek = false;
                   g = x;
               }
               if (g != g2) { // if functioning correctly
                   if (urlString.substring(g2 + 1, g).toLowerCase().compareTo(word) == 0) {//check for word
                       z++; // increment word counter
                   }

                   // Debugging tests
                   //---
                   //System.out.print((g2 + 1) + " to " + (g - 1) + ": ");
                   //System.out.println(urlString.substring(g2 + 1, g));
                   // ---
               if (g > g2 && !kek) { // updates old whitespace index to new one if there is no period
                   g2 = g;
               } else { //removes period
                   g2 = g + 1;
               }
               }
           }
        }
        System.out.println(word + " appears " + z + " times."); //prints the number of words





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
