import java.util.List;

public class ObjectivesPlotFactory
{
    public static AbstractObjectivesPlot build(List<Solution> solutions, int[] objectives)
    {
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
