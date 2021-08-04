package com.company;

import java.util.Arrays;
import java.util.EmptyStackException;

/*
    제네릭 배열을 만드는 2가지 방식
    1. E 타입으로 배열 선언 후 생성자에서 Object 배열 할당, 생성자에 @SuppressedWarnings 태그
    - 가독성이 좋음
    - 형변환을 배열 생성 시 한번만 하면 됨
    - 현업에서 선호

    2. Object 타입으로 배열 선언 후 pop 연산에 return 값에 E 타입으로 형변환, pop 메소드에 @SuppressedWarnings 태그
    - 배열에서 원소를 읽을 때마다 형변환

    컴파일러는 런타임에 발생하는 형변환이 안전한지 증명할 방법이 없다. 개발자가 직접 증명하고, 경고를 숨겨줘야 함

 */
public class StackGeneric<E> {
    private Object[] elements;
//    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

//    @SuppressWarnings("unchecked")
    public StackGeneric() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }
    private void ensureCapacity(){
        if(elements.length == size)
            elements = Arrays.copyOf(elements, 2*size + 1);
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E pop(){
        if(size == 0)
            throw new EmptyStackException();
        @SuppressWarnings("unchecked")
        E result = (E) elements[--size];
        elements[size] = null;
        return result;
    }
    public void pushAll(Iterable<E> src){
        for(E e : src)
            push(e);
    }
}
class Test{
    public static void main(String[] args) {

        StackGeneric<Integer> sg = new StackGeneric<>();

    }
}