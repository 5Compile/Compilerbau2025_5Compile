class TestSimpleClass {
    public static void main(String[] args) {
        SimpleClass obj = new SimpleClass();
        System.out.println("SimpleClass created successfully!");
        System.out.println("Object type: " + obj.getClass().getName());

        // Test accessing the field
        System.out.println("Initial value field: " + obj.value);

        // Test calling the method
        obj.setValue(42);
        System.out.println("After setValue(42): " + obj.value);

        // Test calling main method
        System.out.println("Calling SimpleClass.main():");
        SimpleClass.main(new String[]{"test"});
    }
}