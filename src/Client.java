import java.util.Date;
import java.util.Scanner;

public class Client extends BillService {

    public Bill createBill(double amount, Date processDate, int billType, String memberCode) {
        Bill newBill = new Bill(amount, processDate, billType, memberCode);
        return newBill;
    }

    public void payBillPhone(int billType, String memberCode, double amount, Date processDate) throws CustomException {
        Bill bill = createBill(amount, processDate, billType, memberCode);
        if (bill != null) {
            bill.pay();
        }
    }

    public void payBillInternet(int billType, String memberCode) throws CustomException {
        Bill bill = createBill(0.0, null, billType, memberCode);
        if (bill != null) {
            bill.pay();
        }
    }
}

