public class Operators {
    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }

    public int mod(int a, int b) {
        return a % b;
    }

    public int brackets(int a, int b) {
        return (a + b) * a;
    }

    public int callOperatedMethods(int a, int b) {
        return add(a, b) + sub(a, b) + mul(a, b) + div(a, b) + mod(a, b);
    }
}