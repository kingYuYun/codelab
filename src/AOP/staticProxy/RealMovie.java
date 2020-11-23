package AOP.staticProxy;

public class RealMovie implements Movie{

    @Override
    public void play() {
        System.out.println("watch tv");
    }
}
