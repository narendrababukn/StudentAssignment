package com.chandu.model;

public class Student {
    private String stdId;
    private String stdName;

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stdId='" + stdId + '\'' +
                ", stdName='" + stdName + '\'' +
                '}';
    }
}
