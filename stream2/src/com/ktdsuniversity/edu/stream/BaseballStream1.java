package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseballStream1 {

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
		
		list.stream()
			.filter(vo -> vo.getYearID().equals("1945"))
			.forEach(vo -> {
			System.out.println(vo.getPlayerID());
			System.out.println(vo.getStartingPos());
		});
		
		List<AllStarFullVO> playIn1933 = list.stream()
											 .filter(vo -> vo.getYearID().equals("1933"))
											 .collect(Collectors.toList());

		AllStarFullVO player = list.stream()
								   .filter(vo -> vo.getYearID().equals("1933"))
								   .findFirst()
								   .orElse(new AllStarFullVO());

		System.out.println(player.getPlayerID());

		System.out.println("---------------------연도에 관계없이 이름이 f로 시작하는 모든 데이터를 출력------------------\n");
		// 연도에 관계없이 이름이 f로 시작하는 모든 데이터를 출력
		list.stream()
			.filter(vo -> vo.getPlayerID().toLowerCase().startsWith("f"))
			.forEach(vo -> System.out.println(vo));

		System.out.println("--------------------2004년도 경기에서 팀명이 TEX 인 데이터를 출력-----------------\n");		
		// 2004년도 경기에서 팀명이 TEX 인 데이터를 출력
		list.stream()
			.filter(vo -> vo.getYearID().equals("2004"))
			.filter(vo -> vo.getTeamID().equals("TEX"))
			.forEach(vo -> System.out.println(vo));

		System.out.println("-------------------startingPos 가 0인 데이터 출력-------------------\n");		
		// startingPos 가 0인 데이터 출력
		list.stream()
			.filter(vo -> vo.getStartingPos()==0)
			.distinct()
			.forEach(vo -> System.out.println(vo));

		System.out.println("-----------------GP 값이 0 & teamID가 NYA & PlayerID에 fo가 포함되어 있으면 모두 출력-------------------\n");		
		//GP 값이 0 & teamID가 NYA & PlayerID에 fo가 포함되어 있으면 모두 출력
		list.parallelStream()
			.filter(vo -> vo.getGP()==0)
			.filter(vo -> vo.getTeamID().equals("NYA"))
//			.filter(vo -> vo.getPlayerID().toLowerCase().contains("fo"))
			.filter(vo -> vo.getPlayerID().toLowerCase().indexOf("fo") > -1)
			.forEach(System.out::println);
		
		List<String> playerIDList = list.stream()
										.map(AllStarFullVO::getPlayerID)
										.distinct()
										.sorted()
										.collect(Collectors.toList());
		playerIDList.forEach(System.out::println);
		System.out.println(playerIDList.size());
			

		System.out.println("----------------startinPos== 4 data들의 playerID 추출, 중복 제거, 정렬, 출력--------------------\n");	
		// startinPos== 4 data들의 playerID 추출, 중복 제거, 정렬, 출력
		list.stream()
			.filter(vo -> vo.getStartingPos()==4)
			.map(AllStarFullVO::getPlayerID)
			.distinct()
			.sorted()
			.forEach(System.out::println);
		
		List<String> words = List.of("Java8","Lambdas");
		
		List<Stream<String>> uniqueCharactersMap
							= words.stream() 				// Stream<String>
		 				   		   .map(w -> w.split(""))	// Stream<String[]>
		 				   		   // {["J","a","v","a","8"],["L","a","m","b","d","a","s"]}
		 				   		   .map(Arrays::stream)		// Stream<Stream<String>>
		 				   		   // {{{"J"},{"a"},{"v"},{"a"},{"8"}},{{"L"},{"a"},{"m"},{"b"},{"d"},{"a"},{"s"}}}
				 				   .distinct()
				 				   .collect(Collectors.toList());
		
		uniqueCharactersMap.forEach(s -> s.forEach(System.out::println));
		System.out.println("-----------------");
		List<String> uniqueCharactersFlatMap 
							= words.stream()
								   .map(w -> w.split("")) 	//List<String> -> List<String[]>
		 				   		   // {{"J","a","v","a","8"},{"L","a","m","b","d","a","s"}}
								   .flatMap(Arrays::stream)	//List<String[]> -> Stream<String>
		 				   		   // {"J","a","v","a","8","L","a","m","b","d","a","s"}
								   .distinct()
								   .collect(Collectors.toList());
		uniqueCharactersFlatMap.forEach(System.out::println);
		
	}
}
