package utils;

public enum IOEnum {

    DEFAULT_A_FILE_NAME("a.txt"),
    DEFAULT_B_FILE_NAME("b.txt"),
    PATH_MAIN_FOLDER("D:\\\\walterlucas\\Downloads\\Snippets");

    private IOEnum(String propriedade) {
        this.propriedade = propriedade;
    }

    private String propriedade;

    public String getPropriedade() {
        return propriedade;
    }

    public void setPropriedade(String propriedade) {
        this.propriedade = propriedade;
    }
}
