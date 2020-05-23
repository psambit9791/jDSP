package com.github.psambit9791.jdsp;

import com.github.psambit9791.jdsp.transform.InverseDiscreteFourier;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class TestInverseDiscreteFourier {
    private double[][] seqComp= {{0.0, 0.0}, {0.01, -0.266}, {0.046, -0.588}, {0.131, -1.105}, {0.375, -2.367},
            {7.796, -39.196}, {-0.495, 2.061}, {0.042, -0.148}, {5.708, -17.567}, {-1.099, 2.98}, {-0.712, 1.718},
            {-0.586, 1.271}, {-0.521, 1.023}, {-0.483, 0.862}, {-0.458, 0.748}, {-0.438, 0.656}, {-0.427, 0.587},
            {-0.416, 0.528}, {-0.408, 0.478}, {-0.402, 0.435}, {-0.394, 0.394}, {-0.389, 0.36}, {-0.384, 0.328},
            {-0.381, 0.3}, {-0.383, 0.278}, {-0.378, 0.253}, {-0.378, 0.232}, {-0.372, 0.208}, {-0.376, 0.192},
            {-0.373, 0.172}, {-0.366, 0.152}, {-0.371, 0.137}, {-0.368, 0.12}, {-0.371, 0.105}, {-0.369, 0.089},
            {-0.368, 0.073}, {-0.364, 0.058}, {-0.366, 0.043}, {-0.365, 0.029}, {-0.366, 0.014}, {-0.36, 0.0},
            {-0.366, -0.014}, {-0.365, -0.029}, {-0.366, -0.043}, {-0.364, -0.058}, {-0.368, -0.073}, {-0.369, -0.089},
            {-0.371, -0.105}, {-0.368, -0.12}, {-0.371, -0.137}, {-0.366, -0.152}, {-0.373, -0.172}, {-0.376, -0.192},
            {-0.372, -0.208}, {-0.378, -0.232}, {-0.378, -0.253}, {-0.383, -0.278}, {-0.381, -0.3}, {-0.384, -0.328},
            {-0.389, -0.36}, {-0.394, -0.394}, {-0.402, -0.435}, {-0.408, -0.478}, {-0.416, -0.528}, {-0.427, -0.587},
            {-0.438, -0.656}, {-0.458, -0.748}, {-0.483, -0.862}, {-0.521, -1.023}, {-0.586, -1.271}, {-0.712, -1.718},
            {-1.099, -2.98}, {5.708, 17.567}, {0.042, 0.148}, {-0.495, -2.061}, {7.796, 39.196}, {0.375, 2.367},
            {0.131, 1.105}, {0.046, 0.588}, {0.01, 0.266}};

    private double[] seqReal = {0.0, 0.01, 0.046, 0.131, 0.375, 7.797, -0.495, 0.041, 5.708, -1.098, -0.712, -0.585,
            -0.522, -0.483, -0.457, -0.439, -0.426, -0.415, -0.407, -0.4, -0.395, -0.39, -0.386, -0.383, -0.381, -0.378,
            -0.376, -0.375, -0.373, -0.372, -0.371, -0.37, -0.369, -0.368, -0.368, -0.367, -0.367, -0.367, -0.366,
            -0.366, -0.366, -0.366, -0.366, -0.367, -0.367, -0.367, -0.368, -0.368, -0.369, -0.37, -0.371, -0.372,
            -0.373, -0.375, -0.376, -0.378, -0.381, -0.383, -0.386, -0.39, -0.395, -0.4, -0.407, -0.415, -0.426, -0.439,
            -0.457, -0.483, -0.522, -0.585, -0.712, -1.098, 5.708, 0.041, -0.495, 7.797, 0.375, 0.131, 0.046, 0.01};


    @Test
    public void testInverseFourierComplex() {
        double[] resultReal = {0.0,  0.684,  1.192,  1.401,  1.281,  0.894,  0.373, -0.133, -0.504, -0.688, -0.702, -0.615,
                -0.51 , -0.44 , -0.409, -0.372, -0.263, -0.033,  0.319,  0.726,  1.074,  1.236,  1.121,  0.714, 0.093,
                -0.593, -1.163, -1.464, -1.42 , -1.053, -0.476,  0.147, 0.658,  0.948,  0.991,  0.839,  0.588,  0.338,
                0.154,  0.041, -0.041, -0.154, -0.338, -0.588, -0.839, -0.991, -0.948, -0.658, -0.147,  0.476,  1.053,
                1.42 ,  1.464,  1.163,  0.593, -0.093, -0.714, -1.121, -1.236, -1.074, -0.726, -0.319,  0.033,  0.263,
                0.372,  0.409,  0.44 ,  0.51 ,  0.615,  0.702,  0.688,  0.504, 0.133, -0.373, -0.894, -1.281, -1.401,
                -1.192, -0.684, -0.0};

        double[] resultAbs = {0.0, 0.684, 1.192, 1.401, 1.281, 0.894, 0.373, 0.133, 0.504, 0.688, 0.702, 0.615, 0.51,
                0.44, 0.409, 0.372, 0.263, 0.033, 0.319, 0.726, 1.074, 1.236, 1.121, 0.714, 0.093, 0.593, 1.163, 1.464,
                1.42, 1.053, 0.476, 0.147, 0.658, 0.948, 0.991, 0.839, 0.588, 0.338, 0.154, 0.041, 0.041, 0.154, 0.338,
                0.588, 0.839, 0.991, 0.948, 0.658, 0.147, 0.476, 1.053, 1.42, 1.464, 1.163, 0.593, 0.093, 0.714, 1.121,
                1.236, 1.074, 0.726, 0.319, 0.033, 0.263, 0.372, 0.409, 0.44, 0.51, 0.615, 0.702, 0.688, 0.504, 0.133,
                0.373, 0.894, 1.281, 1.401, 1.192, 0.684, 0.0};

        double[][] resultComplex = {{0.0, 0.684, 1.192, 1.401, 1.281, 0.894, 0.373, -0.133, -0.504, -0.688, -0.702,
                -0.615, -0.51, -0.44, -0.409, -0.372, -0.263, -0.033, 0.319, 0.726, 1.074, 1.236, 1.121, 0.714, 0.093,
                -0.593, -1.163, -1.464, -1.42, -1.053, -0.476, 0.147, 0.658, 0.948, 0.991, 0.839, 0.588, 0.338, 0.154,
                0.041, -0.041, -0.154, -0.338, -0.588, -0.839, -0.991, -0.948, -0.658, -0.147, 0.476, 1.053, 1.42, 1.464,
                1.163, 0.593, -0.093, -0.714, -1.121, -1.236, -1.074, -0.726, -0.319, 0.033, 0.263, 0.372, 0.409, 0.44,
                0.51, 0.615, 0.702, 0.688, 0.504, 0.133, -0.373, -0.894, -1.281, -1.401, -1.192, -0.684, -0.0}, {0.0,
                0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, 0.0, -0.0,
                0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0,
                0.0, 0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}};

        InverseDiscreteFourier transformer = new InverseDiscreteFourier(this.seqComp);
        transformer.idft();
        double[] outReal = transformer.get_real_signal();
        double[] outAbsolute = transformer.get_absolute_signal();

        double[][] out = transformer.get_complex_signal();
        double[] outR = new double[out.length];
        double[] outI = new double[out.length];

        for (int i=0; i<out.length; i++) {
            outR[i] = out[i][0];
            outI[i] = out[i][1];
        }

        assertArrayEquals(resultReal, outReal, 0.001);
        assertArrayEquals(resultAbs, outAbsolute, 0.001);
        assertArrayEquals(resultComplex[0], outR, 0.001);
        assertArrayEquals(resultComplex[1], outI, 0.001);
    }

    @Test
    public void testInverseFourierReal() {
        double[] resultReal = {-0.0, 0.342, 0.254, 0.105, -0.06, -0.193, -0.261, -0.253, -0.186, -0.092, -0.007, 0.043,
                0.053, 0.035, 0.016, 0.018, 0.054, 0.115, 0.176, 0.204, 0.174, 0.081, -0.058, -0.203, -0.311, -0.343,
                -0.285, -0.151, 0.022, 0.184, 0.288, 0.312, 0.255, 0.145, 0.022, -0.076, -0.125, -0.125, -0.092, -0.056,
                -0.041, -0.056, -0.092, -0.125, -0.125, -0.076, 0.022, 0.145, 0.255, 0.312, 0.288, 0.184, 0.022, -0.151,
                -0.285, -0.343, -0.311, -0.203, -0.058, 0.081, 0.174, 0.204, 0.176, 0.115, 0.054, 0.018, 0.016, 0.035,
                0.053, 0.043, -0.007, -0.092, -0.186, -0.253, -0.261, -0.193, -0.06, 0.105, 0.254, 0.342};

        double[] resultAbs = {0.0, 0.342, 0.254, 0.105, 0.06, 0.193, 0.261, 0.253, 0.186, 0.092, 0.007, 0.043, 0.053,
                0.035, 0.016, 0.018, 0.054, 0.115, 0.176, 0.204, 0.174, 0.081, 0.058, 0.203, 0.311, 0.343, 0.285, 0.151,
                0.022, 0.184, 0.288, 0.312, 0.255, 0.145, 0.022, 0.076, 0.125, 0.125, 0.092, 0.056, 0.041, 0.056, 0.092,
                0.125, 0.125, 0.076, 0.022, 0.145, 0.255, 0.312, 0.288, 0.184, 0.022, 0.151, 0.285, 0.343, 0.311, 0.203,
                0.058, 0.081, 0.174, 0.204, 0.176, 0.115, 0.054, 0.018, 0.016, 0.035, 0.053, 0.043, 0.007, 0.092, 0.186,
                0.253, 0.261, 0.193, 0.06, 0.105, 0.254, 0.342};

        double[][] resultComplex = {{-0.0, 0.342, 0.254, 0.105, -0.06, -0.193, -0.261, -0.253, -0.186, -0.092, -0.007,
                0.043, 0.053, 0.035, 0.016, 0.018, 0.054, 0.115, 0.176, 0.204, 0.174, 0.081, -0.058, -0.203, -0.311,
                -0.343, -0.285, -0.151, 0.022, 0.184, 0.288, 0.312, 0.255, 0.145, 0.022, -0.076, -0.125, -0.125, -0.092,
                -0.056, -0.041, -0.056, -0.092, -0.125, -0.125, -0.076, 0.022, 0.145, 0.255, 0.312, 0.288, 0.184, 0.022,
                -0.151, -0.285, -0.343, -0.311, -0.203, -0.058, 0.081, 0.174, 0.204, 0.176, 0.115, 0.054, 0.018, 0.016,
                0.035, 0.053, 0.043, -0.007, -0.092, -0.186, -0.253, -0.261, -0.193, -0.06, 0.105, 0.254, 0.342}, {-0.0,
                -0.0, -0.0, -0.0, -0.0, -0.0, -0.0, 0.0, -0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, -0.0, -0.0,
                0.0, -0.0, 0.0, -0.0, -0.0, -0.0, -0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, -0.0, -0.0, -0.0, -0.0, -0.0,
                -0.0, -0.0, -0.0, -0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, -0.0, 0.0, 0.0, -0.0, -0.0, -0.0, 0.0,
                0.0, 0.0, 0.0, -0.0, 0.0, -0.0, 0.0, 0.0, 0.0, 0.0, -0.0, -0.0, 0.0, -0.0, -0.0, -0.0, 0.0, -0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, 0.0}};

        InverseDiscreteFourier transformer = new InverseDiscreteFourier(this.seqReal);
        transformer.idft();
        double[] outReal = transformer.get_real_signal();
        double[] outAbsolute = transformer.get_absolute_signal();

        double[][] out = transformer.get_complex_signal();
        double[] outR = new double[out.length];
        double[] outI = new double[out.length];

        for (int i=0; i<out.length; i++) {
            outR[i] = out[i][0];
            outI[i] = out[i][1];
        }

        assertArrayEquals(resultReal, outReal, 0.001);
        assertArrayEquals(resultAbs, outAbsolute, 0.001);
        assertArrayEquals(resultComplex[0], outR, 0.001);
        assertArrayEquals(resultComplex[1], outI, 0.001);
    }
}
