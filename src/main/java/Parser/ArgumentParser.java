package Parser;


import org.apache.commons.cli.*;

public class ArgumentParser
{


    CommandLine cmd;


    public ArgumentParser(String[] args) throws ParseException
    {

        Options options = new Options();

        Option filename = new Option("f", "file", true, "file name");
        filename.setRequired(true);
        options.addOption(filename);

        Option objectives = new Option("o", "obj", true, "list of objectives to display");
        objectives.setRequired(true);
        objectives.setArgs(Option.UNLIMITED_VALUES);
        options.addOption(objectives);

        Option front = new Option("front", "front", true, "front to display");
        options.addOption(front);

        Option result = new Option("r", "result", false, "display only last iteration.");
        options.addOption(result);

        CommandLineParser parser = new BasicParser();
        cmd = parser.parse(options, args);
    }

    public String getFileName()
    {
        return cmd.getOptionValue("file");
    }

    public boolean getOnlyEndResult()
    {
        return cmd.hasOption("result");
    }

    public Integer getFront() throws ParseException
    {
        try
        {
            if(cmd.getOptionValue("front")== null)
                return null;
            Integer fr = Integer.parseInt(cmd.getOptionValue("front"));
            if(fr<0)
                throw new ParseException("Front must be positive integer.");
            return fr;
        }
        catch (Exception e)
        {
            throw new ParseException("Invalid front number.");
        }
    }

    public int[] getObjectivesToPlot() throws ParseException
    {
        try
        {
            String[] args = cmd.getOptionValues("o");
            int[] ret = new int[args.length];
            for (int i = 0; i < args.length; i++)
            {
                ret[i] = Integer.parseInt(args[i]);
            }
            return ret;
        }
        catch (Exception e)
        {
            throw new ParseException("Objectives should be integer.");
        }
    }

}
