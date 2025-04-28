package eus.birt.adavila.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"type",
"geometry",
"properties"
})

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="Rurales")

public class Rurales {
	
	@JsonProperty("_id")
	private String id;
	@JsonProperty("id")
	public Integer ruralId;
	@JsonProperty("type")
	public String type;
	@JsonProperty("geometry")
	public Geometry geometry;
	@JsonProperty("properties")
	public Properties properties;


}
