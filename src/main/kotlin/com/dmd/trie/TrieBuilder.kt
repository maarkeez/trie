package com.dmd.trie

class TrieBuilder {

    companion object {

        fun buildTrie(words: Array<String>): Trie {

            val trie = TrieImpl()

            words.forEach { word ->
                var previousNode: TrieChildNode? = null

                word.forEach { character ->

                    previousNode =
                        if (previousNode == null) trie.getOrPutChild(character)
                        else previousNode!!.getOrPutChild(character)
                }

                previousNode?.setAsFinalNode()
            }

            return trie
        }
    }
}