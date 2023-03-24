package info.honzan.tool.har2xsv;

public class Main {

  public static void main(String... args) {

    Har2Xsv Har2Xsv = new Har2Xsv(args[0], "\t", true); // TODO Make separater and headerflg configurable with arguments

    try {
      Har2Xsv.write();
    } catch (Exception e) {
      System.err.println("!!!!!!!!!! error occurd. !!!!!!!!!!");
      e.printStackTrace();
    }

  }

}

