package com.cn.hnust.utils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public class Test {
	String cityid;
	URLConnection connectionData;
	StringBuilder sb;
	BufferedReader br;
	JSONObject jsonData;
	JSONObject info;

		public Test(String cityid) throws IOException,NullPointerException{
				this.cityid = cityid;
				URL url = new URL("http://m.weather.com.cn/data/"+cityid+".html");
				connectionData = url.openConnection();
				connectionData.setConnectTimeout(1000);
				try{
				br = new BufferedReader(new InputStreamReader(connectionData.getInputStream(), "utf-8"));
				sb = new StringBuilder();
				String line = null;
				while((line = br.readLine()) != null)
				sb.append(line);
				}catch (SocketTimeoutException e) {
				System.out.println("连接超时");
				}catch(FileNotFoundException e){
				System.out.println("加载文件出错");
				}
				String datas = sb.toString();
				jsonData = JSONObject.parseObject(datas);
				info = jsonData.getJSONObject("weatherinfo");
				List<Map<String , String >> list = new ArrayList<>();
				for(int i=1;i<=6;i++){
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_YEAR,i-1);
				Date date = cal.getTime();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
				Map<String, String> map = new HashMap<String, String>();
				map.put("city", info.getString("city").toString());
				map.put("date_y", sf.format(date));
				map.put("week", getWeek(cal.get(Calendar.DAY_OF_WEEK)));
				map.put("fchh", info.getString("fchh").toString());
				map.put("weather", info.getString("weather"+i).toString());
				map.put("temp", info.getString("temp"+1).toString());
				map.put("wind", info.getString("wind"+1).toString());
				map.put("fl", info.getString("fl"+1).toString());
				map.put("index", info.getString("index").toString());
				map.put("index_uv", info.getString("index_uv").toString());
				map.put("index_tr", info.getString("index_tr").toString());
				map.put("index_co", info.getString("index_co").toString());
				map.put("index_cl", info.getString("index_cl").toString());
				map.put("index_xc", info.getString("index_xc").toString());
				map.put("index_d", info.getString("index_d").toString());
				list.add(map);
		}
		for(int j=1;j<list.size();j++){
			Map<String, String> wMap = list.get(j);
			System.out.println(wMap.get("city")+"\t"+wMap.get("date_y")+"\t"+wMap.get("week")+wMap.get("weather")+"\t"+wMap.get("temp")+"\t"+wMap.get("index_uv"));
		}

}

	public String getWeek(int iw) {
		String weekStr = "";
		switch (iw) {
		case 1:
			weekStr = "星期天";
			break;
		case 2:
			weekStr = "星期一";
			break;
		case 3:
			weekStr = "星期二";
			break;
		case 4:
			weekStr = "星期三";
			break;
		case 5:
			weekStr = "星期四";
			break;
		case 6:
			weekStr = "星期五";
			break;
		case 7:
			weekStr = "星期六";
			break;
		default:
			break;
		}
		return weekStr;
	}

	public static void main(String[] args) throws IOException {
		CommUtils.getWeather("杭州");
	}
}