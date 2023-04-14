public class ToBinary {
    public static String toBinary(int decimalNumber) {
        String result = "";
        if (decimalNumber>0) {
            while (decimalNumber != 0)
            {
                result =  (decimalNumber % 2) + result;
                decimalNumber = decimalNumber/2;

            }
        } else {
            return null;
        }
        return result;
    }

    public static int toDecimal(String binaryNumber) {
        int result = 0;
        if ((binaryNumber != null) && (binaryNumber != "")) {//напишите тут ваш код
            for (int i = 0; i<binaryNumber.length(); i++) {
                result = result + (int) (binaryNumber.charAt(binaryNumber.length()-1-i)) * (int) (Math.pow (2, i));
            }
        }
        return result;
    }
}
