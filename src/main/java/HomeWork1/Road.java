package HomeWork1;

public class Road implements Overcomable {
    private int length;

    public Road(int length) {
        this.length = length;
    }

    @Override
    public void overcome(Competitable competitable) {
        competitable.run(length);
    }
}
