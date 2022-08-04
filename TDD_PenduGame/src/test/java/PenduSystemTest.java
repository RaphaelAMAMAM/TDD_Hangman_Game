import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PenduSystemTest {
    PenduSystem penduSystem = new PenduSystem();

    String word = "tabla";
    String wordToDiscover = penduSystem.getTotallyHiddenWord(word);
    WordGame wordGame = new WordGame(word, wordToDiscover);

    @Test
    void shouldReturnOnlyUnderscoresWhenWeHideWord() {
        String word = "table";
        String result = String.valueOf(penduSystem.getTotallyHiddenWord(word));
        assertThat(result).isEqualTo("_____");
    }

    @Test
    void shouldReturnTrueWhenLetterMatchWithWord() {
        String letter = "a";
        boolean result = penduSystem.letterMatch(letter, wordGame);
        assertThat(result).isTrue();
    }

    @Test
    void shouldReplaceUnknownLetterWithKnownLetter() {
        String letter = "a";
        String result = penduSystem.replaceWordWithLetter(letter, wordGame);
        assertThat(result).isEqualTo("_A__A");
    }

    @Test
    void shouldReturnTwoWhenLetterIsPresentTwiceInWord() {
        String letter = "a";
        int result = penduSystem.countLetterFound(letter, wordGame);
        assertThat(result).isEqualTo(2);
    }
}