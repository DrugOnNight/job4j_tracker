package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.Store;

import java.util.Objects;

public class FindByIDAction implements UserAction {
    private final Output out;

    public FindByIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by ID";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by ID ===");
        int id = input.askInt("Enter ID: ");
        Item item = tracker.findById(id);
        out.println(Objects.requireNonNullElseGet(item, () -> "Заявка с введенным ID: " + id + " не найдена."));
        return true;
    }
}
