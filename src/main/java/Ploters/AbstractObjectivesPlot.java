package Ploters;

import org.jzy3d.analysis.AbstractAnalysis;

public abstract class AbstractObjectivesPlot extends AbstractAnalysis
{
    protected float[] toFloatArray(double[] arr)
    {
        if (arr == null) return null;
        int n = arr.length;
        float[] ret = new float[n];
        for (int i = 0; i < n; i++) {
            ret[i] = (float)arr[i];
        }
        return ret;
    }
}
