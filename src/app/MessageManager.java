/**
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
 * MessageManager.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.jms.JMSException;

import sonic.AccessManager;
import config.ConnectionInfo;
import core.MessageBuilder;

/**
 * A class will send sample message using a jms wrapper.
 * <pre>
 * 		MessageManager app = new MessageManager(prop);
 * 		app.messageRegister(new PingDateBuilder());
 * 		app.sendFirstMessage();
 * </pre>
 * 
 */
public class MessageManager 
{
	private List<MessageBuilder> messageList = null;
	private Properties properties = null;
	
	public MessageManager(Properties prop)
	{
		properties = prop;
		messageList = new ArrayList<MessageBuilder>();
	}
	
	public void messageRegister(MessageBuilder builder)
	{
		messageList.add(builder);
	}
	
	public void sendFirstMessage() throws FileNotFoundException, JMSException, IOException 
	{
		AccessManager access = new AccessManager(new ConnectionInfo(properties));
		access.connect();
		access.send(getOneMessage());
		access.disconnect();
	}
	
	private String getOneMessage() throws IOException
	{
		if(messageList.isEmpty()) 
			return "";
		
		String msg = messageList.get(0).getMessage(properties);
		return msg;
	}
}
