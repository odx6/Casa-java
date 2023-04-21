package futuroingeniero;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.util.glu.GLU.*;

/**
 *
 * @author tauro
 */
public class Camera {
    
    private float x,y,z,rx,ry,rz;//variabless para movernos en el espacio 3d
    private float fov   ,aspect,near,far;
    
    public Camera(float fov   ,float aspect,float near,float far){
        x=-3f;
        y=0;
        z=-7.5f;               
        rx=0;
        ry=0;
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
