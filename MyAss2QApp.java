import java.util.*;
import java.io.*;
import java.lang.*;
public class MyAss2QApp {
    public static void main(String[] args) throws Exception {
        try{
            BufferedReader br = new BufferedReader (new FileReader ("cakeOrder.txt"));
            PrintWriter pickOut = new PrintWriter (new FileWriter ("pickup.txt"));
            PrintWriter delOut = new PrintWriter (new FileWriter ("delivery.txt"));
            Queue cakeQ=new Queue();
            Queue tempQ=new Queue();
            Cake data;
            
            //a)b)c)read the data from cakeOrder.txt and insert into cakeQ
            String s;
            String custID, cakeType;
            int qty;
            s = br.readLine();
            while (s != null){
                StringTokenizer st = new StringTokenizer(s, "*");
                custID = st.nextToken();
                cakeType = st.nextToken();
                qty = Integer.parseInt(st.nextToken());
                
                data = new Cake(custID, cakeType, qty);
                cakeQ.enqueue(data);
                s = br.readLine();
            }
            
            //d)display the data in the cakeQ
            while(!cakeQ.isEmpty()){
                data = cakeQ.dequeue();
                System.out.println(data.toString());
                tempQ.enqueue(data);
            }
            System.out.println();
            
            //e)Write the data for delivery into delivery.txt output file and the data for customer that choose 
            //self pick up into pickup.txt. 
            pickOut.println("Data for self-pick-up : ");
            delOut.println("Data for delivery : ");
            int countP=1,countD=1;
            while(!tempQ.isEmpty()){
                data = tempQ.dequeue();
                if(data.getID().charAt(0)=='P'){
                    pickOut.println(countP + ") " + data.toString());
                    countP++;
                }
                else if(data.getID().charAt(0)=='D'){
                    delOut.println(countD + ") " + data.toString());
                    countD++;
                }
                cakeQ.enqueue(data);
            }
            
            //f)Display the total quantity order for each cake type and display the cake name of the highest total order
            int countDCC=0,countRV=0,countBCC=0,countBF=0;
            while(!cakeQ.isEmpty()){
                data = cakeQ.dequeue();
                if(data.getCakeType().equalsIgnoreCase("D24 Chocolate Cake")){
                    countDCC = countDCC + data.getQty();
                }
                else if(data.getCakeType().equalsIgnoreCase("Red Velvet")){
                    countRV = countRV + data.getQty();
                }
                else if(data.getCakeType().equalsIgnoreCase("Burnt Cheese Cake")){
                    countBCC = countBCC + data.getQty();
                }
                else if(data.getCakeType().equalsIgnoreCase("Black Forest")){
                    countBF = countBF + data.getQty();
                }
                tempQ.enqueue(data);
            }
            
            System.out.println("Total quantity of D24 Chocolate Cake : " + countDCC);
            System.out.println("Total quantity of Red Velvet : " + countRV);
            System.out.println("Total quantity of Burnt Cheese Cake : " + countBCC);
            System.out.println("Total quantity of Black Forest : " + countBF);
            
            int high = countDCC;
            String text;
            if(countRV > high){
                high = countRV;
                text = "Red Velvet";
            }
            else if(countBCC > high){
                high = countBCC;
                text = "Burnt Cheese Cake";
            }
            else if(countBF > high){
                high = countBF;
                text = "Black Forest";
            }
            else{
                text = "D24 Chocolate Cake";
            }
            
            System.out.println("\nHighest total order is " + high + " for " + text);
            
            //g)Display the receipt for each order.
            int count=1;
            while(!tempQ.isEmpty()){
                data = tempQ.dequeue();
                System.out.println("\n++++++++++++++++++++++++++++++++++ ");
                System.out.println("Customer no " + count);
                System.out.println("++++++++++++++++++++++++++++++++++ ");
                System.out.println("Customer ID : " + data.getID());
                System.out.println("Cake Name : " + data.getCakeType());
                System.out.println("Price : RM " + String.format("%.2f", data.detPrice(data.getCakeType())));
                System.out.println("Quantity : " + data.getQty());
                double payment=0.0;
                payment = data.getQty() * data.detPrice(data.getCakeType());
                if(data.getID().charAt(0)=='P'){
                    System.out.println("Delivery/Self Pick-Up : Self Pick-Up");
                    System.out.println("Payment : RM " + String.format("%.2f", payment));
                }
                else if(data.getID().charAt(0)=='D'){
                    System.out.println("Delivery/Self Pick-Up : Delivery");
                    payment = payment + 5;
                    System.out.println("Payment : RM " + String.format("%.2f", payment));
                }
                count++;
                cakeQ.enqueue(data);
            }
                
            br.close();
            pickOut.close();
            delOut.close();
        }
        catch(Exception e){System.err.println(e.getMessage());}  
    } /***End of main() Method***/   
}/***End of Application Class***/