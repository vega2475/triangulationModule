package edu.vsu.vega.utils;

import edu.vsu.vega.graphics.geometry.Face;
import edu.vsu.vega.models.Model;

import java.util.ArrayList;
import java.util.List;

public class Triangulation {
    public static void triangulate(Model model) {
        // Создаем новый список треугольников
        List<Face> triangulatedFaces = new ArrayList<>();

        for (Face face : model.getFaces()) {
            List<Integer> indices = face.getVertexIndices();

            // Проходим по каждой тройке вершин в полигоне
            for (int i = 0; i < indices.size() - 2; i++) {
                int v1 = indices.get(0);
                int v2 = indices.get(i + 1);
                int v3 = indices.get(i + 2);

                // Создаем новый треугольник
                List<Integer> triangleIndices = new ArrayList<>();
                triangleIndices.add(v1);
                triangleIndices.add(v2);
                triangleIndices.add(v3);

                triangulatedFaces.add(new Face(triangleIndices));

            }
        }

        // Заменяем текущие полигоны на новые треугольники
        model.setFaces(triangulatedFaces);
    }
}
