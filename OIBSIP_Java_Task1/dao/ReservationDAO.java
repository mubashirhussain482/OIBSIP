package OIBSIP_Java_Task1.dao;
import OIBSIP_Java_Task1.database.DBConnection;
import OIBSIP_Java_Task1.model.Reservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ReservationDAO{
    public String getTrainName(int trainNo){
        String sql="SELECT TRAIN_NAME FROM TRAINS WHERE TRAIN_NO = ?";
        try{
            Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,trainNo);

            ResultSet rs=ps.executeQuery();

            if (rs.next()) {
                return rs.getString("TRAIN_NAME");
            }
            rs.close();
            ps.close();
            con.close();
            
            return null;

        }catch(SQLException e){
            System.out.println("Error fetching train name: "+e.getMessage());
            return null;
        }
    }
    public int bookReservation(Reservation reservation){
        String pnrSql = "SELECT PNR_SEQUENCE.NEXTVAL FROM DUAL";
        String insertSql = "INSERT INTO RESERVATIONS "
            + "(PNR, PASSENGER_NAME, TRAIN_NO, TRAIN_NAME, CLASS_TYPE, "
            + "JOURNEY_DATE, SOURCE_STATION, DESTINATION_STATION) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection con=DBConnection.getConnection();
            PreparedStatement pnrPs=con.prepareStatement(pnrSql);
            ResultSet rs=pnrPs.executeQuery()){
            int pnr=0;
            if(rs.next()){
                pnr=rs.getInt(1);
            }
            try(PreparedStatement insertPs=con.prepareStatement(insertSql)){

                insertPs.setInt(1, pnr);
                insertPs.setString(2, reservation.getPassengerName());
                insertPs.setInt(3, reservation.getTrainNo());
                insertPs.setString(4, reservation.getTrainName());
                insertPs.setString(5, reservation.getClassType());
                insertPs.setDate(6, reservation.getJourneyDate());
                insertPs.setString(7, reservation.getSourceStation());
                insertPs.setString(8, reservation.getDestinationStation());

                insertPs.executeUpdate();

                reservation.setPnr(pnr);

                return pnr;
            }
        }catch (SQLException e){
            System.out.println("Booking Error: "+e.getMessage());
            return -1;
        }
    }
    public Reservation getReservation(int pnr){
        String sql="SELECT * FROM RESERVATIONS WHERE PNR = ?";
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,pnr);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Reservation reservation = new Reservation();
                reservation.setPnr(rs.getInt("PNR"));
                reservation.setPassengerName(rs.getString("PASSENGER_NAME"));
                reservation.setTrainNo(rs.getInt("TRAIN_NO"));
                reservation.setTrainName(rs.getString("TRAIN_NAME"));
                reservation.setClassType(rs.getString("CLASS_TYPE"));
                reservation.setJourneyDate(rs.getDate("JOURNEY_DATE"));
                reservation.setSourceStation(rs.getString("SOURCE_STATION"));
                reservation.setDestinationStation(rs.getString("DESTINATION_STATION"));
                return reservation;
            }
            return null;
        }catch(SQLException e){
            System.out.println("Error fetching reservation: "+e.getMessage());
            return null;
        }
    }
    public boolean cancelReservation(int pnr) {
        String sql="DELETE FROM RESERVATIONS WHERE PNR = ?";
        try(Connection con=DBConnection.getConnection();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,pnr);
            int rowsDeleted=ps.executeUpdate();
            return rowsDeleted>0;
        }catch(SQLException e){
            System.out.println("Cancellation Error: "+e.getMessage());
            return false;
        }
    }
}
