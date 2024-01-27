/*
Задание:
-Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
- Создать множество ноутбуков.
- Написать метод, который будет запрашивать у пользователя критерий (или критерии)
Фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
- Далее нужно запросить минимальные значения для указанных критериев - сохранить
параметры фильтрации можно также в Map.
- Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
условиям.
 */

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class MainNotebook {
    private static Notebook filtrNotebook = new Notebook(null, 0, 0, "null", "null");

    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("MacBook", 8, 1000, "Mac_OS_13", "Белый");
        Notebook notebook2 = new Notebook("HP", 16, 10000, "Windows 11", "Черный");
        Notebook notebook3 = new Notebook("Mac_Air 2021", 8, 1000, "Mac_OS_14", "Стальной");
        Notebook notebook4 = new Notebook("Asus", 32, 100000, "Windows 10", "Синий");
        Notebook notebook5 = new Notebook("Acer", 16, 1000, "None", "Серебрянный");
        Notebook notebook6 = new Notebook("Lenovo", 32, 500, "Windows 10", "Красный");

        Set<Notebook> notebooks = new HashSet<>(
                Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5, notebook6));

        filter(notebooks);
    }

    public static void filter(Set<Notebook> notebooks) {
        information();
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        boolean endOfFiltr = true;
        while (endOfFiltr == true) {
            switch (command) {
                case ("1"):
                    System.out.println(
                            "Вы можете ввести желаемый объем оперативной памяти и вам будут представлены варианты ноутбуков такого объема и выше.");
                    int findRamInGB = Integer.valueOf(sc.nextLine());
                    filtrNotebook.setRAM_GBite(findRamInGB);
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("2"):
                    System.out.println(
                            "Вы можете ввести желаемый объем жесткого диска и вам будут представлены варианты ноутбуков такого объема и выше.");
                    int findValueHDD = Integer.valueOf(sc.nextLine());
                    filtrNotebook.setHDDValue(findValueHDD);
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("3"):
                    System.out.println("Вы можете ввести название вашей любимой операционной системы.");
                    String findOperatingSystem = sc.nextLine();
                    filtrNotebook.setOSName(findOperatingSystem);
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("4"):
                    System.out.println("Вы можете ввести название вашего любимого цвета.");
                    String findColor = sc.nextLine();
                    filtrNotebook.setColor(findColor);
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("5"):
                    printAllNotebook(notebooks);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                    break;
                case ("7"):
                    filtrNotebook.setRAM_GBite(0);
                    filtrNotebook.setHDDValue(0);
                    filtrNotebook.setOSName("null");
                    filtrNotebook.setColor("null");
                    System.out.println(filtrNotebook);
                    System.out.println("Введите следующую команду");
                    command = sc.nextLine();
                case ("9"):
                    information();
                    command = sc.nextLine();
                    break;
                case ("0"):
                    endOfFiltr = false;
                    break;
                default:
                    System.out.println("Вы ввели неверную команду, чтобы посмотреть инструкцию введите 9");
                    command = sc.nextLine();
                    break;
            }

        }
        sc.close();
        System.out.println(filtrNotebook);
        findNotebooksWithFiltr(notebooks);
    }

    /**
     * @param notebooks
     */
    public static void findNotebooksWithFiltr(Set<Notebook> notebooks) {

        Set<Notebook> result = new HashSet<>();
        for (Notebook note : notebooks) {
            if (filtrNotebook.getRAM_GBite() <= note.getRAM_GBite() || filtrNotebook.getRAM_GBite() == 0) {
                if (filtrNotebook.getHDDValue() <= note.getHDDValue() || filtrNotebook.getHDDValue() == 0) {
                    if (filtrNotebook.getOSName().equals(note.getOSName())
                            || filtrNotebook.getOSName().equals("null")) {
                        if (filtrNotebook.getColor().equals(note.getColor())
                                || filtrNotebook.getColor().equals("null")) {
                            result.add(note);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("Такого ноутбука - нет");
        } else {
            System.out.println("Вам могут подойти следующие ноутбуки:");
            printAllNotebook(result);
        }

        System.out.println("Конец поиска.");
    }

    public static void printAllNotebook(Set<Notebook> notebooks) {
        System.out.println("В нашем интернет-магазине содержатся следующие ноутбуки:");
        System.out.println();

        for (Notebook note : notebooks) {
            System.out.println(note);
        }
        System.out.println();
    }

    public static void information() {
        System.out.println(
                "Есди вы хотите подобрать определнный ноутбук, то введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - RAM");
        System.out.println("2 - Объем HDD");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет ");
        System.out.println("5 - вы можете посмотреть все ноутбуки, которые у нас есть");
        System.out.println("7 - очистить фильтр");
        System.out.println("9 - еще раз посмотреть инструкцию");
        System.out.println("0 - результат поиска");
    }
}