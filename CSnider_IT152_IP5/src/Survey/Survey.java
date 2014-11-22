/*
 *Class Name: Survey
 * @author Clayton Snider
 * Created 7/12/2014
 *Defines a survey to be delivered by the Survey Conductor class. Contains the 
 *necessary arrays to store survey questions as well as responses, as well as 
 *methods for displaying survey results. These results will be called by the 
 *Survey Conductor class.
 */
package Survey;

import java.util.Scanner;


public class Survey {
    //Declare variables
    private static int respondentID;
    private String title;
    
    //declare array to hold survey questions
    String questions[] = new String[10];
    
    //two dimensional array
    //x-axis: question number
    //y-axis: respondent ID
    int answers[][]= new int [10][10];
    
    //variables to store top-rated and lowest-rated questions
    private int topRated;
    private int lowRated;
    
    //Constructors
    //
    public Survey()
    {
       title = "Customer Survey";
       this.generateRespondentId();
    }
    
    public Survey(String initTitle)
    {
        
        title = initTitle;
        respondentID = 0;
    }
    
    public void setTitle(String initTitle)
    {
        this.title = initTitle;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public int generateRespondentId()
    {
        respondentID++;
        return respondentID;
    }
    
    public int getRespondentId()
    {
        return respondentID;
    }
    
    public int getTopRated()
    {
        return topRated;
    }
    
    public int getLowRated()
    {
        return lowRated;
    }
    public void displaySurveyResults()
    {
        System.out.print("Survey Title: " + title);
        for (int i=0; i<10; i++)
        {
            int questionNum = i + 1;
            System.out.print("\nQuestion " + questionNum + ": ");
            
            for (int j=0; j<10; j++)
            {
              System.out.print (answers[i][j] + "\t"); 
            }
        }
        System.out.println();
    }
    
    public void logResponse(int respID, int qNum, int response)
    {
        respID = respID-1;
      answers[qNum][respID] = response;
    }
    
    public void displayQuestionStats(int questNum)
    {
        //array starts at 0, so we need to get the appropriate value
        //subtract 1 from the given value to give the right question
        int questionNum = questNum - 1;  
        System.out.println(questions[questionNum]);
        System.out.print("Answers: ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(answers[questionNum][i]+ "\t");
        }
        System.out.println();
        
    }
    
    public void enterQuestions()
    {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i<10; i++)
        {
            System.out.print("Please enter a question: ");
            this.questions[i] = scanner.nextLine();
        }
    }
    
    public int topRatedQuestions()
    {
        int total=0; //will increment with each answer that's over 3
        int answer; //stores value from answer array
        int answerTotal = 0; //will store a value to be compared against total (the higher total becomes answerTotal)
        int questionNum = 0;    //holds the question number to be incremented into topRated
        
        for(int i = 0; i < 3; i++) //loop through questions
        {
            for (int j = 0; j < 3; j++) //loop through answers
            {
                answer = answers[i][j];
                if (answer > 3)
                {
                    total++;    //increment total if answer is greater than 3
                }
            }
            if (total > answerTotal)
            {
                answerTotal = total;
                questionNum = i;
            }
        }
        
        topRated = questionNum + 1;
        return topRated;
    }
    
    public int lowRatedQuestions()
    {
       int total=0; //will increment with each answer that's below 3
        int answer; //stores value from answer array
        int answerTotal = 0; //will store a value to be compared against total (the higher total becomes answerTotal)
        int questionNum = 0;    //holds the question number to be incremented into topRated
        
        for(int i = 0; i < 3; i++) //loop through questions
        {
            for (int j = 0; j < 3; j++) //loop through answers
            {
                answer = answers[i][j];
                if (answer < 3)
                {
                    total++;    //increment total if answer is less than 3
                }
            }
            if (total > answerTotal)
            {
                answerTotal = total;
                questionNum = i;
            }
        }
        
        lowRated = questionNum + 1;
        return lowRated;
    }
    
    public void presentQuestion(int qNum)
    {
        int questionNum = qNum + 1;
        System.out.println("Question " + questionNum + ": " + questions[qNum]);
    }
    
    public void presentQuestion(int qNum, int respID)
    {
        int questionNum = qNum + 1;
        System.out.println("Respondent " + respID + ", please answer question "
                + questionNum + ": " + questions[qNum]);
    }
}
