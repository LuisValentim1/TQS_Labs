import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class tqs_stackTest {

    private tqs_stack stack_one;

    @BeforeEach
    void setUp(){
        stack_one = new tqs_stack();
    }

    @AfterEach
    void tearDown(){

    }

    @Test
    @DisplayName("Stack está vazio na inicialização")
    void isEmptyOnCreationTest(){
        assertTrue(stack_one.isEmpty(), "O stack está vazio.");
        assertEquals(0, stack_one.size(), "O Stack está vazio");
    }

    @Test
    @DisplayName("Após n pushes numa stack que estava vazia, a stack terá n elementos")
    void nPushesNElementsTest(){
        assertTrue(stack_one.isEmpty(), "O stack está vazio.");
        int min = 1;
        int max = 10;
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        for(int i = 0; i<random_int; i++){
            stack_one.push("Something" + Integer.toString(i));
        }
        assertEquals(random_int, stack_one.size(), "O Stack tem" + Integer.toString(stack_one.size()) + "elementos e devia ter" + Integer.toString(random_int) + ".");
    }

    @Test
    @DisplayName("Se damos push de x o valor de pop será x")
    void pushXPopXTest(){
        stack_one.push("Isto");
        assertEquals("Isto", stack_one.pop(), "O stack dará pop de 'Isto' ");
    }

    @Test
    @DisplayName("Se damos push de x o valor de peek será x mas o tamanho da stack não é alterado")
    void pushXPeekXTest(){
        stack_one.push("Isto");
        assertEquals("Isto", stack_one.peek(), "O stack dará pop de 'Isto' ");
        assertEquals(1, stack_one.size(), "O Stack possui 1 elemento");
    }

    @Test
    @DisplayName("Uma stack com n elemntos estará vazia após n pops")
    void emptyAfterNPopsTest(){
        assertTrue(stack_one.isEmpty(), "O stack está vazio.");
        int min = 1;
        int max = 10;
        int random_int = (int)(Math.random() * (max - min + 1) + min);
        for(int i = 0; i<random_int; i++){
            stack_one.push("Something" + Integer.toString(i));
        }
        assertEquals(random_int, stack_one.size(), "O Stack tem" + Integer.toString(stack_one.size()) + "elementos e devia ter" + Integer.toString(random_int) + ".");
        for(int i = 0; i<random_int; i++){
            stack_one.pop();
        }
        assertTrue(stack_one.isEmpty(), "O stack está vazio.");
    }

    @Test
    @DisplayName("Fazer pop numa stack fazia resulta em NoSuchElementException")
    void popNoSuchElementTest(){
        assertTrue(stack_one.isEmpty(), "O stack está vazio.");
        assertThrows(NoSuchElementException.class, () ->{
            stack_one.pop();
        });
    }

    @Test
    @DisplayName("Fazer peek numa stack fazia resulta em NoSuchElementException")
    void peekNoSuchElementTest(){
        assertTrue(stack_one.isEmpty(), "O stack está vazio.");
        assertThrows(NoSuchElementException.class, () ->{
            stack_one.peek();
        });
    }

    @Test
    @DisplayName("Numa bounded stack com a capacidade máxima não podem ser pushed novos elementos")
    void pushIllegalStateTest(){
        assertTrue(stack_one.isEmpty(), "O stack está vazio.");
        stack_one.boundTo(1);
        stack_one.push(1);
        assertEquals(1, stack_one.size(), "O Stack está na sua capacidade máxima, 1");
        assertThrows(IllegalStateException.class, () ->{
            stack_one.push(2);
        });
    }
}