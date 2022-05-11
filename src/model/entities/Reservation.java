
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Reservation {
    
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        long diff = checkOut.getTime()- checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        
    }
    public String update (Date checkIn,Date checkOut){
        
        Date now = new Date();
            if(checkIn.before(now)||checkOut.before(now)){
                return "Error in reservation: REservation dates for update must be future dates";
                
            }
            if (!checkOut.after(checkIn)){
            return "Error in reservation: Check-out date must be after checck-in date ";
        
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;
    }

    @Override
    public String toString() {
        return "room"
        +roomNumber
        +", check-in: "
        +sdf.format(checkOut)
        +", "
        + duration()
        +" nights";
    }
    
    
}
}
