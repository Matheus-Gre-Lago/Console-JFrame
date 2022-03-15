package utils;

public enum DataEnum {
    CARACTERES_NOME("1234567890+/*-{}[]=!@#$%^&*()_=+><,.|"),
    CARACTERES_DATA("1234567890");

    private String caracteres;

    DataEnum(String caracteres) {
        this.caracteres = caracteres;
    }

    public String getCaracteres(){
        return caracteres;
    }
}
