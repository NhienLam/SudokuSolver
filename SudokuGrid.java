package sudoku;

import java.util.*;


public class SudokuGrid 
{
	private int[][]	values;
	
	//
	// Constructs a Grid instance from a string[] as provided by TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public SudokuGrid(String[] rows)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
		{
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i=0; i<9; i++)
			{
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}
	
	
	//
	// Copy ctor. Duplicates its source.
	//
	SudokuGrid(SudokuGrid src)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
			for (int i=0; i<9; i++)
				values[j][i] = src.values[j][i];
	}
	
	
	//
	// Finds an empty member of values[][]. Returns an array list of 9 grids that look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the current grid is full. Don’t change
	// “this” grid. Build 9 new grids.
	//
	public ArrayList<SudokuGrid> next9Grids()
	{		
		int xOfNextEmptyCell = 0;
		int yOfNextEmptyCell = 0;
		
		// Find x,y of an empty cell.
		boolean foundEmpty = false;

		for(int row = 0; row < values.length; row++)
		{
			for(int col = 0; col < values[0].length; col++)
			{
				if(values[row][col] == 0)
				{
					xOfNextEmptyCell = row;
					yOfNextEmptyCell = col;
					foundEmpty = true;
				}
			}
		}
		
		
		// Construct array list to contain 9 new grids.
		ArrayList<SudokuGrid> grids = new ArrayList<SudokuGrid>();
			
		// Returns null if the current grid is full
		if(foundEmpty == false)
		{
			return null;
		}
		// Else, create 9 new grids as described in the comments above. Add them to grids.
		else
		{
			for(int i = 1; i <= 9; i++)
			{
				SudokuGrid gr = new SudokuGrid(this);
				gr.values[xOfNextEmptyCell][yOfNextEmptyCell] = i;			
				grids.add(gr);
			}
			return grids;
		}		
	}
	
	
	//
	// Returns true if this grid is legal. A grid is legal if no row, column, or
	// 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	//
	public boolean isLegal()
	{
		// Check every row. If find an illegal row, return false.
		for(int row = 0; row < values.length; row++)
		{
			Set<Integer> set = new HashSet<>();
			for(int col = 0; col < values[0].length; col++)
			{
				// Check if it has valid value
				// Returns false if the value is outside 0 and 9 range
				if(values[row][col] < 0 || values[row][col] >9)
				{
					return false;
				}
				// Check if the value is repeated
				// Returns false if it is repeated
				// If not, add it in the Set set
				else if(values[row][col] != 0)
				{
					if(set.add(values[row][col]) == false)
					{
						return false;
					}
				}
			}
		}
		
		// Check every column. If find an illegal column, return false.
		for(int col = 0; col < values[0].length; col++)
		{
			Set<Integer> set = new HashSet<>();
			for(int row = 0; row < values.length; row++)
			{
				// Check if it has valid value
				// Returns false if the value is outside 0 and 9 range
				if(values[row][col] < 0 || values[row][col] >9)
				{
					return false;
				}
				// Check if the value is repeated
				// Returns false if it is repeated
				// If not, add it in the Set set
				else if(values[row][col] != 0)
				{
					if(set.add(values[row][col]) == false)
					{
						return false;
					}
				}		
			}
		}
		
		// Check every block. If find an illegal block, return false.
		for(int row = 0; row < values.length; row = row + 3)
		{
			for(int col = 0; col < values[0].length; col = col + 3)
	 		{
				Set<Integer> set = new HashSet<>();
				//Checks every block
				for(int rowBlo = row; rowBlo < row+3; rowBlo++)
				{
					for(int colBlo = col; colBlo < col+3; colBlo++)
					{
						// Check if it has valid value
						// Returns false if the value is outside 0 and 9 range
						if(values[rowBlo][colBlo] < 0 || values[rowBlo][colBlo] >9)
						{
							return false;
						}
						// Check if the value is repeated
						// Returns false if it is repeated
						// If not, add it in the Set set
						else if(values[rowBlo][colBlo] != 0)	
						{
							if(set.add(values[rowBlo][colBlo]) == false)
							{
								return false;
							}	
						}											
					}
				}
			}
		}
						
		// All rows/cols/blocks are legal.
		return true;
	}

	
	//
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull()
	{
		for(int row = 0; row < values.length; row++)
		{
			for(int col = 0; col < values[0].length; col++)
			{
				//Checks if the value is a digit from 1-9
				//If not, return false
				if(!(values[row][col] >= 1 && values[row][col] <= 9))
				{
					return false;
				}
			}
		}
		return true;
	}
	

	//
	// Returns true if x is a Grid and, for every (i,j), 
	// x.values[i][j] == this.values[i][j].
	//
	public boolean equals(Object x)
	{
		boolean equal = true;
		
		// Checks if x is a Grid
		if(x instanceof SudokuGrid)
		{
			SudokuGrid other = (SudokuGrid) x;
			// Checks if all x.values[i][j] == this.values[i][j] , for every (i,j)
			for(int row = 0; row < values.length; row++)
			{
				for(int col = 0; col < values[0].length; col++)
				{
					if(other.values[row][col] != this.values[row][col])
					{
						equal = false;
					}
				}
			}
		}
		else
		{
			equal = false;
		}

		return equal;
	}
	
	public String toString()
	{
		String s = "";
		for (int j=0; j<9; j++)
		{
			for (int i=0; i<9; i++)
			{
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char)('0' + n);
			}
			s += "\n";
		}
		return s;
	}
}
