package project2;

import project2.RavensProblem;
import utilities.ConsoleLog;
import utilities.Constants;
import frames.*; 

/*
 * The AI agent that decides the correct answer figure to Ravens Progressive
 * matrix problems passed to it by school-provided test driver.
 */
public class Agent {
    
	// Classes instances
	private RavensProblem problem; 
	
	/**
     * The default constructor.  No parameters are passed; no other constructor
     * signature is allowed.
     */
    public Agent() {
        
    }
    
    
    /**
     * The primary method for solving incoming Raven's Progressive Matrices.
     * For each problem, your Agent's Solve() method will be called. At the
     * conclusion of Solve(), your Agent should return a String representing its
     * answer to the question: "1", "2", "3", "4", "5", or "6". These Strings
     * are also the Names of the individual RavensFigures, obtained through
     * RavensFigure.getName().
     * 
     * In addition to returning your answer at the end of the method, your Agent
     * may also call problem.checkAnswer(String givenAnswer). The parameter
     * passed to checkAnswer should be your Agent's current guess for the
     * problem; checkAnswer will return the correct answer to the problem. This
     * allows your Agent to check its answer. Note, however, that after your
     * agent has called checkAnswer, it will *not* be able to change its answer.
     * checkAnswer is used to allow your Agent to learn from its incorrect
     * answers; however, your Agent cannot change the answer to a question it
     * has already answered.
     * 
     * If your Agent calls checkAnswer during execution of Solve, the answer it
     * returns will be ignored; otherwise, the answer returned at the end of
     * Solve will be taken as your Agent's answer to this problem.
     * 
     * @param problem the RavensProblem your agent should solve
     * @return your Agent's answer to this problem
     */
    public String Solve(RavensProblem problem) {
    	
    	this.problem = problem;
        
		// Initialization and miscellaneous housekeeping
    	this.problem = problem;
    	String agentAnswer = Constants.DEFAULT_ANSWER;	// initialize the Agent's answer.
		
		if (!Constants.solveSingleProblem){
			// Process all RavensProblem objects
			agentAnswer = solveThisProblem();
		} else if (Constants.solveSingleProblem && (this.problem.getName().equals(Constants.debugThisProblem))) {	
			// Process only a single RavensProblem object by name
	    	agentAnswer = solveThisProblem();
		}
    	
		return agentAnswer;
    }
    
   private String solveThisProblem() {
    	
	   String answer = Constants.DEFAULT_ANSWER;
	   long problemStartTime = 0;

	   
	   ConsoleLog.writeMsg(Constants.PROBLEM_START, this.problem.getName());
	   if (Constants.listProblemDetails)
			ConsoleLog.dumpRavensProblemDetails(this.problem);
    	
	   // Produce a listing of all data contained in the current RavensProblem object
	   //   if desired.  Used for monitoring & debugging purposes
    	
	   if (Constants.ENABLE_CONSOLE)		
		   problemStartTime = System.nanoTime();  // THIS STATEMENT'S POSITION IS IMPORTANT!
	   try {
    	//	semNet.buildSemNet();	// results in a knowledge representation object
		} catch (Exception e) {
			ConsoleLog.writeMsg(Constants.TIMESTAMP, "FAILURE: Semantic Network - problem aborted");
			ConsoleLog.reportElapsedTime(problemStartTime);
			e.printStackTrace();
			return Constants.DEFAULT_ANSWER;
		}
		
		try {
			//TODO: GenerateTest class invocation; replace with functioning code
		} catch (Exception e) {
			ConsoleLog.writeMsg(Constants.TIMESTAMP, "FAILURE: GenerateTest - problem aborted");
			ConsoleLog.reportElapsedTime(problemStartTime);
			e.printStackTrace();
			return Constants.DEFAULT_ANSWER;
		}

		// Dispose of Class instantiations created by this program. 
		//this.semNet = null;
		//this.genTest = null;
		
		// Calculate and report the time elapsed to solve this problem.
		ConsoleLog.reportElapsedTime(problemStartTime);
		
		// *** MUST ONLY EXECUTE checkAnswer() WHEN MONITORING AND DEBUGGING!!  ***
		if (Constants.ENABLE_CONSOLE){
			String correctAnswer = problem.checkAnswer(answer);
			if (correctAnswer.equals(answer)){
				ConsoleLog.writeMsg(Constants.NO_TIMESTAMP, "Correct!  Agent's answer(" + answer + ")");
			}else{
				ConsoleLog.writeMsg(Constants.NO_TIMESTAMP, "Agent's answer(" + answer + 
						") - correct answer (" + correctAnswer + ")");	
			}	
		}
		return answer;
	}
}
