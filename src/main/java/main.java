import ArgumentsParser.ArgumentParser;
import org.apache.commons.cli.ParseException;
import org.jzy3d.analysis.AnalysisLauncher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class main
{
    public static void main(String[] args)
    {
        try
        {
            ArgumentParser inputParser = new ArgumentParser(args);

            FileParser p = new FileParser(inputParser.getFileName());


            List<Solution> ls = new ArrayList<Solution>();
            Integer front = inputParser.getFront();
            if(front==null)
                ls = p.getSolutions();
            else
            {
                for(Solution s : p.getSolutions())
                {
                    if(s.front==front)
                        ls.add(s);
                }
            }




            AnalysisLauncher.open(ObjectivesPlotFactory.build(ls, inputParser.getObjectivesToPlot()));
        }
        catch (ParseException e)
        {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

}
