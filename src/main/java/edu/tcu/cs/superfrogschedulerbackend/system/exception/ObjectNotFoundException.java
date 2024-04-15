package edu.tcu.cs.superfrogschedulerbackend.system.exception;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String objectName, String id) {
        super(STR."Could not find \{objectName} with Id \{id} :(");
    }

    public ObjectNotFoundException(String objectName, Integer id) {
        super(STR."Could not find \{objectName} with Id \{id} :(");
    }

}