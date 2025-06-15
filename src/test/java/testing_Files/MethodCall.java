public class MethodCall {

    public int methodCall() {
        return method();
    }

    public int methodCall1() {
        return method1(1);
    }

    public int methodCall2() {
        return method2(1, 2);
    }

    public int method() {
        return 0;
    }

    public int method1(int x) {
        return x;
    }

    public int method2(int x, int y) {
        return x + y;
    }
}