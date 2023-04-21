/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futuroingeniero;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class exe {
    
    public static void main(String[] args) {
        try {
            Display.setDisplayMode(new DisplayMode(640, 480));
            Display.create();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GLU.gluPerspective(45.0f, 640.0f / 480.0f, 0.1f, 100.0f);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        String ruta="C:/Users/ever/Documents/materias/Graficacion/Graficacion/Laberinto OpenGL/src/futuroingeniero/pato.obj";
        Model model = OBJLoader.loadModel(ruta);
        
        while (!Display.isCloseRequested()) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glLoadIdentity();
            GLU.gluLookAt(0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            
            GL11.glBegin(GL11.GL_TRIANGLES);
            for (int i = 0; i < model.getIndices().length; i++) {
                int index = model.getIndices()[i];
                GL11.glVertex3f(model.getVertices()[index*3], model.getVertices()[index*3+1], model.getVertices()[index*3+2]);
                GL11.glNormal3f(model.getNormals()[index*3], model.getNormals()[index*3+1], model.getNormals()[index*3+2]);
            }
            GL11.glEnd();
            
            Display.update();
            Display.sync(60);
        }
        
        Display.destroy();
    }
    
}

