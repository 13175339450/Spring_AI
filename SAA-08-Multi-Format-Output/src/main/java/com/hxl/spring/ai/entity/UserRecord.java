package com.hxl.spring.ai.entity;

/**
 * 用户
 */
public record UserRecord(Integer id, String name, Integer age, String email) {
    @Override
    public Integer id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public Integer age() {
        return age;
    }

    @Override
    public String email() {
        return email;
    }
}
