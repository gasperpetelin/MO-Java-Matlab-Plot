
public class Solution
{
    double[] objectives;
    int numberOfVariables;
    int numberOfObjectives;
    int front;
    public Solution(int numberOfVariables, int numberOfObjectives, double[] objectives, int front)
    {
        this.objectives = objectives;
        this.numberOfVariables = numberOfVariables;
        this.numberOfObjectives = numberOfObjectives;
        this.front = front;
    }
}
