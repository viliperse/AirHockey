package com.vilip22.airhockey.objects;

import com.vilip22.airhockey.Constants;
import com.vilip22.airhockey.data.VertexArray;
import com.vilip22.airhockey.programs.TextureShaderProgram;

import static android.opengl.GLES20.*;

public class Table {

    private static final int POSITION_COMPONENT_COUNT = 2;
    private static final int TEXTURE_COORDINATES_COMPONENT_COUNT = 2;
    private static final int STRIDE = (POSITION_COMPONENT_COUNT +
            TEXTURE_COORDINATES_COMPONENT_COUNT) * Constants.BYTES_PER_FLOAT;

    private static final float[] VERTEX_DATA = {
            // Order of coordinates: x, y, s, t
            0f, 0f, .5f, .5f,
            -.5f, -.8f, 0f, 0.9f,
            .5f, -.8f, 1f, .9f,
            .5f, .8f, 1f, .1f,
            -.5f, .8f, 0f, .1f,
            -.5f, -.8f, 0f, .9f
    };

    private final VertexArray vertexArray;

    public Table() {
        vertexArray = new VertexArray(VERTEX_DATA);
    }

    public void bindData(TextureShaderProgram textureProgram) {
        vertexArray.setVertexAttribPointer(
                0,
                textureProgram.getPositionAttributeLocation(),
                POSITION_COMPONENT_COUNT,
                STRIDE);

        vertexArray.setVertexAttribPointer(
                POSITION_COMPONENT_COUNT,
                textureProgram.getTextureCoordinatesAttributeLocation(),
                TEXTURE_COORDINATES_COMPONENT_COUNT,
                STRIDE);
    }

    public void draw() {
        glDrawArrays(GL_TRIANGLE_FAN, 0, 6);
    }

}
