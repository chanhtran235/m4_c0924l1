package com.example.demoss3.config;

import com.example.demoss3.model.ClassCG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalBindingInitializer {

  @Autowired
    private ClassCGEditor classCGEditor;
  @InitBinder
    public void initBinding(WebDataBinder webDataBinder){
      webDataBinder.registerCustomEditor(ClassCG.class,classCGEditor);
  }
}