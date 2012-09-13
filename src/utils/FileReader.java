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
 * FileReader.Java 
 * Create by Iván Jaimes on 03/09/2012
 * 
 */
package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {

	public FileReader() {
		// TODO Auto-generated constructor stub
	}
	
	public String readFile(String fileName) throws IOException
	{
		String fileLine = null ;
		StringBuilder sBuilder = new StringBuilder(); 
		InputStreamReader iStreamR = new InputStreamReader( ClassLoader.getSystemResourceAsStream(fileName) );
		BufferedReader reader = new BufferedReader(iStreamR);
		while ((fileLine = reader.readLine()) != null)
        {
           sBuilder.append(fileLine);
        }
        reader.close();
		return sBuilder.toString();
	}

}
