package ru.kpfu.itis.group11408.Miftahutdinova.polynom;

public class Polynom {

    private int n; //размерность
    private double [] polynom;

    public Polynom(double[] a){
     set(a);
    }

    public Polynom(int n){
        set(n);
    }

    public void set(double[] polynom){
        this.n = polynom.length;
        this.polynom = new double[n];
        for(int i = 0; i < n; i++){
            this.polynom[i] = polynom[i];
        }
    }

    public void set(int n, double z){
        this.n = n;
        this.polynom = new double[n];
        for(int i = 0; i < n; i++){
            this.polynom[i] = z;
        }
    }

    public void set(int n){
        set(n, 0);
    }

    public void show(){
        System.out.print("Степень x:\t");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + i + "\t");
        }
            System.out.println(" " + (n - 1));
            System.out.print("Коэффициент: \t");
        for(int i = 0; i < n - 1; i++){
            System.out.print(polynom[i] + "\t");
        }
        System.out.println("\n");
    }

    public Polynom add(Polynom second){
        Polynom first;
        if(n >= second.n) {
            first = new Polynom(this.polynom);
            for (int i = 0; i < second.n; i++) {
                first.polynom[i] += second.polynom[i];
            }
        }else {
            first = new Polynom(this.polynom);
            for (int i = 0; i < n; i++) {
                first.polynom[i] += polynom[i];
            }
        }
        return first;
    }

    public Polynom minus(Polynom second){
        return add(second.multiply(-1));
    }

    public Polynom multiply(double number){
        Polynom second = new Polynom(this.polynom);
        for(int i = 0; i < n; i++){
            this.polynom[i] *= number;
        }
        return second;
    }

    public Polynom multiply(Polynom second){
        int N = second.n + n - 1;
        Polynom temp = new Polynom(N);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < second.n; j++){
                temp.polynom[i] += polynom[i]*second.polynom[i];
            }
        }
        return temp;
    }

    public static void main(String [] args){
        double[] coeffs = new double[]{3, -2, -1, 0, 1};
        Polynom pol = new Polynom(coeffs);
        Polynom pol2 = new Polynom(coeffs);
        pol2.add(pol).show();
        pol2.multiply(pol).show();
        pol2.minus(pol).show();
    }
}
