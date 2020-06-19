package sudoku;

//
// All puzzles modeled here are copyright 2016 (copyright 1997-2017Conceptis Ltd.)
//

public class TestGrid 
{
	//
	// A simple puzzle and its solution. 
	//
	private final static String[]		PUZZLE_1 =
	{
		"..3.1.5..",
		"8..395..1",
		"15.....27",
		".8..7..5.",
		"62.9.4.13",
		".9..2..7.",
		"91.....34",
		"2..748..9",
		"..6.3.2.."		
	};    
	
	
	private final static String[]       SOLUTION_1 =
    {
        "463217598",
        "872395641",
        "159486327",
        "384671952",
        "627954813",
        "591823476",
        "918562734",
        "235748169",
        "746139285"
    };
	
	
	static SudokuGrid getPuzzle1()		{ return new SudokuGrid(PUZZLE_1); }
	static SudokuGrid getSolution1()		{ return new SudokuGrid(SOLUTION_1); }

	

	private final static String[]		 PUZZLE_2 =
	{
		".........",
		"8.1...9.7",
		"..75493..",
		"7..9.2..8",
		"....1....",
		"1..3.8..5",
		"..84312..",
		"2.5...1.9",
		"........."
	};     
	
	
	private final static String[]       SOLUTION_2 =
    {
        "439187562",
        "851623947",
        "627549381",
        "763952418",
        "582714693",
        "194368725",
        "978431256",
        "245876139",
        "316295874"
    };

	static SudokuGrid getPuzzle2()		{ return new SudokuGrid(PUZZLE_2); }
	static SudokuGrid getSolution2()		{ return new SudokuGrid(SOLUTION_2); }
	

	

	private final static String[]		 PUZZLE_3 =
	{
		".97..1.6.",
		"2....7..5",
		"....9...3",
		"85.......",
		"..9...5..",
		".......32",
		"3...7....",
		"5..6....1",
		".4.1..37."
	}; 
	
	
    private final static String[]       SOLUTION_3 =
    {
        "497351268",
        "236847195",
        "185296743",
        "853924617",
        "629713584",
        "714568932",
        "361472859",
        "578639421",
        "942185376"
    };

    
	static SudokuGrid getPuzzle3()		{ return new SudokuGrid(PUZZLE_3); }
	static SudokuGrid getSolution3()		{ return new SudokuGrid(SOLUTION_3); }
	
	
	//
	// You can use these to test your Grid's evaluate() method.
	//
	private final static String[]		REJECT_1 =
	{
		"11.......",
		".........",
		".........",
		".........",
		".........",
		".........",
		".........",
		".........",
		"........."
	};
	
	private final static String[]		REJECT_2 =
	{
		"2........",
		"2........",
		".........",
		".........",
		".........",
		".........",
		".........",
		".........",
		"........."
	};
	
	private final static String[]		REJECT_3 =
	{
		"3........",
		"..3......",
		".........",
		".........",
		".........",
		".........",
		".........",
		".........",
		"........."
	};
	
	private final static String[]		REJECT_4 =
	{
		".........",
		".........",
		".........",
		"....4....",
		".....4...",
		".........",
		".........",
		".........",
		"........."
	};
	
	private final static String[]		CONTINUE =
	{
		"123456789",
		".........",
		".........",
		".........",
		".........",
		".........",
		".........",
		".........",
		"........."
	};

	static SudokuGrid getReject1()		{ return new SudokuGrid(REJECT_1); }
	static SudokuGrid getReject2()		{ return new SudokuGrid(REJECT_2); }
	static SudokuGrid getReject3()		{ return new SudokuGrid(REJECT_3); }
	static SudokuGrid getReject4()		{ return new SudokuGrid(REJECT_4); }
	static SudokuGrid getContinue()		{ return new SudokuGrid(CONTINUE); }
	static SudokuGrid getAccept()			{ return getSolution1(); }
}

