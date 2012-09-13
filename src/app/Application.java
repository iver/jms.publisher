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
 * Application.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.jms.JMSException;

import core.ActionMessageBuilder;

public class Application {

	private Properties prop;
	private MessageManager manager;
	
	public Application()
	{
		Initialize();
	}
	
	private void Initialize() 
	{
		try {
			prop = new Properties();
			prop.load(new FileInputStream("config.properties"));
			manager = new MessageManager(prop);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SendActionMessage() throws FileNotFoundException, JMSException, IOException
	{
		manager.messageRegister(new ActionMessageBuilder());
		manager.sendFirstMessage();
	}
	
	public void SendDateMessage() throws FileNotFoundException, JMSException, IOException
	{
		manager.messageRegister(new ActionMessageBuilder());
		manager.sendFirstMessage();
	}
}
