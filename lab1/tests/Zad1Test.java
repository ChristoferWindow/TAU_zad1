import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Zad1Test {

    Zad1 zad1;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        zad1 = new Zad1();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void isAdult() {
    }

    @Test
    void testThrowsExceptionWhenAgeLessThanZero() {
        assertThrows(NumberLessThanZeroException.class, () -> {
            zad1.IsAdult(-1);
        });
    }

    @Test
    void testReturnsFalseWhenAgeLessThanEighteen() throws NumberLessThanZeroException {
        assertFalse(zad1.IsAdult(15), "testReturnsFalseWhenAgeLessThanEighteen");
    }

    @Test
    void testReturnsTrueWhenAgeMoreEqualEighteen() throws NumberLessThanZeroException {
        assertTrue(zad1.IsAdult(19), "testReturnsFalseWhenAgeLessThanEighteen");
    }

    @Test
    void testThrowsExceptionWhenNameIsLessThanThreeCharacters() {
        assertThrows(StringToShortException.class, () -> {
            zad1.IsNameCorrect("ab");
        });
    }

    @Test
    void testPassesWhenNameIsMoreEqualThreeCharacters() throws StringNotAsciiException, StringToShortException {
        assertTrue(zad1.IsNameCorrect("tes"));
    }

    @Test
    void testThrowsExceptionWhenNameIsNotPureAscii() {
        assertThrows(StringNotAsciiException.class, () -> {
            zad1.IsNameCorrect("abcd1");
        });
    }

    @Test
    void testPassesWhenNameIsPureAscii() throws StringNotAsciiException, StringToShortException {
        assertTrue(zad1.IsNameCorrect("abcd"));
    }

    @Test
    void testPassesWhenCvvLengthIsThreeAndIsNumeric() throws CvvLengthIncorrectException, CvvNotANumberException {
        assertTrue(zad1.IsCvvCorrect("123"));
    }

    @Test
    void testThrowsExceptionWhenCvvLengthIsIncorrect() {
        assertThrows(CvvLengthIncorrectException.class, () -> {zad1.IsCvvCorrect("12");});
        assertThrows(CvvLengthIncorrectException.class, () -> {zad1.IsCvvCorrect("1256");});
    }

    @Test
    void testThrowsExceptionWhenCvvIsNotNumbers() {
        assertThrows(CvvLengthIncorrectException.class, () -> {zad1.IsCvvCorrect("abcd");});
        assertThrows(CvvLengthIncorrectException.class, () -> {zad1.IsCvvCorrect("ab");});
    }
}