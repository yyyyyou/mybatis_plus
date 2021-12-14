package com.yao.test;

/*推导lambda表达式*/
public class Lambda {

    //3.静态内部类
    static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("I like Lambda2!");
        }
    }

    public static void main(String[] args) {
        ILike like = new Like();
        like.lambda();

        Like2 like1 = new Like2();
        like1.lambda();


        //4.局部内部类
        class Like3 implements ILike {
            @Override
            public void lambda() {
                System.out.println("I like Lambda3!");
            }
        }

        Like3 like3 = new Like3();
        like3.lambda();


        //5.匿名内部类,没有类的名称,必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lambda() {
                System.out.println("I like Lambda4!");
            }
        };
        like.lambda();


        //lambda简化
        like = () -> {
            System.out.println("I like Lambda5!");
        };
         like.lambda();
    }

}

//定义一个函数式接口
interface ILike {
    void lambda();
}

//实现类
class Like implements ILike {
    @Override
    public void lambda() {
        System.out.println("I like Lambda!");
    }
}