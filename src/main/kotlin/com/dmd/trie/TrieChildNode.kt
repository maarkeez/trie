package com.dmd.trie

internal class TrieChildNode(private val letter: Char) {

    private var isFinalNode = false
    private val children = mutableMapOf<Char, TrieChildNode>()

    internal fun hasChildFor(letter: Char): Boolean {
        return children.containsKey(letter)
    }

    internal fun getOrPutChild(letter: Char): TrieChildNode {
        return children.getOrPut(letter) { TrieChildNode(letter) }
    }

    internal fun getChild(letter: Char): TrieChildNode {
        return children.getOrElse(letter) {
            throw IllegalArgumentException("Trie node ${this.letter}, does not contains a child for $letter")
        }
    }

    internal fun setAsFinalNode() {
        isFinalNode = true
    }

    internal fun isFinalNode(): Boolean {
        return isFinalNode
    }

    internal fun findWords(wordPrefix: String): Set<String> {

        val words = mutableSetOf<String>()
        findWords(this, wordPrefix, words)
        return words.sorted().toSet()

    }

    private fun findWords(node: TrieChildNode, word: String, words: MutableSet<String>) {

        if (node.isFinalNode()) {
            words.add(word + letter.toString())
        }

        val middleWord = word + letter
        node.children.values.forEach { child ->
            child.findWords(child, middleWord, words)
        }

    }

}