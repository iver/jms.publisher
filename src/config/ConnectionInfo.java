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
 * ConnectionInfo.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Represents a connection info and common data.
 *
 */
public class ConnectionInfo {
	
	private String sonicAddress;
	private String userName;
	private String password;	
	private String idEstacion;
	private TopicInfo topic;
	/**
	 * @return The sonic server address.
	 */
	public String getSonicAddress() {
		return sonicAddress;
	}
	/**
	 * @param Sonic server address to set
	 */
	public void setSonicAddress(String sonicAddress) {
		this.sonicAddress = sonicAddress;
	}
	/**
	 * @return Sonic server user name 
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param Sonic server user name to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return Sonic server password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param Sonic server password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return A common data sample
	 */
	public String getIdEstacion() {
		return idEstacion;
	}
	/**
	 * @param A common data sample to set, this case is idEstacion 
	 */
	public void setIdEstacion(String idEstacion) {
		this.idEstacion = idEstacion;
	}
	/**
	 * @return The sonic topic info
	 */
	public TopicInfo getTopic() {
		return topic;
	}
	
	public ConnectionInfo(Properties prop) throws FileNotFoundException, IOException
	{
		topic = new TopicInfo(prop.getProperty("topicName"));
		setIdEstacion(prop.getProperty("idEstacion"));
		setSonicAddress(prop.getProperty("sonicAddress"));
		setUserName(prop.getProperty("userName"));
		setPassword(prop.getProperty("password"));
	}
}
