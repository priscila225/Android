package com.fordroid.gameheroequiz.data;

public class Character {

	private int id;
	private String name;
	private String name_pos1;
	private String name_pos2;
	private String image;
	private int resp;
	private int level;

	public String getName_pos1() {
		return name_pos1;
	}

	public void setName_pos1(String name_pos1) {
		this.name_pos1 = name_pos1;
	}

	public String getName_pos2() {
		return name_pos2;
	}

	public void setName_pos2(String name_pos2) {
		this.name_pos2 = name_pos2;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
