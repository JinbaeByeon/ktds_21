package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.RowFilter.Entry;

public class BaseballStream2 {

	
	public static List<AllStarFullVO> readAllStarFull() {
		try {
			return Files.readAllLines(Paths.get("C:\\Devs\\data\\baseball\\core\\AllStarFull.csv"))
					.stream()
					.skip(1)
//					.map(l -> {
//						l = l.replace(",,", ",0,");
//						if (l.endsWith(",")) {
//							l += "0";
//						}
//						if(l.startsWith(",")) {
//							l= "0" + l;
//						}
//						return l;
//					})
					.map((line) -> {
						List<String> strList = List.of(line.split(","));						
						
						AllStarFullVO vo = new AllStarFullVO();
						vo.setPlayerID(strList.get(0));
						vo.setYearID(strList.get(1));
						vo.setGameNum(Integer.parseInt(strList.get(2)));
						vo.setGameID(strList.get(3));
						vo.setTeamID(strList.get(4));
						vo.setLgID(strList.get(5));
						vo.setGP(Integer.parseInt(strList.get(6)));
						if(strList.size()==8)
							vo.setStartingPos(Integer.parseInt(strList.get(7)));

						return vo;
					}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
	
	public static void main(String[] args) {
		List<AllStarFullVO> list = readAllStarFull();

		System.out.println("---------------------------------------------------------");
		// 1. 1933년 NYA팀의 세 번째 선수의 playerID를 출력		
		String str = list.stream()
						 .filter(vo -> vo.getYearID().equals("1933"))
						 .filter(vo -> vo.getTeamID().equals("NYA"))
						 .skip(2)
						 .map(vo -> vo.getPlayerID())
						 .findFirst()
						 .orElse("NONE");
		
		System.out.println("1. 1933년 NYA팀의 세 번째 선수의 playerID : " + str);
		
		System.out.println("---------------------------------------------------------");
		// 2. 1700년 NYA팀의 세 번째 선수의 playerID를 출력
		/*
		 * Stream<AllStarFullVO> listStream = list.stream(); Stream<AllStarFullVO>
		 * playersIn1700 = listStream.filter(vo -> vo.getYearID().equals("1700"));
		 * Stream<AllStarFullVO> playersInNYA = playersIn1700.filter(vo ->
		 * vo.getTeamID().equals("NYA")); Stream<AllStarFullVO> playerAtThree =
		 * playersInNYA.skip(2).limit(1); Stream<String> playerIDAtThree =
		 * playerAtThree.map(vo -> vo.getPlayerID()); Optional<String> playerID =
		 * playerIDAtThree.findFirst();
		 */

		Optional<String> playerIDOptional = list.stream()
										.filter(vo -> vo.getYearID().equals("1700"))
										.filter(vo -> vo.getTeamID().equals("NYA"))
										.skip(2)
										.map(vo -> vo.getPlayerID())
										.findFirst();
		System.out.println("2. 1700년 NYA팀의 세 번째 선수의 playerID : " +  playerIDOptional.orElse("None"));

		System.out.println("---------------------------------------------------------");
		// 3. 1934년 CHA 팀에서 startinPos가 8인 선수의 playerID를 출력
		String playerID = list.stream()
							  .filter(vo -> vo.getYearID().equals("1934"))
							  .filter(vo -> vo.getTeamID().equals("CHA"))
							  .filter(vo -> vo.getStartingPos() ==8)
							  .map(AllStarFullVO::getPlayerID)
							  .findAny()
							  .orElse("None");
		
		System.out.println("3. 1934년 CHA 팀에서 startinPos가 8인 선수의 playerID : " + playerID);
		
		System.out.println("---------------------------------------------------------");
		// 4. 1934년 CHA 팀에서 startinPos가 8인 두 번째 선수의 playerID를 출력
		playerID = list.stream()
				  .filter(vo -> vo.getYearID().equals("1934"))
				  .filter(vo -> vo.getTeamID().equals("CHA"))
				  .filter(vo -> vo.getStartingPos() ==8)
				  .skip(1)
				  .map(AllStarFullVO::getPlayerID)
				  .findFirst()
				  .orElse("None");
		
		System.out.println("4. 1934년 CHA 팀에서 startinPos가 8인 두 번째 선수의 playerID : " + playerID);
		
		// 5. gomezle01 선수가 속한 팀의 매니저 playerID를 출력 - flatMap
		str = list.stream()
				  .filter(vo -> vo.getPlayerID().equals("gomezle01"))
				  .map(AllStarFullVO::getTeamID) // Stream<String>
				  .flatMap(teamID -> {
					String path = "C:\\Devs\\data\\baseball\\core\\Managers.csv";
					String searchTeamId = "," + teamID + ",";
					try {
						return Files.readAllLines(Paths.get(path))
									.stream()
									.filter(l -> l.contains(searchTeamId))
									.map(l -> l.split(",")[0]);
					} catch (IOException e) {
						e.printStackTrace();
						return Stream.empty();
					}
				}).findFirst().orElse("");


		System.out.println("---------------------------------------------------------");
		// 5-1. 1933년에 출전한 TeamID별 playerId를 모두 출력 (group)
		System.out.println("5-1. 1933년에 출전한 TeamID별 playerId를 모두 출력");
		Map<String,List<AllStarFullVO>> playerIDByTeam
				= list.stream()
					  .filter(vo -> vo.getYearID().equals("1933"))
					  .collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
		
		// Map<String,List<AllStarFullVO>> -> Map<String,List<String>>
		Map<String,List<String>> teamMap =
		playerIDByTeam.entrySet()
		  			  .stream()
		  			  .map(e -> {
		  				  return Map.entry(e.getKey(),e.getValue()
		  						  	.stream()
		  						  	.map(vo->vo.getPlayerID())
		  						  	.collect(Collectors.toList())); 
		  			  })
		  			  .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
					  
		
		playerIDByTeam.forEach((key,value) -> {
			System.out.println("Team : " + key);
			value.forEach(vo -> System.out.println(vo.getPlayerID()));
			System.out.println();
		});
					  

		
			
		System.out.println("---------------------------------------------------------");
		// 5-2. 1933년에 출전한 TeamID별 playerID의 수를 모두 출력 (group)
		System.out.println("5-2. 1933년에 출전한 TeamID별 playerID의 수를 모두 출력");
		playerIDByTeam.forEach((key,value) -> System.out.println(key +" - "+ value.size()));
		
		System.out.println("---------------------------------------------------------");
		// 6. TeamID별 출전 연도를 모두 출력
		System.out.println("6. TeamID별 출전 연도를 모두 출력");
		list.stream()
			.collect(Collectors.groupingBy(AllStarFullVO::getTeamID))
			.forEach((key,value)->{
				System.out.println("team - " +key);
				value.forEach(vo -> System.out.println(vo.getYearID()));
			});
		
		System.out.println("---------------------------------------------------------");
		// 7. TeamID별 출전 연도를 중복제거하여 모두 출력
		System.out.println("7. TeamID별 출전 연도를 중복제거하여 모두 출력");
		list.stream()
			.collect(Collectors.groupingBy(AllStarFullVO::getTeamID))
			.forEach((key,value)->{
				System.out.println("team - " +key);
				value.stream()
					 .map(vo -> vo.getYearID())
					 .distinct()
					 .forEach(vo -> System.out.printf(vo + " "));
				System.out.println();
			});
		

		
		

		System.out.println("---------------------------------------------------------");
		System.out.println("98. 선수들을 팀별로 나눠라");
		Map<String,List<AllStarFullVO>> playersByTeam = list.stream()
													 .collect(Collectors.groupingBy(AllStarFullVO::getTeamID));
	
		System.out.println("99. 선수들을 연도별로 나눠라");
		
		System.out.println("선수들의 playerID를 첫 알파벳 별로 나눠라");
		Map<String,List<String>> playersByFirstID = list.stream()
														.map(vo -> vo.getPlayerID())
														.collect(Collectors.groupingBy(s -> s.substring(0,1)));
		
		System.out.println("");
	}
}
