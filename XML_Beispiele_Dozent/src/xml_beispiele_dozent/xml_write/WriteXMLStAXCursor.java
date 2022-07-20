package xml_beispiele_dozent.xml_write;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import xml_beispiele_dozent.Antwort;
import xml_beispiele_dozent.Frage;
import xml_beispiele_dozent.Stufe;

public class WriteXMLStAXCursor {
	
	public static ArrayList<Frage> fragen= new ArrayList<Frage>();
	public static Frage f;
	public static Antwort[] antworten;
	public static Stufe s;
	
	public static void init()
	{
		
		 antworten = new Antwort[4];
		antworten[0] = new Antwort("Ja");
		antworten[1] = new Antwort("Nein");
		antworten[2] = new Antwort("Niemals");
		antworten[3] = new Antwort("Möglich");
		
		
		for (int i = 0; i < 10; i++) {
			s=new Stufe(i%15,false,500);
			f=new Frage(s, "Frage Nummer " + i, antworten,1);
			fragen.add(f);
		}
	}
	
	public static String formatXML(String xml) throws TransformerException {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		init();
		// Pretty Print by Indention (Einrückung)
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		
		// Line-Break before Root-Element
		transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
		
		StreamSource source = new StreamSource(new StringReader(xml));
		StringWriter output = new StringWriter();
		transformer.transform(source, new StreamResult(output));
		
		return output.toString();
	}

	public static void writeXML(FileOutputStream out) throws XMLStreamException {
		// TODO Auto-generated method stub
        XMLOutputFactory output = XMLOutputFactory.newInstance();
		
		XMLStreamWriter writer = output.createXMLStreamWriter(out, "UTF-8");
		
		writer.writeStartDocument("utf-8", "1.0");
		
		writer.writeStartElement("QuizMasterFragen");
		init();
		
	//for (int i = 0; i < fragen.size(); i++) {
			
			writer.writeStartElement("FrageField");
		
			//writer.writeAttribute("Stuffe", "1");			
			writer.writeStartElement("Frage");
			// hier die Frage
			writer.writeCharacters(fragen.get(1).getFrage());
			// end Frage
			writer.writeEndElement();
			//start Antworten
			writer.writeStartElement("Antworten");
			
			
			writer.writeStartElement("Antwort1");		
			writer.writeEndElement();
			
			writer.writeStartElement("Antwort2");		
			writer.writeEndElement();
			
			writer.writeStartElement("Antwort3");		
			writer.writeEndElement();
			
			writer.writeStartElement("Antwort4");		
			writer.writeEndElement();
			
			
			writer.writeEndElement();
			
			//end Antworten
			writer.writeEndElement();
			//End Frage Field
			writer.writeEndElement();
			
//	}		
		
	
		
		writer.writeEndDocument();
		
		writer.flush();
		
		writer.close();
	}

	public static void writeXML(ByteArrayOutputStream out) throws XMLStreamException {
		// TODO Auto-generated method stub

		init();
	    XMLOutputFactory output = XMLOutputFactory.newInstance();
		
			XMLStreamWriter writer = output.createXMLStreamWriter(out, "UTF-8");
			
			writer.writeStartDocument("utf-8", "1.0");
			
			
			
	for (int i = 0; i < fragen.size(); i++) {
				
				writer.writeStartElement("FrageField");
			
				//writer.writeAttribute("Stuffe", "1");			
				writer.writeStartElement("Frage");
				// hier die Frage
				writer.writeCharacters(fragen.get(1).getFrage().toString());
				// end Frage
				writer.writeEndElement();
				//start Antworten
				writer.writeStartElement("Antworten");
				
				
				writer.writeStartElement("Antwort1");		
				writer.writeEndElement();
				
				writer.writeStartElement("Antwort2");		
				writer.writeEndElement();
				
				writer.writeStartElement("Antwort3");		
				writer.writeEndElement();
				
				writer.writeStartElement("Antwort4");		
				writer.writeEndElement();
				
				
				writer.writeEndElement();
				
				//end Antworten
				writer.writeEndElement();
				//End Frage Field
				
				
	}		
			
		
			
			
			
			writer.flush();
			
			writer.close();
	}

//
}
