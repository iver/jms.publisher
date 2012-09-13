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
 * MessageBuilder.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package core;

import java.io.IOException;
import java.util.Properties;

import utils.FileReader;

import core.messaging.*;

/**
 * Superclass message builder set common elements in messages. 
 *
 */
public abstract class MessageBuilder {
	
	private StringBuilder message;
	private Layout template;
	protected Header header;
	protected Content content;
	protected String headerName;
	protected String contentName;
	
	public MessageBuilder()
	{
		// COMMENT: Default common node names 
		headerName = "headerTagName";
		contentName = "contentTagName";
		initialize();
	}
	
	protected void initialize()
	{	
		template = new Layout();
		header = new Header(headerName);
		content = new Content(contentName);
	}
	
	public String createMessage() 
	{
		message = new StringBuilder();
		message.append(template.getDefinition());
		message.append(template.getOpenTag());
		message.append(template.getStringHeader(header));
		message.append(template.getStringContent(content));
		message.append(template.getCloseTag());
		return message.toString();
	}
	
	public String getMessage(Properties properties) throws IOException 
	{
		Boolean readFromXml = Boolean.valueOf(properties.getProperty("readFromXml"));
		if(readFromXml)
		{
			return new FileReader().readFile(getXmlFileName());
		}
				
		return createMessage();
	}
	
	public abstract String getXmlFileName();
}
