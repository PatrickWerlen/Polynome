import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class PolynomialMap {

    private Map<Integer,Integer> poly = new TreeMap();

    public PolynomialMap(Term term){
        poly.put(term.power, term.coef);
    }

    public PolynomialMap(Term[] terms){
        for(Term term : terms){
            poly.put(term.power, term.coef);
        }
    }

    private PolynomialMap(){}

    public void add(PolynomialMap p) {
        for(Map.Entry<Integer, Integer> entry : p.poly.entrySet()){
            if(poly.containsKey(entry.getKey())){
                poly.put(entry.getKey(), poly.get(entry.getKey()) + entry.getValue());
            }else{
                poly.put(entry.getKey(),entry.getValue());
            }
        }
    }

    public PolynomialMap sum(PolynomialMap p) {
        PolynomialMap tmp = new PolynomialMap();
        tmp.poly.putAll(this.poly);
        tmp.add(p);

        return tmp;
    }

    public PolynomialMap multiply(PolynomialMap p){
       PolynomialMap result = new PolynomialMap();
       for(Map.Entry<Integer,Integer> multiC : this.poly.entrySet()){
           Term multicand = new Term(multiC.getValue(),multiC.getKey());
           for(Map.Entry<Integer,Integer> multiP : p.poly.entrySet()){
               Term multiplyer = new Term(multiP.getValue(),multiP.getKey());
               int coef = multicand.coef*multiplyer.coef;
               int power = multicand.power + multiplyer.power;
               Term term = new Term(coef,power);
               result.add(new PolynomialMap(term));
           }
       }
       return result;
   }

    @Override
    public String toString(){
        StringBuilder sB = new StringBuilder("p(x) = ");
        boolean isFirst = true;
        Map<Integer,Integer> reversed = new TreeMap<>(Collections.reverseOrder());
        reversed.putAll(poly);
        for(Map.Entry<Integer,Integer> entry : reversed.entrySet()){
            Term term = new Term(entry.getValue(), entry.getKey());
            if(isFirst){
                if(term.coef < 0) sB.append("-" + term.toString());
                else sB.append(term.toString());
                isFirst = false;
            }else{
                if(term.coef < 0) sB.append(" - " + term.toString());
                else sB.append(" + " + term.toString());
            }
        }
        return sB.toString();
    }

}
