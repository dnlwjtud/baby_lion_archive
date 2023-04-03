package io.dnlwjtud.singletonPtn;

import java.util.ArrayList;
import java.util.List;

public class SomeRepository {

    private List<String> myArray = new ArrayList<>();

    public void writeString(String a) {
        myArray.add(a);
    }

    public List<String> getMyArray() {
        return myArray;
    }

}
