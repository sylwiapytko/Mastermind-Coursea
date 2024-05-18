package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    var rightPosition = 0
    var wrongPosition = 0

    var modifableSecret = secret
    var modifableGuess = guess

    //Count and Filter out characters on correct position
    for (char in guess.withIndex()) {
            if (secret[char.index] == char.value) {
                rightPosition++
                modifableSecret = modifableSecret.replaceFirst(char.value.toString(), "")
                modifableGuess = modifableGuess.replaceFirst(char.value.toString(),"" )
            }
    }

    //Count and Filter out characters on wrong position
    for (char in modifableGuess.withIndex()) {
        if (modifableSecret.any { it == char.value }) {
            wrongPosition++
            modifableSecret = modifableSecret.replaceFirst(char.value.toString(),"")
        }
    }
    return Evaluation(rightPosition, wrongPosition)
}
