package Parsers;

import Entities.Recipe;
import Entities.Staff;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class StAXParsers {
    private static String path = "D:\\Disk_D\\VTPart2\\DataBase\\";

    private static Staff staff = null;
    private static Recipe recipe = null;
    private static ObservableList<Recipe> recipesList = FXCollections.observableArrayList();
    private static ObservableList<Staff> staffList = FXCollections.observableArrayList();

    public static ObservableList<Recipe> receiptsParse(){
        boolean id = false;
        boolean recDishName = false;
        boolean recProductName = false;
        boolean amount = false;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(path + "RecipeXML.xml"));

            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch(event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("RECIPE")) {
                            recipe = new Recipe(0, "", "", 0);
                        } else if (qName.equalsIgnoreCase("ID")) {
                            id = true;
                        } else if (qName.equalsIgnoreCase("DISHNAME")) {
                            recDishName = true;
                        } else if (qName.equalsIgnoreCase("PRODUCTNAME")) {
                            recProductName = true;
                        }
                        else if (qName.equalsIgnoreCase("AMOUNT")) {
                            amount = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(id) {
                            recipe.setId(Integer.parseInt(characters.getData()));
                            id = false;
                        }
                        if(recDishName) {
                            recipe.setDishName(characters.getData());
                            recDishName = false;
                        }
                        if(recProductName) {
                            recipe.setProductName(characters.getData());
                            recProductName = false;
                        }
                        if(amount) {
                            recipe.setAmount(Integer.parseInt(characters.getData()));
                            amount = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if(endElement.getName().getLocalPart().equalsIgnoreCase("RECIPE")) {
                            recipesList.add(recipe);
                        }
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return recipesList;
    }

    public static ObservableList<Staff> staffParse(){
        boolean id = false;
        boolean name = false;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(new FileReader(path + "StaffXML.xml"));

            while(eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();

                switch(event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("PERSON")) {
                            staff = new Staff(0, "");
                        } else if (qName.equalsIgnoreCase("ID")) {
                            id = true;
                        } else if (qName.equalsIgnoreCase("NAME")) {
                            name = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(id) {
                            staff.setId(Integer.parseInt(characters.getData()));
                            id = false;
                        }
                        if(name) {
                            staff.setName(characters.getData());
                            name = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();

                        if(endElement.getName().getLocalPart().equalsIgnoreCase("PERSON")) {
                            staffList.add(staff);
                        }
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return staffList;
    }
}
