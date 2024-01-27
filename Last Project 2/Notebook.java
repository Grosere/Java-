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

import java.util.Objects;

public class Notebook {

    private String NoteName;
    private int RamValue;
    private int HDDValue;
    private String OSName;
    private String Color;

    public Notebook(String name, int RAM_GBite, int HDD, String OS, String color) {
        this.NoteName = name;
        this.RamValue = RAM_GBite;
        this.HDDValue = HDD;
        this.OSName = OS;
        this.Color = color;
    }

    public String getName() {
        return NoteName;
    }

    public void setName(String name) {
        this.NoteName = name;
    }

    public int getRAM_GBite() {
        return RamValue;
    }

    public void setRAM_GBite(int RAM_GBite) {
        this.RamValue = RAM_GBite;
    }

    public int getHDDValue() {
        return HDDValue;
    }

    public void setHDDValue(int HDD) {
        this.HDDValue = HDD;
    }

    public String getOSName() {
        return OSName;
    }

    public void setOSName(String OS) {
        this.OSName = OS;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "Название: '" + NoteName + '\'' +
                ", Обьем RAM: " + RamValue +
                ", Обьем HDD: " + HDDValue +
                ", Используемая ОС: " + OSName +
                ", Цвет: '" + Color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Notebook note = (Notebook) obj;
        return NoteName.equals(note.NoteName) && RamValue == note.RamValue && HDDValue == note.HDDValue
                && OSName.equals(note.OSName) && Color.equals(note.Color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NoteName, RamValue, HDDValue, OSName, Color);
    }
}