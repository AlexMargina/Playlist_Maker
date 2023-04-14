import java.util.ArrayList;
import java.util.List;

public class Analitica {
        interface Analytics {
            void send();
        }

static class FirebaseAnalytics implements Analytics {

            @Override
            public void send() {
                System.out.println("Отправляем данные в Firebase");
            }
        }

static class MetricaAnalytics implements Analytics {

            @Override
            public void send() {
                System.out.println("Отправляем данные в Metrica");
            }
        }

        static class FlurryAnalytics implements Analytics {

            @Override
            public void send() {
                System.out.println("Отправляем данные в Flurry");
            }
        }
        /**
         *  Тут нужно реализовать класс FlurryAnalytics. Требования:
         *  1. Класс должен реализовать интерфейс Analytics
         *  2. У класс должна быть реализация метода send()
         *  3. Метод send() должен выводить в консоль строку "Отправляем данные в Flurry"
         */

        public static void main(String[] args) {
            /**
             * Вызов метода, который создаёт список объектов Analytics.
             * Если метод реализован правильно, то в консоль будет выведено три строки:
             * Отправляем данные в Firebase
             * Отправляем данные в Metrica
             * Отправляем данные в Flurry
             */
            List<Analytics> analytics = createAnalytics();
            sendAnalytics(analytics);
        }

        /** В этом методе нужно реализовать такую логику:
         * 1. Создать список типа Analytics
         * 2. Создать три объекта типов FirebaseAnalytics, MetricaAnalytics и FlurryAnalytics
         * 3. Добавить объекты в список
         */
        public static List<Analytics> createAnalytics() {

            return new ArrayList<>();
        }

        private static void sendAnalytics(List<Analytics> analytics) {
            for (Analytics item: analytics) {
                item.send();
            }
        }
    }
}
