package com.example.pencilduration

class Pencil(var durability: Int = 50, var remainingSharpenings: Int = 5, var EraserDurability: Int = 50) {

    private var defaultDurability = 0
    private val uppercaseDegradation = 2
    private val lowercaseDegradation = 1
    private val spaceDegradation = 0


    init {
        this.defaultDurability = durability
    }


    fun degrades(sentence: String): String {

        sentence.toCharArray().forEach {
            degradePencilDurability(it)
        }
        return sentence
    }


    private fun degradePencilDurability(characterInSentence: Char) {
        when {
            this.durability <= 0 -> this.durability = 0
            !characterInSentence.isLetter() -> this.durability = this.durability - spaceDegradation
            characterInSentence.isUpperCase() -> this.durability = this.durability - uppercaseDegradation
            characterInSentence.isLowerCase() -> this.durability = this.durability - lowercaseDegradation
        }
    }

    private fun writeItOut(character: Char): Char {
        return when {
            this.durability == 0 -> ' '
            else -> return character
        }
    }

    fun degradesByChar(character: Char): Char {
        var writeThatCharacter = writeItOut(character)
        degradePencilDurability(writeItOut(character))
        return writeThatCharacter
    }

    fun sharpen() {
        if (this.remainingSharpenings > 0) {
            this.durability = this.defaultDurability
            this.remainingSharpenings--
        }
    }

    fun erase(wordToErase: String) {
        this.EraserDurability -= wordToErase.length
    }
}
