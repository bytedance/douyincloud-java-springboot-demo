package com.bytedance.douyinclouddemo.model;

import java.util.ArrayList;

public class TextAntidirt {

    public ArrayList<Task> tasks;

    public TextAntidirt(String content) {
        this.tasks = new ArrayList<>();
        this.tasks.add(new Task(content));
    }
}

class Task {
    public String content;

    public Task(String content) {
        this.content = content;
    }
}

