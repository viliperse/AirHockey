package com.vilip22.airhockey.programs;

import android.content.Context;
import com.vilip22.airhockey.R;
import static android.opengl.GLES20.*;

/**
 * Created by klen on 20/04/16.
 */
public class ColorShaderProgram extends ShaderProgram {

    private final int uMatrixLocation;
    private final int uPointSizeLocation;

    private final int aPositionLocation;
    private final int aColorLocation;

    public ColorShaderProgram(Context context) {
        super(context, R.raw.simple_vertex_shader, R.raw.simple_fragment_shader);
        uMatrixLocation = glGetUniformLocation(program, U_MATRIX);
        uPointSizeLocation = glGetUniformLocation(program, U_POINT_SIZE);
        aPositionLocation = glGetAttribLocation(program, A_POSITION);
        aColorLocation = glGetAttribLocation(program, A_COLOR);
    }
    public void setUniforms(float[] matrix) {
        // Pass the matrix into the shader program.
        glUniformMatrix4fv(uMatrixLocation, 1, false, matrix, 0);
        glUniform1f(uPointSizeLocation, 20f);
    }

    public int getPositionAttributeLocation() {
        return aPositionLocation;
    }

    public int getColorAttributeLocation() {
        return aColorLocation;
    }
}
