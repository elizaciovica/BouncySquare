package cg.bouncysquare;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL11;

import android.opengl.GLSurfaceView;
import java.lang.Math;
import android.content.Context;

public class SquareRenderer implements  GLSurfaceView.Renderer {

    private final Context context;
    private Square mSquare;
    private float mTransY;

    public SquareRenderer(Context context) {
        this.context = context;
        this.mSquare = new Square();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        int reside = R.drawable.avengers;
        mSquare.createTexture(gl, this.context, reside);

        //gl.glDisable(GL10.GL_DITHER);
        gl.glEnable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);

        gl.glClearColor(0.3f,0.6f,0.7f,0.4f);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        float ratio = (float) width / height;
        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);

    }

    @Override
    public void onDrawFrame(GL10 gl) {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

        gl.glTranslatef(0.0f,(float)Math.sin(mTransY), -3.0f);
        mTransY += 0.075f;
        //mTransY += 0.3f;

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        mSquare.draw(gl);
    }
}
