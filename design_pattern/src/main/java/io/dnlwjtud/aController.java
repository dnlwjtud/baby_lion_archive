package io.dnlwjtud;

import java.util.List;

public class aController {

    private final SomeRepository repository;

    public aController(SomeRepository repository) {
        this.repository = repository;
    }

    public void write(String a) {
        this.repository.writeString(a);
    }

    public List<String> getList() {
        return repository.getMyArray();
    }

}
