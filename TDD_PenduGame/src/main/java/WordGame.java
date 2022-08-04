public class WordGame {

    private final String word;
    private String wordToDiscover;

    public WordGame(String word, String wordToDiscover) {
        this.word = word.toUpperCase();
        this.wordToDiscover = wordToDiscover.toUpperCase();
    }

    public String getWord() {
        return word;
    }

    public String getWordToDiscover() {
        return wordToDiscover;
    }

    public void setWordToDiscover(String wordToDiscover) {
        this.wordToDiscover = wordToDiscover;
    }


}
