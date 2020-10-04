# Trie

![badge workflow status](https://img.shields.io/github/workflow/status/maarkeez/trie/Java%20CI%20with%20Gradle)

This project implements [Trie](https://en.wikipedia.org/wiki/Trie) search such as
* Check if the Trie contains a word starting with a given prefix
* Check if a word it's contained in the Trie
* Find all the words in the Trie starting with a prefix


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

In order to be able to develop on this project, you will need to install:

* [Kotlin](https://kotlinlang.org/docs/reference/)

* [Kotlin development IDE](https://www.jetbrains.com/idea/)

* [Gradle 6.1](https://gradle.org/install/)


### Installing

Follow this steps to get a development environment running

* Clone the repository

```
git clone https://github.com/maarkeez/trie.git
```

* Import the project as Gradle project to your Java development IDE
* Build the project

```
gradlew clean build -x test
```

## Running the tests

Main tests can be found [here](./src/test/kotlin/com/dmd/trie/TrieTest.kt)

```
gradlew test
```

## Authors

* **David Márquez Delgado** - *Initial work* 

## License

This project is licensed under [GNU General Public License v3.0](LICENSE.md)
