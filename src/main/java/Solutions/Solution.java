package Solutions;

public class Solution
{
    public double[] objectives;
    public int numberOfVariables;
    public int numberOfObjectives;
    public int front;
    public int generation;
    public Solution(int numberOfVariables, int numberOfObjectives, double[] objectives, int front, int generation)
    {
        this.objectives = objectives;
        this.numberOfVariables = numberOfVariables;
        this.numberOfObjectives = numberOfObjectives;
        this.front = front;
        this.generation = generation;
    }
}
