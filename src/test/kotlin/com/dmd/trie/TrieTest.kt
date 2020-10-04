package com.dmd.trie

import com.dmd.trie.TrieBuilder.Companion.buildTrie
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class TrieTest {

    private val trie = buildTrie(arrayOf("amazing", "awesome", "trie"))

    @Test
    fun `hasWordStartingWith - when empty search`() {
        val search = ""
        val found = trie.hasWordStartingWith(search)
        assertThat(found).isFalse()
    }

    @Test
    fun `hasWordStartingWith - when non existing substring`() {
        val search = "X"
        val found = trie.hasWordStartingWith(search)
        assertThat(found).isFalse()
    }

    @Test
    fun `hasWordStartingWith - when existing substring - one char in the middle`() {
        val search = "z"
        val found = trie.hasWordStartingWith(search)
        assertThat(found).isFalse()
    }

    @Test
    fun `hasWordStartingWith - when existing substring - two char in the middle`() {
        val search = "az"
        val found = trie.hasWordStartingWith(search)
        assertThat(found).isFalse()
    }

    @Test
    fun `hasWordStartingWith - when existing substring - one char in the beginning`() {
        val search = "a"
        val found = trie.hasWordStartingWith(search)
        assertThat(found).isTrue()
    }

    @Test
    fun `hasWordStartingWith - when existing substring - two char in the beginning`() {
        val search = "am"
        val found = trie.hasWordStartingWith(search)
        assertThat(found).isTrue()
    }


    @Test
    fun `hasWordStartingWith - when existing substring - complete word`() {
        val search = "trie"
        val found = trie.hasWordStartingWith(search)
        assertThat(found).isTrue()
    }

    @Test
    fun `hasWord - when word exists`() {
        val search = "trie"
        val found = trie.hasWord(search)
        assertThat(found).isTrue()
    }

    @Test
    fun `hasWord - when word does not exists`() {
        val search = "non-existing-word"
        val found = trie.hasWord(search)
        assertThat(found).isFalse()
    }

    @Test
    fun `hasWord - when is half of a word`() {
        val search = "tri"
        val found = trie.hasWord(search)
        assertThat(found).isFalse()
    }


    @Test
    fun `findWordsStartingWith - when one match`() {
        val search = "tri"
        val found = trie.findWordsStartingWith(search)
        assertThat(found).containsExactly("trie")
    }

    @Test
    fun `findWordsStartingWith - when multiple match`() {
        val search = "a"
        val found = trie.findWordsStartingWith(search)
        assertThat(found).containsExactly("amazing", "awesome")
    }

    @Test
    fun `findWordsStartingWith - when no match`() {
        val search = "no-match"
        val found = trie.findWordsStartingWith(search)
        assertThat(found).isEmpty()
    }
}