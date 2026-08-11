class Question{
    private String questionText;
    private String[] options;
    private int correctAnswer;
    private int selectedAnswer;
    
    Question(String question,String[] options,int correctAnswer){
    if(options.length!=4){
        throw new IllegalArgumentException("A question must have exactly 4 options.");
    }
    if(correctAnswer<0||correctAnswer>3){
        throw new IllegalArgumentException("Correct answer must be between 0 and 3.");
    }
        this.questionText=question;
        this.options=options;
        this.correctAnswer=correctAnswer;
        this.selectedAnswer=-1;
    }
    public String getQuestionText(){
        return questionText;
    }
    public String[] getOptions(){
        return options;
    }
    public int getCorrectAnswer(){
        return correctAnswer;
    }
    public int getSelectedAnswer(){
        return selectedAnswer;
    }
    public void setSelectedAnswer(int selectedAnswer){
        this.selectedAnswer=selectedAnswer;
    }
    public boolean isCorrect(){
        return this.selectedAnswer==this.correctAnswer;
    }
}
