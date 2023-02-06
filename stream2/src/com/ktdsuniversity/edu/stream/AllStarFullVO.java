package com.ktdsuniversity.edu.stream;

public class AllStarFullVO {
	private String playerID;
	private String yearID;
	private int gameNum;
	private String gameID;
	private String teamID;
	private String lgID;
	private int GP;
	private int startingPos;

	public String getPlayerID() {
		return playerID;
	}

	public void setPlayerID(String playerID) {
		this.playerID = playerID;
	}

	public String getYearID() {
		return yearID;
	}

	public void setYearID(String yearID) {
		this.yearID = yearID;
	}

	public int getGameNum() {
		return gameNum;
	}

	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
	}

	public String getGameID() {
		return gameID;
	}

	public void setGameID(String gameID) {
		this.gameID = gameID;
	}

	public String getTeamID() {
		return teamID;
	}

	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}

	public String getLgID() {
		return lgID;
	}

	public void setLgID(String lgID) {
		this.lgID = lgID;
	}

	public int getGP() {
		return GP;
	}

	public void setGP(int gP) {
		GP = gP;
	}

	public int getStartingPos() {
		return startingPos;
	}

	public void setStartingPos(int startingPos) {
		this.startingPos = startingPos;
	}

	@Override
	public String toString() {
		String res = "playerID: " + playerID;
		res += "\nyearID: " + yearID;
		res += "\ngameNum: " + gameNum;
		res += "\ngameID: " + gameID;
		res += "\nteamID: " + teamID;
		res += "\nlgID: " + lgID;
		res += "\nGP: " + GP;
		res += "\nstartingPos: " + startingPos+"\n";	
		return res;
	}
}
