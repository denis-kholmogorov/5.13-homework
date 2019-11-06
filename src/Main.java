import java.sql.Time;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listNumber = new ArrayList<>();
        String[] chars = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
        for (int n = 1; n < 44444; n++) {
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < 10; j++) {
                    if(n < 10) {
                        listNumber.add(chars[i]  + j + j + j + chars[i] + chars[i] + "0" + n);
                    }
                    else{
                        listNumber.add(chars[i] + j + j + j + chars[i] + chars[i] + n);
                    }
                }
            }
        }
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(listNumber);

        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.addAll(listNumber);

        Scanner scanner = new Scanner(System.in);
        String number;
        boolean iSindex;

        System.out.println("Количество номеров: " + listNumber.size());

        for(;;) {
            number = scanner.nextLine();

            containsMethod(listNumber, number);
            binaryMethod(listNumber, number);
            hashMethod(hashSet, number);
            treeMethod(treeSet, number);
        }
    }
    public static void containsMethod (ArrayList<String> list, String number){
        long start;
        long finish;
        long during;
        System.out.println("Contains старт");
        start = System.currentTimeMillis();
        boolean iSindex = list.contains(number);
        finish = System.currentTimeMillis();
        System.out.println("Номер найден " + iSindex);
        System.out.println("Старт - " + start + " Финиш - " + finish);
        during = finish - start;
        System.out.println("Медленный метод " +  during + " мс\n");
    }
    public static void binaryMethod (ArrayList<String> list, String number){
        long start;
        long finish;
        long during;
        int indexBinary;
        System.out.println("Binary Старт");
        start = System.currentTimeMillis();
        indexBinary = Collections.binarySearch(list,number);
        finish = System.currentTimeMillis();
        System.out.println("Номер индекса найден " + indexBinary);
        System.out.println("Старт - " + start + " Финиш - " + finish);
        during = finish - start;
        System.out.println("Быстрый метод " + during + " мс\n");
    }
    public static void hashMethod (HashSet<String> hashSet, String number){
        long start;
        long finish;
        long during;
        System.out.println("Hash Старт");
        start = System.currentTimeMillis();
        boolean iSindex = hashSet.contains(number);
        finish = System.currentTimeMillis();
        System.out.println("Номер найден " + iSindex);
        System.out.println("Старт - " + start + " Финиш - " + finish);
        during = finish - start;
        System.out.println("Быстрый метод " + during + " мс\n");
    }
    public static void treeMethod (TreeSet<String> treeSet, String number){
        long start;
        long finish;
        long during;
        System.out.println("Tree Старт");
        start = System.currentTimeMillis();
        boolean iSindex = treeSet.contains(number);
        finish = System.currentTimeMillis();
        System.out.println("Номер найден " + iSindex);
        System.out.println("Старт - " + start + " Финиш - " + finish);
        during = finish - start;
        System.out.println("Быстрый метод " + during + "мс \n");
    }
}
