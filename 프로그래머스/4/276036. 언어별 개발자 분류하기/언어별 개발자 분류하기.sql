-- 코드를 작성해주세요
SELECT
CASE 
WHEN SUM(CASE WHEN CATEGORY = 'Front End' THEN 1 ELSE 0 END) >= 1 AND SUM(CASE WHEN NAME = 'Python' THEN 1 ELSE 0 END) >= 1 THEN 'A'
WHEN SUM(CASE WHEN NAME = 'C#' THEN 1 ELSE 0 END) = 1 THEN 'B'
WHEN SUM(CASE WHEN CATEGORY = 'Front END' THEN 1 ELSE 0 END) >= 1 THEN 'C'
ELSE NULL
END AS GRADE, 
ID, EMAIL
FROM SKILLCODES A JOIN DEVELOPERS B ON (A.CODE & B.SKILL_CODE) = A.CODE
GROUP BY ID, EMAIL
HAVING GRADE IS NOT NULL
ORDER BY GRADE, ID

# SELECT CASE WHEN CATEGORY = 'Front End' THEN 1 ELSE 0 END AS GRADE
# FROM SKILLCODES A JOIN DEVELOPERS B ON (A.CODE & B.SKILL_CODE) = A.CODE