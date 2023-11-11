package edu.vsu.vega.graphics.geometry;

import lombok.Data;

import java.util.List;

@Data
public class Face {
    private List<Integer> vertexIndices;

    public Face(List<Integer> vertexIndices) {
        this.vertexIndices = vertexIndices;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("f ");
        for (int index : vertexIndices) {
            result.append(index).append(" ");
        }
        return result.toString().trim();
    }
}
