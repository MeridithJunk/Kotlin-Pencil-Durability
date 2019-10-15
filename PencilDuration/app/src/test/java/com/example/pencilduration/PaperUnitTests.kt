package com.example.pencilduration

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PaperUnitTests {

    private var paper: Paper? = null
    private val sentence = "this is a sentence"

    @Before
    fun setup() {

        this.paper = Paper(sentence)
    }

    @Test
    fun GIVEN_APencilAndPaper_WHEN_IWriteASentence_THEN_ThatSentenceIsReturned() {
        assertEquals(this.sentence, this.paper?.getSentence())
    }

    @Test
    fun givenAPaperWithASentenceInItWhenIWriteToItThenItWillAppendToTheSentence() {
        paper?.write(" and it is really cool!")

        val expectedValue = "this is a sentence and it is really cool!"

        assertEquals(expectedValue, paper?.getSentence())
    }

    @Test
    fun `Given text on paper that is misspelled, WHEN i want to edit, THEN the text will be replaced`() {
        paper?.write("How much wood would a woodchuck chuck if a woodchuck could chuck wood")
        paper?.erase("chuck")

        val expectedValue = "this is a sentenceHow much wood would a woodchuck chuck if a woodchuck could       wood"

        assertEquals(expectedValue, paper?.getSentence())
    }




}
