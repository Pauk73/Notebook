import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // Создаём объект FileWriter
        FileWriter writer = new FileWriter("notebook.txt", true);

        // Создаём объект FileReader
        FileReader reader = new FileReader("notebook.txt");

        // Запрашиваем команду у пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите команду:"+"\n");
        String command = scanner.nextLine();

        if (command.equals("#write")) {
            // Запрашиваем текст у пользователя
            System.out.print("Введите ваши планы на сегодня:"+"\n");
            String text = scanner.nextLine();

            // Получаем текущую дату
            LocalDateTime date = LocalDateTime.now();

            // Формируем строку с датой
            String dateString = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Добавляем дату в начало текста
            text = dateString + ": " + text;

            // Записываем текст в файл и переносим на следующую строку
            writer.write(text);
            writer.append("\n");

            // Закрываем метод
            writer.close();

        } else {
            if (command.equals("#read")) {
                // Считываем данные из файла
                int c;
                while ((c = reader.read()) != -1) {

                    // Выводим данные на экран
                    System.out.print((char) c);

                }
            } else {
                // Если команда неверная выводим сообщение
                System.err.println("Неизвестная команда!");
            }
            // Закрываем метод
            scanner.close();
        }

    }
}
