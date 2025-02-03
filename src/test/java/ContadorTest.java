
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ContadorTest {

    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    @SuppressWarnings("unused")
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    @SuppressWarnings("unused")
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("Should throw exception when first parameter is greater")
    void shouldThrowException() {
        ParametrosInvalidosException exception = assertThrows(ParametrosInvalidosException.class,
                () -> Contador.contar(10, 5));
    }

    @Test
    @DisplayName("Should accept when second parameter is greater")
    void shouldAcceptValidParameters() {
        assertDoesNotThrow(() -> Contador.contar(5, 10));
    }

    @Nested
    @DisplayName("Output Tests")
    @SuppressWarnings("unused")
    class OutputTests {

        @Test
        @DisplayName("Should print correct sequence")
        void shouldPrintCorrectSequence() {
            assertDoesNotThrow(() -> {
                Contador.contar(2, 5);
                String expected = "Imprimindo o número 3" + System.lineSeparator()
                        + "Imprimindo o número 4" + System.lineSeparator()
                        + "Imprimindo o número 5" + System.lineSeparator();
                assertEquals(expected, outputStream.toString());
            });
        }

        @Test
        @DisplayName("Should handle equal parameters")
        void shouldHandleEqualParameters() {
            assertDoesNotThrow(() -> {
                Contador.contar(5, 5);
                assertEquals("", outputStream.toString());
            });
        }
    }
}
