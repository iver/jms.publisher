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
 * Main.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package app;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.jms.JMSException;

public class Main {

	public static void main(String[] args) 
	{
		final String fileName = "config.properties";
		try 
		{
			Application app = new Application(fileName);
			app.SendDateMessage();
			app.SendActionMessage();
		} 
		catch (FileNotFoundException e) {
			System.out.printf("El archivo %s no existe", fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("Error de entrada y salida");
			e.printStackTrace();
		} catch (JMSException e) {
			System.out.print("Error JMS");
			e.printStackTrace();
		}
	}
}
