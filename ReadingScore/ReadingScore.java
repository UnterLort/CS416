import java.util.Scanner;

/**
 * 
 * 
 * @author Kyle Stewart.
 * @version 5.
 */

public class ReadingScore {

    /**
     * 
     * 
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int readingScore = getReadingScore(text);
        System.out.println(readingScore);
        System.out.println(getReadingDifficulty(readingScore));
    }

    /**
     *
     *
     * @param token The token to be formatted.
     * @return The formatted token with non-alphabetic characters removed.
     */
    public static String formatToken(String token) {
        StringBuilder formattedToken = new StringBuilder();
        for (char c : token.toCharArray()) {
            if (Character.isLetter(c)) {
                formattedToken.append(c);
            }
        }
        return formattedToken.toString();
    }

    /**
     *
     *
     * @param text The text to be tokenized.
     * @return An array of strings where the text has been converted into tokens.
     */
    public static String[] tokenize(String text) {
        return text.split("\\s+");
    }

    /**
     *
     *
     * @param tokens An array of strings where the text has been converted into
     *               tokens.
     * @return The number of sentences in the tokens array.
     */
    public static int getSentenceCount(String[] tokens) {
        int sentenceCount = 0;
        for (String token : tokens) {
            char lastChar = token.charAt(token.length() - 1);
            if (lastChar == '.' || lastChar == ':' || lastChar == ';' || lastChar == '?' || lastChar == '!') {
                sentenceCount++;
            }
        }
        return sentenceCount;
    }

    /**
     *
     *
     * @param tokens An array of strings where the text has been converted into
     *               tokens.
     * @return The number of tokens in the array.
     */
    public static int getTokenCount(String[] tokens) {
        return tokens.length;
    }

    /**
     *
     *
     * @param word The word to count the syllables for.
     * @return The number of syllables in the word.
     */
    public static int getSyllableCount(String word) {
        word = formatToken(word);

        for (char c : word.toCharArray()) {
            if (isVowel(c)) {
                syllableCount++;
            }
        }
        if (word.endsWith("e") || word.endsWith("E")) {
            syllableCount--;
        }
        if (syllableCount < 1) {
            syllableCount = 1;
        }
        return syllableCount;
    }

    /**
     *
     *
     * @param tokens An array of strings where the text has been converted into
     *               tokens.
     * @return The total number of syllables in the tokens array.
     */
    public static double getTotalSyllableCount(String[] tokens) {
        double syllableCount = 0;
        for (String token : tokens) {
            syllableCount += getSyllableCount(token);
        }
        return syllableCount * 0.88;
    }

    /**
     *
     *
     * @param text The text to be analyzed.
     * @return The reading score of the text.
     */
    public static int getReadingScore(String text) {
        String[] tokens = tokenize(text);
        int tokenCount = getTokenCount(tokens);
        int sentenceCount = getSentenceCount(tokens);
        double totalSyllableCount = getTotalSyllableCount(tokens);
        double readingScore = Math
                .round(206.835 - 1.015 * (tokenCount / sentenceCount) - 84.6 * (totalSyllableCount / tokenCount));
        if (readingScore > 100) {
            readingScore = 100;
        }
        return (int) readingScore;
    }

    /**
     *
     *
     * @param score The reading score.
     * @return The reading difficulty based on the score.
     */
    public static String getReadingDifficulty(int score) {
        if (score >= 91 && score <= 100) {
            return "Very easy to read.";
        } else if (score >= 81 && score <= 90) {
            return "Easy to read.";
        } else if (score >= 71 && score <= 80) {
            return "Fairly easy to read.";
        } else if (score >= 61 && score <= 70) {
            return "Plain English.";
        } else if (score >= 51 && score <= 60) {
            return "Fairly difficult to read.";
        } else if (score >= 31 && score <= 50) {
            return "Difficult to read.";
        } else if (score >= 11 && score <= 30) {
            return "Very difficult to read.";
        } else {
            return "Extremely difficult to read.";
        }
    }

    /**
     *
     *
     * @param c The character to be checked.
     * @return {@code true} if the character is a vowel (a, e, i, o, u, or y),
     *         {@code false} otherwise.
     */
    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }
}