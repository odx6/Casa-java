/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuroingeniero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class OBJLoader {
    
    public static Model loadModel(String fileName) {
        ArrayList<float[]> vertices = new ArrayList<>();
        ArrayList<float[]> normals = new ArrayList<>();
        ArrayList<int[]> indices = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("v ")) {
                    String[] parts = line.split(" ");
                    float x = Float.parseFloat(parts[1]);
                    float y = Float.parseFloat(parts[2]);
                    float z = Float.parseFloat(parts[3]);
                    float[] vertex = {x, y, z};
                    vertices.add(vertex);
                } else if (line.startsWith("vn ")) {
                    String[] parts = line.split(" ");
                    float x = Float.parseFloat(parts[1]);
                    float y = Float.parseFloat(parts[2]);
                    float z = Float.parseFloat(parts[3]);
                    float[] normal = {x, y, z};
                    normals.add(normal);
                } else if (line.startsWith("f ")) {
                    String[] parts = line.split(" ");
                    int[] vertexIndices = new int[3];
                    int[] normalIndices = new int[3];
                    for (int i = 0; i < 3; i++) {
                        String[] subParts = parts[i+1].split("/");
                        vertexIndices[i] = Integer.parseInt(subParts[0]) - 1;
                        normalIndices[i] = Integer.parseInt(subParts[2]) - 1;
                    }
                    indices.add(vertexIndices);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error al cargar el archivo .obj: " + fileName+e.getMessage());
            e.printStackTrace();
        }
        
        // Convertir los datos en arrays
        float[] verticesArray = new float[vertices.size() * 3];
        float[] normalsArray = new float[normals.size() * 3];
        int[] indicesArray = new int[indices.size() * 3];
        int vertexPointer = 0;
        int normalPointer = 0;
        for (float[] vertex : vertices) {
            verticesArray[vertexPointer++] = vertex[0];
            verticesArray[vertexPointer++] = vertex[1];
            verticesArray[vertexPointer++] = vertex[2];
        }
        for (float[] normal : normals) {
            normalsArray[normalPointer++] = normal[0];
            normalsArray[normalPointer++] = normal[1];
            normalsArray[normalPointer++] = normal[2];
        }
        for (int[] vertexIndices : indices) {
            for (int i = 0; i < 3; i++) {
                indicesArray[vertexPointer++] = vertexIndices[i];
            }
        }
        
        return new Model(verticesArray, normalsArray, indicesArray);
    }
    
}