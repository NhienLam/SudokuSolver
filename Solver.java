package sudoku;

import java.util.*;


public class Solver 
{
	private SudokuGrid					     	problem;
	private ArrayList<SudokuGrid>				solutions;
	
	
	public Solver(SudokuGrid problem)
	{
		this.problem = problem;
	}
	
	
	public void solve()
	{
		solutions = new ArrayList<>();
		solveRecurse(problem);
	}

	//
	// Standard backtracking recursive solver.
	//
	private void solveRecurse(SudokuGrid grid)
	{		
		Evaluation eval = evaluate(grid);
		
		if (eval == Evaluation.ABANDON)
		{
			// Abandon evaluation of this illegal board.
			return;
			// Not do anything with when it is abandon
		}
		else if (eval == Evaluation.ACCEPT)
		{
			// A complete and legal solution. Add it to solutions.
			solutions.add(grid);
		}
		else
		{
			// Here if eval == Evaluation.CONTINUE. Generate all 9 possible next grids. Recursively 
			// call solveRecurse() on those grids.

			ArrayList<SudokuGrid> grids = grid.next9Grids();
			for(SudokuGrid g : grids)
			{
				solveRecurse(g);
			}
		}
		
	}
	

	//
	// Returns ABANDON if the grid is illegal. 
	// Returns ACCEPT if the grid is legal and complete.
	// Returns CONTINUE if the grid is legal and incomplete.
	//
	public Evaluation evaluate(SudokuGrid grid)
	{
		if(!grid.isLegal())
		{
			return Evaluation.ABANDON;
		}
		else if(grid.isFull() && grid.isLegal())
		{
			return Evaluation.ACCEPT;
		}
		else
		{
			return Evaluation.CONTINUE;
		}
	}

	public ArrayList<SudokuGrid> getSolutions()
	{
		return solutions;
	}
}
