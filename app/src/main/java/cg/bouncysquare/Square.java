package cg.bouncysquare;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

public class Square {

    private FloatBuffer mFVertexBuffer;
    private ByteBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;

    public Square() {
        float vertices[] =
                {
                        -2.0f, -1.0f,
                        1.0f, -1.0f,
                        -1.0f, 1.0f,
                        1.0f, 1.0f
                };

        byte maxColor=(byte)255;
        byte colors[] =
                {
                        // initial red color
                        /*
                        0, 0, 0, maxColor,
                        maxColor, 0, 0, maxColor,
                        0, 0, 0, maxColor,
                        maxColor, 0, 0, maxColor,
                         */

                        // green color
                       /*
                        0, maxColor, 0, maxColor,
                        0, maxColor, 0, maxColor,
                        0, maxColor, 0, maxColor,
                        0, maxColor, 0, maxColor,
                        */

                        // blue color
                        0, 0, maxColor, maxColor,
                        0, 0, maxColor, maxColor,
                        0, 0, maxColor, maxColor,
                        0, 0, maxColor, maxColor,
                };

        byte indices[] =
                {
                        0, 3, 1,
                        0, 2, 3
                };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());

        mFVertexBuffer = vbb.asFloatBuffer();
        mFVertexBuffer.put(vertices);
        mFVertexBuffer.position(0);

        mColorBuffer = ByteBuffer.allocateDirect(colors.length);
        mColorBuffer.put(colors);
        mColorBuffer.position(0);

        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);

    }

    public void draw(GL10 gl) {

        gl.glVertexPointer(2, GL11.GL_FLOAT, 0, mFVertexBuffer);
        gl.glColorPointer(4, GL11.GL_UNSIGNED_BYTE, 0, mColorBuffer);
        //gl.glDrawElements(GL11.GL_TRIANGLES, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);
        //gl.glDrawElements(GL11.GL_POINTS, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);
        //gl.glDrawElements(GL11.GL_LINE_STRIP, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);
        //gl.glDrawElements(GL11.GL_LINE_LOOP, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);
        //gl.glDrawElements(GL11.GL_LINES, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);
        gl.glDrawElements(GL11.GL_TRIANGLE_STRIP, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);
        //gl.glDrawElements(GL11.GL_TRIANGLE_FAN, 6, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);

        gl.glFrontFace(GL11.GL_CW);
    }
}
