import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerDecodeTest {

    @Test()
    public void testDec() {
        Assertions.assertEquals(Main.decode("555"), 555);
    }

    @Test()
    public void testNegativeDec() {
        Assertions.assertEquals(Main.decode("-0x22B"), -555);
    }

    @Test()
    public void testHex() {
        Assertions.assertEquals(Main.decode("0x22B"), 555);
        Assertions.assertEquals(Main.decode("#22B"), 555);
    }

    @Test()
    public void testNegativeHex() {
        Assertions.assertEquals(Main.decode("-0x22B"), -555);
        Assertions.assertEquals(Main.decode("-#22B"), -555);
    }

    @Test()
    public void testX() {
        Assertions.assertEquals(Main.decode("0X22B"), 555);
    }

    @Test()
    public void testOct() {
        Assertions.assertEquals(Main.decode("01053"), 555);
    }

    @Test()
    public void testNegativeOct() {
        Assertions.assertEquals(Main.decode("-01053"), -555);
    }

    private void check(String input) {

        NumberFormatException thrown = Assertions.assertThrows(NumberFormatException.class, () -> {
            Main.decode(input);
        });
        Assertions.assertEquals(NumberFormatException.class,thrown.getClass());
    }

    @Test()
    public void testNFE() {
        check("");
        check("xdxDFsa1g");
        check("0xL67");
        check("0128");
    }

    @Test()
    public void testNPE() {

        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            Main.decode(null);
        });

        Assertions.assertEquals(NullPointerException.class, thrown.getClass());
    }
}
