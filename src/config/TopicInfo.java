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
 * TopicInfo.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */

package config;

import javax.jms.JMSException;
import javax.jms.Topic;

/**
 * @author Iván Jaimes
 * 
 * This entity implements javax.jms.Topic interface.
 * 
 *  @see javax.jms.JMSException
 *  @see javax.jms.Topic
 */
public class TopicInfo implements Topic 
{
	private String topicName;
	/** 
	 * @param topic Topic name to use 
	 */
	public TopicInfo(String topic)
	{
		topicName = topic;
	}
	/**
	 * Get topic name used.
	 */
	@Override
	public String getTopicName() throws JMSException 
	{
		return topicName;
	}
}
