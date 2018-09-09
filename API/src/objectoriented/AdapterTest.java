package objectoriented;

public class AdapterTest {

    public static void main(String[] args){
        PowerA powerA = new PowerAImpl();
        work(powerA);
        System.out.println();

        PowerB powerB = new PowerBImpl();
        Adapter adapter = new Adapter(powerB);
        work(powerA);
    }

    public static void work(PowerA a){
        System.out.println("正在连接");
        a.insert();
        System.out.println("工作结束");
    }
}

interface PowerA{
    void insert();
}

interface PowerB{
    void connect();
}

class PowerAImpl implements PowerA{
    public void insert(){
        System.out.println("电源A开始工作");
    }
}

class PowerBImpl implements PowerB{
    public void connect(){
        System.out.println("电源B开始工作");
    }
}

class Adapter implements PowerA{
    private PowerB powerB;

    public Adapter(PowerB powerB) {
        this.powerB = powerB;
    }

    @Override
    public void insert() {
        powerB.connect();
    }
}


