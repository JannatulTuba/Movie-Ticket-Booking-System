import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class mvTicketBooking {
    private  final int totalSeat=240;
    private int revTotal=0;
    String [] aName = new String[250];
    String [] aPrice = new String[250];
    int user=0;

    BufferedReader buff =null;
    FileOutputStream file = null;


    public mvTicketBooking() {
        readBookingInput();
    }

    public int numberOfVacant(){
        int vacant=totalSeat-user;
        return vacant;
    }

    ////////// file write Booking input//////////////////

    public void nameAndPriceWrite (String name ,String price){
        try{
            file=new FileOutputStream("src/customerName1.txt",true);
            file.write(name.getBytes());
            file.write("\n".getBytes());
            file.close();
            file=new FileOutputStream("src/revenue1.txt",true);
            file.write(price.getBytes());
            file.write("\n".getBytes());
            file.close();
        }catch(Exception e){

        }

    }
    //////////////////// total revenue  ////////////////////////

    public int totalRevenue(){
        try{
            buff =new BufferedReader(new FileReader("src/revenue1.txt"));
            String i;
            while( (i= buff.readLine())!=null){
                revTotal=revTotal +Integer.parseInt(i);
            }
        }catch(Exception e){

        }
        return revTotal;


    }

    //////////////////////read booking input///////////////////////////////////

    public void readBookingInput() {
        try{
            buff =new BufferedReader(new FileReader("src/customerName1.txt"));
            String s;
            int index=0;
            while((s=buff.readLine())!=null){
                aName[index] = s;
                index++;
                //System.out.println("Loop " + arrName[index-1]);
            }
        }catch(Exception e){
        }

        try{
            buff =new BufferedReader(new FileReader("src/revenue1.txt"));
            String s;
            int index=0;
            while((s=buff.readLine())!=null){
                aPrice[index]=s;
                index++;
                user=index;
            }
        }catch(Exception e){
        }

    }

    ///////////////////reservations/////////////////////////////////

    public void delete (int seatNo){
        try{
            int userTemp=user;
            file=new FileOutputStream("src/customerName1.txt");
            for(int i=0;i<userTemp;i++) {
                if (seatNo==(i+1)) {
                    continue;
                }
                else {
                    file.write(aName[i].getBytes());
                    file.write("\n".getBytes());
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }

        try{
            int userTemp=user;
            file=new FileOutputStream("src/revenue1.txt");
            for(int i=0;i<userTemp;i++) {
                if (seatNo==(i+1)) {
                    continue;
                }
                else {
                    file.write(aPrice[i].getBytes());
                    file.write("\n".getBytes());
                }
            }
            if(user!=userTemp)
                user--;

        }catch(Exception e){
            System.out.println(e);
        }


    }

    public int getTotalSeat() {
        return totalSeat;
    }

}