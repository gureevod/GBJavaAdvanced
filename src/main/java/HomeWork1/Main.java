package HomeWork1;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        CanJump[] jumpers = {new Cat(11, 10), new Human(12, 22)};
        CanRun[] runners = {new Cat(10, 10), new Human(12, 12)};

        Competitable[] competitors = {new Cat(10, 10), new Human(12, 12)};

        Overcomable[] obstacles = {new Wall(10), new Road(100)};

        for (Overcomable overcomable : obstacles) {
            for (Competitable competitable : competitors) {
                overcomable.overcome(competitable);
            }
        }

    }
}
