public class ComplexExample {

    int counter = 0;
    boolean active = true;
    String name = "Compiler";

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

    public String getName() {
        return name;
    }

    public void updateName(String newName) {
        name = newName;
    }

    public double calculateArea(double width, double height) {
        return width * height;
    }

    public String summarize() {
        return name + " [" + counter + "]";
    }
}