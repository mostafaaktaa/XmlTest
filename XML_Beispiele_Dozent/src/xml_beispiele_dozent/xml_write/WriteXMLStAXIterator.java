package xml_beispiele_dozent.xml_write;

import java.io.OutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

public class WriteXMLStAXIterator {
	public static void writeXML(OutputStream out) throws XMLStreamException {
		XMLOutputFactory output = XMLOutputFactory.newInstance();
		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		
		XMLEventWriter writer = output.createXMLEventWriter(out, "UTF-8");
		
		writer.add(eventFactory.createStartDocument());
		
		writer.add(eventFactory.createStartElement("", "", "Company"));
		
		writer.add(eventFactory.createStartElement("", "", "Staff"));
		writer.add(eventFactory.createAttribute("id", "1001"));
		writer.add(eventFactory.createStartElement("", "", "Name"));
		writer.add(eventFactory.createCharacters("Schirmer"));
		writer.add(eventFactory.createEndElement("", "", "Name"));
		writer.add(eventFactory.createEndElement("", "", "Staff"));
		
		writer.add(eventFactory.createStartElement("", "", "Staff"));
		writer.add(eventFactory.createAttribute("id", "1002"));
		writer.add(eventFactory.createStartElement("", "", "Name"));
		writer.add(eventFactory.createCharacters("Müller"));
		writer.add(eventFactory.createEndElement("", "", "Name"));
		writer.add(eventFactory.createEndElement("", "", "Staff"));
		
		writer.add(eventFactory.createStartElement("", "", "Staff"));
		writer.add(eventFactory.createAttribute("id", "1003"));
		writer.add(eventFactory.createStartElement("", "", "Name"));
		writer.add(eventFactory.createCharacters("Schmidt"));
		writer.add(eventFactory.createEndElement("", "", "Name"));
		writer.add(eventFactory.createEndElement("", "", "Staff"));
		
		writer.add(eventFactory.createEndDocument());
		
		writer.flush();
		writer.close();
	}
}
