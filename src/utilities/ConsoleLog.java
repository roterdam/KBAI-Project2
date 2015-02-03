package utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import project2.RavensAttribute;
import project2.RavensFigure;
import project2.RavensObject;
import project2.RavensProblem;

public class ConsoleLog {
	
	/*****
     * Prints a message to the console, as a debugging aid. It can also be used
     * to monitor the progress of the agent as it works on the problem.  It is
     * particularly helpful when watching for endless loops.
     * 
     * Requires that ENABLE_CONSOLE is true to print messages to system console.
     * The default setting is ENABLE_CONSOLE = true.
     * 
     * Parameters: 
     * 	String type
     * 		TIMESTAMP prefixes the message with a time stamp (hh.mm.ss:SSS)
     * 		PROBLEM_START prints the name of the problem
     * 		AGENT_START prints the date Agent() was instantiated (yyyy.MM.dd E)
     * 	String message - the message that will be written to the system console 
     */
    public static void writeMsg(String messageType, String message) {

		if (Constants.ENABLE_CONSOLE) {
			Date sysClock = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat();
			switch (messageType) {
	        	case Constants.TIMESTAMP:
	        		sdf.applyPattern("hh.mm.ss:S ");
	        		System.out.println(sdf.format(sysClock) + message);
	        		break;
	        	case Constants.NO_TIMESTAMP:
	        		String lineHeader = ("--.--.--:--- ");
	        		System.out.println(lineHeader + message);
	        		break;
	        	case Constants.PROBLEM_START:
	        		System.out.println("\n************* " + message);
	        		break;
	        	case Constants.AGENT_START:
	        		sdf.applyPattern("yyyy.MM.dd E");
	        		String asterisks = "***************************************";
	        		System.out.println("\n\n" + asterisks);
	        		System.out.println("*** Agent Started on " + sdf.format(sysClock));
	        		if (Constants.solveSingleProblem)
	        			System.out.println("*** Set to solve only a single problem");
	        		System.out.println(asterisks);	
	        		break;
	        	default: 
	        		System.out.println(message);
	        		break;
			}
		}
		
    }
	
    /**
     * List the time in milliseconds it took to solve the problem
     * 
     * @param problemStartTime
     */
    public static void reportElapsedTime(long problemStartTime) {
    	
		long problemEndTime = System.nanoTime();
		long problemElapsedTimeMs = ((problemEndTime - problemStartTime) / 1000000);
		writeMsg(Constants.TIMESTAMP, "solution took = " + Long.toString(problemElapsedTimeMs) + " ms");
	}
    
    public static void dumpRavensProblemDetails(RavensProblem problem){
		HashMap<String, Set> attribute = new HashMap<String, Set>();
		Collection<RavensFigure> values = problem.getFigures().values();
	
		for (Object figure : values) {
			RavensFigure ravensFigure = (RavensFigure) figure;
			String figureName = ravensFigure.getName();
			writeMsg(Constants.TIMESTAMP, "figure name = " + figureName);
			ArrayList<RavensObject> objects = ravensFigure.getObjects();
			for (Object object : objects) {
				RavensObject ravensObject = (RavensObject) object;
				String objectName = ravensObject.getName();
				writeMsg(Constants.NO_TIMESTAMP, "   object name = " + objectName);
				ArrayList<RavensAttribute> attributes = ravensObject.getAttributes();
				for (Object attrib : attributes) {
					RavensAttribute ravensAttribute = (RavensAttribute) attrib;
					String attribName = ravensAttribute.getName();
					String attribValue = ravensAttribute.getValue();
					writeMsg(Constants.NO_TIMESTAMP, "      Attribute name = " + 
                		attribName + " :  value = " + attribValue);
					Set set = attribute.get(attribName);
					if (set == null) {
						set = new HashSet<String>();
						attribute.put(attribName, set);
					}
					set.add(attribValue);
				}
			}
		}	
    }
}    


