import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static PrintStream out = System.out;

    public static void main(String[] args) throws IOException {
        int n = in.nextInt(); //Количество строк
        int m = in.nextInt(); //Количество столбцов
        double proizv = 1;
        in.nextLine();
        String [][] a = new String[n][m]; // Исходный массив
        double [][] mod = new double[n][m]; // Массив модулей
        double [][] arg = new double[n][m]; // Массив аргументов
        int s = 0;
        for (int i = 0 ; i < a.length ; i++) { // Ввод массива
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = in.nextLine();
                s=s+(a[i][j].charAt(4)-'0'); //Подсчет суммы мнимых частей чисел
            }
        }
        for (int z = 0; z < a.length ; z++) { // Заполнение массива модулей чисел
            for (int x = 0; x < a[z].length; x++) {
                 mod[z][x] = Math.sqrt((Math.pow(a[z][x].charAt(0)-'0',2) + Math.pow(a[z][x].charAt(4)-'0',2)));
                 proizv=proizv*mod[z][x]; //Подсчет произведения моделей чисел
            }
        }
        for (int z = 0; z < a.length ; z++) { // Заполнение массива аргументов чисел
            for (int x = 0; x < a[z].length; x++) {
                arg[z][x] = Math.atan(a[z][x].charAt(4)-'0' / a[z][x].charAt(0)-'0');
            }
        }

        for (int i = 0 ; i < a.length ; i++) { // Сортировка массива
            for (int j = 0; j < a.length-i; j++) {
                if (mod[i][j]==mod[i][j+1]){
                    if (arg[i][j]>arg[i][j+1]){
                        String z = a[i][j];
                        a[i][j] = a[i][j+1];
                        a[i][j+1] = z;
                        double u = arg[i][j];
                        arg[i][j] = arg[i][j+1];
                        arg[i][j+1] = u;
                        double y = mod[i][j];
                        mod[i][j] = mod[i][j+1];
                        mod[i][j+1] = y;
                    }
                }
                else{
                    if (mod[i][j]>mod[i][j+1]){
                    String z = a[i][j];
                    a[i][j] = a[i][j+1];
                    a[i][j+1] = z;
                    double y = mod[i][j];
                    mod[i][j] = mod[i][j+1];
                    mod[i][j+1] = y;
                    double u = arg[i][j];
                    arg[i][j] = arg[i][j+1];
                    arg[i][j+1] = u;
                    }
                }
            }
        }

        out.println(proizv);
        for (int i = 0 ; i < a.length ; i++) { // Вывод массива обратных элементов
            for (int j = 0 ; j < a[i].length ; j++) {
                int sumab = (int) (Math.pow(a[i][j].charAt(0)-'0',2) + Math.pow(a[i][j].charAt(4)-'0',2));
                out.print(a[i][j].charAt(0));
                out.print('/');
                out.print(sumab);
                out.print("-(");
                out.print(a[i][j].charAt(4));
                out.print('/');
                out.print(sumab);
                out.print(")i ");
            }
            out.println();
        }
        out.println(s);
    }
}