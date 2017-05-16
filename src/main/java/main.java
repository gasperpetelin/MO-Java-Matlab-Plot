import Parser.ArgumentParser;
import Parser.FileParser;
import Ploters.ObjectivesPlotFactory;
import Solutions.Solution;
import Solutions.SolutionFilters;
import org.apache.commons.cli.ParseException;
import org.jzy3d.analysis.AnalysisLauncher;
import java.io.IOException;
import java.util.List;


public class main
{
    public static void main(String[] args)
    {
        try
        {
            ArgumentParser inputParser = new ArgumentParser(args);

            FileParser p = new FileParser(inputParser.getFileName());

            List<Solution> ls = new SolutionFilters(p.getSolutions())
                    .filterFront(inputParser.getFront())
                    .filterOnlyLastGeneration(inputParser.getOnlyEndResult())
                    .getEndSolutions();

            AnalysisLauncher.open(ObjectivesPlotFactory.build(ls, inputParser.getObjectivesToPlot()));
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }



    }

}
