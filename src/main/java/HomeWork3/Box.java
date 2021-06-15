package HomeWork3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitsList = new ArrayList<>();

    public ArrayList<T> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(ArrayList<T> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public void addFruit(T fruit) {
        fruitsList.add(fruit);
    }

    public float getBoxWeight() {

        return fruitsList.size() * fruitsList.get(0).weight;
    }

    public boolean compare(Box<?> box) {
        return getBoxWeight() == box.getBoxWeight();
    }

    public void transferFruits(Box<T> box) {
        fruitsList.addAll(box.fruitsList);
        box.fruitsList.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitsList=" + fruitsList +
                '}';
    }
}
