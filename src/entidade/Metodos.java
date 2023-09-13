package entidade;

public class Metodos {
    double resultado;


    public double calc(double peso, double altura) {

        this.resultado = peso / (altura * altura);
        return this.resultado;
    }

    public String classificarIMC(double resultado) {
        if (resultado <= 18.5) {
            return "Abaixo do normal";
        } else if (resultado <= 24.9) {
            return "Saudável";
        } else if (resultado <= 29.9) {
            return "Sobrepeso";
        } else if (resultado <= 34.9) {
            return "Obesidade grau I";
        } else if (resultado <= 39.9) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }


    public String toString() {
        return "resultado = " + resultado;
    }

}
