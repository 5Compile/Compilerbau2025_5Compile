public class MethodTestClass {
    public int sum(int a, int b) {
        return a + b;
    }

    public char change(char x, char y) {
        char temp;
        temp = y;
        y = x;
        x = y;
        return x;
    }

    public boolean isPositive(int number) {
        return number > 0;
    }
}