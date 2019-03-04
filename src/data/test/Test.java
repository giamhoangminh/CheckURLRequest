package data.test;

import java.util.ArrayList;
import data.io.URLFactory;
import data.model.URLModel;
import httpconnection.HttpConnect;

public class Test {

	public static void main(String[] args) {
		ArrayList<URLModel> arr = new ArrayList<URLModel>();
		arr = URLFactory.readData("data1.txt");
		HttpConnect.connect(arr);
		boolean kt = URLFactory.writeOutPut(arr, "output");
		if(kt == true) System.out.println("Thành công");
	}
}
