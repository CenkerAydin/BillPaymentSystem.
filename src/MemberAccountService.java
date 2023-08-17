

public  abstract  class MemberAccountService {
    public abstract MemberAccount createAccount(int id,String name,String surname,String code,Double balance);

    public abstract MemberAccount readAccount(String memberCode);
    public abstract MemberAccount updateAccount(int id,String name,String surname,String code,Double balance);
    public abstract MemberAccount deleteAccount(int id,String name,String surname,String code,Double balance);

}
