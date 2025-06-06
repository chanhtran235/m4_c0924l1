package com.example.demoss3.config;

import com.example.demoss3.model.ClassCG;
import com.example.demoss3.service.IClassService;
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
