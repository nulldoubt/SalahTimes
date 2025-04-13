package me.mohamad.salahtimes.dto;

import com.batoulapps.adhan.*;
import com.batoulapps.adhan.data.DateComponents;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public final class SalahTimes {
	
	private static final CalculationMethod DEFAULT_CALCULATION_METHOD;
	private static final CalculationParameters DEFAULT_CALCULATION_PARAMETERS;
	
	static {
		DEFAULT_CALCULATION_METHOD = CalculationMethod.MUSLIM_WORLD_LEAGUE;
		DEFAULT_CALCULATION_PARAMETERS = DEFAULT_CALCULATION_METHOD.getParameters();
		DEFAULT_CALCULATION_PARAMETERS.madhab = Madhab.SHAFI;
	}
	
	public final String method;
	public final double latitude;
	public final double longitude;
	public final LocalDate date;
	
	public final LocalTime fajr;
	public final LocalTime sunrise;
	public final LocalTime dhuhr;
	public final LocalTime asr;
	public final LocalTime maghrib;
	public final LocalTime isha;
	
	public SalahTimes(double longitude, double latitude, LocalDate date) {
		PrayerTimes prayerTimes = new PrayerTimes(
				new Coordinates(longitude, latitude),
				new DateComponents(date.getYear(), date.getMonthValue(), date.getDayOfMonth()),
				DEFAULT_CALCULATION_PARAMETERS
		);
		
		this.method = DEFAULT_CALCULATION_METHOD.name();
		this.longitude = longitude;
		this.latitude = latitude;
		this.date = date;
		
		ZoneId zoneId = ZoneId.systemDefault();
		fajr = LocalTime.ofInstant(prayerTimes.fajr.toInstant(), zoneId);
		sunrise = LocalTime.ofInstant(prayerTimes.sunrise.toInstant(), zoneId);
		dhuhr = LocalTime.ofInstant(prayerTimes.dhuhr.toInstant(), zoneId);
		asr = LocalTime.ofInstant(prayerTimes.asr.toInstant(), zoneId);
		maghrib = LocalTime.ofInstant(prayerTimes.maghrib.toInstant(), zoneId);
		isha = LocalTime.ofInstant(prayerTimes.isha.toInstant(), zoneId);
	}
	
}
