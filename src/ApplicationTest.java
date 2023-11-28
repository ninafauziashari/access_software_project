import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;
public class ApplicationTest {

    Application application = new Application();

    @Test
    @DisplayName("Given the user inserts `1`, the outcome should show `one dollar` (without s)")
    public void testForDollar() {
        String result = application.setDollarAndCent(1.0);
        assertEquals("one dollar", result);
    }

    @Test
    @DisplayName("Given the user inserts every single number, the outcome should show their respective word")
    public void testForSingles() {

        String[] expectedResult = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < expectedResult.length; i++) {
            String result = application.setDollarAndCent((double) i+2);

            assertEquals(expectedResult[i] + " dollars", result);
        }
    }

    @Test
    @DisplayName("Given the user inserts every single number in teens, the outcome should show their respective word")
    public void testForTeens() {

        String[] expectedResult = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        for (int i = 0; i < expectedResult.length; i++) {
            String result = application.setDollarAndCent((double) i+11);

            assertEquals(expectedResult[i] + " dollars", result);
        }
    }

    @Test
    @DisplayName("Given the user inserts every single number in teens, the outcome should show their respective word")
    public void testForTens() {

        String[] expectedResult = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        for (int i = 0; i < expectedResult.length; i++) {
            String result = application.setDollarAndCent((double) (i*10) + 10);

            assertEquals(expectedResult[i] + " dollars", result);
        }
    }

    @Test
    @DisplayName("Given the user inserts values that are multiples of elevens, the outcome should show their respective word")
    public void testForMultipleOfEleven() {

        String[] expectedResult = {"eleven", "twenty two", "thirty three", "forty four", "fifty five", "sixty six", "seventy seven", "eighty eight", "ninety nine"};

        for (int i = 0; i < expectedResult.length; i++) {
            String result = application.setDollarAndCent((double) (i*11) + 11);

            assertEquals(expectedResult[i] + " dollars", result);
        }
    }

    @Test
    @DisplayName("Given the user inserts `0.01`, the outcome should show `one cent`")
    public void testForOneCent() {
        String result = application.setDollarAndCent(0.01);
        assertEquals("one cent", result);
    }

    @Test
    @DisplayName("Given the user inserts `0.1`, the outcome should show `ten cents`")
    public void testForTenCent() {
        String result = application.setDollarAndCent(0.1);
        assertEquals("ten cents", result);
    }

    @Test
    @DisplayName("Given the user inserts `1.01`, the outcome should show `one dollar and one cent`")
    public void testForADollarAndACent() {
        String result = application.setDollarAndCent(1.01);
        assertEquals("one dollar and one cent", result);
    }

    @Test
    @DisplayName("Given the user inserts `1.1` or `1.10`, the outcome should show `one dollar and ten cents`")
    public void testForADollarAndTenCent() {
        String result = application.setDollarAndCent(1.1);
        assertEquals("one dollar and ten cents", result);
    }

    @Test
    @DisplayName("Given the user inserts `20`, the outcome should show `twenty dollars`")
    public void testForTwentyDollars() {
        String result = application.setDollarAndCent(20.0);
        assertEquals("twenty dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `10`, the outcome should show `ten dollars`")
    public void testForTenDollars() {
        String result = application.setDollarAndCent(10.0);
        assertEquals("ten dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `11`, the outcome should show `eleven dollars`")
    public void testForElevenDollars() {
        String result = application.setDollarAndCent(11.0);
        assertEquals("eleven dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `12`, the outcome should show `twelve dollars`")
    public void testForTwelveDollars() {
        String result = application.setDollarAndCent(12.0);
        assertEquals("twelve dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `0` or trailing zeroes, the outcome should show `No value`")
    public void testForZeroes() {
        String result = application.setDollarAndCent(0.0);
        assertEquals("No value", result);
    }

    @Test
    @DisplayName("Given the user inserts `100`, the outcome should show `one hundred dollars`")
    public void testForHundred() {
        String result = application.setDollarAndCent(100.0);
        assertEquals("one hundred dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `110`, the outcome should show `one hundred and ten dollars`")
    public void testForHundredAndTen() {
        String result = application.setDollarAndCent(110.0);
        assertEquals("one hundred and ten dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `110.10`, the outcome should show `one hundred and ten dollars and ten cents`")
    public void testForHundredAndTenAndTenCents() {
        String result = application.setDollarAndCent(110.10);
        assertEquals("one hundred and ten dollars and ten cents", result);
    }

    @Test
    @DisplayName("Given the user inserts `110.11`, the outcome should show `one hundred and ten dollars and eleven cents`")
    public void testForHundredAndTenAndElevenCents() {
        String result = application.setDollarAndCent(110.11);
        assertEquals("one hundred and ten dollars and eleven cents", result);
    }

    @Test
    @DisplayName("Given the user inserts `100.20`, the outcome should show `one hundred dollars and twenty cents`")
    public void testForHundredAndTenAndTwentyCents() {
        String result = application.setDollarAndCent(100.20);
        assertEquals("one hundred dollars and twenty cents", result);
    }

    @Test
    @DisplayName("Given the user inserts `111.00`, the outcome should show `one hundred and eleven dollars`")
    public void testForHundredAndElevenDollars() {
        String result = application.setDollarAndCent(111.00);
        assertEquals("one hundred and eleven dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `112.00`, the outcome should show `one hundred and twelve dollars`")
    public void testForHundredAndTwelveDollars() {
        String result = application.setDollarAndCent(112.00);
        assertEquals("one hundred and twelve dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `101.00`, the outcome should show `one hundred and one dollars`")
    public void testForHundredAndOneDollars() {
        String result = application.setDollarAndCent(101.00);
        assertEquals("one hundred and  one dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `1000.00`, the outcome should show `one thousand dollars`")
    public void testForThousandDollars() {
        String result = application.setDollarAndCent(1000.00);
        assertEquals("one thousand  dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `1100.00`, the outcome should show `one thousand one hundred dollars`")
    public void testForThousandOneHundredDollars() {
        String result = application.setDollarAndCent(1100.00);
        assertEquals("one thousand one hundred dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `1100.00`, the outcome should show `one thousand one hundred dollars`")
    public void testForThousandAndHundredDollars() {
        String result = application.setDollarAndCent(1011.00);
        assertEquals("one thousand  and eleven  dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `1001.00`, the outcome should show `one thousand and one dollars`")
    public void testForThousandAndOneDollars() {
        String result = application.setDollarAndCent(1001.00);
        assertEquals("one thousand  and   one dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `1011.00`, the outcome should show `one thousand and eleven dollars`")
    public void testForThousandAndElevenDollars() {
        String result = application.setDollarAndCent(1001.00);
        assertEquals("one thousand  and   one dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `1101.00`, the outcome should show `one thousand one hundred and one dollars`")
    public void testForThousandHundredAndOneDollars() {
        String result = application.setDollarAndCent(1101.00);
        assertEquals("one thousand one hundred and   one dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `1111.00`, the outcome should show `one thousand one hundred and eleven dollars`")
    public void testForThousandHundredAndElevenDollars() {
        String result = application.setDollarAndCent(1101.00);
        assertEquals("one thousand one hundred and   one dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `1211.00`, the outcome should show `one thousand two hundred and eleven dollars`")
    public void testForThousandTwoHundredAndElevenDollars() {
        String result = application.setDollarAndCent(1211.00);
        assertEquals("one thousand two hundred and eleven  dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `2011.00`, the outcome should show `two thousand and eleven dollars`")
    public void testForTwoThousandAndElevenDollars() {
        String result = application.setDollarAndCent(2011.00);
        assertEquals("two thousand  and eleven  dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `2222.00`, the outcome should show `two thousand and twenty two dollars`")
    public void testForTwoThousandAndTwentyTwoDollars() {
        String result = application.setDollarAndCent(2222.00);
        assertEquals("two thousand two hundred and twenty  two dollars", result);
    }

    @Test
    @DisplayName("Given the user inserts `3333.33`, the outcome should show `three thousand three hundred and thirty three dollars`")
    public void testForMultipleThreeThousands() {
        String result = application.setDollarAndCent(3333.33);
        assertEquals("three thousand three hundred and thirty  three dollars and thirty three cents", result);
    }

    @Test
    @DisplayName("Given the user inserts `4.100`, the outcome should show `four dollars and ten cents`")
    public void testForLongerThanTwoCents() {
        String result = application.setDollarAndCent(Double.valueOf("4.100"));
        assertEquals("four dollars and ten cents", result);
    }

    @Test
    @DisplayName("Given the user inserts `12.55`, the outcome should show `four dollars and ten cents`")
    public void testForTwelveAndFiftyFiveTwoCents() {
        String result = application.setDollarAndCent(Double.valueOf("12.555"));
        assertEquals("twelve dollars and fifty five cents", result);
    }
}