import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner num = new Scanner (System.in);
        System.out.println("Введите число для перевода в восьмеричное и десятичное число: ");

            int decimalNumber = num.nextInt();
            System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + ToOctalToDecimal.toOctal(decimalNumber));
                if (ToOctalToDecimal.isOctal(decimalNumber)) {
                    int octalNumber = decimalNumber;
                    System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + ToOctalToDecimal.toDecimal(octalNumber));
                } else {
                    System.out.println("Это не восьмеричное число, невозможно его перевести в десятичное ");
                }
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + ToBinary.toBinary(decimalNumber));
            }
    }



