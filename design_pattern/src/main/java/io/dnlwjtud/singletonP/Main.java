package io.dnlwjtud.singletonP;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SomeRepository someRepository = new SomeRepository();

        aController aController = new aController(someRepository);
        bController bController = new bController(someRepository);

        aController.write("hello world!");

        List<String> list = bController.getList();
        String someString = list.get(0);


        System.out.println("someString = " + someString);


    }

}