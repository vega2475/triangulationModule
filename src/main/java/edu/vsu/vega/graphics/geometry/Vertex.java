package edu.vsu.vega.graphics.geometry;

import lombok.Data;

public @Data class Vertex {
    private double x;
    private double y;
    private double z;

    public Vertex(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString(){
        return "v " + x + " " + y + " " + z;
    }
}
