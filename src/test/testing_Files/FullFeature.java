class FullFeature {
    int x;
    boolean flag;
    char symbol;

    FullFeature() {
        x = 10;
        flag = true;
    }

    void doStuff(int a, boolean b) {
        int result;
        result = a + 5 * (x - 2);
        if (b && flag) {
            print(result);
        } else {
            print(0);
        }
    }

    void anotherMethod() {
        FullFeature f = new FullFeature();
        f.doStuff(7, false);
    }

    public static void main(String[] args) {
        FullFeature obj = new FullFeature();
        obj.doStuff(3, true);
    }
}
