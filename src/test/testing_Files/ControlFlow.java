class ControlFlow {
    int counter;

    ControlFlow() {
        counter = 0;
    }

    void loopIt() {
        while (counter < 5) {
            counter = counter + 1;
        }

        if (counter == 5) {
            counter++;
        } else {
            counter--;
        }
    }

    public static void main(String[] args) {
        ControlFlow c = new ControlFlow();
        c.loopIt();
    }
}
