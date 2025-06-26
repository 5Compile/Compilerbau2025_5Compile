package E2ETests;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


// DIESE KOMPLETTE KLASSE ÜBERSETZT TESTKLASSEN IN BYTECODE UND LÄDT SIE MIT EINEM CLASSLOADER IN DIE LAUFZEIT
// DANACH WERDEN MIT JAVA-REFLECTION-AUFRUFEN INFOS ABGEPRÜFT

// SPÄTER NOCH ANPASSEN !!!!
public class ReflectionsTestUtil {

    /**
     * Class object representing the class that was compiled and can be analysed using reflection
     */
    private final Class<?> clazz;
    /**
     * Object of the class that was compiled to help testing values of fields
     */
    private final Object instance;
    /**
     * Logger to log exceptions
     */
    private static final Logger LOGGER = Logger.getLogger(ReflectionsTestUtil.class.getName());

    /**
     * Constructor to compile the source files, load the Class<?>-Object and create an instance of the class
     * @param sourceFilePath Path to the source file to be compiled
     * @param className Name of the class to be loaded into the Class<?>-Object and create an instance of
     * @throws Exception If any exception occurs
     */
    public ReflectionsTestUtil(String sourceFilePath, String className) throws Exception {
        // Generate bytecode from source file
        byte[] resultBytecode = Compiler.generateByteCodeArrayFromFiles(List.of(sourceFilePath)).get(0);

        // Custom class loader to load the class
        ClassLoader classLoader = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) {
                return defineClass(name, resultBytecode, 0, resultBytecode.length);
            }
        };

        // Load the class and create an instance of it or throw an exception if it fails
        try {
            clazz = classLoader.loadClass(className);
            this.instance = clazz.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | SecurityException | NoSuchMethodException e) {
            LOGGER.log(Level.SEVERE, "Exception occurred", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the number of constructors of the class
     * @return Number of constructors
     */
    public int getConstructorCount() {
        return clazz.getDeclaredConstructors().length;
    }

    /**
     * Get the names of the constructors of the class
     * @return List of constructor names
     */
    public List<String> getConstructorNames() {
        List<String> constructorNames = new ArrayList<>();
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            constructorNames.add(constructor.getName());
        }
        return constructorNames;
    }

    /**
     * Get the number of parameters of a constructor
     * @param index Index of the constructor
     * @return Number of parameters
     */
    public int getConstructorParameterCount(int index) {
        return clazz.getDeclaredConstructors()[index].getParameterCount();
    }

    /**
     * Get the types of the parameters of a constructor
     * @param parameterTypes Array of parameter types the constructor should have
     * @return Number of parameters
     */
    public int getConstructorParameterCount(Class<?>[] parameterTypes) throws Exception {
        return clazz.getDeclaredConstructor(parameterTypes).getParameterCount();
    }

    /**
     * Get the types of the parameters of a constructor
     * @param index Index of the constructor
     * @return List of parameter types as strings
     */
    public List<String> getConstructorParameterTypes(int index) {
        List<String> parameterTypes = new ArrayList<>();
        for (Class<?> parameterType : clazz.getDeclaredConstructors()[index].getParameterTypes()) {
            parameterTypes.add(parameterType.getSimpleName());
        }
        return parameterTypes;
    }

    /**
     * Invoke a constructor of the class
     * @param parameterTypes Array of parameter types the constructor should have
     * @param args Arguments to be passed to the constructor
     * @return Object created by the constructor
     */
    public Object invokeConstructor(Class<?>[] parameterTypes, Object... args) throws Exception {
        return clazz.getDeclaredConstructor(parameterTypes).newInstance(args);
    }


    /**
     * Get the number of methods of the class
     * @return Number of methods
     */
    public int getMethodCount() {
        return clazz.getDeclaredMethods().length;
    }

    /**
     * Get the names of the methods of the class
     * @return List of method names
     */
    public List<String> getMethodNames() {
        List<String> methodNames = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            methodNames.add(method.getName());
        }
        return methodNames;
    }

    /**
     * Get the return type of method
     * @param methodName Name of the method
     * @param params Array of parameter types the method should have
     * @return Return type of the method
     */
    public String getMethodReturnType(String methodName, Class<?>... params) throws Exception {
        try {
            return clazz.getMethod(methodName, params).getReturnType().getSimpleName();
        } catch (NoSuchMethodException | SecurityException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the number of parameters of a method
     * @param methodName Name of the method
     * @param params Array of parameter types the method should have
     * @return Number of parameters
     */
    public int getMethodParameterCount(String methodName, Class<?>... params) throws Exception {
        try {
            return clazz.getMethod(methodName, params).getParameterCount();
        } catch (NoSuchMethodException | SecurityException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Get the types of the parameters of a method
     * @param methodName Name of the method
     * @param params Array of parameter types the method should have
     * @return List of parameter types as strings
     */
    public List<String> getMethodParameterTypes(String methodName, Class<?>... params) {
        try {
            List<String> parameterTypes = new ArrayList<>();
            for (Class<?> parameterType : clazz.getMethod(methodName, params).getParameterTypes()) {
                parameterTypes.add(parameterType.getSimpleName());
            }
            return parameterTypes;
        } catch (NoSuchMethodException | SecurityException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Invoke a method of the class with the given name and parameters, execute it on the instance and return the result
     * @param methodName Name of the method
     * @param parameterTypes Array of parameter types the method should have
     * @param args Arguments to be passed to the method
     * @return Object returned by the method
     */
    public Object invokeMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        try {
            Method method = clazz.getMethod(methodName, parameterTypes);
            return method.invoke(instance, args);
        } catch (InvocationTargetException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            throw new RuntimeException(e.getTargetException());
        }
    }


    /**
     * Get the number of fields of the class
     * @return Number of fields
     */
    public int getFieldCount() {
        return clazz.getDeclaredFields().length;
    }

    /**
     * Get the names of the fields of the class
     * @return List of field names
     */
    public List<String> getFieldNames() {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }

    /**
     * Get the types of the fields of the class
     * @return List of field types
     */
    public List<String> getFieldTypes() {
        List<String> fieldTypes = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            fieldTypes.add(field.getType().getSimpleName());
        }
        return fieldTypes;
    }

    /**
     * Get the value of a field of the class in the instance
     * @param fieldName Name of the field
     * @return Value of the field
     */
    public Object getFieldValue(String fieldName) throws Exception {
        try {
            return clazz.getField(fieldName).get(instance);
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Set the value of a field of the class in the instance
     * @param fieldName Name of the field
     * @param value Value to be set
     */
    public void setFieldValue(String fieldName, Object value) throws Exception {
        clazz.getField(fieldName).set(instance, value);
    }




    /**
     * Get the value of a field of an object by reflection
     * @param obj Object to get the field value from
     * @param fieldName Name of the field
     * @return Value of the field
     */
    public Object getFieldValueOfObject(Object obj, String fieldName) {
        try {
            Field field = obj.getClass().getField(fieldName);
            return field.get(obj);
        } catch (NoSuchFieldException e) {
            System.out.println("Das Feld " + fieldName + " existiert nicht.");
            return null;
        } catch (IllegalAccessException e) {
            System.out.println("Zugriff auf das Feld " + fieldName + " ist nicht erlaubt.");
            return null;
        }
    }
}
