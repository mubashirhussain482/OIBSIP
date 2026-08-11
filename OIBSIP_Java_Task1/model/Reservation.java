package OIBSIP_Java_Task1.model;
import java.sql.Date;
public class Reservation {
    private int pnr;
    private String passengerName;
    private int trainNo;
    private String trainName;
    private String classType;
    private Date journeyDate;
    private String sourceStation;
    private String destinationStation;
    public Reservation(){        
    }
    public Reservation(int pnr, String passengerName, int trainNo, String trainName, String classType,
            Date journeyDate,String sourceStation, String destinationStation){
        this.pnr=pnr;
        this.passengerName=passengerName;
        this.trainNo=trainNo;
        this.trainName=trainName;
        this.classType=classType;
        this.journeyDate=journeyDate;
        this.sourceStation=sourceStation;
        this.destinationStation=destinationStation;
    }
    public int getPnr(){
        return pnr;
    }
    public String getPassengerName(){
        return passengerName;
    }
    public int getTrainNo(){
        return trainNo;
    }
    public String getTrainName(){
        return trainName;
    }
    public String getClassType(){
        return classType;
    }
    public Date getJourneyDate(){
        return journeyDate;
    }
    public String getSourceStation(){
        return sourceStation;
    }
    public String getDestinationStation(){
        return destinationStation;
    }
    
    public void setPnr(int pnr){
        this.pnr=pnr;
    }
    public void setPassengerName(String passengerName){      
        this.passengerName=passengerName;        
    }
    public void setTrainNo(int trainNo){
        this.trainNo=trainNo;        
    }
    public void setTrainName(String trainName){
        this.trainName=trainName;        
    }
    public void setClassType(String classType){
        this.classType=classType;        
    }
    public void setJourneyDate(Date journeyDate){
        this.journeyDate=journeyDate;        
    }
    public void setSourceStation(String sourceStation){
        this.sourceStation=sourceStation;      
    }
    public void setDestinationStation(String destinationStation){
        this.destinationStation=destinationStation;
    }
}
