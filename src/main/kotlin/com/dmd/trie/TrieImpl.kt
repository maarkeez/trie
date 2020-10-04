package com.dmd.trie


internal class TrieImpl : Trie {

    private val children = mutableMapOf<Char, TrieChildNode>()

    override fun hasWordStartingWith(prefix: String): Boolean {
        return findNodeStartingWith(prefix).second != null
    }

    override fun hasWord(searchedWord: String): Boolean {
        return findNodeStartingWith(searchedWord).second?.isFinalNode() ?: false
    }

    override fun findWordsStartingWith(prefix: String): Set<String> {
        val found = findNodeStartingWith(prefix)

        // If middle node it's not found, just finish the search
        val node = found.second ?: return emptySet()
        val wordPrefix = found.first

        // We need to remove the last character, because it's the same one that from the node
        val wordPrefixWithoutLast = wordPrefix.substring(0, wordPrefix.length - 1)
        return node.findWords(wordPrefixWithoutLast)

    }

    internal fun getOrPutChild(letter: Char): TrieChildNode {
        return children.getOrPut(letter) { TrieChildNode(letter) }
    }

    private fun hasChildFor(letter: Char): Boolean {
        return children.containsKey(letter)
    }

    private fun getChild(letter: Char): TrieChildNode {
        return children.getOrElse(letter) {
            throw IllegalArgumentException("Trie does not contains a child for $letter")
        }
    }

    private fun findNodeStartingWith(search: String): Pair<String, TrieChildNode?> {

        if (search.isEmpty() || !hasChildFor(search.first())) {
            return Pair("", null)
        }

        val firstChar = search.first();
        val wordWithoutFirst = search.substring(1, search.length)

        var previousNode: TrieChildNode = getChild(firstChar)
        var stringSearchPath = firstChar.toString()

        wordWithoutFirst.forEach { character ->
            stringSearchPath += character
            if (!previousNode.hasChildFor(character)) {
                return Pair(stringSearchPath, null)
            }

            previousNode = previousNode.getChild(character)
        }

        return Pair(stringSearchPath, previousNode)

    }

}