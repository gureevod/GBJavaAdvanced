package HomeWork1;

public class Human implements Competitable {
    private int jumpHeight;
    private int runLength;

    public Human(int jumpHeight, int runLength) {
        this.jumpHeight = jumpHeight;
        this.runLength = runLength;
    }

    @Override
    public void jump(int height) {
        if (jumpHeight >= height ) {
            System.out.println("Я человек, я перепрыгнул!");
        }
    }

    @Override
    public void run(int length) {
        if (runLength >= length) {
            System.out.println("Я человек, я пробежал!");
        }
    }
}
