public class PenduSystem {

    private final String[] wordsAvailable;

    public PenduSystem() {
        this.wordsAvailable = new String[]{"cactus", "protestation", "danger", "affiche", "fichier",
                "orphelin", "jupiter", "guirlande", "ceinture", "kangourou", "oreille", "arriere",
                "fertile", "peluche", "estimation", "bouteille", "ceremonial", "abandonne", "supplice",
                "predire", "polaire", "chaud", "cryptage", "bachelier", "canape", "hachette", "mordre",
                "traumatisme", "hamster", "filament", "poesie", "cecite", "myrtille", "phenomenes",
                "toutefois", "barricade", "cambriolage", "lion", "antiviral", "donut", "poisson", "sourire"};
    }

    public String getWord() {
        return wordsAvailable[(int) (Math.random() * wordsAvailable.length)].toUpperCase();
    }

    public String getTotallyHiddenWord(String word) {
        return "_".repeat(splitWord(word).length);
    }

    public boolean letterMatch(String letter, WordGame wordGame) {
        return wordGame.getWord().contains(letter.toUpperCase());
    }

    public String replaceWordWithLetter(String letter, WordGame wordGame) {
        String[] splitWord = splitWord(wordGame.getWord());
        String[] wordToDiscover = splitWord(wordGame.getWordToDiscover());

        for (int i = 0; i < splitWord.length; i++) {
            if (splitWord[i].equals(letter.toUpperCase())) {
                wordToDiscover[i] = letter.toUpperCase();
            }
        }
        StringBuilder word = new StringBuilder();
        for (String s : wordToDiscover) {
            word.append(s);
        }
        wordGame.setWordToDiscover(String.valueOf(word));
        return String.valueOf(word);
    }

    public int countLetterFound(String letterToFind, WordGame wordGame) {
        int numberLetterFound = 0;
        String[] splitWord = splitWord(wordGame.getWord());
        for (String letter : splitWord) {
            if (letterToFind.toUpperCase().equals(letter)) {
                numberLetterFound++;
            }
        }
        return numberLetterFound;
    }

    private String[] splitWord(String wordToSplit) {
        return wordToSplit.split("");
    }


}

