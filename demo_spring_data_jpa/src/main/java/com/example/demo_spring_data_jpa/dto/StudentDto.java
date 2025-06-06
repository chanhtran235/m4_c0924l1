package com.example.demo_spring_data_jpa.dto;

import com.example.demo_spring_data_jpa.model.ClassCG;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
// dto => dâta transfer object
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto implements Validator {
//    @NotEmpty(message = "Not Empty")
//    @Pattern(regexp = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$", message = "Not Match")
    private String name;
    private int gender;
    private ClassCG classCG;

    // không cần
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
       StudentDto studentDto = (StudentDto)target;
       if ("".equals(studentDto.getName())){
           errors.rejectValue("name",null, "Khong de trong");
       } else if (!studentDto.getName().matches("^[A-Z][a-z]+(\\s[A-Z][a-z]+)*$")) {
           errors.rejectValue("name","notMatch", "Khong dung dinh dang");
       }

    }
}
