package me.mohamad.salahtimes;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import me.mohamad.salahtimes.dto.SalahTimes;

import java.time.LocalDate;

@Path("/get")
public class SalahResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public SalahTimes get(
			@QueryParam("longitude") double longitude,
			@QueryParam("latitude") double latitude,
			@QueryParam("date") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate date
	) {
		return new SalahTimes(longitude, latitude, date != null ? date : LocalDate.now());
	}
	
}
