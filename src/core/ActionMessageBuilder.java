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
 * RondaMessageBuilder.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package core;

public class ActionMessageBuilder extends MessageBuilder 
{
	private final String fileName = "xml/ActionMessage.xml";

	public ActionMessageBuilder() {
		FillData();
	}
	
	private void FillData()
	{
		header.addAttribute("type", "ACTION");
		header.addAttribute("appId", "d220c916-50f9-430c-aaf9-2e231e0a9720");
		header.addAttribute("terminal", "nombreMaquina");
		
		content.addAttribute("id", "69");
		content.addAttribute("operacion", "Iniciar");
		
	}
	
	@Override
	public String getXmlFileName() 
	{
		return fileName;
	}
}
