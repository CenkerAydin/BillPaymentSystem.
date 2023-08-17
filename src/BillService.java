import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class BillService {
    private List<Bill> bills;
    private double amount;
    private int billType;
    public BillService(){
        this.bills=new ArrayList<>();
    }

    public  Bill createBill(double amount, Date processDate, int billType,String memberCode){
        Bill bill =new Bill(amount,processDate,billType,memberCode);
        bills.add(bill);
        return bill;
    }

    public Bill readBill(int billId){
        for (Bill bill: bills){
            if (bill.getBillId()==billId){
                return bill;
            }
        }
        return null;
    }
    public void updateBill(Bill bill){
        Bill existingBill=readBill(bill.getBillId());
        if (existingBill !=null){
            System.out.println("Neyi güncellemek istiyorsunuz: \n1:Amount \n2:Bill Type");
            Scanner sc=new Scanner(System.in);
            int choose= sc.nextInt();
            switch (choose){
                case 1:
                    System.out.println("Yeni bir değer giriniz: ");
                    double newAmount=sc.nextDouble();
                    amount=newAmount;
                    break;
                case 2:
                    System.out.println("Yeni bir değer giriniz: ");
                    int newBillType=sc.nextInt();
                    billType=newBillType;
                    break;
            }
        }else {
            System.out.println("Güncellenecek fatura bulunamadı!");
        }
    }

    public void deleteBill(int billId){
        Bill bill=readBill(billId);
        if (bill !=null){
            bills.remove(bill);
            System.out.println("Fatura silindi.");
        }else{
            System.out.println("Fatura bulunamadı!");
        }
    }


    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }
}


