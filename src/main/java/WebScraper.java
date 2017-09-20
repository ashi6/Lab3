import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Scrape the web or something.
 */
public class WebScraper {

    /**
     * main method.
     * @param args doesn't do anything
     */
    public static void main(final String[] args) {
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        int count = wordCount(text);
        System.out.println(count("Give", text));
        System.out.println(count);
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
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

    /**
     * Count the number of words in a string.
     *
     * @param text the string to count the number of words in
     * @return the number of words in the string
     */
    public static int wordCount(final String text) {
        String[] words = splitIntoWords(text);
        return words.length;
    }

    /**
     * Return an array of words in a string.
     *
     * @param text the string to split into an array
     * @return a string array containing the words in the string
     */
    public static String[] splitIntoWords(final String text) {
        return text.trim().split("\\s+");
    }

    /**
     * Counts the number of occurrences of a word in a string, case insensitive.
     *
     * @param word the word to search for in the string
     * @param text the string to search for the word in
     * @return the number of occurrences of the word in the string
     */
    public static int count(final String word, final String text) {
        Pattern pattern = Pattern.compile(word, Pattern.CASE_INSENSITIVE);
        Matcher m = pattern.matcher(text);
        int count = 0;
        while (m.find()) {
            count++;
        }
        return count;
    }
}
