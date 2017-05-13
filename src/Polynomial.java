import java.util.LinkedList;

public class Polynomial {

    private LinkedList<Term> poly = new LinkedList();

    //create polynomial from an array of terms
    public Polynomial(Term[] terms){
        for(int i = 0; i < terms.length; i++){
            poly.add(i, terms[i]);
        }
    }

    //create a polynomial out of a single term (can be added later together with others)
    public Polynomial(Term term){
        poly.add(term);
    }

    //creates an empty poly (needed for multiply())
    private Polynomial(){}

    //adds two polynomial together
    public void add(Polynomial p) {
        for (Term in : p.poly) {
            int index = 0;
            boolean added = false;
            if (poly.isEmpty()) {
                poly.add(index, in);
                added = true;
            }
            while (!added) {
                //addition of coef, when power is equal
                if (this.poly.get(index).power == in.power) {
                    this.poly.get(index).coef += in.coef;
                    added = true;
                }
                //add to list if power is bigger
                else if (this.poly.get(index).power < in.power) {
                    this.poly.add(index, in);
                    added = true;
                }
                //inc index if power is smaller
                else if (this.poly.get(index).power > in.power) {
                    if (index + 1 == this.poly.size()) {
                        poly.add((index + 1), in);
                        added = true;
                    } else index++;
                }
            }
        }
    }

    public Polynomial sum(Polynomial p){
        System.out.println("Before: " + this.poly);
        Polynomial tmp = new Polynomial();
        /*IMPORTANT needs to be done like this so that the
        original termsvalues (@specificAdress) wont be changed in the
        further process. NO .putAll(this.poly) ALLOWED!
         */
        for(Term term : this.poly){
            int coef = term.coef;
            int power = term.power;
            tmp.poly.add(new Term(coef, power));
        }
        tmp.add(p);

        System.out.println("After: " + this.poly);
        return tmp;
    }

    public Polynomial multiply(Polynomial p){
        Polynomial result = new Polynomial();
        for(Term multicand : this.poly){
            for(Term multiplyer : p.poly){
                int coef = multicand.coef*multiplyer.coef;
                int power = multicand.power + multiplyer.power;
                Term term = new Term(coef,power);
                result.add(new Polynomial(term));
            }
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder sB = new StringBuilder("p(x) = ");
        boolean isFirst = true;
        for(Term term : this.poly){
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
