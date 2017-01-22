package com.cn.hnust.pojo.weather;

/**
 * @author zn
 * @version 创建时间：2017年1月19日 下午7:39:13 类说明:空气质量指数（Air Quality Index，简称AQI）是定量描述空气质量状况的无量纲指数。
 */
public class Aqi {

	private String so2;
	private String so224;
	private String no2;
	private String no224;
	private String co;
	private String co24;
	private String o3;
	private String o38;
	private String o324;
	private String pm10;
	private String pm1024;
	private String pm2_5;
	private String pm2_524;
	private String iso2;
	private String ino2;
	private String ico;
	private String io3;
	private String io38;
	private String ipm10;
	private String ipm2_5;
	/**
	 * 空气质量指数（Air Quality Index，简称AQI）是定量描述空气质量状况的无量纲指数。
	 */
	private String aqi;
	
	/**
	 * PM值
	 */
	private String primarypollutant;
	
	/**
	 * 空气质量等级 优良差...
	 */
	private String quality;
	/**
	 * 更新时间
	 */
	private String timepoint;
	
	/**
	 * 空气质量详情描述实体
	 */
	private Aqinfo aqinfo;

	public String getSo2() {
		return so2;
	}

	public void setSo2(String so2) {
		this.so2 = so2;
	}

	public String getSo224() {
		return so224;
	}

	public void setSo224(String so224) {
		this.so224 = so224;
	}

	public String getNo2() {
		return no2;
	}

	public void setNo2(String no2) {
		this.no2 = no2;
	}

	public String getNo224() {
		return no224;
	}

	public void setNo224(String no224) {
		this.no224 = no224;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getCo24() {
		return co24;
	}

	public void setCo24(String co24) {
		this.co24 = co24;
	}

	public String getO3() {
		return o3;
	}

	public void setO3(String o3) {
		this.o3 = o3;
	}

	public String getO38() {
		return o38;
	}

	public void setO38(String o38) {
		this.o38 = o38;
	}

	public String getO324() {
		return o324;
	}

	public void setO324(String o324) {
		this.o324 = o324;
	}

	public String getPm10() {
		return pm10;
	}

	public void setPm10(String pm10) {
		this.pm10 = pm10;
	}

	public String getPm1024() {
		return pm1024;
	}

	public void setPm1024(String pm1024) {
		this.pm1024 = pm1024;
	}

	public String getPm2_5() {
		return pm2_5;
	}

	public void setPm2_5(String pm2_5) {
		this.pm2_5 = pm2_5;
	}

	public String getPm2_524() {
		return pm2_524;
	}

	public void setPm2_524(String pm2_524) {
		this.pm2_524 = pm2_524;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getIno2() {
		return ino2;
	}

	public void setIno2(String ino2) {
		this.ino2 = ino2;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}

	public String getIo3() {
		return io3;
	}

	public void setIo3(String io3) {
		this.io3 = io3;
	}

	public String getIo38() {
		return io38;
	}

	public void setIo38(String io38) {
		this.io38 = io38;
	}

	public String getIpm10() {
		return ipm10;
	}

	public void setIpm10(String ipm10) {
		this.ipm10 = ipm10;
	}

	public String getIpm2_5() {
		return ipm2_5;
	}

	public void setIpm2_5(String ipm2_5) {
		this.ipm2_5 = ipm2_5;
	}

	public String getAqi() {
		return aqi;
	}

	public void setAqi(String aqi) {
		this.aqi = aqi;
	}

	public String getPrimarypollutant() {
		return primarypollutant;
	}

	public void setPrimarypollutant(String primarypollutant) {
		this.primarypollutant = primarypollutant;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getTimepoint() {
		return timepoint;
	}

	public void setTimepoint(String timepoint) {
		this.timepoint = timepoint;
	}

	public Aqinfo getAqinfo() {
		return aqinfo;
	}

	public void setAqinfo(Aqinfo aqinfo) {
		this.aqinfo = aqinfo;
	}
	
	public Aqi() {
		// TODO Auto-generated constructor stub
	}

	public Aqi(String so2, String so224, String no2, String no224, String co, String co24, String o3, String o38,
			String o324, String pm10, String pm1024, String pm2_5, String pm2_524, String iso2, String ino2, String ico,
			String io3, String io38, String ipm10, String ipm2_5, String aqi, String primarypollutant, String quality,
			String timepoint, Aqinfo aqinfo) {
		super();
		this.so2 = so2;
		this.so224 = so224;
		this.no2 = no2;
		this.no224 = no224;
		this.co = co;
		this.co24 = co24;
		this.o3 = o3;
		this.o38 = o38;
		this.o324 = o324;
		this.pm10 = pm10;
		this.pm1024 = pm1024;
		this.pm2_5 = pm2_5;
		this.pm2_524 = pm2_524;
		this.iso2 = iso2;
		this.ino2 = ino2;
		this.ico = ico;
		this.io3 = io3;
		this.io38 = io38;
		this.ipm10 = ipm10;
		this.ipm2_5 = ipm2_5;
		this.aqi = aqi;
		this.primarypollutant = primarypollutant;
		this.quality = quality;
		this.timepoint = timepoint;
		this.aqinfo = aqinfo;
	}

	@Override
	public String toString() {
		return "Aqi [so2=" + so2 + ", so224=" + so224 + ", no2=" + no2 + ", no224=" + no224 + ", co=" + co + ", co24="
				+ co24 + ", o3=" + o3 + ", o38=" + o38 + ", o324=" + o324 + ", pm10=" + pm10 + ", pm1024=" + pm1024
				+ ", pm2_5=" + pm2_5 + ", pm2_524=" + pm2_524 + ", iso2=" + iso2 + ", ino2=" + ino2 + ", ico=" + ico
				+ ", io3=" + io3 + ", io38=" + io38 + ", ipm10=" + ipm10 + ", ipm2_5=" + ipm2_5 + ", aqi=" + aqi
				+ ", primarypollutant=" + primarypollutant + ", quality=" + quality + ", timepoint=" + timepoint
				+ ", aqinfo=" + aqinfo + "]";
	}
	
	
	

}
