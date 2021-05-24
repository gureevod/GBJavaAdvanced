package HomeWork3;

import java.util.Arrays;

public class Main {
    public static void changeArrayElements(Object[] array, int i, int j) {
        Object tempElement = array[i];
        array[i] = array[j];
        array[j] = tempElement;
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 5, 6, 7};
        changeArrayElements(array, 0, 1);
        System.out.println(Arrays.toString(array));

        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());
        appleBox2.addFruit(new Apple());

        System.out.println(appleBox.compare(appleBox2));

        appleBox.transferFruits(appleBox2);
        System.out.println(appleBox);
        System.out.println(appleBox2);
    }
}
