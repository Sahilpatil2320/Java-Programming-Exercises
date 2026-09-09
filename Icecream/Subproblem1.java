class IceCream{
   protected String flavor;
   protected int quantity;
   protected double unitPrice;

  public IceCream( String flavor,int quantity,double unitPrice){
      this.flavor=flavor;
      this.quantity=quantity;
      this.unitPrice=unitPrice;
   }
 
  public void display(){
    System.out.println(" Flavor : " + flavor + ", Quantity : " + quantity + ", UnitPrice " + unitPrice);
    }
}

 interface IceCreamItem{
   double calculateCost();
   String getDetails(); 
 }

 class Cup extends IceCream implements IceCreamItem{
    public Cup(String flavor,int quantity,double unitPrice){
       super(flavor,quantity,unitPrice);
      }
     public double calculateCost(){
        return quantity * unitPrice;
      }
    public String getDetails(){
        return " Cup|Flavor: " + flavor + " |Qty: " + quantity + " |Unit Price: $ " + unitPrice;
    }
}

class Candy extends IceCream implements IceCreamItem{
   public Candy(String flavor,int quantity,double unitPrice){
     super(flavor,quantity,unitPrice);
   }

public double calculateCost(){
  return quantity * unitPrice;
}
 public String getDetails(){
  return "Candy|Flavor:"+flavor+"|Qty:"+quantity+"|Unit Price:$"+unitPrice;
  }
}

public class Subproblem1{
  public static void main(String args[]){
   Cup cu=new Cup(" Mango ", 2 , 3.5);
   cu.display();
   System.out.println(" IceCreamItem: "+cu.getDetails());
   Candy cy=new Candy(" Chocolate ", 1 , 1.5);
   cy.display();
   System.out.println(" IceCreamItem: " + cy.getDetails());

  double totalBill = cu.calculateCost() + cy.calculateCost();
        System.out.println(" Total Bill: $" + totalBill);
  }
}
