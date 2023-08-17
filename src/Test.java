import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ParseException {
        Scanner sc=new Scanner(System.in);
        System.out.println("FATURA ÖDEME SİSTEMİNE HOŞ GELDİNİZ!");
        MemberAccount memberAccount=new MemberAccount(1,"Cenker","Aydın","1CA",100.0);
        memberAccount.showMemberInfo();

        BillService billService=new Client();
        System.out.println("Fatura tipini girin (1-Telefon, 2-Internet, 3-Su): ");
        int faturaType = sc.nextInt();

        sc.nextLine();

        System.out.println("Üye kodunu girin: ");
        String memberCode = sc.nextLine();

        System.out.println("Ödeme miktarını girin: ");
        double amount = sc.nextDouble();

        System.out.println("Fatura tarihini girin (GG.AA.YYYY): ");
        String dateStr = sc.next();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd.MM.yyyy");
        Date processDate=dateFormat.parse(dateStr);

        Bill  bill = billService.createBill(amount, processDate, faturaType, memberCode);

        if (bill !=null){
            try {
                bill.pay();
            }catch (CustomException e){
                System.out.println("Hata: "+e.getMessage());
            }
        }
        sc.close();
    }
}
