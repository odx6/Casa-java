package futuroingeniero;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

/**
 *
 * @author Suleidy
 */
public class Vista {
    
    private float x,y,z,rx,ry,rz;//variabless para movernos en el espacio 3d
    private float fov   ,aspect,near,far;
    
    public Vista(float fov   ,float aspect,float near,float far){
        x=-4f;
        y=0;
        z=-8f;               
        rx=0;
        ry=-0;
        rz=0;
        
        this. fov=fov;
        this.aspect=aspect;
        this.near=near;
        this.far=far;
        
        initProjection();
    }

    private void initProjection(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        gluPerspective(fov, aspect, near, far);
        
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        
    }
    
    public void useView(){
        glRotatef(rx,1,0,0);
        glRotatef(ry,0,1,0);
        glRotatef(rz,0,0,1);
        glTranslatef(x,y,z);
    }
   
    public boolean estaColision(float x1,float y1,float z1){
      double  x2= Double.valueOf(x1-x);
       double y2=Double.valueOf(y1-y);
        double z2=Double.valueOf(z1-z);
       
        double distancia= Math.sqrt(Math.pow(x2,2)+Math.pow(y2,2)+Math.pow(z2,2));
        if (distancia<1){
            return true;
            
            
        }
        else{
            return false;
        }
        
    }
    
   public boolean ValidaPared(){
       float size=0.5f;
      float[] traslacionParedFrontal=new float []{0.05f,-0.9f,2.2f};
   float[][] ParedCaraFrontal=new float[][] {{-size/40,-size/2,1.5f},{size/40,-size/2,1.5f},{size/40,0.2f,1.5f},{-size/40,0.2f,1.5f}};
   for (float[] vertice:ParedCaraFrontal){
   vertice[0]=vertice[0]+traslacionParedFrontal[0];
   vertice[1]=vertice[1]+traslacionParedFrontal[1];
   vertice[2]=vertice[2]+traslacionParedFrontal[2];
   }
   boolean flag = false;
     //pared frontal der
     
     for (float[] vertice:ParedCaraFrontal){
   
      if(estaColision(vertice[0],vertice[1],vertice[2])) //getX()>=-4f && getX()<=-2f && getZ()<=-4.5f && getZ()>= -8f   -0.091f
     {
      flag=true;
      System.out.println("Pared!");
      
     }
     }
     
     
      
      
      
   return flag;

}

        
    public void moveX(float amt){
        
       z+=amt*Math.sin(Math.toRadians(ry));
       x+=amt*Math.cos(Math.toRadians(ry));
    }
    public void moveY(float amt){
        y+=amt;
    }
    public void moveZ(float amt){
        //aSystem.out.println(z+"---"+x);
        z+=amt*Math.sin(Math.toRadians(ry+90));
       x+=amt*Math.cos(Math.toRadians(ry+90));
    }
    public void rotateX(float amt){
        rx+=amt;
    }
    public void rotateY(float amt){
        ry+=amt;
    }
    public void rotateZ(float amt){
        rz+=amt;
    }
    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the z
     */
    public float getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(float z) {
        this.z = z;
    }

    /**
     * @return the rx
     */
    public float getRx() {
        return rx;
    }

    /**
     * @param rx the rx to set
     */
    public void setRx(float rx) {
        this.rx = rx;
    }

    /**
     * @return the ry
     */
    public float getRy() {
        return ry;
    }

    /**
     * @param ry the ry to set
     */
    public void setRy(float ry) {
        this.ry = ry;
    }

    /**
     * @return the rz
     */
    public float getRz() {
        return rz;
    }

    /**
     * @param rz the rz to set
     */
    public void setRz(float rz) {
        this.rz = rz;
    }
    
    
}
