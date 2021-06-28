package crafting;

public class Receiver extends Crafter{

    void checkEnv(){
        Recipe cfted=null;

        for (var r : rcps){
            if(r.craftAble(inv)){
                r.craft(inv);
                cfted  = r;
                
            }
        }
        if(cfted!=null){rcps.remove(cfted);checkEnv();}

    }
}
