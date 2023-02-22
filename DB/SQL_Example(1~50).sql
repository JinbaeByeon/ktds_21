--1. 현재 시간을 조회한다.
SELECT SYSDATE "현재 시간"
  FROM DUAL
;

--2. 현재 시간을 "연-월-일" 포멧으로 조회한다.
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD')
  FROM DUAL
;

--3. 한 시간 전 시간을 "시:분:초" 포멧으로 조회한다.
SELECT TO_CHAR(SYSDATE-1/24,'HH24:MI:SS')
  FROM DUAL
;

--4. EMPLOYEES 테이블의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
;
--5. DEPARTMENTS 테이블의 모든 정보를 조회한다.
SELECT *
  FROM DEPARTMENTS
;
--6. JOBS 테이블의 모든 정보를 조회한다.
--7. LOCATIONS 테이블의 모든 정보를 조회한다.
--8. COUNTRIES 테이블의 모든 정보를 조회한다.
--9. REGIONS 테이블의 모든 정보를 조회한다.
--10. JOB_HISTORY 테이블의 모든 정보를 조회한다.
-- 귀찮

--11. 90번 부서에서 근무하는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID = 90
;

--12. 90번, 100번 부서에서 근무하는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE DEPARTMENT_ID IN (90, 100)
;

--13. 100번 상사의 직속 부하직원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES EMP
 WHERE EMP.MANAGER_ID = 100
;

--14. 직무 아이디가 AD_VP 인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE JOB_ID = 'AD_VP'
;

--15. 연봉이 7000 이상인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE SALARY >= 7000
;

--16. 2005년 09월에 입사한 사원들의 모든 정보를 조회한다.
 SELECT *
   FROM EMPLOYEES
  WHERE TO_CHAR(HIRE_DATE,'YYYY-MM') = '2005-09'
;

--17. 111번 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 111
;

--18. 인센티브를 안받는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NULL
;

--19. 인센티브를 받는 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT IS NOT NULL
;

--20. 이름의 첫 글자가 'D' 인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE 'D%'
;

--21. 성의 마지막 글자가 'a' 인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE LAST_NAME LIKE '%a'
;

--22. 전화번호에 '.124.'이 포함된 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE PHONE_NUMBER LIKE '%.124.%'
;

--23. 직무 아이디가 'PU_CLERK'인 사원 중 연봉이 3000 이상인 사원들의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE JOB_ID = 'PU_CLERK'
   AND SALARY >= 3000
;

--24. 평균 연봉보다 많이 받는 사원들의 사원번호, 이름, 성, 연봉을 조회한다.
SELECT EMPLOYEE_ID
	 , FIRST_NAME 
	 , LAST_NAME 
	 , SALARY 
  FROM EMPLOYEES
 WHERE SALARY > (SELECT AVG(SALARY)
 				   FROM EMPLOYEES)
;

--25. 평균 연봉보다 적게 받는 사원들의 사원번호, 연봉, 부서번호를 조회한다.
SELECT EMPLOYEE_ID
	 , SALARY
	 , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE SALARY < (SELECT AVG(SALARY)
 				   FROM EMPLOYEES)
;

--26. 가장 많은 연봉을 받는 사원의 사원번호, 이름, 연봉을 조회한다.
SELECT EMPLOYEE_ID
	 , FIRST_NAME
	 , SALARY
  FROM EMPLOYEES
 WHERE SALARY = (SELECT MAX(SALARY)
 				   FROM EMPLOYEES)
;

--27. 이름이 4글자인 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE FIRST_NAME LIKE ('____')
;

--28. 'SA_REP' 직무인 직원 중 가장 높은 연봉과 가장 낮은 연봉을 조회한다.
SELECT MAX_SALARY
	 , MIN_SALARY
  FROM JOBS
 WHERE JOB_ID = 'SA_REP'
;
SELECT MAX(SALARY)
	 , MIN(SALARY)
  FROM EMPLOYEES  
 WHERE JOB_ID = 'SA_REP'
;

--29. 직원의 입사일자를 '연-월-일' 형태로 조회한다.
SELECT TO_CHAR(HIRE_DATE,'YYYY-MM-DD')
  FROM EMPLOYEES
;

--30. 가장 늦게 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE HIRE_DATE = (SELECT MAX(HIRE_DATE)
 					  FROM EMPLOYEES)
;

--31. 가장 일찍 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES 
 WHERE HIRE_DATE = (SELECT MIN(HIRE_DATE)
 					  FROM EMPLOYEES)
;

--32. 자신의 상사보다 더 많은 연봉을 받는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES E
 WHERE SALARY > (SELECT SALARY
 				   FROM EMPLOYEES MGR
 				  WHERE MGR.EMPLOYEE_ID = E.MANAGER_ID)
;

--33. 자신의 상사보다 더 일찍 입사한 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES E
 WHERE HIRE_DATE < (SELECT HIRE_DATE
 					  FROM EMPLOYEES MGR
 					 WHERE MGR.EMPLOYEE_ID = E.MANAGER_ID)
;

--34. 부서아이디별 평균 연봉을 조회한다.
SELECT DEPARTMENT_ID 
	 , AVG(SALARY)
  FROM EMPLOYEES
 GROUP BY DEPARTMENT_ID
;

--35. 직무아이디별 평균 연봉, 최고연봉, 최저연봉을 조회한다.
SELECT JOB_ID
	 , AVG(SALARY)
	 , MAX(SALARY)
	 , MIN(SALARY)
  FROM EMPLOYEES
 GROUP BY JOB_ID
;

--36. 가장 많은 인센티브를 받는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES
 WHERE COMMISSION_PCT = (SELECT MAX(COMMISSION_PCT)
 						   FROM EMPLOYEES)
;

--37. 가장 적은 인센티브를 받는 사원의 연봉과 인센티브를 조회한다.
SELECT SALARY
	 , COMMISSION_PCT
  FROM EMPLOYEES 
 WHERE COMMISSION_PCT = (SELECT MIN(COMMISSION_PCT)
 						   FROM EMPLOYEES)
;

--38. 직무아이디별 사원의 수를 조회한다.
SELECT JOB_ID 
	 , COUNT(1) 
  FROM EMPLOYEES 
 GROUP BY JOB_ID
;

--39. 상사아이디별 부하직원의 수를 조회한다. 단, 부하직원이 2명 이하인 경우는 제외한다.
SELECT MANAGER_ID 
	 , COUNT(1)
  FROM EMPLOYEES 
 GROUP BY MANAGER_ID
 HAVING COUNT(1) > 2
;

--40. 사원이 속한 부서의 평균연봉보다 적게 받는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES E
 WHERE SALARY < (SELECT AVG(E2.SALARY)
 				   FROM EMPLOYEES E2
 				  WHERE E2.DEPARTMENT_ID = E.DEPARTMENT_ID)
;

--41. 사원이 근무하는 부서명, 이름, 성을 조회한다.
SELECT DEP.DEPARTMENT_NAME 
	 , EMP.FIRST_NAME 
	 , EMP.LAST_NAME
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEP
  	ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID 
;

--42. 가장 적은 연봉을 받는 사원의 부서명, 이름, 성, 연봉, 부서장사원번호를 조회한다.
SELECT DEP.DEPARTMENT_NAME 
	 , EMP.FIRST_NAME 
	 , EMP.LAST_NAME 
	 , EMP.SALARY 
	 , EMP.MANAGER_ID
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEP
  	ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID
 WHERE SALARY = (SELECT MIN(SALARY)
 				   FROM EMPLOYEES)
;

--43. 상사사원번호를 중복없이 조회한다.
SELECT DISTINCT MANAGER_ID
  FROM EMPLOYEES
;

--44. 50번 부서의 부서장의 이름, 성, 연봉을 조회한다.
SELECT FIRST_NAME
	 , LAST_NAME
	 , SALARY
  FROM EMPLOYEES 
 WHERE EMPLOYEE_ID = (SELECT MANAGER_ID
 						FROM DEPARTMENTS
 					   WHERE DEPARTMENT_ID = 50)
;

--45. 부서명별 사원의 수를 조회한다.
SELECT DEP.DEPARTMENT_NAME 
	 , COUNT(1)
  FROM EMPLOYEES EMP
  JOIN DEPARTMENTS DEP
 	ON EMP.DEPARTMENT_ID = DEP.DEPARTMENT_ID 
 GROUP BY DEP.DEPARTMENT_NAME
;

--46. 사원의 수가 가장 많은 부서명, 사원의 수를 조회한다.

-- ORDER BY에 집계함수를 쓰면 연산이 커져서 쓰면 안됨
-- 하나의 인라인뷰에서 데이터 정제를 해결하면 보기엔 좋지만 데이터가 많아질 경우 성능이 안좋음
SELECT *
  FROM (SELECT DEP.DEPARTMENT_NAME 
			 , COUNT(1) CNT
		  FROM EMPLOYEES EMP
		  JOIN DEPARTMENTS DEP
		  	ON DEP.DEPARTMENT_ID = EMP.DEPARTMENT_ID 
		 GROUP BY DEP.DEPARTMENT_NAME
		 ORDER BY CNT DESC)
 WHERE ROWNUM = 1
;

-- 데이터가 많아질 경우 인라인 뷰를 사용해 데이터를 정제해주는게 성능상 좋음
SELECT DEP.DEPARTMENT_NAME 
	 , MAX_EMP.CNT
  FROM DEPARTMENTS DEP
  JOIN (SELECT *
		  FROM (SELECT *
				  FROM (SELECT DEPARTMENT_ID
							 , COUNT(1) CNT
						  FROM EMPLOYEES EMP
						 GROUP BY DEPARTMENT_ID)
				 ORDER BY CNT DESC)
		 WHERE ROWNUM = 1) MAX_EMP
	ON DEP.DEPARTMENT_ID = MAX_EMP.DEPARTMENT_ID
;

--47. 사원이 없는 부서명을 조회한다.
SELECT DEPARTMENT_NAME
  FROM DEPARTMENTS
 WHERE DEPARTMENT_ID NOT IN (SELECT DISTINCT DEPARTMENT_ID
 							   FROM EMPLOYEES
 							  WHERE DEPARTMENT_ID IS NOT NULL)
;

--48. 직무가 변경된 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES EMP
 WHERE EMP.EMPLOYEE_ID IN (SELECT DISTINCT JH.EMPLOYEE_ID
 							 FROM JOB_HISTORY JH)
;
 							 
--49. 직무가 변경된적 없는 사원의 모든 정보를 조회한다.
SELECT *
  FROM EMPLOYEES EMP
 WHERE EMP.EMPLOYEE_ID NOT IN (SELECT DISTINCT JH.EMPLOYEE_ID
 								 FROM JOB_HISTORY JH
 								WHERE JH.EMPLOYEE_ID IS NOT NULL)
;

--50. 직무가 변경된 사원의 과거 직무명과 현재 직무명을 조회한다.

-- Scala Query
SELECT EMP.EMPLOYEE_ID 
	 , J.JOB_TITLE "현재 직무명"
	 , (SELECT JOB_TITLE
	 	  FROM JOBS J
	 	 WHERE J.JOB_ID = JH.JOB_ID) "과거 직무명"
  FROM EMPLOYEES EMP
  JOIN JOBS J
  	ON J.JOB_ID = EMP.JOB_ID
  JOIN JOB_HISTORY JH
  	ON JH.EMPLOYEE_ID = EMP.EMPLOYEE_ID
;

-- JOIN
SELECT EMP.EMPLOYEE_ID 
	 , J_NOW.JOB_TITLE "현재 직무명"
	 , J_BEFORE.JOB_TITLE "과거 직무명"
  FROM EMPLOYEES EMP
  JOIN JOBS J_NOW
  	ON J_NOW.JOB_ID = EMP.JOB_ID
  JOIN JOB_HISTORY JH
	ON JH.EMPLOYEE_ID = EMP.EMPLOYEE_ID
  JOIN JOBS J_BEFORE
  	ON J_BEFORE.JOB_ID = JH.JOB_ID
;

-- SubQuery
-- 어차피 서브쿼리에서 외부 테이블의 칼럼을 가져오니까 조인하나 서브쿼리 쓰나 똑같음
SELECT EMP.EMPLOYEE_ID 
	 , J_NOW.JOB_TITLE "현재 직무명"
	 , J_BEFORE.JOB_TITLE "과거 직무명"
  FROM EMPLOYEES EMP
  JOIN JOBS J_NOW
  	ON J_NOW.JOB_ID = EMP.JOB_ID
  JOIN JOBS J_BEFORE
  	ON J_BEFORE.JOB_ID IN (SELECT JH.JOB_ID
  							 FROM JOB_HISTORY JH
  							WHERE JH.EMPLOYEE_ID = EMP.EMPLOYEE_ID)
;