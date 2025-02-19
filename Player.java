/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut;

/**
 *
 * @author samuk
 */
public class Player {
    private String name;
    private Integer idNum;
    private Integer age;
    private String area;

    public Player(String name, Integer idNum, Integer age, String area) {
        this.name = name;
        this.idNum = idNum;
        this.age = age;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdNum() {
        return idNum;
    }

    public void setIdNum(Integer idNum) {
        this.idNum = idNum;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", idNum=" + idNum + ", age=" + age + ", area=" + area + '}';
    }
    
    
    
}
