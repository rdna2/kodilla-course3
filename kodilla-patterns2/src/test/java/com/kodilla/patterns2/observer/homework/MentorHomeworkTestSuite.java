package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MentorHomeworkTestSuite {

    @Test
    public void taskUpdate() {
        // Given
        Homework javaTask = new JavaTasks();
        Homework cPlusTask = new CPlusTasks();
        Homework pythonTask = new PythonTasks();
        Mentor johnSmith = new Mentor("John Smith");
        Mentor ivoneEscobar= new Mentor("Ivone Escobar");
        Mentor jessiePinkman = new Mentor("Jessie Pinkman");
        javaTask.registerMentor(johnSmith);
        cPlusTask.registerMentor(ivoneEscobar);
        pythonTask.registerMentor(jessiePinkman);
        javaTask.registerMentor(jessiePinkman);
        // When
        javaTask.addTask("Module 1 for review");
        javaTask.addTask("Module 2 for processing");
        cPlusTask.addTask("Module 3 for review");
        cPlusTask.addTask("Module 4 for analysis");
        pythonTask.addTask("Module 1 for analysis");
        pythonTask.addTask("Module 3 for review");
        pythonTask.addTask("Module 4 for processing");
        // Then
        assertEquals(2, johnSmith.getUpdateCount());
        assertEquals(2, ivoneEscobar.getUpdateCount());
        assertEquals(5, jessiePinkman.getUpdateCount());
    }
}