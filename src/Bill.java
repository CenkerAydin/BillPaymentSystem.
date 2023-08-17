import java.util.Date;

public class Bill {
    private double amount;
    private Date processDate;
    private int billType;
    private MemberAccount memberAccount=new MemberAccount(1,"Cenker","Aydın","1CA",100.0);
    private String memberCode;
    private boolean isPaid;
    private int billId;
    private String additionalInfo;

    public Bill(double amount, Date processDate, int billType, String memberCode, String additionalInfo) {
        this.amount = amount;
        this.processDate = processDate;
        this.billType = billType;
        this.memberCode = memberCode;
        this.additionalInfo = additionalInfo;
    }

    public Bill(double amount, Date processDate, int billType, String memberCode) {
        this.amount = amount;
        this.processDate = processDate;
        this.billType = billType;
        this.memberCode = memberCode;
    }

    public Bill(double amount, Date processDate, int billType, MemberAccount memberAccount, boolean isPaid, int billId) {

        this.amount = amount;
        this.processDate = processDate;
        this.billType = billType;
        this.memberAccount = memberAccount;
        this.isPaid = false;
        this.billId = billId;
    }

    public void pay() throws CustomException {
        if (!isPaid) {
            if (balanceIsSufficient()) {
                System.out.println("Fatura başarılı şekilde ödendi: " + amount);
                memberAccount.reduceBalance(amount);
                isPaid = true;
            } else {
               throw new CustomException("Hesap bakiyesi yetersiz. Ödeme başarısız.");
            }
        } else {
            System.out.println("Fatura zaten ödenmiş!");
        }
    }

    public boolean balanceIsSufficient() {
        return memberAccount.getBalance() >= amount;
    }

    public boolean queryPayment() {
        return isPaid;
    }

    public void cancelPayment() {
        if (isPaid) {
            isPaid = false;
            System.out.println("Ödeme iptal edildi.");
        } else {
            System.out.println("Ödeme zaten iptal edilmiş.");
        }
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public int getBillType() {
        return billType;
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    public MemberAccount getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(MemberAccount memberAccount) {
        this.memberAccount = memberAccount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }
}
