package com.disney.disneyproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String recurseName;
    private String fieldName;
    private long fieldValue;

    public ResourceNotFoundException(String recurseName, String fieldName, long fieldValue){
        super(String.format("%s not founded with: %s :'%s'", recurseName, fieldName,fieldValue));
        this.fieldName=fieldName;
        this.recurseName=recurseName;
        this.fieldValue=fieldValue;
    }

    public String getRecurseName() {
        return recurseName;
    }

    public void setRecurseName(String recurseName) {
        this.recurseName = recurseName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(long fieldValue) {
        this.fieldValue = fieldValue;
    }
}
