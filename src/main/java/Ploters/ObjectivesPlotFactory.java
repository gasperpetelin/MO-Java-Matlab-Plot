package Ploters;

import Solutions.Solution;

import java.util.Arrays;
import java.util.List;

public class ObjectivesPlotFactory
{
    public static AbstractObjectivesPlot build(List<Solution> solutions, int[] objectives)
    {
        if(solutions==null)
            throw new IllegalArgumentException("List of solutions is null.");
        if(solutions.get(0).numberOfObjectives<objectives.length)
            throw new IllegalArgumentException("To many objectives to plot.");
        if(Arrays.stream(objectives).summaryStatistics().getMin()<0)
            throw new IllegalArgumentException("Objectives array should contain numbers between 0 and number of objectives.");
        if(Arrays.stream(objectives).summaryStatistics().getMax()>=solutions.get(0).numberOfObjectives)
            throw new IllegalArgumentException("Objectives array should contain numbers between 0 and number of objectives.");
        switch (objectives.length)
        {
            case 2:
                return new ObjectivesPlot2D(solutions, objectives);
            case 3:
                return new ObjectivesPlot3D(solutions, objectives);
            case 4:
                return new ObjectivesPlot4D(solutions, objectives);
            default:
                throw new IllegalArgumentException ("Array objectives should contain 2, 3 or 4 integers.");
        }
    }

}
