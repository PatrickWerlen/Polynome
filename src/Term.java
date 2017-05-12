import static java.lang.Math.abs;

public class Term{
    int coef;
    int power;

    public Term(int coef, int power){
        this.coef = coef;
        this.power = power;
    }

    @Override
    public String toString(){
        if(power == 0) return String.valueOf(abs(coef));
        else if(power == 1){
            if(coef == 1 || coef == -1) return "x";
            else return abs(coef) + "x";
        }
        else return abs(coef) +"x^"+power;
    }

}