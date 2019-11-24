import Parsers.DOMParser;

public class MainServlet {
    private static DOMParser parser = new DOMParser();

    public static void main(String[] args){
        parser.loadProductXMLFile();
        parser.loadDishesXMLFile();
    }
}
