package Parser;

import Solutions.Solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser
{
    String name;
    public FileParser(String name)
    {
        this.name = name;
    }

    public List<Solution> getSolutions() throws IOException
    {
        List<Solution> list = new ArrayList<Solution>();

        BufferedReader br = new BufferedReader(new FileReader(this.name));
        String line;

        int vars = 0;
        int objs = 0;

        boolean isHeader = true;
        while ((line = br.readLine()) != null)
        {
            String[] arr = line.split(",");
            if(!isHeader)
            {
                double[] obj = new double[objs];
                for (int i = 0; i < objs ; i++)
                {
                    obj[i] = Double.parseDouble(arr[3+vars+i]);
                }
                int front = Integer.parseInt(arr[2]);
                int generation = Integer.parseInt(arr[0]);
                list.add(new Solution(vars, objs, obj, front, generation));
            }
            else
            {
                vars = Integer.parseInt(arr[0]);
                objs = Integer.parseInt(arr[1]);

            }
            isHeader = false;
        }
        return list;
    }
}
