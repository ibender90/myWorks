package ru.geekbrains.patterns.easy_builder;

public class EasyBuilder {
    public static void main(String[] args) {
        KitchenFurniture kitchen1 = new KitchenFurniture.Builder(2000)
                .setColor("White")
                .setHeight(3000)
                .setMaterial("Wood")
                .build();

        System.out.println(kitchen1);

        KitchenFurniture kitchen2 = new KitchenFurniture.Builder(1600)
                .setHeight(2000)
                .build();

        System.out.println(kitchen2);
    }
}
