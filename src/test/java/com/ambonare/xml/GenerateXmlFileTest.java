package com.ambonare.xml;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.ParserConfigurationException;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;





public class GenerateXmlFileTest {
   private Document doc;
   
   public static void main(String [] args){
	   GenerateXmlFileTest s = new GenerateXmlFileTest();
	   try {
		s.init();
		s.createXml("ss", "ss", "ss");
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   
   
   public void init() throws ParserConfigurationException{
	   doc = DocumentHelper.createDocument(); 
   }
   
   public void createXml(String fName,String mName,String lName) throws IOException{
	   Element root  =  doc.addElement("TCEQForm");
	   Element name = root.addElement("name");
	   Element firstname = name.addElement("firstName");
	   Element middleName = name.addElement("MiddleName");
	   Element lastName = name.addElement("LastName");
	   firstname.setText(fName);
	   middleName.setText(mName);
	   lastName.setText(lName);
	   
	   OutputFormat of = new OutputFormat();
	   of.setEncoding("utf-8");
	   of.setNewlines(true);
	   of.setIndent(true);
	   of.setIndent("    ");
	   
	   StringWriter fw = new StringWriter();
	   XMLWriter xmlw = new XMLWriter(fw,of);
	   xmlw.write(doc);
	   System.out.println(fw.toString());
	   xmlw.close();
   }
}
