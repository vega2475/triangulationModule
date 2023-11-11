package edu.vsu.vega.models;

import edu.vsu.vega.graphics.geometry.Face;
import edu.vsu.vega.graphics.geometry.Vertex;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public @Data class Model {
    private List<Vertex> vertices;
    private List<Face> faces;

    public Model() {
        vertices = new ArrayList<>();
        faces = new ArrayList<>();
    }
}
