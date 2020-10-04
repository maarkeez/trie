package com.dmd.trie

interface Trie {
    fun hasWordStartingWith(prefix: String): Boolean
    fun hasWord(searchedWord: String): Boolean
    fun findWordsStartingWith(prefix: String): Set<String>
}