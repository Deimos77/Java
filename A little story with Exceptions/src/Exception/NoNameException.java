package Exception;

public class NoNameException extends IllegalArgumentException {

    private String name;

    public NoNameException(String problem){
        this.name = problem;
        this.getException();
    }
    public String getException() {
        return name;
    }
}
