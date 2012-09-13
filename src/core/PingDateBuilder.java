/**
 * 
 * This file is part of Jms.publisher sample.
 * 
 *  Jms.publisher is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 * 
 *  Jms.publisher is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with Jms.publisher.  If not, see <http://www.gnu.org/licenses/>.
 *  
 * 
 * PingDateBuilder.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package core;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Sample class that build a simple ping message. 
 * The message can build dynamically and can read from xml file.
 *
 */
public class PingDateBuilder extends MessageBuilder 
{
	private final String fileName = "xml/PingMessage.xml";

	public PingDateBuilder() {
		FillData();
	}
	
	@Override
	protected void initialize() 
	{
		// COMMENT: Sample for override contentName property (TagName in xml node) 
		this.contentName = "systemDate";
		super.initialize();
	}
	
	private void FillData()
	{
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss Z");
		
		header.addAttribute("type", "DATE");
		header.addAttribute("appId", "f87d16f0-f2c4-4583-9847-56aa5c872fd9");
						
		content.addAttribute("date", simple.format(new Date()));
	}
	
	@Override
	public String getXmlFileName() 
	{
		return fileName;
	}
}
