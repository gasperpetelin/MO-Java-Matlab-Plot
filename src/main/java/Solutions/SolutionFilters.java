package Solutions;

import java.util.ArrayList;
import java.util.List;

public class SolutionFilters
{
    List<Solution> sol;
    public SolutionFilters(List<Solution> sol)
    {
        this.sol = sol;
    }

    public SolutionFilters filterFront(Integer front)
    {
        if(front!=null)
        {
            List<Solution> ls = new ArrayList<>();
            for(Solution s:this.sol)
            {
                if(s.front==front)
                    ls.add(s);
            }
            this.sol = ls;
        }
        return this;
    }

    public SolutionFilters filterOnlyLastGeneration(boolean onlyLast)
    {
        if(onlyLast)
            this.filterOnlyLastGeneration();
        return this;
    }

    public SolutionFilters filterOnlyLastGeneration()
    {
        int maxGen = 0;

        for(Solution s:this.sol)
        {
            if(s.generation>maxGen)
                maxGen = s.generation;
        }

        List<Solution> ls = new ArrayList<>();
        for(Solution s:this.sol)
        {
            if(s.generation==maxGen)
                ls.add(s);
        }
        this.sol = ls;
        return this;
    }

    public List<Solution> getEndSolutions()
    {
        return this.sol;
    }
}
