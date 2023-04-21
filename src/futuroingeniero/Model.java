/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuroingeniero;

/**
 *
 * @author ever
 */
public class Model {
    
    private float[] vertices;
    private float[] normals;
    private int[] indices;
    
    public Model(float[] vertices, float[] normals, int[] indices) {
        this.vertices = vertices;
        this.normals = normals;
        this.indices = indices;
    }
    
    public float[] getVertices() {
        return vertices;
    }
    
    public float[] getNormals() {
        return normals;
    }
    
    public int[] getIndices() {
        return indices;
    }
}

