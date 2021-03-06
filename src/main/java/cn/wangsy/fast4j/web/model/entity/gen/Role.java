/*
 * Role.java
 * Copyright(C) 2011-2016
 * All rights reserved.
 * --------------------------------
 * 20160803
 */
package cn.wangsy.fast4j.web.model.entity.gen;

import java.io.Serializable;

public class Role implements Serializable {
    /**
     * 角色id
     * 
     * This field corresponds to the database column role.id
     */
    private String id;

    /**
     * 角色名称
     * 
     * This field corresponds to the database column role.name
     */
    private String name;

    /**
     * 签名
     * 
     * This field corresponds to the database column role.role_sign
     */
    private String roleSign;

    /**
     * 父角色id
     * 
     * This field corresponds to the database column role.parent
     */
    private String parent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.name
     *
     * @return the value of role.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.name
     *
     * @param name the value for role.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_sign
     *
     * @return the value of role.role_sign
     *
     * @mbggenerated
     */
    public String getRoleSign() {
        return roleSign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_sign
     *
     * @param roleSign the value for role.role_sign
     *
     * @mbggenerated
     */
    public void setRoleSign(String roleSign) {
        this.roleSign = roleSign == null ? null : roleSign.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.parent
     *
     * @return the value of role.parent
     *
     * @mbggenerated
     */
    public String getParent() {
        return parent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.parent
     *
     * @param parent the value for role.parent
     *
     * @mbggenerated
     */
    public void setParent(String parent) {
        this.parent = parent == null ? null : parent.trim();
    }
}