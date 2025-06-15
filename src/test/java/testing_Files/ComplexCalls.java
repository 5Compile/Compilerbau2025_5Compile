public class ComplexCalls {
    ComplexCalls classObject;
    int a;

    public int makeComplexCalls() {
        this.classObject = new ComplexCalls();
        this.a = 1;
        this.classObject.a = 2;
        this.classObject.classObject = new ComplexCalls();
        this.classObject.classObject.a = this.getClassObject().a;
        return this.classObject.classObject.getA(3);
    }

    public ComplexCalls getClassObject() {
        return this.classObject;
    }

    public int getA(int x) {
        this.a = x;
        return x;
    }
}