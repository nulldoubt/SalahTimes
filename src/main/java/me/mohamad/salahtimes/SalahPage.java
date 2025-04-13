package me.mohamad.salahtimes;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import me.mohamad.salahtimes.dto.SalahTimes;

import java.time.LocalDate;
import java.util.Objects;

@Path("/")
public class SalahPage {
	
	private final Template page;
	
	public SalahPage(Template page) {
		this.page = Objects.requireNonNull(page, "page is required");
	}
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public TemplateInstance get(
			@QueryParam("longitude") double longitude,
			@QueryParam("latitude") double latitude,
			@QueryParam("date") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate date
	) {
		return page.data("salahTimes", new SalahTimes(longitude, latitude, date != null ? date : LocalDate.now()).toData());
	}
	
}
