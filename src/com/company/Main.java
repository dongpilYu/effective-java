package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // 배열은 공변이기 때문에, 성립 가능
        Object[] objectArray = new Integer[1];
        objectArray[0] = 1;

        // 리스트는 불공변이기 때문에, 컴파일 에러 발생
        // List<Object> objectList = new ArrayList<Integer>







    }
}
