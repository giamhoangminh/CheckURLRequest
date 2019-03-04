package threadpool;

//import data.io.URLFactory;
import data.model.URLModel;
import httpconnection.HttpConnect;

public class RunPool implements Runnable {
	URLModel url;
	public void run() {
		try {
			HttpConnect.connect(url);
			System.out.println(url);
			//URLFactory.writeOutPut2(url, "output");
		} catch (Exception e) {
			e.printStackTrace();
			}
	}
	public RunPool(URLModel url)
	{
		this.url = url;
	}
}

