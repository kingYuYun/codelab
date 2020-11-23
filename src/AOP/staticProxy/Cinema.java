package AOP.staticProxy;

public class Cinema implements Movie{
    RealMovie movie;
    public Cinema(RealMovie movie){
        super();
        this.movie=movie;
    }

    @Override
    public void play() {
        guanggao(true);
        movie.play();
        guanggao(false);
    }

    public void guanggao(boolean isStart){
        if ( isStart ) {
            System.out.println("��Ӱ���Ͽ�ʼ�ˣ����׻������֡�������9.8�ۣ������򰡣�");
        } else {
            System.out.println("��Ӱ���Ͻ����ˣ����׻������֡�������9.8�ۣ���ؼҳ԰ɣ�");
        }
    }
}
