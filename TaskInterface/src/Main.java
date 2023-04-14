import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello!");

        Article article1 = new Article("Первая заметка");

        Subscriber subscriber1 = new OfflineSubscriber ("Москва, Красная площадь");
        Subscriber subscriber2 = new OfflineSubscriber ("Воронеж, Набережная");
        Subscriber subscriber3 = new WebSite ("http://dzen.ru");


    }

    private static void subscribe(Subscriber subscriber1) {

    }
}



class Article {

    final String title;

    Article(final String title) {
        this.title = title;
    }
}

interface Subscriber {// создайте интерфейс Subscriber

    void update(Article article);   // интерфейс должен иметь всего один метод `void update()`, который принимает на вход объект класса `Article`
}


class OfflineSubscriber implements Subscriber  /* реализуйте интерфейс Subscriber */
    {
    private final String address;

    public OfflineSubscriber(final String address) {
        this.address = address;
    }

    @Override
    public void update(Article article) {
            // метод update должен выводить текст "{article.title} была доставлена по адресу: {address}"
            System.out.println (article.title + " была доставлена по адресу: " + address);
        }
    }

class WebSite implements Subscriber { /* реализуйте интерфейс Subscriber */

    private final String url;

    public WebSite(final String url) {
            this.url = url;
    }

    public void update(Article article) {
        // метод update должен выводить текст "{article.title} была доставлена по адресу: {address}"
        System.out.println (article.title + " была доставлена по адресу: " + url);
    }// метод update должен выводить текст "{article.title} опубликована на страничке: {url}"
        }

class NewspaperPublisher {

    List<Subscriber> subscribers = new ArrayList<>(); // создайте список подписчиков  с именем subscribers
    // для отправки статей подписчикам вам нужно хранить их в списке

    private final List<Article> articles;

    public NewspaperPublisher(final List<Article> articles) {
        this.articles = articles;
    }

    void subscribe(Subscriber subscriber) {    // Подписчик/ метод должен принимать на вход любой объект, реализующий интерфейс Subscriber
        if (subscribers.contains(subscriber)) {
            ;// в списке подписчиков не должно быть дубликатов. Вы можете проверить, есть ли уже этот подписчик в списке методом List.contains()
        } else {
            // при вызове метода subscribe() новый подписчик должен добавляться в список подписчиков.
            subscribers.add(subscriber);
        }
    }

    void unsubscribe(Subscriber subscriber) {
        // метод  должен принимать на вход любой объект, реализующий интерфейс Subscriber
        // при вызове данного метода подписчик должен удаляться из списка подписчиков
        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        }
    }

    void startWork() {
        // метод  должен отправлять все статьи, которые хранятся в данный момент в списке articles, всем подписчикам
        for (Article article : articles) {
            for (Subscriber subscriber : subscribers ) {
                subscriber.update(article);//article.send.subscriber;
            }
        }
    }

    void publishNewArticle(final Article article) {
        // метод  принимает на вход объект класса Article
        // метод должен добавлять новую статью в список статей articles, а также делать рассылку новой статьи всем активным подписчикам
        articles.add (article);
        for (Subscriber subscriber : subscribers) {
            subscriber.update(article);//article.send.subscriber;
        }
    }
}
