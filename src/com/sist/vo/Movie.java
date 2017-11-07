package com.sist.vo;

import java.util.Arrays;

/**
 * @author dslee
 *
 */
public class Movie {
	
	//API
	private String movieCd;		//영화코드
	private String movieNm;		//영화명
	private String showTm;		//상영시간
	private String openDt;		//개봉일
	private String prdtStatNm;	//개봉유무
	private String[] genreNm;	//장르명
	private String[] directors;	//감독
	private String[] actors; 	//배우
	private String watchGradeNm;//관람등급
	
	
	//DB
	private String image;
	private String mcode;
	private String summary;
	private double GPA;
	private String rate;
	
	
	
	
	public String getMovieCd() {
		return movieCd;
	}
	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getShowTm() {
		return showTm;
	}
	public void setShowTm(String showTm) {
		this.showTm = showTm;
	}
	public String getOpenDt() {
		return openDt;
	}
	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}
	public String getPrdtStatNm() {
		return prdtStatNm;
	}
	public void setPrdtStatNm(String prdtStatNm) {
		this.prdtStatNm = prdtStatNm;
	}
	public String[] getGenreNm() {
		return genreNm;
	}
	public void setGenreNm(String[] genreNm) {
		this.genreNm = genreNm;
	}
	public String[] getDirectors() {
		return directors;
	}
	public void setDirectors(String[] directors) {
		this.directors = directors;
	}
	public String[] getActors() {
		return actors;
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	public String getWatchGradeNm() {
		return watchGradeNm;
	}
	public void setWatchGradeNm(String watchGradeNm) {
		this.watchGradeNm = watchGradeNm;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMcode() {
		return mcode;
	}
	public void setMcode(String mcode) {
		this.mcode = mcode;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	

	
	
}
