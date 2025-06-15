public class ClassObjects {

    ClassObjects b;

    public ClassObjects() {
    }

    public ClassObjects(int a) {
    }

    public void objectsMethod() {
        this.b = new ClassObjects();
        ClassObjects c = new ClassObjects(2);
        ClassObjects d = new ClassObjects();
    }
}