package test;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import data.io.URLFactory;
import data.model.URLModel;
//import httpconnection.HttpConnect;
import threadpool.RunPool;

public class Test {

	public static void main(String[] args) {
		ArrayList<URLModel> arr = new ArrayList<URLModel>();
		arr = URLFactory.readData("data1.txt");
		// tạo hàng đợi
		ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 2, TimeUnit.SECONDS, queue);
		
		for(URLModel u : arr)
		{
			threadPoolExecutor.execute(new RunPool(u));
		}
	}
}
