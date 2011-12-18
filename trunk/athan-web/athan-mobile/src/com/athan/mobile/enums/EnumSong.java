/**
 * 
 */
package com.athan.mobile.enums;

/**
 * Enum for the resources songs
 * 
 * @author Saad BENBOUZID
 */
public enum EnumSong {

	JERUSALEM("soundfiles.alaqsa", "", "Alaqsa.mp3", "Alaqsa.wav"), BOSNIA(
			"soundfiles.bosnia", "", "Bosnia.mp3", "Bosnia.wav"), EGYPT(
			"soundfiles.egypt", "", "Egypt.mp3", "Egypt.wav"), LEBANON(
			"soundfiles.lebanon", "", "Lebanon.mp3", "Lebanon.wav"), MADINA("soundfiles.madina",
			"", "Madina.mp3", "Madina.wav"), MAKKAH1("soundfiles.makkah1", "1",
			"Makkah1.mp3", "Makkah1.wav"), MAKKAH2("soundfiles.makkah2", "2",
			"Makkah2.mp3", "Makkah2.wav"), PAKISTAN("soundfiles.pakistan", "",
			"Pakistan.mp3", "Pakistan.wav"), TURKEY("soundfiles.turkey", "",
			"Turkey.mp3", "Turkey.wav"), SHEIKH("soundfiles.sheikh", "",
			"Sheikh.mp3", "Sheikh.wav");

	/** Key label in labels.properties */
	private String keyLabel;
	/** Label complement (for ex. "(1)", "bis",...) */
	private String labelCmpl;
	/** MP3 file uri */
	private String mp3Url;
	/** WAV file uri */
	private String wavUrl;

	private EnumSong(String keyLabel, String labelCmpl, String mp3Url,
			String wavUrl) {
		this.keyLabel = keyLabel;
		this.labelCmpl = labelCmpl;
		this.mp3Url = mp3Url;
		this.wavUrl = wavUrl;
	}

	public String keyLabel() {
		return keyLabel;
	}

	public String labelCmpl() {
		return labelCmpl;
	}

	public String mp3Url() {
		return "/sound/mp3/" + mp3Url;
	}

	public String wavUrl() {
		return "/sound/wav/" + wavUrl;
	}

}