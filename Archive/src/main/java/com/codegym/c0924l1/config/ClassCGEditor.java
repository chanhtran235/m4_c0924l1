package com.codegym.c0924l1.config;

import com.codegym.c0924l1.model.ClassCG;
import com.codegym.c0924l1.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class ClassCGEditor extends PropertyEditorSupport {

    @Autowired
    private  IClassService classService;
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("------ Binding with PropertyEditor: " + text);
        try {
            int id = Integer.parseInt(text);
            ClassCG classCG = classService.findById(id);
            this.setValue(classCG);
        } catch (NumberFormatException e) {
            this.setValue(null);
        }
    }
}
