public class ComplexExample {

    int counter = 0;
    boolean active = true;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter++;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        active = false;
    }


    public void updateName(String newName) {
        name = newName;
    }

    public double calculateArea(double width, double height) {
        return width * height;
    }

}