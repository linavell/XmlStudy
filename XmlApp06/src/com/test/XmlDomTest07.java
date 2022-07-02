/*====================================================
	XmlDomTest07.java
	- 콘솔 기반 자바 프로그램
	- XML DOM 활용 → 원격(remote) XML 읽어내기
	  (https://fs.jtbc.joins.com/RSS/newsflash.xml)
=====================================================*/

/*

title> JTBC News
link> https://fs.jtbc.joins.com/RSS/newsflash.xml
description> 속보 RSS
copyright> Copyright(C) JTBC All rights reserved.

주요 기사 ------------------------------------------
title> [날씨] 전국 흐리다가 오후부터 차차 갬…서울 낮 기온 27도
description> 목요일인 오늘(16일)은 전국이 대체로 흐리다가 오후부터 차차 갤 것으로 보입니다.오전까지 강원 지역에는 5㎜ 미만의 비가 이어지고 경기 동부와 경북, 충북 일부 지역에도 적은 양의 비가 내리겠습니다.비가 갠
link> https://news.jtbc.joins.com/article/article.aspx?news_id=NB12062697
pubDate> 2022.06.16

title> [날씨] [날씨] 전국 흐리다가 오후부터 차차 갬…서울 낮 기온 27도
description> 목요일인 오늘(16일)은 전국이 대체로 흐리다가 오후부터 차차 갤 것으로 보입니다.오전까지 강원 지역에는 5㎜ 미만의 비가 이어지고 경기 동부와 경북, 충북 일부 지역에도 적은 양의 비가 내리겠습니다.비가 갠
link> https://news.jtbc.joins.com/article/article.aspx?news_id=NB12062697
pubDate> 2022.06.16

 
*/

package com.test;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlDomTest07
{
	public static void main(String[] args)
	{
		
		/*
		1. 원격 XML 정보를 요청하고, 그 결과를 메모리에 로드
		   → XML DOM 구성
		   - DB 활용
		   - DBF 활용
		   - XML 로딩
		 
		2. 루트 엘리먼트 접근
		3. 특정 하위 엘리먼트 접근
		4. 텍스트 노드 접근
		   → 필요한 데이터 획득
		   
		5. 결과 처리(출력)		
		*/
		
		try
		{
			// ※ DOM(Document Object Model)
			//    - XML 이나 HTML Document(문서)를 응용프로그램에서 사용하기 위한 API 규격
			//    - DOM 은 Document(문서)의 각 부분들을 객체(Object)로 표현한 API
			
			/*
			   ※ DOM 파서(Parser)
			      - XML 문서를 읽고, 해석한 후,
			        해석한 결과를 메모리에 DOM 객체 트리 구조로 생성시키는 파서(Parser)
			      - 원하는 데이터에 접근할 수 있도록 해주어
			        검색, 수정, 삭제할 수 있도록 지원
			        
			   ※ 주로 사용되는 DOM 인터페이스
			      - Node
			        : 모든 객체의 부모 인터페이스로서 공통적으로 기능하는 함수를 가진다.
			      - NodeList (NODESET)
			        : 노드들을 리스트로 받아 처리하기 쉽도록 한 것 (일괄 처리)
			      - Document
			        : DOM(Document Object Model) 트리 구조의 최상위 노드로
			          XML 문서 자체를 의미한다.
			      - Element
			        : XML 의 엘리먼트에 해당하는 객체 유형
			      - Attr
			        : XML 의 Attribute 에 해당하는 객체 유형
			      - CharacterData
			        : XML 의 데이터에 해당하는 객체 유형
			      - Text
			        : 문자 데이터(내용)에 해당하는 객체 유형
			*/
			
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document xmlObj = null;
			
			URL url = new URL("https://fs.jtbc.joins.com/RSS/newsflash.xml");
			
			InputSource is = new InputSource(url.openStream());
			xmlObj = builder.parse(is);
			
			Element root = xmlObj.getDocumentElement();
			
			Node channelNode = root.getElementsByTagName("channel").item(0);
			Element channelElement = (Element)channelNode;
			System.out.printf("title> %s%nlink> %s%ndescription> %s%ncopyright> %s%n"
							, XMLDOM.getText(channelElement, "title")
							, XMLDOM.getText(channelElement, "link")
							, XMLDOM.getText(channelElement, "description")
							, XMLDOM.getText(channelElement, "copyright"));
			
			System.out.println("\n주요 기사 -------------------------------------------------------");
			
			NodeList itemNodeList = root.getElementsByTagName("item");
			
			for (int i=0; i<itemNodeList.getLength(); i++)
			{
				Node itemNode = itemNodeList.item(i);
				Element itemElement = (Element)itemNode;
				
				System.out.printf("title> %s%ndescription> %s%nlink> %s%npubDate> %s%n%n"
								, XMLDOM.getText(itemElement, "title")
								, XMLDOM.getText(itemElement, "description")
								, XMLDOM.getText(itemElement, "link")
								, XMLDOM.getText(itemElement, "pubDate"));
			}
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}






















