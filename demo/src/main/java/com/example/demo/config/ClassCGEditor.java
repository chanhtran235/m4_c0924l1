package com.example.demo.config;

import com.example.demo.model.ClassCG;
import com.example.demo.service.ClassService;
import com.example.demo.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.beans.PropertyEditorSupport;

@Component

public class StringToClassCGConverter extends PropertyEditorSupport {

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
//    @Override
//    public ClassCG convert(String idStr) {
//        System.out.println("----------Converting String to ClassCG:------------ " + idStr);
//        try {
//            int id = Integer.parseInt(idStr);
//            return classService.findById(id);
//        } catch (NumberFormatException e) {
//            return null;
//        }
//    }
}
