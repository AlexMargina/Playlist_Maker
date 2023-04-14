public class OctalToDecimal {
    public static int toOctal (int decimalNumber) {
        int i=0;//напишите тут ваш код
        int result = 0;
        while (decimalNumber != 0) {
            result = result + (decimalNumber % 8)  * (int) (Math.pow(10, i));
            decimalNumber = (decimalNumber / 8);
            i = i + 1;
        }
        return result;
    }

    public static int toDecimal (int octalNumber) {
        int i = 0;//напишите тут ваш код
        int result = 0;
        while (octalNumber != 0) {
            result = result + (octalNumber % 10)  * (int) (Math.pow(8, i));
            octalNumber = (octalNumber/ 10);
            i = i + 1;
        }
        return result;
    }
}
