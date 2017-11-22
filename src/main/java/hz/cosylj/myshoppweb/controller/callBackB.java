package hz.cosylj.myshoppweb.controller;

/**
 * Created by cosy on 2017/10/13.
 */
public class callBackB {

    public void answer(callBackA callBackA){
        System.out.print("=====================what is your name.....");

        callBackA.answ(this);


    }


    public void sayHello(){
        System.out.print("===================how do you do");

    }
}
