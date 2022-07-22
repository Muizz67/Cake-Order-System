/**
 *
 * Group members name and matric number:
 * 1) MUHAMMAD MU'IZZ BIN RUSDI (2020488798) 
 * 2) MUHAMMAD SYAWAL BIN MUHAMMED ROZI (2020826726)
 * 3)
 * Class : CS1103B
 */
import java.lang.*;
public class Cake{
   private String custID; //D001, P003
   private String cakeType; //D24 Chocolate Cake,Red Velvet,Burnt Cheese Cake,Black Forest
   private int qty;
   private double price;
   
   public Cake(String ID,String cakeType, int qty){    
        this.custID=ID;
        this.cakeType=cakeType;
        this.qty=qty;
   }
   
   public void setID(String ID){this.custID=ID;}
   public void setCakeType(String cakeType){this.cakeType=cakeType;}
   public void setQty(int qty){this.qty=qty;}
   
   //2.a)Write the retriever method for custID, cakeType and qty
   public String getID(){return this.custID;}
   public String getCakeType(){return this.cakeType;}
   public int getQty(){return this.qty;}
  
   //2.b)Write the detPrice() method that will return the price of cake based on cakeType.Refer 2_GroupProject.docx
   public double detPrice(String cakeType){
       double price = 0.0;
       if(this.cakeType.equalsIgnoreCase("D24 Chocolate Cake")){
           price = 120;
       }
       else if(this.cakeType.equalsIgnoreCase("Red Velvet")){
           price = 80;
       }
       else if(this.cakeType.equalsIgnoreCase("Burnt Cheese Cake")){
           price = 100;
       }
       else if(this.cakeType.equalsIgnoreCase("Black Forest")){
           price = 80;
       }
       return price;
   }
   
   //2.c)Write the toString method that will return the output look like as below:
   //Customer ID:XXXX    Cake Type:XXXXXXX            Price: RM XX.XX         Quantity:XX
   public String toString(){
       if(cakeType.equalsIgnoreCase("Red Velvet"))
       {
       return ("Customer ID: " +getID()+"\t" + 
               "Cake Type: Red Velvet \t\t" + 
               "Price: RM " + String.format("%.2f", this.detPrice(this.getCakeType())) + "\t\t" + 
               "Quantity: " + getQty());
       }
       
       else if (cakeType.equalsIgnoreCase("D24 Chocolate Cake")){
       return ("Customer ID: " +getID()+"\t" + 
               "Cake Type: D24 Chocolate Cake \t" + 
               "Price: RM " + String.format("%.2f", this.detPrice(this.getCakeType())) + "\t" + 
               "Quantity: " + getQty());
       }
       else if (cakeType.equalsIgnoreCase("Burnt Cheese Cake")){
       return ("Customer ID: " +getID()+"\t" + 
               "Cake Type: Burnt Cheese Cake \t" + 
               "Price: RM " + String.format("%.2f", this.detPrice(this.getCakeType())) + "\t"+ 
               "Quantity: " + getQty());
       }
       else 
       return ("Customer ID: " +getID()+"\t" + 
               "Cake Type: Black Forest \t" + 
               "Price: RM " + String.format("%.2f", this.detPrice(this.getCakeType())) + "\t\t"+ 
               "Quantity: " + getQty());
   }
}
