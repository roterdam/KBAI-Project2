package utilities;

public class Constants {
	
	//****************************************************************************************************
	// SWITCHES FOR MONITORING AGENT EXECUTION AND FOR DEBUGGING PURPOSES 
	//****************************************************************************************************
	public static final boolean ENABLE_CONSOLE = true;  	// enables/disables console output
	
	public static final boolean solveSingleProblem = false;		// Results in only a single problem
																//   to be solved by name.
	
	public static final String debugThisProblem = "2x1 Basic Problem 15";	// Name of the single problem
																			//   to be solved.
	
	public static final boolean listProblemDetails = true;	// When true, the entire contents of the
																//   RavensProblem object are listed
																//   on the system console.
	//****************************************************************************************************
	//****************************************************************************************************
	
	// console output formats used by ConsoleLog.java
	public static final String TIMESTAMP = "TIMESTAMP";
	public static final String NO_TIMESTAMP = "NO_TIMESTAMP";
	public static final String AGENT_START = "AGENT_START";
	public static final String PROBLEM_START = "PROBLEM_START";
	
	public static final String DEFAULT_ANSWER = "1";

}
