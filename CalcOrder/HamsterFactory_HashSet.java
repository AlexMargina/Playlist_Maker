import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

public class Main {  // был класс  Practicum

        public static void main(String[] args) {
            HamsterFactory hamsterFactory = new HamsterFactory();
            hamsterFactory.start();
        }
    }


    class HamsterFactory {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hamsterSet = new HashSet <>(); // нужна структура данных, в которой можно хранить только уникальных хомяков


        public void start() {
            System.out.println("Добро пожаловать на фабрику хомяков!");
            System.out.println("Здесь вы можете создавать, удалять и даже печатать хомяков");
            System.out.println("Для работы с фабрикой используйте следующие команды:");
            System.out.println("'Печать' — показать всех хомяков в хранилище");
            System.out.println("'Создать [Имя]' — создать хомяка с выбранным именем");
            System.out.println("'Удалить [Имя]' — удалить хомяка с выбранным именем");
            System.out.println("'Очистить' — удалить всех, ранее созданных хомяков");
            System.out.println("'Размер' — вывести на экран текущее количество хомяков в хранилище");
            System.out.println("'Завершить' — завершить работу программы");

            while (true) {
                System.out.println("\n>>Введите команду...");

                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("Завершить")) {

                    System.out.println("Программа завершена! Спасибо, что пользуетесь нашей сетью хомячих фабрик");
                    break;// если пользователь ввел команду "Завершить", надо закончить работу программы (остановить цикл)
                    // при завершении работы вывести сообщение
                } else {
                    execCommand(command); // вызвать метод executeCommand(),
                    //который распознает команду и вызывает нужный метод для её обработки
                }
            }
        }

        private void execCommand(String commandMethod) {

            String[] commandArgs = commandMethod.split(" "); // разделить переданную строку на команду и аргументы
            String commandExec = commandArgs[0].toLowerCase();  // первое слово - непосредственно КОМАНДА для исполнения

            switch (commandExec) {
                case ("печать"):
                    executePrint();
                    break;
                case ("создать"):
                    if (commandArgs.length >1) {
                        executeCreate(commandArgs[1]);
                    } else {
                        System.out.println("Введена команда Создать без аргумента");
                    }
                    break;
                case ("удалить"):
                    if (commandArgs.length >1) {   // если более одного слова, то второе всегда целое
                        try  {
                            //argIndex = Integer.parseInt(commandArgs[1].trim());   // String преобразуется в int
                            executeRemoveByName(commandArgs[1]); // аргумент argIndex мы уже привели к целому числу
                        }
                        catch (NumberFormatException nfe)
                        {
                            System.out.println("Введите имя для удаления");
                        }
                    }
                    break;
                case ("очистить"):
                    executeClear();
                    break;
                case ("размер"):
                    executeSize();
                    break;
                default:
                    showErrorMessage();
                    break;
            }
        }

        private void executePrint() {
            System.out.println("Вывожу актуальный список хомяков в хранилище:"); // выведите сообщение: "Вывожу актуальный список хомяков в хранилище:"
            for (String hamster : hamsterSet) {
                System.out.println("Хомяк '" + hamster + "'");  // напечатайте всех хомяков, которые есть в хранилище в формате "Хомяк '[Имя хомяка]'"
            }
        }

        private void executeCreate(String name) {
            Hamster hamster = new Hamster(name);  // создайте хомяка с именем [name] и добавьте его в ваше хранилище
            if (hamsterSet.add(hamster.name)) {  // если добавление успешно, то add возвращает true
                System.out.println("Хомяк '"+ hamster.name +"' создан и добавлен в хранилище");
            }  else {
                System.out.println("Хомяк '" + hamster.name +"' уже находится в хранилище");
            }
        }

        private void executeRemoveByName(String name) {
            if (hamsterSet.contains(name)){    	//если хомяк существует,
                hamsterSet.remove (name);				// то нужно удалить его
                System.out.println("Хомяк '" + name + "' удалён успешно"); 		//  и вывести сообщение
            }else{
                System.out.println("Хомяка с именем '" + name + "' не существует"); // иначе вывести сообщение
            }
        }

        private void executeClear() {
            Iterator<String> iteratorSet = hamsterSet.iterator();
            while (iteratorSet.hasNext()) {												// нужно удалить всех хомяков, которые есть в хранилище
                System.out.println("Хомяк '"+ iteratorSet.next() +"' удалён успешно"); 	// каждый удаленный хомяк должен сопровождаться сообщением
                iteratorSet.remove();
            }
            System.out.println("Операция очистки завершена успешно! Все хомяки были удалены из хранилища"); // после завершения очистки напечатайте
        }

        private void executeSize() {
            if (hamsterSet.size() <1) {
                System.out.println("В хранилище нет хомяков"); //  если в хранилище нет хомяков, вывести: "В хранилище нет хомяков"
            } else {
                System.out.println("Количество хомяков в хранилище равно "+ hamsterSet.size()); // если в хранилище есть хомяки, вывести сообщение
            }
        }

        // этот метод мы реализовывали в прошлой фабрике, оставим без изменений
        private void showErrorMessage() {
            System.out.println("Неверная команда, попробуйте еще раз.");
        }
    }

class Hamster {

    String name;

    public Hamster(String name) {
        this.name = name;
    }
}