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
 * ContentItem.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package core.messaging;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContentItem {

	private String tagName;
	private Map<String, String> attributes;
	private List<ContentItem> items;
	/**
	 * 
	 */
	public ContentItem(String itemName) {
		Initialize(itemName);
	}
	
	private void Initialize(String itemName)
	{
		tagName = itemName;
		attributes = new HashMap<String, String>();
		items = new ArrayList<ContentItem>();
	}
	
	public void addAttribute(String key, String value)
	{
		if(key == null || key == "")
			return;
		
		attributes.put(key, value);
	}
	
	public void addItem(ContentItem item)
	{
		if(item == null)
			return;
		
		items.add(item);
	}
	
	public String getName()
	{
		return tagName;
	}
	
	public String getStringAttributes()
	{
		StringBuilder builder = new StringBuilder();
		for(Map.Entry<String, String> entry : attributes.entrySet())
		{
			builder.append(String.format(" %1$s=\"%2$s\"", entry.getKey(), entry.getValue()));
		}
		return builder.toString();
	}
	
	public List<ContentItem> getItems()
	{
		return items;
	}

	public Boolean HasItems()
	{
		return (items.isEmpty() == false);
	}
}
