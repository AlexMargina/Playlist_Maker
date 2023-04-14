import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {  // был класс  Practicum

        public static void main(String[] args) {
            HamsterFactory hamsterFactory = new HamsterFactory();
            hamsterFactory.start();
        }
    }


    class HamsterFactory {
        Scanner scanner = new Scanner(System.in);
        Hamster hamster = new Hamster(""); // нужна структура данных, в которой можно хранить хомяков
        ArrayList<String> hamsterList = new ArrayList<>(); //  нужна сущность, которая может изменять свой размер

        public void start() {
            System.out.println("Добро пожаловать на фабрику хомяков!");
            System.out.println("Здесь вы можете создавать, удалять и даже заменять одних хомяков на других");
            System.out.println("Для работы с фабрикой используйте следующие команды:");
            System.out.println("'Печать' — показать всех активных хомяков");
            System.out.println("'Создать [Имя]' — создать хомяка с выбранным именем");
            System.out.println("'Удалить [Индекс]' — удалить хомяка по выбранному индексу");
            System.out.println("'Очистить' — удалить всех, ранее созданных хомяков");
            System.out.println("'Заменить [Индекс] [Имя]' — заменить хомяка под выбранным индексом на нового с выбранным именем");
            System.out.println("'Размер' — вывести на экран текущее количество хомяков в хранилище");
            System.out.println("'Завершить' — завершить работу программы");

            while (true) {
                System.out.println("Введите команду...");

                String command = scanner.nextLine();

                if (command.equalsIgnoreCase("Завершить")) {

                    System.out.println("Программа завершена! Спасибо, что пользуетесь нашей сетью хомячих фабрик");
                    break;// если пользователь ввел команду "Завершить", надо закончить работу программы (остановить цикл)
                    // при завершении работы вывести сообщение
                } else {
                    execCommand(command); // иначе вызвать метод executeCommand(),
                    //который распознает команду и вызывает нужный метод для её обработки
                }
            }
        }

        private void executeCommand(String commandMethod) {

            String[] commandArgs = commandMethod.split(" "); // разделить переданную строку на команду и аргументы
            String commandExec = commandArgs[0].toLowerCase();  // первое слово - непосредственно КОМАНДА для исполнения
            int argIndex = 0; // вводим переменную для аргумента индекса

            switch (commandExec) {
                case ("печать"):
                    executePrint();
                    break;
                case ("создать"):
                    if (commandArgs.length >1) {
                        hamster.name = commandArgs[1];
                        executeCreate(hamster.name);
                    } else {
                        System.out.println("Введена команда Создать без аргумента");
                    }
                    break;
                case ("удалить"):
                    if (commandArgs.length >1) {   // если более одного слова, то второе всегда целое
                        try  {
                            argIndex = Integer.parseInt(commandArgs[1].trim());   // String преобразуется в int
                            executeRemoveByIndex(argIndex); // аргумент argIndex мы уже привели к целому числу
                        }
                        catch (NumberFormatException nfe)
                        {
                            System.out.println("Значение индекса необходимо ввести целым числом отделенное запятыми: " + nfe.getMessage());
                        }
                    }
                    break;
                case ("очистить"):
                    executeClear();
                    break;
                case ("заменить"):
                    if (commandArgs.length >1) {   // если более одного слова, то второе всегда целое
                        try  {
                            argIndex = Integer.parseInt(commandArgs[1].trim());   // String преобразуется в int
                            executeSet(argIndex, commandArgs[2]);    // 1 аргумент приведен к целому числу, второй - имя, тип String
                        } catch (NumberFormatException nfe)  {
                            System.out.println("Значение индекса необходимо ввести целым числом, отделенное пробелами: " + nfe.getMessage());
                        }
                    }
                    break;
                case ("размер"):
                    executeSize();
                    break;
                default:
                    showErrorMessage();
                    break;
            }
        }

        private void executePrint() {   // напечатать всех хомяков, которые есть в хранилище в формате "Хомяк '[Имя хомяка]'"
            if (hamsterList.size() > 0) {                   // проверка массива на наличие элементов
                System.out.println("Вывожу актуальный список хомяков в хранилище:");
                for (String  hamsterName: hamsterList) {
                    System.out.println("Хомяк '" + hamsterName + "'");
                }
            } else {
                System.out.println("В хранилище нет хомяков!");     //если нет ни одного хомяка
            }
        }

        private void executeCreate(String name) {       // создаем хомяка с именем [name] и добавляем его в хранилище
            hamsterList.add (name);
            System.out.println("Хомяк '"+ name +"' создан и добавлен в хранилище");// выводим сообщение
        }

        private void executeRemoveByIndex(int index) {
            if (hamsterList.size() >= index) {     // если хомяк существует, надо удалить его и вывести сообщение
                String oldName = hamsterList.get(index);
                hamsterList.remove(index);  // запомнить имя хомяка перед его удаленнием
                System.out.println ("Хомяк '" + oldName + "' удалён успешно");
            } else {
                System.out.println("Хомяка по заданному индексу не существует"); // елси индекса не существует
            }
        }

        private void executeClear() {
            hamsterList.clear();      // очистить хранилище
            System.out.println("Операция очистки завершена успешно! Все хомяки были удалены из хранилища");
        }

        private void executeSet(int index, String name) {
            if (hamsterList.size() >= index) {     // если хомяк существует, надо заменить его и вывести сообщение
                String oldName = hamsterList.get(index);   // запомним имя хомяка перед его удалением
                hamsterList.set(index, name);  // создайте хомяка с именем [name] и замените им хомяка на позиции [index]
                System.out.println("Хомяк '" + oldName + "' был успешно заменён на хомяка '" + hamsterList.get(index) + "'"); // выведите сообщение "Хомяк '[Имя удаленного хомяка]' был успешно заменён на хомяка '[Имя нового хомяка]'"
            } else {
                System.out.println("Хомяка по заданному индексу не существует"); // иначе вывести сообщение: "Хомяка по заданному индексу не существует"
            }
        }

        private void executeSize() {
            if (hamsterList.size() >0) {
                System.out.println("Количество хомяков в хранилище равно "+ hamsterList.size());// если в хранилище есть хомяки
            } else {
                System.out.println("В хранилище нет хомяков"); // иначе вывести: "В хранилище нет хомяков"
            }
        }

        private void showErrorMessage() {
            System.out.println("Неверная команда, попробуйте ещё раз."); // выведите сообщение: "Неверная команда, попробуйте ещё раз."
        }

    }

    class Hamster {
        String name;

        public Hamster(String name) {
            this.name = name;
        }
    }