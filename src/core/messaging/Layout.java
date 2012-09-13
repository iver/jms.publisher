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
 * Layout.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package core.messaging;

import java.util.List;

public class Layout {

	private String definition;
	private String bodyName;
	
	public Layout() {
		Initialize();
	}
	
	private void Initialize()
	{
		definition = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"yes\"?>\n";
		bodyName = "mensaje";
	}
	
	public String getDefinition()
	{
		return definition;
	}
	
	public String getOpenTag()
	{
		return String.format("<%s>\n", bodyName);
	}
	
	public String getCloseTag()
	{
		return String.format("</%s>\n", bodyName);
	}
	
	public String getStringHeader(Header header)
	{
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("<%s ", header.getName()));
		builder.append(String.format("%s />\n", header.getStringAttributes()));
		return builder.toString();
	}

	public String getStringContent(Content content) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("<%s ", content.getName()));
		if(content.HasItems())
		{
			builder.append(String.format("%s >\n", content.getStringAttributes()));
			builder.append(getStringCollectionItems(content.getItems()));					
			builder.append(String.format("</%s>\n", content.getName()));
		}else
		{
			builder.append(String.format("%s />\n", content.getStringAttributes()));
		}
		return builder.toString();
	}
	
	public String getStringCollectionItems(List<ContentItem> items)
	{
		StringBuilder builder = new StringBuilder();
		for(ContentItem item : items)
		{
			builder.append(getStringContentItem(item));
		}
		return builder.toString();
	}
	
	public String getStringContentItem(ContentItem item)
	{
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("<%s ", item.getName()));
		if(item.HasItems())
		{
			builder.append(String.format("%s >\n", item.getStringAttributes()));
			builder.append(getStringCollectionItems(item.getItems()));
			builder.append(String.format("</%s>\n", item.getName()));
		}else
		{
			builder.append(String.format("%s />\n", item.getStringAttributes()));
		}
		return builder.toString();
	}
}
