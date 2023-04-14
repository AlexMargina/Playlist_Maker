    import java.util.regex.Pattern;

/*
Восьмеричный конвертер
*/

    public class ToOctalToDecimal {

        public static int toOctal (int decimalNumber) {
            int i=0;//
            int result = 0;
            if (decimalNumber > 0 ) {
                while (decimalNumber != 0) {
                    result = result + (decimalNumber % 8)  * (int) (Math.pow(10, i));
                    decimalNumber = (decimalNumber / 8);
                    i = i + 1;
                }
            }
            return result;
        }

        public static int toDecimal (int octalNumber) {
            int i = 0;//напишите тут ваш код
            int result = 0;
            if (octalNumber > 0 ) {
                while (octalNumber != 0) {
                    result = result + (octalNumber % 10)  * (int) (Math.pow(8, i));
                    octalNumber = (octalNumber/ 10);
                    i = i + 1;
                } }
            return result;
        }

        public static boolean isOctal(int octal) {

            boolean isOctal = false;

            if (octal >= 0) {
                //int number = Integer.parseInt(octal);

                while (octal > 0) {
                    if (octal % 10 <= 7) {
                        isOctal = true;
                    } else {
                        isOctal = false;
                        break;
                    }
                    octal /= 10;
                }
            }
            return isOctal;
        }
    }


