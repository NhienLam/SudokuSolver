package sudoku;

public class SudokuTester 
{
	public static void main(String[] args)
	{
		/*********
		 * TEST PUZZLE 1 
		 *********/
		SudokuGrid g1 = TestGrid.getPuzzle1();		// or any other puzzle
		Solver solver1 = new Solver(g1);
		System.out.println("Will solve\n" + g1);
		solver1.solve();
		
		
		// Print out your solution, or test if it equals() the solution in TestGridSupplier.
		System.out.println("Solution: ");
		// My solution
		System.out.println(solver1.getSolutions());
		
		
		System.out.println("TestGridSupplier.getSolution1:");
		// TestGridSupplier solution
		System.out.println(TestGrid.getSolution1());
		
		// Check if they are equal
		if(solver1.getSolutions().get(0).equals(TestGrid.getSolution1()))
		{
			System.out.println("Sudoku Puzzle 1 - PASS! ");
		}
		else
		{
			System.out.println("Sudoku Puzzle 1 - FAIL!");
		}
		
		System.out.println("*********************");
		
		/*********
		 * TEST PUZZLE 2 
		 *********/
		SudokuGrid g2 = TestGrid.getPuzzle2();		// or any other puzzle
		Solver solver2 = new Solver(g2);
		System.out.println("Will solve\n" + g2);
		solver2.solve();
		
		
		// Print out your solution, or test if it equals() the solution in TestGridSupplier.
		System.out.println("Solution: ");
		// My solution
		System.out.println(solver2.getSolutions());
		
		
		System.out.println("TestGridSupplier.getSolution2:");
		// TestGridSupplier solution
		System.out.println(TestGrid.getSolution2());
		
		// Check if they are equal
		if(solver2.getSolutions().get(0).equals(TestGrid.getSolution2()))
		{
			System.out.println("Sudoku Puzzle 2 - PASS! ");
		}
		else
		{
			System.out.println("Sudoku Puzzle 2 - FAIL!");
		}
		
		System.out.println("*********************");
		
		/*********
		 * TEST PUZZLE 3
		 *********/
		SudokuGrid g3 = TestGrid.getPuzzle3();		// or any other puzzle
		Solver solver3 = new Solver(g3);
		System.out.println("Will solve\n" + g3);
		solver3.solve();
		
		
		// Print out your solution, or test if it equals() the solution in TestGridSupplier.
		System.out.println("Solution: ");
		// My solution
		System.out.println(solver3.getSolutions());
		
		
		System.out.println("TestGridSupplier.getSolution3:");
		// TestGridSupplier solution
		System.out.println(TestGrid.getSolution3());
		
		// Check if they are equal
		if(solver3.getSolutions().get(0).equals(TestGrid.getSolution3()))
		{
			System.out.println("Sudoku Puzzle 3 - PASS! ");
		}
		else
		{
			System.out.println("Sudoku Puzzle 3 - FAIL!");
		}
	}
}
