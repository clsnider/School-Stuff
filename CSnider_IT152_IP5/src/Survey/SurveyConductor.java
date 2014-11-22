/*
 * @author Clayton Snider
 * Created 8/4/2014
 * Allows a user to create 10 survey questions. The survey is then conducted,
asking the 10 questions to 10 users. The results for all respondents are given, 
and then the user is asked if they want to see results to specific questions.
 */
package Survey;

import java.util.Scanner;


public class SurveyConductor {
    
    
    
    public static void main(String[]args)
    {
        //Create scanner and conductor-specific variables
        Scanner input = new Scanner(System.in);
        int answer; //for taking survey responses
        int choice; //for picking options
        //Create Default Survey
        Survey survey = new Survey();
        System.out.println("A new survey has just been created!");
        System.out.println("This survey needs questions.");
        System.out.println("Please provide the necessary questions.");
        //Populate survey with questions
        survey.enterQuestions();
        //While there are less than 10 respondents
        while (survey.getRespondentId() < 11)    
        {//Present Questions
            for(int i = 0; i < 10; i++)
            {
                survey.presentQuestion(i, survey.getRespondentId());
            //Ask user for Answers(1-5)
                
                System.out.print("Please enter your answer(1-5): ");
                answer = input.nextInt();
            //If their answer is between 1 and 5 proceed with survey
                if (answer >=1 && answer <= 5) 
                {
                    survey.logResponse(survey.getRespondentId(), i, answer);
                }
            //If not, ask again for an answer between 1 and 5
                else
                {
                   while (answer <= 0 || answer >= 6)
                   {
                  System.out.print("Please enter your answer(1-5): ");
                  answer = input.nextInt();  
                   }
                   survey.logResponse(survey.getRespondentId(), i, answer);
                }  
               
            }
            //Increment respondent ID upon completion of survey
            survey.generateRespondentId();
        }
        //Dispaly Survey Results
        survey.displaySurveyResults();
        System.out.println();
        System.out.println("Here we have all of the results of the survey.");
        System.out.println("Below are the numbers for the top rated and lowest rated"
                + " questions.");
        //Display Top Rated Question
        survey.topRatedQuestions();
        System.out.println("Top Rated Question: " + survey.getTopRated());
        //Display Lowest Rated Question
        survey.lowRatedQuestions();
        System.out.println("Lowest Rated Question: " + survey.getLowRated());
        //Ask User if they want to see specific questions
        System.out.print("Do you wish to see answers to a question? (1-yes 2-no): ");
        choice = input.nextInt();
            //If they do, display the question's statistics
            while(choice == 1)
            {
                System.out.print("Which question?: ");
                answer = input.nextInt();
                survey.displayQuestionStats(answer);
                System.out.print("Any other Questions? (1-yes 2-no): ");
                choice = input.nextInt();
                
            }
            
            
        System.out.println("Thank you for completing our survey! Good bye!");
            
    }//end main
    
}//end SurveyConductor
