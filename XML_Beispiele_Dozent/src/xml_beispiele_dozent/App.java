package xml_beispiele_dozent;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;


import xml_beispiele_dozent.xml_write.WriteXMLStAXCursor;
import xml_beispiele_dozent.xml_write.WriteXMLStAXIterator;

public class App {
	public static void main(String[] args) {
		
		
		
		
		try {
//			FileOutputStream out = new FileOutputStream("resources/STAXCursor.xml");
//			WriteXMLStAXCursor.writeXML(out);
		    prettyPrintXML();
//			WriteXMLStAXIterator.writeXML(new FileOutputStream("resources/STAXIterator.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
	public static void prettyPrintXML() throws XMLStreamException, TransformerException, IOException {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		WriteXMLStAXCursor.writeXML(out);
		
		String xml = new String(out.toByteArray(), StandardCharsets.UTF_8);
		
		String prettyXML = WriteXMLStAXCursor.formatXML(xml);
		
		Files.writeString(Paths.get("resources/STAXCursorPretty.xml"), prettyXML, StandardCharsets.UTF_8);
	}

}


//Her Schirmer : prettyPrintXML(); funktioniert nicht bei mir , könnten Sie bitte helfen ? bisher kann ich nicht eine Lösung finden, 
