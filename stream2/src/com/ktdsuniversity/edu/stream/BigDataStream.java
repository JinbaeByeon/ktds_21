package com.ktdsuniversity.edu.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BigDataStream {

	public static List<TextVO> readTextFile(){
		try {
		return Files.readAllLines(Paths.get("C:\\Devs\\data\\bigdata\\10K.ID.CONTENTS"))
					.parallelStream()
					.map(l ->{
						TextVO vo = new TextVO();
						String[] strArr = l.split("\t");
						vo.setKey(strArr[0].trim());
						if(strArr.length>=2) {						
							vo.setValue(strArr[1].trim());
						}
						return vo;
					})
					.collect(Collectors.toList());
		}
		catch (IOException e) {
			return new ArrayList<>();
		}
	}
	
	public static void main(String[] args) {
		List<TextVO> list = readTextFile();
		System.out.println("10K.ID.CONTENTS의 줄 수\n > " + list.size());
		System.out.println("---------------------------------------------------------");
		// 8-1. 10K.ID.CONTENTS 파일에서 "12370584"의 내용을 출력
		long startTime = System.currentTimeMillis();
		String line = readTextFile().stream()
						  .filter(vo -> vo.getKey().equals("12370584"))
						  .map(vo -> vo.getValue())
						  .findAny()
						  .orElse("None");
		System.out.println("실행 시간: " + (System.currentTimeMillis() - startTime));
		
		System.out.println("8-1. 10K.ID.CONTENTS 파일에서 \"12370584\"의 내용\n > " + line);
		System.out.println("---------------------------------------------------------");	
		// 여기부터 병렬 처리 (ParallelStream)
		// 8-2. 10K.ID.CONTENTS 파일에서 "12370584"의 내용을 출력 
		startTime = System.currentTimeMillis();
		line = readTextFile().parallelStream()
							 .filter(vo->vo.getKey().equals("12370584"))
							 .map(vo->vo.getValue())
							 .findAny()
							 .orElse("None");
		System.out.println("실행 시간: " + (System.currentTimeMillis() - startTime));
		
		System.out.println("8-2. (병렬)10K.ID.CONTENTS 파일에서 \"12370584\"의 내용\n > "+ line);
		
		System.out.println("---------------------------------------------------------");
		// 9. 10K.ID.CONTENTS 파일에서 ""7670637"에 몇 개의 단어가 있는지 출력
		long cnt = list.parallelStream()
					   .filter(vo -> vo.getKey().equals("7670637"))
					   .map(vo -> List.of(vo.getValue().split(" ")))
					   .findFirst()
					   .orElse(new ArrayList<>()).size();
		
		System.out.println("9. 10K.ID.CONTENTS 파일에서 \"\"7670637\"에 있는 단어의 수\n > " + cnt);
		
		System.out.println("---------------------------------------------------------");
		// 10. 10K.ID.CONTENTS 파일에서 내용이 없는 "번호"는 몇 개인지 출력
		cnt = list.parallelStream()
				  .filter(vo -> "".equals(vo.getValue()))
				  .count();
		
		System.out.println("10. 10K.ID.CONTENTS 파일에서 내용이 없는 \"번호\"의 개수\n > " + cnt);
		
		System.out.println("---------------------------------------------------------");
		// 11. 두 개의 단어로만 이루어진 "번호"는 몇 개인지 출력
		cnt = list.parallelStream()
				  .filter(vo -> vo.getValue() != null)
				  .filter(vo ->  vo.getValue().split(" ").length == 2)
				  .count();
		System.out.println("11. 두 개의 단어로만 이루어진 \"번호\"의 개수\n > " + cnt);
		
		System.out.println("---------------------------------------------------------");
		// 12. 내용에 "that"이 포함된 글은 몇 개인지 출력
		cnt = list.parallelStream()
				  .filter(vo -> vo.getValue() != null)
				  .filter(vo -> vo.getValue().contains("that"))
				  .count();
		System.out.println("12. 내용에 \"that\"이 포함된 글의 개수\n > " + cnt );
		
		System.out.println("---------------------------------------------------------");
		// 13. 글 번호가 6자리
		cnt = list.parallelStream()
				  .filter(vo -> vo.getKey().length()==6)
				  .count();				  
		System.out.println("13. 글 번호가 6자리\n > " + cnt);
		
		System.out.println("---------------------------------------------------------");
		// 14. 글 번호가 7자리
		cnt = list.parallelStream()
				  .filter(vo -> vo.getKey().length()==7)
				  .count();
				  
		System.out.println("14. 글 번호가 7자리\n > " + cnt);
		
		System.out.println("---------------------------------------------------------");
		// 15. 글 번호가 9로 시작하는 모든 글들의 첫 번째 단어
		System.out.println("15. 글 번호가 9로 시작하는 모든 글들의 첫 번째 단어");
		list.parallelStream()
			.filter(vo -> vo.getKey().startsWith("9"))
			.map(vo -> vo.getValue() == null ? "" : vo.getValue().split(" ")[0])
			.forEach(w -> System.out.println("[" + w + "]"));
		
		System.out.println("---------------------------------------------------------");
		// 16. 파일에서 내용이 있으며 글 번호가 7로 시작하는 모든 글들의 첫 번째 단어
		System.out.println("16. 내용이 있으며 글 번호가 7로 시작하는 모든 글들의 첫 번째 단어");
		list.parallelStream()
			.filter(vo -> vo.getValue() != null && !vo.getValue().isEmpty())
			.filter(vo -> vo.getKey().startsWith("7"))
			.map(vo -> vo.getValue().split(" ")[0])
			.filter(w -> !w.equals(""))
			.forEach(w -> System.out.println("[" + w + "]"));
	}
	
}
