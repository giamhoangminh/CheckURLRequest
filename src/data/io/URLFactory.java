package data.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import data.model.URLModel;

public class URLFactory {
	//ghi tiếp dữ liệu ra file
	public static void writeOutPut2(URLModel url, String path)
	{
		try
		{
			File file = new File(path);
			if(!file.exists())
			{
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			//ghi dữ liệu
				bw.write(url.toString());
				bw.newLine();
			
			bw.close();
			fw.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// ghi dữ liệu ra file
	public static boolean writeOutPut(ArrayList<URLModel> arr, String path)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(path);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			//ghi dữ liệu
			for(URLModel url : arr)
			{
				bw.write(url.toString());
				bw.newLine();
			}
			bw.close();
			osw.close();
			fos.close();	
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	//đọc dữ liệu từ file
	public static ArrayList<URLModel> readData(String path)
	{
		ArrayList<URLModel> arr = new ArrayList<URLModel>();
		try
		{
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader bfr = new BufferedReader(isr);
			
			String line = bfr.readLine();
			while( line != null)
			{
				URLModel url = new URLModel();
				url.setUrl(line);
				arr.add(url);
				line = bfr.readLine();
			}
			bfr.close();
			isr.close();
			fis.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return arr;
	}
}
