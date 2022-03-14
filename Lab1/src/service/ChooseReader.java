package service;

public class ChooseReader {

    public ChooseReader() {
        System.out.println("Каким образом вы хотите ввести данные? Выберите соответствующую цифру:\n" +
                "1 - Пользовательский ввод\n" +
                "2 - Ввод данных из файла\n" +
                "3 - Генерация случайных матриц\n" +
                "-------------------------------------------");
    }

    public int chooseReading(String data) {
        switch (data) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            default:
                return 0;
        }
    }
}
