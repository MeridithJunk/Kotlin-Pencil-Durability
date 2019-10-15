package com.example.pencilduration

class Paper {

    private var sentence: String? = null

    constructor(Sentence: String) {
        this.sentence = Sentence
    }

    fun getSentence(): String? {

        return this.sentence
    }

    fun write(textToWrite: String) {
        this.sentence += textToWrite
    }

    fun erase(word: String) {
        var whitespaceWordToReplace = " ".repeat(word.length)
        var startOfWordIndex = this.sentence?.lastIndexOf(word)
        var endOfWordIndex = startOfWordIndex?.plus(word.length)

        this.sentence =
            StringBuilder(this.sentence).replace(startOfWordIndex!!, endOfWordIndex!!, whitespaceWordToReplace)
                .toString()
    }

}
