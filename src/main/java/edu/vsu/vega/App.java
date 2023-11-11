package edu.vsu.vega;
import de.javagl.obj.Obj;
import de.javagl.obj.ObjReader;
import edu.vsu.vega.models.Model;
import edu.vsu.vega.utils.ObjParser;
import edu.vsu.vega.utils.Triangulation;

import java.io.*;

public class App
{
    public static void main( String[] args ) throws IOException {
        InputStream objInputStream = new FileInputStream("MaleLow.obj");

        Obj obj = ObjReader.read(objInputStream);

        ObjParser objParser = new ObjParser();

        Model model = objParser.parseToModel(obj);

        Triangulation.triangulate(model);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.obj"))) {
            writer.write(objParser.parseModelToObjString(model));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
