/*
 *Class Name: Survey Test
 * @author Clayton Snider
 * Created 7/12/2014
 *Tests the survey class to ensure the arrays are populated correctly, and that
 *the results are displayed in a clear and understandable fashion. Used before
 *development of the Survey Conductor.
 */
package Survey;

import Survey.Survey;
import java.util.Scanner;


public class SurveyTest {
    
    
    
   // public static void main(String[]args)
    {
        //Declare necessary test variables
        Scanner input = new Scanner(System.in);
        int answer = 0; //For use in menus to test incrementer and new survey creation
        String newTitle;
        //create new default survey for testing
        Survey survey = new Survey();
        //create new custom survey to test overload cunstructor
        System.out.print("Please enter a title: ");
        newTitle = input.nextLine();
        
        Survey hello = new Survey(newTitle);
        //Display info for both surveys
        System.out.println("First Survey: " + survey.getTitle());
        System.out.println("ID: " + survey.getRespondentId());
        System.out.println("Second Survey: " + hello.getTitle());
        System.out.println("ID: " + hello.getRespondentId());
        //Demonstrate incrementing respondent ID values
        while(answer !=3)
        {
            System.out.println("\n1 - Default Survey\n2- Custom Survey\n3-Quit");
            System.out.print("Which should we complete next?: ");
            answer = input.nextInt();
        
            if (answer == 1)
            {
                survey.generateRespondentId();
                System.out.println("First Survey: " + survey.getTitle());
                System.out.println("ID: " + survey.getRespondentId());
            }
            else if (answer == 2)
            {
                hello.generateRespondentId();
                System.out.println("Second Survey: " + hello.getTitle());
                System.out.println("ID: " + hello.getRespondentId());
            }
        }
        
        //Demonstrate creation of new custom survey to reset ID to 0
        System.out.print("Do you want to create a new survey? (1=yes 2=no): ");
        answer = input.nextInt();
        if (answer == 1)
        {
            System.out.print("Please enter a title: ");
            newTitle = input.next();
            hello = new Survey(newTitle);
            System.out.println("Second Survey: " + hello.getTitle());
            System.out.println("ID: " + hello.getRespondentId());
        }
        
        //Demonstrates entering the questions into the survey
        survey.enterQuestions();
        for(int i = 0; i < 10; i++)
        {
            System.out.println(survey.questions[i]);
        }
        //test the logResponse() method
        for (int i = 0; i < 10; i++)
        {
            System.out.println(survey.questions[i]);
            System.out.print("Please enter your answer(1-5): ");
            answer = input.nextInt();
            survey.logResponse(survey.getRespondentId(),i ,answer);
        }
        System.out.print("Which question number do you want to see?: ");
        int qNum = input.nextInt();
        survey.displayQuestionStats(qNum);
        //test displaySurveyResults() method
        survey.displaySurveyResults();
        
        for(int i = 0; i < 3; i++)
        {
            survey.presentQuestion(i);
            System.out.print("Please enter your answer(1-5): ");
            answer = input.nextInt();
            survey.logResponse(survey.getRespondentId(),i ,answer);
        }
        
        survey.generateRespondentId();
        
        for (int i = 0; i < 3; i++)
        {
           survey.presentQuestion(i, survey.getRespondentId());
            System.out.print("Please enter your answer(1-5): ");
            answer = input.nextInt();
            survey.logResponse(survey.getRespondentId(),i ,answer); 
        }
        survey.displaySurveyResults();
        System.out.println();
        survey.topRatedQuestions();
        survey.lowRatedQuestions();
        System.out.println("Top Question: " + survey.getTopRated());
        System.out.println("Lowest Question: " + survey.getLowRated());
        
        
    }//end main
    
    
    
}//end class SurveyTest
