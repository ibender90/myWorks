package ru.geekbrains.patterns.easy_builder;

public class KitchenFurniture {
    private String material;
    private int width;
    private int height;
    private String color;

    public String getMaterial(){
        return material;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "KitchenFurniture{" +
                "width=" + width +
                ", height=" + height +
                ", material= " + material +
                ", color='" + color + '\'' +
                '}';
    }

    private KitchenFurniture(Builder builder){
        this.material = builder.Material;
        this.width = builder.Width;
        this.height = builder.Height;
        this.color = builder.Color;
    }

    static class Builder {
        private String Material;
        private int Width;
        private int Height;
        private String Color;

        public Builder(int width){
            Width = width;
        }

        public Builder setMaterial(String material){
            Material = material;
            return this;
        }

        public Builder setHeight(int height){
            Height = height;
            return this;
        }

        public Builder setColor(String color){
            Color = color;
            return this;
        }

        public KitchenFurniture build(){
            return new KitchenFurniture(this);
        }


    }
}
