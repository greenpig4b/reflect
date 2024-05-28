package ex02;
// 단점 : 하나바꾸면 계속 연락해서 수정요청해야함
public class UserController {
    @RequestMapping(uri = "/login")
    public void login() {
        System.out.println("login");
    }

    @RequestMapping(uri = "/join")
    public void join(){
        System.out.println("join");
    }

    @RequestMapping(uri = "/userInfo")
    public void userInfo(){
        System.out.println("userInfo");
    }
}
