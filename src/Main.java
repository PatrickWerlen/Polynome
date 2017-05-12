public class Main {

    public static void main(String[] args) {

        //creating terms for 2 polynomials
        Term[] terms = new Term[3];
        terms[0] = new Term(5,10);
        terms[1] = new Term(3,2);
        terms[2] = new Term(10,0);

        Term[] terms1 = new Term[3];
        terms1[0] = new Term(10,7);
        terms1[1] = new Term(26,1);
        terms1[2] = new Term(-25,0);

        //using TreeMap
        PolynomialMap polyM0 = new PolynomialMap(terms);
        PolynomialMap polyM1 = new PolynomialMap(terms1);
        PolynomialMap sumM = polyM0.sum(polyM1);
        PolynomialMap resultM = polyM0.multiply(polyM1);

        System.out.println("This calculations were made with a TreeMap:\n" +
                polyM0.toString() + "\n" +
                polyM1.toString() + "\n" +
                "The sum of these polynomials are\t" + sumM.toString() + "\n" +
                "The product of these polynomials is:\t" + resultM.toString() + "\n");

        System.out.println("***--------------------------------------------------------------------------------------------***\n");

        //using LinkedList
        Polynomial poly0 = new Polynomial(terms);
        Polynomial poly1 = new Polynomial(terms1);
        Polynomial sum = poly0.sum(poly1);
        Polynomial result = poly0.multiply(poly1);

        System.out.println("This calculations were made with a TreeMap:\n" +
                polyM0.toString() + "\n" +
                polyM1.toString() + "\n" +
                "The sum of these polynomials are\t" + sum.toString() + "\n" +
                "The product of these polynomials is:\t" + result.toString() + "\n\n");

    }
}
