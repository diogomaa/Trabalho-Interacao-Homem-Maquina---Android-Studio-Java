package andrecastro.burguerall.app.burgerall;

public class LoginTest extends MainActivity{

    boolean login;

    public LoginTest(){
        this.login = false;
    }

    public void setLoginTrue() {
        this.login = true;
    }

    public void setLoginFalse() {
        this.login = false;
    }

    public boolean getLoginEstado() {
        return this.login;
    }

}
