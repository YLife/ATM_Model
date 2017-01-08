package config;

import interfaces.Dao.CardInfoDao;
import interfaces.Dao.TradeInfoDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import biz.BankBiz;

/**
 * 解析配置文件信息，并通过反射技术动态得到类的实例
 * @author YangLun
 *
 */
public class ApplicationContext {
	//配置文件信息
	private static Map<String, String> config = new HashMap<String, String>();
	
	//读取配置文件信息
	static{
		SAXReader reader = new SAXReader();
		try {
			//tomcat根目录
			String catalina_base = System.getProperty("catalina.base");
			//配置文件applicationConfig.xml的根目录
			String path = catalina_base+"/webapps/bs_bank/WEB-INF/classes/ApplicationConfig.xml";
			Document doc = reader.read(path);
			Element root = doc.getRootElement();
			List<Element> list = root.elements();
			for (Element element : list) {
				config.put(element.attributeValue("id"), element.attributeValue("impl"));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	//以下方法通过反射技术动态得到类的实例
	
	public static BankBiz getBankBiz(){
		String className = config.get("bankBiz");
		try {
			Object obj = Class.forName(className).newInstance();
			return (BankBiz) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static CardInfoDao getCardInfoDao(){
		String className = config.get("cardInfoDao");
		try {
			Object obj = Class.forName(className).newInstance();
			return (CardInfoDao) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static TradeInfoDao getTradeInfoDao(){
		String className = config.get("tradeInfoDao");
		try {
			Object obj = Class.forName(className).newInstance();
			return (TradeInfoDao) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
