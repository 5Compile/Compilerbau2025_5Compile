public class MultipleClasses1 {
    MultipleClasses2 anotherClass;

    public MultipleClasses1() {
        this.anotherClass = new MultipleClasses2();
    }

    public int getIFromAnotherClass() {
        return this.anotherClass.i;
    }
}