package HomeWork1;

public class Cat implements Competitable {
    private int jumpHeight;
    private int runLength;
    private boolean atDistance;

    public Cat(int jumpHeight, int runLength) {
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
        atDistance = true;
    }

    @Override
    public void jump(int height) {
        if (jumpHeight >= height && atDistance) {
            System.out.println("Я кот, я перепрыгнул!");
        } else if (atDistance) {
            System.out.println("Я кот, я не смог прыгнуть");
            atDistance = false;
        } else {
            System.out.println("Я давно выбыл");
        }
    }

    @Override
    public void run(int length) {
        if (runLength >= length) {
            System.out.println("Я человек, я пробежал!");
        } else {
            System.out.println("Я человек, я не смог пробежать");
        }
    }
}
