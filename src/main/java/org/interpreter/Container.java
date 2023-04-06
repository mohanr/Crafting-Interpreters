package org.interpreter;

public class Container<T> {
    private T element;

    public static <T> Integer verifyType(Object element) {
        Class<Integer> type = Integer.class;
        if (type == Integer.class) {
            return type.cast(new Integer(Integer.parseInt(element.toString())));
        }
        return null;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public Container(T someElement) {
        this.element = someElement;
    }

    public static <T> T verifyType(String name, Class<T> type) {
        if (type == Integer.class) {
            return type.cast(new Integer(Integer.parseInt(name)));
        }
        return null;
    }
}