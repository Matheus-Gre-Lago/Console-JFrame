package utils;

public enum CalculadoraDeDescontoEnum {
    CARACTERES_VALOR("1234567890");

    private String caracteres;

    CalculadoraDeDescontoEnum(String caracteres) {
        this.caracteres = caracteres;
    }

    public String getCaracteres(){
        return caracteres;
    }
}
