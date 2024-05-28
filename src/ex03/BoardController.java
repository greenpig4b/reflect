package ex03;

@Controller
public class BoardController {

    @RequestMapping(uri = "/save")
    public void save(){
        System.out.println("글쓰기 호출됨");
    }

}
