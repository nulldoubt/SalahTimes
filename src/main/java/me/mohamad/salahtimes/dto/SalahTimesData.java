package me.mohamad.salahtimes.dto;

import java.time.format.DateTimeFormatter;

public final class SalahTimesData {
	
	public final String method;
	public final String date;
	
	public final String fajr;
	public final String sunrise;
	public final String dhuhr;
	public final String asr;
	public final String maghrib;
	public final String isha;
	
	public SalahTimesData(DateTimeFormatter dateFormat, DateTimeFormatter timeFormat, SalahTimes salahTimes) {
		this.method = salahTimes.method;
		this.date = salahTimes.date.format(dateFormat);
		this.fajr = salahTimes.fajr.format(timeFormat);
		this.sunrise = salahTimes.sunrise.format(timeFormat);
		this.dhuhr = salahTimes.dhuhr.format(timeFormat);
		this.asr = salahTimes.asr.format(timeFormat);
		this.maghrib = salahTimes.maghrib.format(timeFormat);
		this.isha = salahTimes.isha.format(timeFormat);
	}
	
}
