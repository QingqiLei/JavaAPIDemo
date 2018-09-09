package objectoriented;

public class ProxyTest {
    public static void main(String[] args) {
        Action userAction = new UserAction();
        ActionProxy proxy = new ActionProxy(userAction);
        proxy.doAction();
    }

}

interface Action {
    void doAction();
}

class UserAction implements Action {

    @Override
    public void doAction() {
        System.out.println("用户开始工作");
    }
}

class ActionProxy implements Action {
    private Action target;

    public ActionProxy(Action target) {
        this.target = target;
    }

    @Override
    public void doAction() {
        long startTime = System.currentTimeMillis();
        target.doAction();
        long endTime = System.currentTimeMillis();
        System.out.println("共耗时 " + (endTime - startTime));
    }
}
