package eus.birt.adavila.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"type",
"coordinates"
})

@Data
@NoArgsConstructor
public class Geometry {

	@JsonProperty("type")
	public String type;
	@JsonProperty("coordinates")
	public List<Double> coordinates;

}
