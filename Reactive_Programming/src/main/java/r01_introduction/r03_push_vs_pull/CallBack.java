package r01_introduction.r03_push_vs_pull;

public interface CallBack {

    void pushData(String data);

    void pushComplete();

    void pushError(Exception e);
}
