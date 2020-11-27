package javacode.desmodel.FactoryPattern.simpleFactory;

public class Factory {
    //�����ڹ�����������κ�������Ҫ���߼�
    public static Product create(String str)
    {
        //����ProductA
        if(str.equalsIgnoreCase("ProductA"))
        {
            return new ProductA();
        }
        else
            //����ProductB
            if(str.equalsIgnoreCase("ProductB"))
            {
                return new ProductB();
            }
        return null;
    }
}
