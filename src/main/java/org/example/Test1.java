package org.example;
import java.io.File;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        System.out.println("Введите абсолютный путь папки: ");
        Scanner in = new Scanner(System.in);

        String folderPath;

        do {
            folderPath = in.nextLine();
            File file = new File(folderPath);

            if (!file.exists() || !file.isDirectory()){ // Проверяем существует ли путь и является ли он папкой
                System.out.println("Папка не существует или не является папкой. Повторите ввод.");
            }

        }while (!new File(folderPath).exists() || !new File(folderPath).isDirectory()); // Повторять запрос, пока путь не существует или не является папкой


        File folder = new File(folderPath); // Получаем путь к папке
        File[] files = folder.listFiles(); // Получаем список файлов в папке


        boolean found = false; // Переменная для проверки файлов больше 10 мегабайт

        if (files != null){
            for (File file : files){
                double fileSizeInMB = (double) file.length() / (1024 * 1024); // Переводим размер в мегабайты
                if (fileSizeInMB > 10){
                    System.out.println("Этот файл весит больше 10 мегабайт. Вот путь этого файла " + file.getAbsolutePath());
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("Не найдены файлы размером больше 10 мегабайт.");
        }
    }
}
