package eus.birt.adavila.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"documentname",
"documentdescription",
"templatetype",
"locality",
"phone",
"address",
"marks",
"physical",
"visual",
"auditive",
"intellectual",
"organic",
"qualityassurance",
"tourismemail",
"web",
"lodgingtype",
"category",
"signatura",
"capacity",
"postalcode",
"municipality",
"municipalitycode",
"territory",
"territorycode",
"country",
"countrycode",
"friendlyurl",
"physicalurl",
"dataxml",
"metadataxml",
"zipfile"
})

@Data
@NoArgsConstructor
public class Properties {

	@JsonProperty("documentname")
	public String documentname;
	@JsonProperty("documentdescription")
	public String documentdescription;
	@JsonProperty("templatetype")
	public String templatetype;
	@JsonProperty("locality")
	public String locality;
	@JsonProperty("phone")
	public String phone;
	@JsonProperty("address")
	public String address;
	@JsonProperty("marks")
	public String marks;
	@JsonProperty("physical")
	public String physical;
	@JsonProperty("visual")
	public String visual;
	@JsonProperty("auditive")
	public String auditive;
	@JsonProperty("intellectual")
	public String intellectual;
	@JsonProperty("organic")
	public String organic;
	@JsonProperty("qualityassurance")
	public String qualityassurance;
	@JsonProperty("tourismemail")
	public String tourismemail;
	@JsonProperty("web")
	public String web;
	@JsonProperty("lodgingtype")
	public String lodgingtype;
	@JsonProperty("category")
	public String category;
	@JsonProperty("signatura")
	public String signatura;
	@JsonProperty("capacity")
	public String capacity;
	@JsonProperty("postalcode")
	public String postalcode;
	@JsonProperty("municipality")
	public String municipality;
	@JsonProperty("municipalitycode")
	public String municipalitycode;
	@JsonProperty("territory")
	public String territory;
	@JsonProperty("territorycode")
	public String territorycode;
	@JsonProperty("country")
	public String country;
	@JsonProperty("countrycode")
	public String countrycode;
	@JsonProperty("friendlyurl")
	public String friendlyurl;
	@JsonProperty("physicalurl")
	public String physicalurl;
	@JsonProperty("dataxml")
	public String dataxml;
	@JsonProperty("metadataxml")
	public String metadataxml;
	@JsonProperty("zipfile")
	public String zipfile;
}
