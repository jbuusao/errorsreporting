package com.example.errorsreporting;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "errors")
@Entity
@Data
public class Error {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String converter;
    private String source;
    private String context;
    private String message;
    private Date date;

    protected Error() {}

    public Error(String converter, String source, String context, String message) {
        this.converter = converter;
        this.source = source;
        this.context = context;
        this.message = message;
        this.date = new Date();
    }
/*
    public Long getId() {
        return id;
    }

    public String getConverter() {
        return converter;
    }
    public String getSource() {
        return source;
    }
    public String getContext() {
        return context;
    }
    public String getMessage() {
        return message;
    }
    */
}