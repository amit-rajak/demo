package com.example.demo.requests;

import com.example.demo.model.Student;
import lombok.*;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentCreateRequest {
    private String name;
    private int age;
    private String country;
    private String contact;

    public Student toStudent()
    {
        return Student.builder().age(age)
                .contact(contact)
                .name(name)
                .country(country).build();
    }
}
