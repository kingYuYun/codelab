package leetcode.dianchu;

public class shengzhengStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("zhishi")) {
            return new xiamengzhishiPizza();
        }
        if (type.equals("sushi")) {
            return new xiamengsushiPizza();
        }
        if (type.equals("geli")){
            return new xiamenggeliPizza();
        }
        if (type.equals("xiangc")){
            return new xiamengxiangcPizza();
        }
        else
            return null;
    }
}
