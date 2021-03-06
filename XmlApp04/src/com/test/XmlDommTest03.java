/*===============================================
	XmlDomTest01.java
	- 콘솔 기반 자바 프로그램
	- XML DOM 활용 → 로컬(local) XML 읽어내기
	  (breakfast_menu.xml)
=================================================*/

/*

■[Belgian Waffles]	$5.95	650칼로리
 - Two of our famous Belgian Waffles with plenty of real maple syrup
-------------------------------------------------------------------------
 								: 
 								

*/

package com.test;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlDommTest03
{
	public static void main(String[] args)
	{
		
		
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xmlObj = null;
			
			String url = "breakfast_menu.xml";
			xmlObj = builder.parse(url);
			
			Element root = xmlObj.getDocumentElement();
			
			NodeList foodNodeList = root.getElementsByTagName("food");
			
			//System.out.println(foodNodeList.getLength());
			
			for (int i=0; i<foodNodeList.getLength(); i++)
			{
				Node foodNode = foodNodeList.item(i);
				
				Element foodElement = (Element)foodNode;
				
				System.out.printf("■[%s]	%s	 %s칼로리%n- %s%n"
						+ "--------------------------------------------------------------------------------------------%n"
													, getText(foodElement, "name")
													, getText(foodElement, "price")
													, getText(foodElement, "calories")
													, getText(foodElement, "description"));
			}
			/*
			■[Belgian Waffles]	$5.95	650칼로리
			 - Two of our famous Belgian Waffles with plenty of real maple syrup
			-------------------------------------------------------------------------
			*/
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
	}
	
	
	private static String getText(Element parent, String tagName)
	{
		String result = "";
		
		Node node = parent.getElementsByTagName(tagName).item(0);
		Element element = (Element)node;
		
		result = element.getChildNodes().item(0).getNodeValue();
		
		return result;
	}
}











