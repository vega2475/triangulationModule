package edu.vsu.vega.utils;

import de.javagl.obj.FloatTuple;
import de.javagl.obj.Obj;
import de.javagl.obj.ObjFace;
import edu.vsu.vega.graphics.geometry.Face;
import edu.vsu.vega.graphics.geometry.Vertex;
import edu.vsu.vega.models.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjParser {
    public Model parseToModel(Obj obj){
        Model model = new Model();
        List<Vertex> vertices = model.getVertices();
        List<Face> faces = model.getFaces();
        for (int i = 0; i < obj.getNumVertices(); i++) {
            FloatTuple vertex = obj.getVertex(i);
            double x = vertex.getX();
            double y = vertex.getY();
            double z = vertex.getZ();
            vertices.add(new Vertex(x, y, z));
        }

        for (int i = 0; i < obj.getNumFaces(); i++) {
            ObjFace face = obj.getFace(i);
            List<Integer> vertexIndices = new ArrayList<>();
            for (int j = 0; j < face.getNumVertices(); j++) {
                vertexIndices.add(face.getVertexIndex(j));
            }
            faces.add(new Face(vertexIndices));
        }
        return model;
    }

    public String parseModelToObjString(Model model){
        StringBuilder result = new StringBuilder();

        for (Vertex vertex : model.getVertices()) {
            result.append(vertex).append("\n");
        }

        for (Face face : model.getFaces()) {
            face.setVertexIndices(
                    face.getVertexIndices().stream().map(num -> num + 1).collect(Collectors.toList())
            );
            result.append(face).append("\n");
        }

        return result.toString();
    }
}
