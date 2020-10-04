package com.dmd.trie

import com.dmd.trie.TrieBuilder.Companion.buildTrie
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

internal class TrieBuilderTest {

    @Test
    fun `non empty trie`() {
        val trie = buildTrie(arrayOf("amazing", "awesome", "trie"))
        assertThat(trie).isNotNull()
    }
}