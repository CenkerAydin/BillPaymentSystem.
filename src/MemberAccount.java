public class MemberAccount {
    private int id;
    private String name;
    private String surname;
    private String code;
    private double balance;

    public MemberAccount(int id, String name, String surname, String code, double balance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.code = code;
        this.balance = balance;
    }
    public void showMemberInfo(){
        System.out.println("ID: "+this.getId());
        System.out.println("Name: "+this.getName());
        System.out.println("Surname: "+this.getSurname());
        System.out.println("Code: "+this.getCode());
        System.out.println("Balance: "+this.getBalance());
    }

    public void reduceBalance(double amount){
        if (balance >=amount){
            balance -=amount;
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
