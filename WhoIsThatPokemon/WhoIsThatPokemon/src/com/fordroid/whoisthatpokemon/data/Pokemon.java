package com.fordroid.whoisthatpokemon.data;

public class Pokemon {

	private int number;
	private String name;
	private String image1;
	private String image2;
	private String help_easy;
	private String help_medium;
	private String help_hard;
	private int resp;
	private int level;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public String getHelp_easy() {
		return help_easy;
	}
	public void setHelp_easy(String help_easy) {
		this.help_easy = help_easy;
	}
	public String getHelp_medium() {
		return help_medium;
	}
	public void setHelp_medium(String help_medium) {
		this.help_medium = help_medium;
	}
	public String getHelp_hard() {
		return help_hard;
	}
	public void setHelp_hard(String help_hard) {
		this.help_hard = help_hard;
	}
	public int getResp() {
		return resp;
	}
	public void setResp(int resp) {
		this.resp = resp;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
}
