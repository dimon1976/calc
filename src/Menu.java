import java.util.Random;
import java.util.Scanner;

public class Menu {

    public static void start(Calculator calculator) {
        Scanner r = new Scanner(System.in);
        System.out.println("Меню:\n" +
                "1) Регистрация.\n" +
                "2) Вход.\n" +
                "3) Завершение работы.");
        int a = 0;
        while (a != 1 || a != 2 || a != 3) {
            a = r.nextInt();
            if (a == 3) {
                System.out.println("Завершаем работу");
                return;
            } else if (a == 1 || a == 2) {
                choice(a, calculator);
                return;
            } else {
                System.out.println("Некорректный ввод:");
                System.out.println("Меню:\n1) Регистрация.\n2) Вход.\n3) Завершение работы.");
            }
        }
    }

    public static void choice(int a, Calculator calculator) {
        Scanner r = new Scanner(System.in);
        switch (a) {
            case 1:              // Регистрация
                boolean check = true;
                while (check) {
                    System.out.println("Введите Имя:");
                    String name = r.nextLine();
                    System.out.println("Введите логин:");
                    String login = r.nextLine();
                    System.out.println("Введите пароль:");
                    String pass = r.nextLine();
                    check = Storage.register(name, login, pass);  //проверка на совпадение в массиве
                    if (!check) {
                        System.out.println("Регистрация прошла успешно.\nЗапускаем калькулятор.");
                        launch(calculator);
                    } else {
                        System.out.println("Повторите ввод");
                    }
                }
                break;
            case 2:
                boolean check2 = false;
                while (!check2) {
                    System.out.println("Введите Имя:");
                    String name = r.nextLine();
                    System.out.println("Введите логин:");
                    String login = r.nextLine();
                    System.out.println("Введите пароль:");
                    String pass = r.nextLine();
                    check2 = Storage.signIn(name, login, pass);  //проверка на совпадение в массиве
                    if (check2) {
                        System.out.println("Авторизация прошла успешно\nЗапускаем калькулятор.");
                        launch(calculator);
                    } else {
                        System.out.println("Неверные данные авторизации\nПовторите ввод.");
                        System.out.println("Продолжить - 1\nВыйти - 0");
                        String x = r.nextLine();
                        if (x.equals("0")) {
                            break;
                        } else if (x.equals("1")) {
                        }
                    }
                }
                break;
        }
    }


    public static void launch(Calculator calculator) {
        Scanner r = new Scanner(System.in);
        Random rand = new Random();
        boolean condition = true;
        double[] array = new double[3];
        int count = 0;
        while (condition) {
            System.out.println("Для выхода из расчетов введите 0 или end\nВведите 2 числа и операцию вычисления:");
            int a = rand.nextInt(10) + 1;
            System.out.print(a + " ");
            int b = rand.nextInt(10) + 1;
            System.out.println(b);
            String c = r.nextLine();
            boolean valid = false;
            while (!valid) {
                if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || a == 0 || b == 0 || c.equals("0") || c.equalsIgnoreCase("end")) {
                    valid = true;
                } else {
                    System.out.println("Неправильный ввод операнда\nВведите одно из значений: + - * /");
                    c = r.nextLine();
                }
            }

            if (a == 0 || b == 0 || c.equals("0") || c.equalsIgnoreCase("end")) {
                condition = false;
            } else {
                if (count == array.length) {
                    count = 0;
                    array[count] = (check(c, calculator, a, b));
                    count++;
                } else {
                    array[count] = (check(c, calculator, a, b));
                    count++;
                }
            }
        }
        System.out.println("Завершаем работу");
        result(array);
    }

    private static double check(String c, Calculator calculator, int a, int b) {
        switch (c) {
            case "+":
                double summ = calculator.sum(a, b);
                System.out.println(a + " + " + b + " = " + summ);
                return summ;
            case "-":
                double sub = calculator.sub(a, b);
                System.out.println(a + " - " + b + " = " + sub);
                return sub;
            case "/":
                double delete = calculator.delete(a, b);
                System.out.println(a + " / " + b + " = " + delete);
                return delete;
            case "*":
                double mult = calculator.multi(a, b);
                System.out.println(a + " + " + b + " = " + mult);
                return mult;
        }
        return 0;
    }

    private static void result(double[] arr) {
        for (double j : arr) {
            System.out.print(j + " ");
        }
    }
}

