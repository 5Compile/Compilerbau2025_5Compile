public class LogicExpr {
    public boolean test() {
        int x;
        x = 10;
        int y;
        y = 20;
        return x < y;
    }

    public boolean test2() {
        int x;
        x = 10;
        int y;
        y = 20;
        return x > y;
    }

    public boolean test3() {
        int x;
        x = 10;
        int y;
        y = 20;
        return x == y;
    }

    public boolean test4() {
        int x;
        x = 10;
        int y;
        y = 20;
        return x != y;
    }

    public boolean test5() {
        int x;
        x = 10;
        int y;
        y = 20;
        return x <= y;
    }

    public boolean test6() {
        int x;
        x = 10;
        int y;
        y = 20;
        return x >= y;
    }

    public boolean test7() {
        boolean x;
        x = true;
        boolean y;
        y = false;
        return x && y;
    }

    public boolean test8() {
        boolean x;
        x = true;
        boolean y;
        y = false;
        return x || y;
    }
}