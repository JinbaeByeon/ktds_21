package com.ktdsuniversity.edu;

import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		String str = "                       a   b   c                ";
		System.out.println("str = [" + str + "]");

		str = str.trim();
		System.out.println("trim() -> str = [" + str + "]");

		str = str.replace(" ", "_");
		System.out.println("replace(\"\",\"_\") -> str = [" + str + "]");
		str = str.replaceAll("_", "-");
		System.out.println("replace(\"_\",\"-\") -> str = [" + str + "]");

		str = "<html>HTML 문서를 작성합니다.</html>";
		System.out.println("str = [" + str + "]");
		str = str.replaceAll("[가-힣]", "");
		System.out.println("replaceAll(\"[가-힣]\",\"\") =  [" + str + "]");

		str = "<html>HTML 문서를 작성합니다.</html>";
		str = str.replaceAll("[^가-나라-힣]", "");
		System.out.println("replaceAll(\"[^가-나라-힣]\",\"\") = [" + str + "]");

		str = "자전자전거";
		System.out.println("자의 자리: " + str.indexOf("자"));
		System.out.println("전의 자리: " + str.indexOf("전"));
		System.out.println("거의 자리: " + str.indexOf("거"));
		System.out.println("기의 자리: " + str.indexOf("기"));

		String str2 = "자주전자";
		if (str2.lastIndexOf(str.charAt(0)) == str2.length() - 1) {
//	if (str.indexOf(str2.charAt(str2.length() - 1)) == 0) {
			System.out.println(str2 + " -> " + str);
		}
		if (StringUtil.startsWith(str, str2.substring(str2.length() - 1))) {

		}

		str = "2023-02-03";
		System.out.println(str.substring(5).replace("-", ""));
		str = "2023-02-03 11:01:15";
		// 0123456789012345678
		String year = str.substring(0, 4);
		String hour = str.substring(11, 13);
		String min = str.substring(14, 16);
		String sec = str.substring(17, 19);
		System.out.println(year + "년\n" + hour + "시 " + min + "분 " + sec + "초");

		str = "자전거 , 거중기 , 기러기";
		List<String> strList = Arrays.asList(str.split(","));
		strList.forEach(word -> System.out.println(word.trim()));

		str = "2023-02-03 11:01:15";
		List<String> dateList = Arrays.asList(str.split("[- :]"));
		dateList.forEach(word -> System.out.println(word.trim()));

		// substring,indexOf로 추출
		String url = "https://www.google.co.kr/asdasdads";

		System.out.println("");
		Arrays.asList(url.split("[://./]")).forEach(word -> System.out.print(word));
		System.out.println("");
		String protocol = url.substring(0, url.indexOf("://"));

		String subDomain = url.substring(url.indexOf("://") + 3, url.indexOf("."));

		String domain = url.substring(url.indexOf(subDomain) + subDomain.length() + 1);
		domain = domain.substring(0, domain.indexOf("."));

		String companyCode = url.substring(url.indexOf(domain) + domain.length() + 1);
		companyCode = companyCode.substring(0, companyCode.indexOf("."));

		String nationCode = url.substring(url.lastIndexOf(".") + 1);
		if (nationCode.indexOf("/") > 0) {
			nationCode = nationCode.substring(0, nationCode.indexOf("/"));
		}
		System.out.println();
		System.out.println(protocol);
		System.out.println(subDomain);
		System.out.println(domain);
		System.out.println(companyCode);
		System.out.println(nationCode);
	}
}
