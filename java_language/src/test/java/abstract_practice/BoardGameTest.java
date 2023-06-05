package abstract_practice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardGameTest {

    @Test
    public void abstractClassTest(){
        BoardGame boardGame = new BoardGame() {
            @Override
            public String printGameTitle() {
                return "this is board game";
            }
        };

        Assertions.assertEquals(boardGame.play(), "play this is board game");
        Assertions.assertEquals(boardGame.printGameTitle(), "this is board game");
    }

    @Test
    public void ChessClassTest(){
        BoardGame boardGame = new Chess();
        Assertions.assertEquals(boardGame.play(), "let's play board game:chess");
        Assertions.assertEquals(boardGame.printGameTitle(), "board game:chess");
    }

    @Test
    public void CheckerClassTest(){
        BoardGame boardGame = new Checker();
        Assertions.assertEquals(boardGame.play(), "play checker");
        Assertions.assertEquals(boardGame.printGameTitle(), "checker");

        Checker checker = new Checker();
        Assertions.assertEquals(checker.play(), "play checker");
        Assertions.assertEquals(checker.printGameTitle(), "checker");
        Assertions.assertEquals(checker.getPrice(), 2000);
    }
}