package step2

class ChunkTokenCalculator : TokenCalculator {

    override fun calculate(tokens: List<Token>): Int {
        val (headToken: Token, restTokens: List<Token>) = headWithRest(tokens)
        val firstOperand = headToken.getOperand()
        return restTokens
            .chunked(2)
            .fold(firstOperand) { acc, tokens ->
                val (operatorToken: Token, operandToken: Token) = tokens
                val operator = operatorToken.getOperator()
                val operand = operandToken.getOperand()
                operator.execute(acc, operand)
            }
    }
}