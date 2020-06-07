package search

import java.io.File

fun main(args: Array<String>) {
    var filePath = "Simple Search Engine/task/src/search/text.txt"
    if (args.isNotEmpty()) {
        for (i in args.indices) {
            if (args[i] == "--data") {
                if (args.lastIndex >= i + 1) {
                    filePath = args[i + 1]
                } else {
                    println("no filename")
                }
            }
        }
    }

    val s = readFile(filePath)
    s.createSearchIndex()
    menu(s)
}

class Search(private val corpus: Array<String>) {
    var index = mutableMapOf<String, MutableList<Int>>()

    fun createSearchIndex() {
        for (lineIdx in corpus.indices) {
            val lineItems = corpus[lineIdx].split(" ")
            lineItems.forEach { it.trim() }
            lineItems.forEach {
                if (index.containsKey(it.toLowerCase())) {
                    index[it.toLowerCase()]!!.add(lineIdx)
                } else {
                    index[it.toLowerCase()] = mutableListOf(lineIdx)
                }
            }
        }
        //index.forEach() { println(" ${it.key} ${it.value}") }
    }

    fun queryIndexAny(queryStr: String): Array<String> {
        val result = mutableSetOf<String>()
        val searchTerms = queryStr.split(" ")
        for (term in searchTerms) {
            if (index.containsKey(term.toLowerCase())) {
                val idxResult = index[term.toLowerCase()]
                idxResult!!.forEach { result.add(corpus[it]) }
            }
        }
        return result.toTypedArray()
    }

    fun queryIndexAll(queryStr: String): Array<String> {
        // not working
        val result = mutableSetOf<String>()
        var idxHits = mutableSetOf<Int>()
        val searchTerms = queryStr.split(" ")
        for (term in searchTerms) {
            if (index.containsKey(term.toLowerCase())) {
                val idxResult = index[term.toLowerCase()]
                idxResult!!.forEach {
                    idxHits = if (idxHits.isEmpty()) {
                        idxResult.toMutableSet()
                    } else {
                        idxHits.intersect(mutableSetOf(it)) as MutableSet<Int>
                    }
                }
            }
        }
        for (key in idxHits) {
            result.add(corpus[key])
        }
        return result.toTypedArray()
    }

    fun queryIndexNone(queryStr: String): Array<String> {
        val result = mutableSetOf<String>()
        var idxHits = mutableSetOf<Int>()
        val searchTerms = queryStr.split(" ")
        for (term in searchTerms) {
            if (index.containsKey(term.toLowerCase())) {
                val idxResult = index[term.toLowerCase()]
                idxResult!!.forEach { idxHits.add(it) }
            }
        }
        for (i in corpus.indices) {
            if (i !in idxHits) {
                result.add(corpus[i])
            }
        }
        return result.toTypedArray()
    }

    fun query(queryStr: String): Array<String> {
        val result = arrayListOf<String>()
        for (line in corpus) {
            if (line.toLowerCase().contains(queryStr.toLowerCase())) result.add(line)
        }
        return result.toTypedArray()
    }

    fun print() {
        for (line in corpus) {
            println(line)
        }
    }
}

fun searchPeople(search: Search) {
    println("Select a matching strategy: ALL, ANY, NONE")
    val strategy = readLine()!!
    println("Enter a name or email to search all suitable people.")
    val query = readLine()!!
    val results: Array<String>
    results = when (strategy) {
        "ANY" -> {
            search.queryIndexAny(query)
        }
        "ALL" -> {
            search.queryIndexAll(query)
        }
        "NONE" -> {
            search.queryIndexNone(query)
        }
        else -> {
            search.queryIndexAny(query)
        }
    }

    for (result in results) {
        println(result)
    }
}

fun readStdin(): Search {
    println("Enter the number of people: ")
    val num = readLine()!!.toInt()
    val corpus = Array<String>(num) { "" }
    repeat(num) {
        val words = readLine()!!
        corpus[it] = words
    }
    return Search(corpus)
}

fun readFile(filePath: String): Search {
    val corpus = mutableListOf<String>()
    val file = File(filePath)

    if (file.exists()) {
        file.forEachLine { corpus.add(it) }
    } else {
        println("File not found.")
        val path = System.getProperty("user.dir")
        println("Working Directory = $path")
        println("Absolute Path = ${file.absolutePath}")
    }
    return Search(corpus.toTypedArray())
}

fun menu(search: Search) {

    do {
        println()
        println("=== Menu ===")
        println("1. Search information.")
        println("2. Print all data.")
        println("0. Exit.")
        println()
        val choice = readLine()!!.toInt()
        when (choice) {
            1 -> {
                searchPeople(search)
            }
            2 -> {
                println("=== List of people ===")
                search.print()
            }
            0 -> println("Bye!")
            else -> {
                println("Incorrect option! Try again.")
            }
        }
    } while (choice != 0)
}
