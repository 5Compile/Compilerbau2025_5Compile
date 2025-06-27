package End2EndTests;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.Parser;

import static javax.swing.UIManager.get;


// DIESE KOMPLETTE KLASSE ÜBERSETZT TESTKLASSEN IN BYTECODE UND LÄDT SIE MIT EINEM CLASSLOADER IN DIE LAUFZEIT
// DANACH WERDEN MIT JAVA-REFLECTION-AUFRUFEN INFOS ABGEPRÜFT

// SPÄTER NOCH ANPASSEN !!!!
public class ReflectionUtility {

    private final Class<?> clazz;
    private final Object instance;
    private static final Logger LOGGER = Logger.getLogger(ReflectionUtility.class.getName());

    public ReflectionUtility(String sourceFilePath, String className) throws Exception {
        // Generate bytecode from source file
        byte[] resultBytecode = Parser.generateBytecodeFromFile(sourceFilePath);

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

    public int getConstructorCount() {
        return clazz.getDeclaredConstructors().length;
    }

    public List<String> getConstructorNames() {
        List<String> constructorNames = new ArrayList<>();
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            constructorNames.add(constructor.getName());
        }
        return constructorNames;
    }

    public int getConstructorParameterCount(int index) {
        return clazz.getDeclaredConstructors()[index].getParameterCount();
    }


    public int getConstructorParameterCount(Class<?>[] parameterTypes) throws Exception {
        return clazz.getDeclaredConstructor(parameterTypes).getParameterCount();
    }


    public List<String> getConstructorParameterTypes(int index) {
        List<String> parameterTypes = new ArrayList<>();
        for (Class<?> parameterType : clazz.getDeclaredConstructors()[index].getParameterTypes()) {
            parameterTypes.add(parameterType.getSimpleName());
        }
        return parameterTypes;
    }


    public Object invokeConstructor(Class<?>[] parameterTypes, Object... args) throws Exception {
        return clazz.getDeclaredConstructor(parameterTypes).newInstance(args);
    }


    public int getMethodCount() {
        return clazz.getDeclaredMethods().length;
    }


    public List<String> getMethodNames() {
        List<String> methodNames = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            methodNames.add(method.getName());
        }
        return methodNames;
    }


    public String getMethodReturnType(String methodName, Class<?>... params) throws Exception {
        try {
            return clazz.getMethod(methodName, params).getReturnType().getSimpleName();
        } catch (NoSuchMethodException | SecurityException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            throw new RuntimeException(e);
        }
    }

    public int getMethodParameterCount(String methodName, Class<?>... params) throws Exception {
        try {
            return clazz.getMethod(methodName, params).getParameterCount();
        } catch (NoSuchMethodException | SecurityException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            throw new RuntimeException(e);
        }
    }

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

    public Object invokeMethod(String methodName, Class<?>[] parameterTypes, Object... args) throws Exception {
        try {
            Method method = clazz.getMethod(methodName, parameterTypes);
            return method.invoke(instance, args);
        } catch (InvocationTargetException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            throw new RuntimeException(e.getTargetException());
        }
    }


    public int getFieldCount() {
        return clazz.getDeclaredFields().length;
    }

    public List<String> getFieldNames() {
        List<String> fieldNames = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }


    public List<String> getFieldTypes() {
        List<String> fieldTypes = new ArrayList<>();
        for (Field field : clazz.getDeclaredFields()) {
            fieldTypes.add(field.getType().getSimpleName());
        }
        return fieldTypes;
    }


    public Object getFieldValue(String fieldName) throws Exception {
        try {
            return clazz.getField(fieldName).get(instance);
        } catch (IllegalAccessException e) {
            LOGGER.log(Level.SEVERE, "Exception occur", e);
            throw new RuntimeException(e);
        }
    }

    public void setFieldValue(String fieldName, Object value) throws Exception {
        clazz.getField(fieldName).set(instance, value);
    }



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
    public Class<?> getCompiledClass() {
        return clazz; // oder wie auch immer dein geladenes Class-Objekt heißt
    }

}
