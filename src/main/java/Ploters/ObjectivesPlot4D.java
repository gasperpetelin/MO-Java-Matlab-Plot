package Ploters;

import Solutions.Solution;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;

import java.util.List;

public class ObjectivesPlot4D extends AbstractObjectivesPlot
{
    List<Solution> solutions;
    int[] objectives;

    public ObjectivesPlot4D(List<Solution>solutions, int[] objectives)
    {
        if(objectives.length!=4)
            throw new IllegalArgumentException ("Array objectives should contain 4 integers.");
        if(solutions==null)
            throw new IllegalArgumentException ("List of solutions is null.");

        this.solutions = solutions;
        this.objectives = objectives;
    }

    @Override
    public void init()
    {
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for(Solution s : this.solutions)
        {
            if(s.objectives[objectives[3]]>max)
                max = s.objectives[objectives[3]];
            if(s.objectives[objectives[3]]<min)
                min = s.objectives[objectives[3]];
        }

        int size = this.solutions.size();

        Coord3d[] points = new Coord3d[size];
        Color[]   colors = new Color[size];

        for(int i=0; i<size; i++)
        {
            float[] obj = toFloatArray(solutions.get(i).objectives);
            points[i] = new Coord3d(obj[objectives[0]],obj[objectives[1]],obj[objectives[2]]);
            colors[i] = new Color(255-this.scale(obj[objectives[3]], max, min), 20, this.scale(obj[objectives[3]], max, min));
        }

        Scatter scatter = new Scatter(points, colors);
        scatter.setWidth(3);
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");

        chart.getAxeLayout().setXAxeLabel("Objective " + objectives[0]);
        chart.getAxeLayout().setYAxeLabel("Objective " + objectives[1]);
        chart.getAxeLayout().setZAxeLabel("Objective " + objectives[2]);
        chart.getScene().add(scatter);
    }

    private int scale(double value, double max, double min)
    {
        double range = max-min;
        return (int) (((value-min)/range) *255);

    }
}
