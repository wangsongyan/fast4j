/*
 * Permission.java
 * Copyright(C) 2011-2016
 * All rights reserved.
 * --------------------------------
 * 20160726
 */
package cn.wangsy.fast4j.web.model.entity.gen;

import java.io.Serializable;

public class Permission implements Serializable {
    /**
     * 权限id
     * 
     * This field corresponds to the database column permission.id
     */
    private String id;

    /**
     * 权限名字
     * 
     * This field corresponds to the database column permission.name
     */
    private String name;

    /**
     * 权限编码
     * 
     * This field corresponds to the database column permission.code
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table permission
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.id
     *
     * @return the value of permission.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.id
     *
     * @param id the value for permission.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.name
     *
     * @return the value of permission.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.name
     *
     * @param name the value for permission.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column permission.code
     *
     * @return the value of permission.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column permission.code
     *
     * @param code the value for permission.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}