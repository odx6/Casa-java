package futuroingeniero;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;
import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class ProyectoFinal  {

    public static Vista cam;
    static ArrayList<Float> corDispX = new  ArrayList<>();
    static ArrayList<Float> corDispZ = new  ArrayList<>();
    public static void main(String[] args) {
        initDisplay();
        initGL();
        gameLoop();
        cleanUp();
        
    }

    public static void initGL()  {
        
        cam=new Vista(70, (float)Display.getWidth() / (float)Display.getHeight()  ,0.3f ,500);
        
        glClearColor(0, 0, 0, 1);

        glEnable(GL_DEPTH_TEST);
        glCullFace(GL_BACK);
     
       glEnable(GL_LIGHT0);  
       glEnable(GL11.GL_BACK_RIGHT);  
       glEnable(GL11.GL_LIGHT_MODEL_AMBIENT); 
       
       glShadeModel(GL_SMOOTH);      
       glEnable(GL_COLOR_MATERIAL);
       glEnable(GL_TEXTURE_2D);
         
    }

    public static void gameLoop() {       
              
        Texture tParedrojo=loadTexture("paredroja");
        Texture tPisoCasa=loadTexture("pisoDeCasa");
        Texture tParedblanco=loadTexture("paredblanca");
        Texture tPuerta=loadTexture("paredblanca");
        
        while (!Display.isCloseRequested()) {
            glColor3f (1.0f, 1.0f, 1.0f);
                                  
            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
            glShadeModel(GL_SMOOTH);
            glLoadIdentity();
            
            cam.useView();
           
            tPisoCasa.bind();
            glBegin(GL_QUADS);
            {
                glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(-0.2f,-0.49f,-0.7f);
                glTexCoord2f(20,0);glVertex3f(-0.2f,-0.49f,3.7f);
                glTexCoord2f(20,20);glVertex3f(6.2f,-0.49f,3.7f);
                glTexCoord2f(0,20);glVertex3f(6.2f,-0.49f,-0.7f);
                //----------------------------
                glTexCoord2f(0,0);glVertex3f(-0.2f,-0.59f,-0.7f);
                glTexCoord2f(20,0);glVertex3f(-0.2f,-0.59f,3.7f);
                glTexCoord2f(20,20);glVertex3f(6.2f,-0.59f,3.7f);
                glTexCoord2f(0,20);glVertex3f(6.2f,-0.59f,-0.7f);
                  //----------------------------
                glTexCoord2f(0,0);glVertex3f(-0.2f,-0.49f,-0.7f);
                glTexCoord2f(20,0);glVertex3f(-0.2f,-0.49f,3.7f);
                glTexCoord2f(20,20);glVertex3f(-0.2f,-0.59f,3.7f);
                glTexCoord2f(0,20);glVertex3f(-0.2f,-0.59f,-0.7f);
                //------------------------------------------
                glTexCoord2f(0,0);glVertex3f(6.2f,-0.49f,-0.7f);
                glTexCoord2f(20,0);glVertex3f(6.2f,-0.49f,3.7f);
                glTexCoord2f(20,20);glVertex3f(6.2f,-0.59f,3.7f);
                glTexCoord2f(0,20);glVertex3f(6.2f,-0.59f,-0.7f);
            }
                  glEnd();
                tParedrojo.bind();
            glBegin(GL_QUADS);
            {
                glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(5.82f,1.5f,3.4f);
                glTexCoord2f(20,0);glVertex3f(5.82f,1.5f,3.2f);
                glTexCoord2f(20,20);glVertex3f(5.82f,-0.5f,3.2f);
                glTexCoord2f(0,20);glVertex3f(5.82f,-0.5f,3.4f);
                //----------------------------
                glTexCoord2f(0,0);glVertex3f(5.82f,1.5f,-0.35f);
                glTexCoord2f(20,0);glVertex3f(5.82f,1.5f,-0.55f);
                glTexCoord2f(20,20);glVertex3f(5.82f,-0.5f,-0.55f);
                glTexCoord2f(0,20);glVertex3f(5.82f,-0.5f,-0.35f);
                //----------------------------                                
                glTexCoord2f(0,0);glVertex3f(5.65f,1.5f,3.4f);
                glTexCoord2f(20,0);glVertex3f(5.85f,1.5f,3.4f);
                glTexCoord2f(20,20);glVertex3f(5.85f,-0.5f,3.4f);
                glTexCoord2f(0,20);glVertex3f(5.65f,-0.5f,3.4f);
                //----------------------------
                 glTexCoord2f(0,0);glVertex3f(5.65f,1.5f,-0.55f);
                glTexCoord2f(20,0);glVertex3f(5.85f,1.5f,-0.55f);
                glTexCoord2f(20,20);glVertex3f(5.85f,-0.5f,-0.55f);
                glTexCoord2f(0,20);glVertex3f(5.65f,-0.5f,-0.55f);
                //----------------------------
                
                glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(-0.05f,1.5f,3.2f);
                glTexCoord2f(20,0);glVertex3f(-0.05f,1.5f,3.4f);
                glTexCoord2f(20,20);glVertex3f(-0.05f,-0.5f,3.4f);
                glTexCoord2f(0,20);glVertex3f(-0.05f,-0.5f,3.2f);
                //----------------------------
                glTexCoord2f(0,0);glVertex3f(-0.05f,1.5f,-0.35f);
                glTexCoord2f(20,0);glVertex3f(-0.05f,1.5f,-0.55f);
                glTexCoord2f(20,20);glVertex3f(-0.05f,-0.5f,-0.55f);
                glTexCoord2f(0,20);glVertex3f(-0.05f,-0.5f,-0.35f);
                //----------------------------                                
                glTexCoord2f(0,0);glVertex3f(0.15f,1.5f,3.4f);
                glTexCoord2f(20,0);glVertex3f(-0.05f,1.5f,3.4f);
                glTexCoord2f(20,20);glVertex3f(-0.05f,-0.5f,3.4f);
                glTexCoord2f(0,20);glVertex3f(0.15f,-0.5f,3.4f);
                //----------------------------
                 glTexCoord2f(0,0);glVertex3f(0.15f,1.5f,-0.55f);
                glTexCoord2f(20,0);glVertex3f(-0.05f,1.5f,-0.55f);
                glTexCoord2f(20,20);glVertex3f(-0.05f,-0.5f,-0.55f);
                glTexCoord2f(0,20);glVertex3f(0.15f,-0.5f,-0.55f);
                
                //----------------------------
                
                
            }
                  
                  glEnd(); 
            tParedblanco.bind();           
            glBegin(GL_QUADS);
            {
                glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(-200.74f,200.39f,-200.4f);
                glTexCoord2f(20,0);glVertex3f(200.71f,200.39f,-200.4f);
                glTexCoord2f(20,20);glVertex3f(200.71f,-200.5f,-200.4f);
                glTexCoord2f(0,20);glVertex3f(-200.74f,-200.5f,-200.4f);
                //----------------------------
                 glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(-200.74f,200.39f,200.4f);
                glTexCoord2f(20,0);glVertex3f(200.71f,200.39f,200.4f);
                glTexCoord2f(20,20);glVertex3f(200.71f,-200.5f,200.4f);
                glTexCoord2f(0,20);glVertex3f(-200.74f,-200.5f,200.4f);
                //----------------------------
                glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(200.0f,200.43f,200.3f);
                glTexCoord2f(20,0);glVertex3f(200.f,200.43f,-200.3f);
                glTexCoord2f(20,20);glVertex3f(200.05f,-200.5f,-200.3f);
                glTexCoord2f(0,20);glVertex3f(200.08f,-200.5f,200.3f);
                //----------------------------
                 glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(-200.0f,200.43f,200.3f);
                glTexCoord2f(20,0);glVertex3f(-200.f,200.43f,-200.3f);
                glTexCoord2f(20,20);glVertex3f(-200.05f,-200.5f,-200.3f);
                glTexCoord2f(0,20);glVertex3f(-200.08f,-200.5f,200.3f);
                //----------------------------
                 glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(200.0f,200.43f,200.3f);
                glTexCoord2f(20,0);glVertex3f(200.f,200.43f,-200.3f);
                glTexCoord2f(20,20);glVertex3f(-200.05f,200.5f,-200.3f);
                glTexCoord2f(0,20);glVertex3f(-200.08f,200.5f,200.3f);
                //----------------------------
                glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(200.0f,-200.43f,200.3f);
                glTexCoord2f(20,0);glVertex3f(200.f,-200.43f,-200.3f);
                glTexCoord2f(20,20);glVertex3f(-200.05f,-200.5f,-200.3f);
                glTexCoord2f(0,20);glVertex3f(-200.08f,-200.5f,200.3f);
                //----------------------------
                
                
            }
            
            tPuerta.bind();           
            glBegin(GL_QUADS);
            {
                glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(-200.74f,200.39f,-200.4f);
                glTexCoord2f(20,0);glVertex3f(200.71f,200.39f,-200.4f);
                glTexCoord2f(20,20);glVertex3f(200.71f,-200.5f,-200.4f);
                glTexCoord2f(0,20);glVertex3f(-200.74f,-200.5f,-200.4f);
                //----------------------------
                 glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(-200.74f,200.39f,200.4f);
                glTexCoord2f(20,0);glVertex3f(200.71f,200.39f,200.4f);
                glTexCoord2f(20,20);glVertex3f(200.71f,-200.5f,200.4f);
                glTexCoord2f(0,20);glVertex3f(-200.74f,-200.5f,200.4f);
                //----------------------------
                glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(200.0f,200.43f,200.3f);
                glTexCoord2f(20,0);glVertex3f(200.f,200.43f,-200.3f);
                glTexCoord2f(20,20);glVertex3f(200.05f,-200.5f,-200.3f);
                glTexCoord2f(0,20);glVertex3f(200.08f,-200.5f,200.3f);
                //----------------------------
                 glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(-200.0f,200.43f,200.3f);
                glTexCoord2f(20,0);glVertex3f(-200.f,200.43f,-200.3f);
                glTexCoord2f(20,20);glVertex3f(-200.05f,-200.5f,-200.3f);
                glTexCoord2f(0,20);glVertex3f(-200.08f,-200.5f,200.3f);
                //----------------------------
                 glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(200.0f,200.43f,200.3f);
                glTexCoord2f(20,0);glVertex3f(200.f,200.43f,-200.3f);
                glTexCoord2f(20,20);glVertex3f(-200.05f,200.5f,-200.3f);
                glTexCoord2f(0,20);glVertex3f(-200.08f,200.5f,200.3f);
                //----------------------------
                glNormal3f(1,1,1f);
                glTexCoord2f(0,0);glVertex3f(200.0f,-200.43f,200.3f);
                glTexCoord2f(20,0);glVertex3f(200.f,-200.43f,-200.3f);
                glTexCoord2f(20,20);glVertex3f(-200.05f,-200.5f,-200.3f);
                glTexCoord2f(0,20);glVertex3f(-200.08f,-200.5f,200.3f);
                //----------------------------
                
                
            }
                  glEnd(); 
                  

            //System.out.println(pInZ+" - "+(pInZ-1)+" - "+pInX+" - "+(pInX-1));
            glTranslatef(0,0,0);           
            dibujarParedes(1);
           
            
            glTranslatef(0.05f,-0.9f,2.2f);
            dibujarParedes(1);
           
            glRotatef(-90,0.0f,90.0f,0.0f);
            glTranslatef(-1.9f,-0.9f,-1.55f);
            dibujarParedes(1);
           
            glTranslatef(0.05f,-0.9f,-1.5f);
            dibujarParedes(1);
            
            glTranslatef(0.05f,-0.9f,-1.5f);
            dibujarParedes(1);
            
            glRotatef(-90,0.0f,5.0f,0.0f);
            glTranslatef(-0.09f,-0.9f,-1.55f);
            dibujarParedes(1);
            
             
            glTranslatef(0.05f,-0.9f,-1.5f);
            dibujarParedes(1);
            
           
            glRotatef(-90,0.0f,5.0f,0.0f);
            glTranslatef(-0.1f,-0.9f,-1.6f);
            dibujarParedes(1);
            
            glTranslatef(0.15f,-0.9f,-3.31f);
            dibujarParedes(1);
             
            /*glEnable(GL11.GL_LIGHTING);///luz de l techo
            glEnable(GL11.GL_LIGHT0);*/
            glRotatef(-180f,0f,90f,0f);
            glRotatef(55f,0f,0f,-8f);
            glTranslatef(-2.15f,0.27f,2.0f);
            glTranslatef(-0.03f,-0.2f,2.5f);
            glTranslatef(-0.6f,-2.52f,-5.75f);
            
            dibujarParedGrande();
            
            
           
            glTranslatef(0f,0f,-2.0f);
            dibujarParedGrande();
            
            glTranslatef(0f,0f,-2.0f);
            dibujarParedGrande();
            /*glDisable(GL11.GL_LIGHTING);*/
           
            
            glRotatef(70f,0f,0f,-5.8f);
            glTranslatef(-1.85f,1.15f,4f);
            dibujarParedGrande();
            
            
            
            
            glTranslatef(0f,0f,-2f);
            dibujarParedGrande();
            glTranslatef(0f,0f,-2f);
            dibujarParedGrande();
            
           
            glRotatef(90f,0f,8f,0f);
            glRotatef(235f,8f,0f,0f);
            glTranslatef(-5.45f,-1.15f,-0.43f);
            dibujarTriangulo();
            
             
            glTranslatef(5.9f,0f,0f);
            dibujarTriangulo();
       
           
            glRotatef(90f,0f,1f,0f);
            glTranslatef(-1.95f,-1.46f,-3.25f);            
            dibujarCanaleta();
            
            glTranslatef(0.0f,0.0f,0.1f);            
            dibujarCanaleta();
            
            
            
            
            
            /*
            glRotatef(-40f,0f,2f,0f);
            glTranslatef(-0.95f,-3.3f,-0.28f);
            //glTranslatef(1.45f,-3.3f,1.5f);
            dibujarCanaletaLarga();
            
            
            
            
             glTranslatef(3.05f,0f,-2.53f);
            //glTranslatef(1.45f,-3.3f,1.5f);
            dibujarCanaletaLarga();]*/
            //dibujarParedGrandeVentanaPequeñaMosaico(1);
            controles();
            Display.update();
        }
    }
public static void dibujarParedGrande(){
    Texture tParedroja=loadTexture("paredroja");
    tParedroja.bind();                                  
        glBegin(GL_QUADS);
        
         //CARA izquierda
        //glColor3f(0,0.5,0);
        glNormal3f(0,0,0.5f);
            glTexCoord2d(0,0);glVertex3f(0.025f,1.95f,1.5f);
            glTexCoord2d(0,1); glVertex3f(0.025f,-0.5f,1.5f);
            glTexCoord2d(1,1);glVertex3f(0.025f,-0.5f,-0.5f);
            glTexCoord2d(1,0);glVertex3f(0.025f,1.95f,-0.5f);
         //CARA derecha
         //glColor3f(0.5,0.5,0.5);
         glNormal3f(0,0,0.8f);
            glTexCoord2d(0,0);glVertex3f(-0.025f,1.95f,1.5f);
            glTexCoord2d(0,1); glVertex3f(-0.025f,-0.5f,1.5f);
            glTexCoord2d(1,1);glVertex3f(-0.025f,-0.5f,-0.5f);
            glTexCoord2d(1,0);glVertex3f(-0.025f,1.95f,-0.5f);
        
        //cara frontal
        //glColor3f(0.5,0.5,0.5); 
        
           glNormal3f(0,0,1);            
                glTexCoord2d(0,0);glVertex3f(-0.025f,-0.5f,1.5f);
                glTexCoord2d(0,1);glVertex3f(0.025f,-0.5f,1.5f);
                glTexCoord2d(1,1);glVertex3f(0.025f,1.5f,1.5f);
                glTexCoord2d(1,0);glVertex3f(-0.025f,1.5f, 1.5f);                  
        //CARA POSTERIOR                                         
        glNormal3f(0,0,-1);
            glTexCoord2d(0,0);glVertex3f(-0.025f,-0.5f,-0.5f);
            glTexCoord2d(0,1);glVertex3f(0.025f,-0.5f,-0.5f);
            glTexCoord2d(1,1);glVertex3f(0.025f,1.5f,-0.5f);
            glTexCoord2d(1,0);glVertex3f(-0.025f,1.5f, -0.5f);           
            //CARA superior
        glNormal3f(0,1,0);
        //glColor3f(0.5,0.5,0);        
            glTexCoord2d(0,0);glVertex3f(-0.025f,1.8f,1.5f);
            glTexCoord2d(0,1);glVertex3f(0.025f,1.8f,1.5f);
            glTexCoord2d(1,1);glVertex3f(0.025f,1.8f,-0.5f);
            glTexCoord2d(1,0);glVertex3f(-0.025f,1.8f, -0.5f);
       
        //CARA inferior
        /* // glColor3f(0.5,0,0.5);
        glNormal3f(0,-1,0);
        glTexCoord2d(0,0);glVertex3f(-size/9,-0.5,0.5);
        glTexCoord2d(0,1);glVertex3f(size/9,-0.5,0.5);
        glTexCoord2d(1,1);glVertex3f(size/9,-0.5,-0.5);
        glTexCoord2d(1,0);glVertex3f(-size/9,-0.5, -0.5); */
        
        glEnd();
        
        
    }
public static void dibujarCanaleta(){
    Texture tParedamarillo=loadTexture("paredlamina");
    Texture tParedpiedra=loadTexture("paredlamina");
     glEnable(GL11.GL_LIGHTING);
    tParedamarillo.bind();                                  
    glBegin(GL_QUADS);        
         //CARA izquierda
        //glColor3f(0,0.5,0);
        glNormal3f(0,2,1f);
            glTexCoord2d(0,0);glVertex3f(0.025f,1.5f,-0.48f);
            glTexCoord2d(0,1); glVertex3f(0.025f,-0.5f,-0.48f);
            glTexCoord2d(1,1);glVertex3f(0.025f,-0.5f,-0.5f);
            glTexCoord2d(1,0);glVertex3f(0.025f,1.5f,-0.5f);  

            
            glEnd();
          glDisable(GL11.GL_LIGHTING);   
        tParedpiedra.bind();                                  
        glBegin(GL_QUADS);
            glTexCoord2d(0,0);glVertex3f(0.01f,1.5f,-0.46f);
            glTexCoord2d(0,1); glVertex3f(0.01f,-0.5f,-0.46f);
            glTexCoord2d(1,1);glVertex3f(0.025f,-0.5f,-0.48f);
            glTexCoord2d(1,0);glVertex3f(0.025f,1.5f,-0.48f);                         
        glEnd();
        
        
        tParedamarillo.bind();                                  
        glBegin(GL_QUADS);
            glTexCoord2d(0,0);glVertex3f(-0.02f,1.5f,-0.44f);
            glTexCoord2d(0,1); glVertex3f(-0.02f,-0.5f,-0.44f);
            glTexCoord2d(1,1);glVertex3f(0.01f,-0.5f,-0.46f);
            glTexCoord2d(1,0);glVertex3f(0.01f,1.5f,-0.46f);                         
        glEnd();
        
        
        
        tParedpiedra.bind();                                  
        glBegin(GL_QUADS);
            glTexCoord2d(0,0);glVertex3f(-0.045f,1.5f,-0.435f);
            glTexCoord2d(0,1); glVertex3f(-0.045f,-0.5f,-0.435f);
            glTexCoord2d(1,1);glVertex3f(-0.02f,-0.5f,-0.44f);
            glTexCoord2d(1,0);glVertex3f(-0.02f,1.5f,-0.44f);                         
        glEnd();
        
        
        
        //ladocontrario
        tParedpiedra.bind();                                  
        glBegin(GL_QUADS);
            glTexCoord2d(0,0);glVertex3f(0.01f,1.5f,-0.52f);
            glTexCoord2d(0,1); glVertex3f(0.01f,-0.5f,-0.52f);
            glTexCoord2d(1,1);glVertex3f(0.025f,-0.5f,-0.5f);
            glTexCoord2d(1,0);glVertex3f(0.025f,1.5f,-0.5f);                         
        glEnd();
        
        
        tParedamarillo.bind();                                  
        glBegin(GL_QUADS);
            glTexCoord2d(0,0);glVertex3f(-0.02f,1.5f,-0.54f);
            glTexCoord2d(0,1); glVertex3f(-0.02f,-0.5f,-0.54f);
            glTexCoord2d(1,1);glVertex3f(0.01f,-0.5f,-0.52f);
            glTexCoord2d(1,0);glVertex3f(0.01f,1.5f,-0.52f);                         
        glEnd();
        
        
        
        tParedpiedra.bind();                                  
        glBegin(GL_QUADS);
            glTexCoord2d(0,0);glVertex3f(-0.045f,1.5f,-0.555f);
            glTexCoord2d(0,1); glVertex3f(-0.045f,-0.5f,-0.555f);
            glTexCoord2d(1,1);glVertex3f(-0.02f,-0.5f,-0.54f);
            glTexCoord2d(1,0);glVertex3f(-0.02f,1.5f,-0.54f);                         
        glEnd();
        
        
    }


public static void dibujarTriangulo(){
    Texture tParedroja=loadTexture("paredroja");
    tParedroja.bind();                                  
        glBegin(GL_QUADS);
        
        //CARA izquierda
        //glColor3f(0,0.5,0);
        glNormal3f(1,0,1);
            glTexCoord2d(0,0);glVertex3f(0.025f,0.0f,2.0f);
            glTexCoord2d(0,1); glVertex3f(0.025f,0.0f,-2.0f);
            glTexCoord2d(1,1);glVertex3f(0.025f,1.4f,0.0f);
            glTexCoord2d(1,0);glVertex3f(0.025f,1.4f,0.0f);
         //CARA derecha
         //glColor3f(0.5,0.5,0.5);
         glNormal3f(1,0,1);
         glTexCoord2d(0,0);glVertex3f(-0.025f,0.0f,2.0f);
            glTexCoord2d(0,1); glVertex3f(-0.025f,0.0f,-2.0f);
            glTexCoord2d(1,1);glVertex3f(-0.025f,1.4f,0.0f);
            glTexCoord2d(1,0);glVertex3f(-0.025f,1.4f,0.0f);
        glEnd();
        
        
    }
public static void dibujarParedes(float size){
    Texture tParedrojo=loadTexture("paredroja");
    Texture tParedblanca=loadTexture("paredblanca"); 
    Texture tParedazul=loadTexture("paredazul"); 
    Texture tParednegro=loadTexture("parednegro"); 
     Texture tParedCP=loadTexture("cuadropeque"); 
     Texture tParedCP2=loadTexture("marcoventana"); 
     Texture tParedCP3=loadTexture("marcoventanah");
     tParedblanca.bind();
    glBegin(GL_QUADS);
    //cara frontal
    //glColor3f(size/2,size/2,size/2);
   
    
    
    //CARA superior
    
    //glColor3f(size/2,size/2,0);
    
    

    //CARA izquierda
    //glColor3f(0,size/2,0);
    glNormal3f(0,1,5);
    glTexCoord2d(0,0);glVertex3f(size/40,1.5f,1.5f);
    glTexCoord2d(0,1); glVertex3f(size/40,1.5f,-0.5f);
    glTexCoord2d(1,1);glVertex3f(size/40,1.3f,-0.5f);
    glTexCoord2d(1,0);glVertex3f(size/40,1.3f,1.5f);
    //CARA derecha
    //glColor3f(size/2,size/2,size/2);
    glNormal3f(0,1,4);
    glTexCoord2d(0,0);glVertex3f(-size/40,1.5f,1.5f);
    glTexCoord2d(0,1); glVertex3f(-size/40,1.5f,-0.5f);
    glTexCoord2d(1,1);glVertex3f(-size/40,1.3f,-0.5f);
    glTexCoord2d(1,0);glVertex3f(-size/40,1.3f,1.5f);
    
        //lado de abajo

        //cara frontal
        //glColor3f(size/2,size/2,size/2);        
           glNormal3f(1,0,1);            
                glTexCoord2d(0,0);glVertex3f(-size/40,-size/2,1.5f);
                glTexCoord2d(0,1);glVertex3f(size/40,-size/2,1.5f);
                glTexCoord2d(1,1);glVertex3f(size/40,0.2f,1.5f);
                glTexCoord2d(1,0);glVertex3f(-size/40,0.2f,1.5f);
                  
        //CARA POSTERIOR                                         
        glNormal3f(0,1,1);
            glTexCoord2d(0,0);glVertex3f(-size/40,-size/2,-0.5f);
            glTexCoord2d(0,1);glVertex3f(size/40,-size/2,-0.5f);
            glTexCoord2d(1,1);glVertex3f(size/40,0.2f,-0.5f);
            glTexCoord2d(1,0);glVertex3f(-size/40,0.2f, -0.5f);
           
            //CARA superior
        glNormal3f(0,1,1);
        //glColor3f(size/2,size/2,0);        
            glTexCoord2d(0,0);glVertex3f(-size/40,0.2f,1.5f);
            glTexCoord2d(0,1);glVertex3f(size/40,0.2f,1.5f);
            glTexCoord2d(1,1);glVertex3f(size/40,0.2f,-0.5f);
            glTexCoord2d(1,0);glVertex3f(-size/40,0.2f, -0.5f);
        //CARA izquierda
        //glColor3f(0,size/2,0);       
        glNormal3f(0,0,5);
            glTexCoord2d(0,0);glVertex3f(size/40,0.2f,1.5f);
            glTexCoord2d(0,1); glVertex3f(size/40,0.2f,-0.5f);
            glTexCoord2d(1,1);glVertex3f(size/40,-size/2,-0.5f);
            glTexCoord2d(1,0);glVertex3f(size/40,-size/2, 1.5f);    
         //CARA derecha
         //glColor3f(size/2,size/2,size/2);
         glNormal3f(0,0,5);
            glTexCoord2d(0,0);glVertex3f(-size/40,0.2f,1.5f);
            glTexCoord2d(0,1); glVertex3f(-size/40,0.2f,-0.5f);
            glTexCoord2d(1,1);glVertex3f(-size/40,-size/2,-0.5f);
            glTexCoord2d(1,0);glVertex3f(-size/40,-size/2, 1.5f);
        
        //ladoderecho de ventana
        //cara frontal
        //glColor3f(size/2,size/2,size/2);        
                                                     
      
        //CARA izquierda
        //glColor3f(0,size/2,0);       
 
        
             
         //CARA derecha
         //glColor3f(size/2,size/2,size/2);
         glNormal3f(0,0,5);
            glTexCoord2d(0,0);glVertex3f(-size/40,1.3f,-0.5f);
            glTexCoord2d(0,1); glVertex3f(-size/40,1.3f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(-size/40,-size/2,-0.1f);
            glTexCoord2d(1,0);glVertex3f(-size/40,-size/2,-0.5f);
        
            ///culomna is¿zquierade la ventana--------------------------------------------------------------------------
        glNormal3f(0,0,5);
            glTexCoord2d(0,0);glVertex3f(size/40,1.3f,1.5f);
            glTexCoord2d(0,1); glVertex3f(size/40,1.3f,1.1f);
            glTexCoord2d(1,1);glVertex3f(size/40,-size/2,1.1f);
            glTexCoord2d(1,0);glVertex3f(size/40,-size/2,1.5f);
             
         //CARA derecha
         
         //glColor3f(size/2,size/2,size/2);
         glNormal3f(0,0,5);
            glTexCoord2d(0,0);glVertex3f(-size/40,1.3f,1.5f);
            glTexCoord2d(0,1); glVertex3f(-size/40,1.3f,1.1f);
            glTexCoord2d(1,1);glVertex3f(-size/40,-size/2,1.1f);
            glTexCoord2d(1,0);glVertex3f(-size/40,-size/2,1.5f);
        
            
             glEnd();
             tParedazul.bind();
            glBegin(GL_QUADS);
             //rejilla de ventana
             
             
             float valY1=0.35f;
             float valY2=0.355f;
             float valZ1=1.0f;
             float valZ2=0.995f;
             for(int x=0;x<40;x++){
                 glTexCoord2d(0,0);glVertex3f(0,0.25f,valZ1);
                glTexCoord2d(0,1); glVertex3f(0,0.25f,valZ2);
                glTexCoord2d(1,1);glVertex3f(0,valY1,1.1f);
                glTexCoord2d(1,0);glVertex3f(0,valY2,1.1f);
                
               valY1+=0.025f;
               valY2+=0.025f;
               valZ1-=0.025f;
               valZ2-=0.025f;
             }
             valY1=1.35f;
             valY2=1.355f;
             valZ1=0.0f;
              valZ2=0.005f;
             for(int x=0;x<49;x++){
                 glTexCoord2d(0,0);glVertex3f(0,1.45f,valZ1);
                glTexCoord2d(0,1); glVertex3f(0,1.45f,valZ2);
                glTexCoord2d(1,1);glVertex3f(0,valY1,-0.1f);
                glTexCoord2d(1,0);glVertex3f(0,valY2,-0.1f);
                
               valY1-=0.025f;
               valY2-=0.025f;
               valZ1+=0.025f;
               valZ2+=0.025f;
             }
             //comeltar ventana
             valY1=0.35f;
             valY2=0.355f;
             valZ1=0.0f;
             valZ2=0.005f;
             
             for(int x=0;x<40;x++){
                 glTexCoord2d(0,0);glVertex3f(0,0.25f,valZ1);
                glTexCoord2d(0,1); glVertex3f(0,0.25f,valZ2);
                glTexCoord2d(1,1);glVertex3f(0,valY1,-0.1f);
                glTexCoord2d(1,0);glVertex3f(0,valY2,-0.1f);
                
               valY1+=0.025f;
               valY2+=0.025f;
               valZ1+=0.025f;
               valZ2+=0.025f;
             }
             valY1=1.35f;
             valY2=1.355f;
             valZ1=1.0f;
              valZ2=0.995f;
             for(int x=0;x<49;x++){
                 glTexCoord2d(0,0);glVertex3f(0,1.45f,valZ1);
                glTexCoord2d(0,1); glVertex3f(0,1.45f,valZ2);
                glTexCoord2d(1,1);glVertex3f(0,valY1,1.1f);
                glTexCoord2d(1,0);glVertex3f(0,valY2,1.1f);
                
               valY1-=0.025f;
               valY2-=0.025f;
               valZ1-=0.025f;
               valZ2-=0.025f;
             }
             glEnd();
             
            //Marco de ventana
            //Lados de atras
           
            //lados horizontales
            //GL11.glRotatef(90f, 0.0f, 0.1f,0.0f);
            tParedCP3.bind();
            glBegin(GL_QUADS);  
            glNormal3f(2,8,5);
            glTexCoord2d(0,0);glVertex3f(0.0255f,1.3f,1.1f);
            glTexCoord2d(0,1); glVertex3f(0.0255f,1.3f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(0.0255f,1.24f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(0.0255f,1.24f,1.1f);
            
            
             glTexCoord2d(0,0);glVertex3f(size/45,0.2f,1.1f);
            glTexCoord2d(0,1); glVertex3f(size/45,0.2f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(size/45,0.26f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.26f,1.1f);
            
            
             glTexCoord2d(0,0);glVertex3f(size/45,0.72f,1.1f);
            glTexCoord2d(0,1); glVertex3f(size/45,0.72f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(size/45,0.79f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.79f,1.1f);
     
            glEnd();
            
            
            tParedrojo.bind();
            glBegin(GL_QUADS);
            //lado izqueirdo
            glTexCoord2d(0,0);glVertex3f(-size/45,1.3f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-size/45,1.3f,1.04f);
            glTexCoord2d(1,1);glVertex3f(-size/45,0.2f,1.04f);
            glTexCoord2d(1,0);glVertex3f(-size/45,0.2f,1.1f);
            
            
            //enfrente
            
            
            
            glTexCoord2d(0,0);glVertex3f(size/45,1.3f,1.04f);
            glTexCoord2d(0,1); glVertex3f(-size/45,1.3f,1.04f);
            glTexCoord2d(1,1);glVertex3f(-size/45,0.2f,1.04f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.2f,1.04f);
            //lado derecho
            glTexCoord2d(0,0);glVertex3f(-size/45,1.3f,-0.1f);
            glTexCoord2d(0,1); glVertex3f(-size/45,1.3f,-0.04f);
            glTexCoord2d(1,1);glVertex3f(-size/45,0.2f,-0.04f);
            glTexCoord2d(1,0);glVertex3f(-size/45,0.2f,-0.1f);
            //enfrente
            
            
            glTexCoord2d(0,0);glVertex3f(size/45,1.3f,-0.04f);
            glTexCoord2d(0,1); glVertex3f(-size/45,1.3f,-0.04f);
            glTexCoord2d(1,1);glVertex3f(-size/45,0.2f,-0.04f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.2f,-0.04f);
            //lado derechoenmedio
            glTexCoord2d(0,0);glVertex3f(-size/45,1.3f,0.47f);
            glTexCoord2d(0,1); glVertex3f(-size/45,1.3f,0.53f);
            glTexCoord2d(1,1);glVertex3f(-size/45,0.2f,0.53f);
            glTexCoord2d(1,0);glVertex3f(-size/45,0.2f,0.47f);
            
            //enfrente
                                    
            
            
            glTexCoord2d(0,0);glVertex3f(size/45,1.3f,0.53f);
            glTexCoord2d(0,1); glVertex3f(-size/45,1.3f,0.53f);
            glTexCoord2d(1,1);glVertex3f(-size/45,0.2f,0.53f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.2f,0.53f); 
            
             glTexCoord2d(0,0);glVertex3f(size/45,1.3f,0.47f);
            glTexCoord2d(0,1); glVertex3f(-size/45,1.3f,0.47f);
            glTexCoord2d(1,1);glVertex3f(-size/45,0.2f,0.47f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.2f,0.47f);
            //lado superior
             glTexCoord2d(0,0);glVertex3f(-size/45,1.3f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-size/45,1.3f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(-size/45,1.24f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(-size/45,1.24f,1.1f);
            //enfrente
             
            
            glTexCoord2d(0,0);glVertex3f(-size/45,1.24f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-size/45,1.24f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(size/45,1.24f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(size/45,1.24f,1.1f);
            
            //lado inferior
             glTexCoord2d(0,0);glVertex3f(-size/45,0.2f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-size/45,0.2f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(-size/45,0.26f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(-size/45,0.26f,1.1f);
            //enfrente
            
            
            glTexCoord2d(0,0);glVertex3f(-size/45,0.26f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-size/45,0.26f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(size/45,0.26f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.26f,1.1f);
            
            //lado inferior enmedio
             glTexCoord2d(0,0);glVertex3f(-size/45,0.72f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-size/45,0.72f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(-size/45,0.79f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(-size/45,0.79f,1.1f);
            
            glTexCoord2d(0,0);glVertex3f(-size/45,0.79f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-size/45,0.79f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(size/45,0.79f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.79f,1.1f);
            
            glTexCoord2d(0,0);glVertex3f(-size/45,0.72f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-size/45,0.72f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(size/45,0.72f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.72f,1.1f);
            
            
            //enfrente
            
            
            
           tParedrojo.bind();
            glBegin(GL_QUADS);                   
            //cuadrospequeños de abajo
             glTexCoord2d(0,0);glVertex3f(-0.026f,0.15f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-0.026f,0.1f,1.1f);
            glTexCoord2d(1,1);glVertex3f(-0.026f,0.1f,0.99f);
            glTexCoord2d(1,0);glVertex3f(-0.026f,0.15f,0.99f);
            //enfrente
            glTexCoord2d(0,0);glVertex3f(-0.026f,0.15f,-0.11f);
            glTexCoord2d(0,1); glVertex3f(-0.026f,0.1f,-0.11f);
            glTexCoord2d(1,1);glVertex3f(-0.026f,0.1f,0.0f);
            glTexCoord2d(1,0);glVertex3f(-0.026f,0.15f,0.0f);
            glEnd();  
             tParedCP.bind();
            glBegin(GL_QUADS);                   
            //cuadrospequeños de abajo
             glTexCoord2d(0,0);glVertex3f(0.026f,0.15f,1.1f);
            glTexCoord2d(0,1); glVertex3f(0.026f,0.1f,1.1f);
            glTexCoord2d(1,1);glVertex3f(0.026f,0.1f,0.99f);
            glTexCoord2d(1,0);glVertex3f(0.026f,0.15f,0.99f);
            //enfrente
            glTexCoord2d(0,0);glVertex3f(0.026f,0.15f,-0.11f);
            glTexCoord2d(0,1); glVertex3f(0.026f,0.1f,-0.11f);
            glTexCoord2d(1,1);glVertex3f(0.026f,0.1f,0.0f);
            glTexCoord2d(1,0);glVertex3f(0.026f,0.15f,0.0f);
            glEnd();
             //cilindro
                 
             
             glRotatef(90f,1f,0f,0f);           
            glTranslatef(-0.054f,-0.4f,-0.895f);
           //dibujarCailindro();
            glRotatef(-90f,1f,0f,0f);
            glTranslatef(0f,0f,0f);
            /*    float incAlt1 = 1.3270833f;
            float incAlt2=1.315f;
            float incAnc1=-0.063f;
            float incAnc2=-0.05684f;
            for(int x=0;x<13;x++){
            glTexCoord2d(0,0);glVertex3f(incAnc1,incAlt2,1.1f);
            glTexCoord2d(0,1); glVertex3f(incAnc1,incAlt2,-0.1f);
            glTexCoord2d(1,1);glVertex3f(incAnc2,incAlt1,-0.1f);
            glTexCoord2d(1,0);glVertex3f(incAnc2,incAlt1,1.1f);
            
            
            incAlt1 += 0.0120833f;
            incAlt2+=0.0120833f;d
            
            }*/
            
            
            
            /* tParednegro.bind();
            glBegin(GL_QUADS);
            glTexCoord2d(0,0);glVertex3f(-0.026f,1.4f,1.1f);
            glTexCoord2d(0,1); glVertex3f(-0.026f,1.485f,-0.1f);
            glTexCoord2d(1,1);glVertex3f(-0.03f,1.495f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(-0.03f,1.495f,1.1f);
            glEnd();*/
            /* tParedazul.bind();
            glBegin(GL_QUADS);
            glTexCoord2d(0,0);glVertex3f(size/45,1.24f,1.04f);
            glTexCoord2d(0,1); glVertex3f(size/45,1.24f,1.035f);
            glTexCoord2d(1,1);glVertex3f(size/45,0.2f,-0.1f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.2f,-0.095f);
            
            glTexCoord2d(0,0);glVertex3f(size/45,1.22f,1.035f);
            glTexCoord2d(0,1); glVertex3f(size/45,1.22f,1.03f);
            glTexCoord2d(1,1);glVertex3f(size/45,0.18f,-0.095f);
            glTexCoord2d(1,0);glVertex3f(size/45,0.18f,-0.085f);
            
            
            glEnd();*/
        
        
        
        
    }

public static void controles() {
        
        
        boolean forward=Keyboard.isKeyDown(Keyboard.KEY_W);
        boolean backward=Keyboard.isKeyDown(Keyboard.KEY_S);
        boolean left=Keyboard.isKeyDown(Keyboard.KEY_A);
        boolean right=Keyboard.isKeyDown(Keyboard.KEY_D);
        
        boolean up=Keyboard.isKeyDown(Keyboard.KEY_E);
        boolean donw=Keyboard.isKeyDown(Keyboard.KEY_C);
        
        float mx= Mouse.getDX();
        float my= Mouse.getDY();
        
        mx*=0.10f;
        my*=0.10f;
        
        if(Mouse.isButtonDown(0)){
            cam.rotateY(mx);
            cam.rotateX(-my);
        }
        
        if(forward){ 
            cam.moveZ(0.99f); 
           if (cam.ValidaPared()==true)
                cam.moveZ(-0.99f); 
    
            
        }
        if(backward){
            /* for(int g=0;g<corDispZ.size();g+=2){
            //System.out.println((cam.getZ()+Math.sin(Math.toRadians(cam.getRy()+90)))+""+corDispZ.get(g+1));
            if((cam.getZ()-Math.sin(Math.toRadians(cam.getRy()+90)))<corDispZ.get(g) && (cam.getZ()-Math.sin(Math.toRadians(cam.getRy()+90)))>corDispZ.get(g+1)){
            cam.moveZ(0.009f);
            }
            }*/
            cam.moveZ(-0.99f);
            if (cam.ValidaPared()==true)
                cam.moveZ(0.99f); 
            
        }
        if(left){
            cam.moveX(0.99f);
            if (cam.ValidaPared()==true)
                cam.moveX(-0.99f); 
        }
        if(right){
            cam.moveX(-0.99f);
            if (cam.ValidaPared()==true)
                cam.moveX(0.99f); 
        }
        if(up){
        /*if(cam.getY()>=0)return;*/
        cam.moveY(0.99f);
        if (cam.ValidaPared()==true)
                cam.moveY(-0.99f); 
        }
        if(donw){
        cam.moveY(-0.99f);
        if (cam.ValidaPared()==true)
                cam.moveY(+0.99f); 
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)) {
            cleanUp();
        }
        
    }
    public static void cleanUp() {
        Display.destroy();
        System.exit(0);
    }
    public static void initDisplay() {
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.setTitle("Laberinto en openGL. Lwjgl: " + Sys.getVersion());
            Display.create();
        } catch (LWJGLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ProyectoFinal.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }
    public static Texture loadTexture(String key) {
        try {
            return TextureLoader.getTexture("png", new FileInputStream(
                    new File("res/" + key + ".png")));

        } catch (IOException ex) {
            Logger.getLogger(ProyectoFinal.class
                    .getName()).log(
                            Level.SEVERE, null, ex);
        }
        return null;
    }
    public static FloatBuffer asFloatBuffer(float[] arreglo) {
        FloatBuffer fb = BufferUtils.createFloatBuffer(arreglo.length);
        fb.put(arreglo);
        fb.flip();
        return fb;
    }
    public static IntBuffer asIntBuffer(int[] arreglo) {
        IntBuffer ib = BufferUtils.createIntBuffer(arreglo.length);
        ib.put(arreglo);
        ib.flip();
        return ib;
    }
}
