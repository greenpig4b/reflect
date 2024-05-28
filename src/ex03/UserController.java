package ex03;

// 단점 : 하나바꾸면 계속 연락해서 수정요청해야함
@Controller
public class UserController {

    @RequestMapping(uri = "/update")
    public void update(){
        System.out.println("update() 호출됨");
    }

    @RequestMapping(uri = "/userinfo")
    public void userinfo(){
        System.out.println("userinfo() 호출됨");
    }

    @RequestMapping(uri = "/login")
    public void login(){
        System.out.println("login() 호출됨");
    }

    @RequestMapping(uri = "/join")
    public void join(){
        System.out.println("join() 호출됨");
    }


}