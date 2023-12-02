package com.solvd.automation_homework;

public class Equipment {
    private int equipmentId;
    private String name;
    private String brand;
    private String type;
    private double weight;
    protected String color;
    private boolean isAvailable;

    public Equipment(int equipmentId, String name, String brand, String type, double weight, String color) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.weight = weight;
        this.color = color;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
