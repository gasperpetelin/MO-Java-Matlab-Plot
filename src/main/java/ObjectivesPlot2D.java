import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jzy3d.chart.factories.AWTChartComponentFactory;
import org.jzy3d.colors.Color;
import org.jzy3d.maths.Coord3d;
import org.jzy3d.plot3d.primitives.Scatter;
import org.jzy3d.plot3d.rendering.canvas.Quality;
import org.jzy3d.plot3d.rendering.view.modes.ViewPositionMode;

import java.util.List;

public class ObjectivesPlot2D extends AbstractObjectivesPlot
{
    List<Solution> solutions;
    int[] objectives;

    public  ObjectivesPlot2D(List<Solution>solutions, int[] objectives)
    {
        if(objectives.length!=2)
            throw new IllegalArgumentException ("Array objectives should contain 2 integers.");
        if(solutions==null)
            throw new IllegalArgumentException ("List of solutions is null.");

        this.solutions = solutions;
        this.objectives = objectives;
    }

    @Override
    public void init()
    {
        int size = this.solutions.size();

        Coord3d[] points = new Coord3d[size];
        Color[]   colors = new Color[size];

        for(int i=0; i<size; i++)
        {
            float[] obj = toFloatArray(solutions.get(i).objectives);
            points[i] = new Coord3d(obj[objectives[0]],obj[objectives[1]],0);
            colors[i] = new Color(91, 143, 245);
        }

        Scatter scatter = new Scatter(points, colors);
        scatter.setWidth(3);
        chart = AWTChartComponentFactory.chart(Quality.Advanced, "newt");

        Logger.getRootLogger().setLevel(Level.OFF);

        chart.getAxeLayout().setXAxeLabel("Objective " + objectives[0]);
        chart.getAxeLayout().setYAxeLabel("Objective " + objectives[1]);
        chart.stopAnimator();
        chart.getView().setViewPositionMode(ViewPositionMode.TOP);

        chart.getScene().add(scatter);

    }

}
