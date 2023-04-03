package io.dnlwjtud.singletonP;

import java.util.List;

public class bController {

    private final SomeRepository repository;

    public bController(SomeRepository repository) {
        this.repository = repository;
    }

    public void write(String a) {
        this.repository.writeString(a);
    }

    public List<String> getList() {
        return repository.getMyArray();
    }

}
